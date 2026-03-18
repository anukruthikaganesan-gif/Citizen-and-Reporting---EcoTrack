package com.ecotrack.citizenship.serviceimpl;

import com.ecotrack.citizenship.entity.Issue;
import com.ecotrack.citizenship.repository.IssueRepository;
import com.ecotrack.citizenship.service.IssueService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecotrack.citizenship.repository.CitizenRepository;
import com.ecotrack.citizenship.entity.Citizen;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class IssueServiceImpl implements IssueService {

    @Autowired
    private IssueRepository issueRepository;

    @Autowired
    private CitizenRepository citizenRepository;

    @Override
    public Issue reportIssue(Issue issue) {

        Long citizenId = issue.getCitizen().getCitizenId();

        Citizen citizen = citizenRepository.findById(citizenId)
                .orElseThrow(() -> new RuntimeException("Citizen not found"));

        issue.setCitizen(citizen);  // 🔥 VERY IMPORTANT

        issue.setStatus("Reported");

        return issueRepository.save(issue);
    }

    @Override
    public List<Issue> getAllIssues () {
        return issueRepository.findAll();
    }

    @Override
     public Issue updateIssue(Long id, Issue issue) {

            // 🔹 Step 1: Fetch existing record
            Issue existingIssue = issueRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Issue not found"));

            // 🔹 Step 2: Update fields
            existingIssue.setIssueType(issue.getIssueType());
            existingIssue.setDescription(issue.getDescription());
            existingIssue.setLocation(issue.getLocation());
            existingIssue.setStatus(issue.getStatus());

            // 🔹 Step 3: Set citizen properly
            if(issue.getCitizen() != null){
                Long citizenId = issue.getCitizen().getCitizenId();

                Citizen citizen = citizenRepository.findById(citizenId)
                        .orElseThrow(() -> new RuntimeException("Citizen not found"));

                existingIssue.setCitizen(citizen);
            }

            // 🔥 Step 4: Save updated object
            return issueRepository.save(existingIssue);
    }

    @Override
    public void deleteIssue(Long id) {
        issueRepository.deleteById(id);
    }
    @Override
    public List<Issue> getIssuesByCitizen(Long citizenId){
        return  issueRepository.findByCitizenCitizenId(citizenId);
    }
    @Override
    public Issue updateIssueStatus(Long id, String status) {

        Issue issue = issueRepository.findById(id).orElse(null);

        if (issue != null) {
            issue.setStatus(status);
            return issueRepository.save(issue);
        }

        return null;
    }
    @Override
    public List<Issue> getIssuesByStatus(String status){

        return issueRepository.findByStatus(status);
    }

}
