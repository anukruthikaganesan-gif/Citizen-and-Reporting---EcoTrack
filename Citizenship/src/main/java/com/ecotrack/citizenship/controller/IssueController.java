package com.ecotrack.citizenship.controller;
import com.ecotrack.citizenship.entity.Issue;
import com.ecotrack.citizenship.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/issues")
public class IssueController {

    @Autowired
    private IssueService issueService;

    @PostMapping("/report")
    public Issue reportIssue(@RequestBody Issue issue){
        return issueService.reportIssue(issue);
    }

    @GetMapping
    public List<Issue> getAllIssues(){

        return issueService.getAllIssues();
    }

    @GetMapping("/citizen/{id}")
    public List<Issue> getIssuesByCitizen(@PathVariable Long id){
        return issueService.getIssuesByCitizen(id);
    }

    @PutMapping("/{id}")
    public Issue updateIssue(@PathVariable Long id, @RequestBody Issue issue){
        return issueService.updateIssue(id,issue);
    }

    @DeleteMapping("/{id}")
    public String deleteIssue(@PathVariable Long id){
        issueService.deleteIssue(id);
        return "Issue deleted successfully";
    }
    @PutMapping("/status/{id}")
    public Issue updateIssueStatus(@PathVariable Long id, @RequestBody Issue issue){
        return issueService.updateIssueStatus(id, issue.getStatus());
    }
    @GetMapping("/status/{status}")
    public List<Issue> getIssuesByStatus(@PathVariable String status){

        return issueService.getIssuesByStatus(status);
    }



}

