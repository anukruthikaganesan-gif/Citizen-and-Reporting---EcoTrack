package com.ecotrack.citizenship.service;
import com.ecotrack.citizenship.entity.Issue;

import java.util.List;

public interface IssueService {

    Issue reportIssue(Issue issue);

    List<Issue> getAllIssues();
    Issue updateIssue(Long id,Issue issue);
    void deleteIssue(Long id);
    List<Issue> getIssuesByCitizen(Long citizenId);
    Issue updateIssueStatus(Long id, String status);
    List<Issue> getIssuesByStatus(String status);

}
