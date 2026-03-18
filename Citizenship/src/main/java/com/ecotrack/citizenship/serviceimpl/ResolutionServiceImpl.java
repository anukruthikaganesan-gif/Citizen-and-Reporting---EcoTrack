package com.ecotrack.citizenship.serviceimpl;

import com.ecotrack.citizenship.entity.Issue;
import com.ecotrack.citizenship.entity.Resolution;
import com.ecotrack.citizenship.repository.ResolutionRepository;
import com.ecotrack.citizenship.service.ResolutionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecotrack.citizenship.repository.IssueRepository;

import java.util.List;

@Service
public class ResolutionServiceImpl implements ResolutionService {

    @Autowired
    private ResolutionRepository resolutionRepository;



    @Autowired
    private IssueRepository issueRepository;  // ✅ ADD THIS

    @Override
    public Resolution addResolution(Resolution resolution) {

        // 🔹 Step 1: Get issueId
        Long issueId = resolution.getIssue().getIssueId();

        // 🔹 Step 2: Fetch full Issue from DB
        Issue issue = issueRepository.findById(issueId)
                .orElseThrow(() -> new RuntimeException("Issue not found"));

        // 🔥 Step 3: Set full issue object
        resolution.setIssue(issue);

        // 🔹 Step 4: Save
        return resolutionRepository.save(resolution);
    }


    @Override
    public List<Resolution> getAllResolutions() {
        return resolutionRepository.findAll();
    }

    @Override
    public List<Resolution> getResolutionByIssue(Long issueId) {
        return resolutionRepository.findByIssueIssueId(issueId);
    }

    @Override
    public Resolution updateResolution(Long id, Resolution resolution) {

        Resolution existingResolution = resolutionRepository.findById(id).orElse(null);

        if(existingResolution != null){
            existingResolution.setOfficerId(resolution.getOfficerId());
            existingResolution.setActions(resolution.getActions());
            existingResolution.setDate(resolution.getDate());
            existingResolution.setStatus(resolution.getStatus());

            return resolutionRepository.save(existingResolution);
        }

        return null;
    }

    @Override
    public void deleteResolution(Long id) {
        resolutionRepository.deleteById(id);
    }



}
