package com.ecotrack.citizenship.entity;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Resolution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resolutionId;

    private Long officerId;

    private String actions;

    private LocalDate date;

    private String status;

    @ManyToOne
    @JoinColumn(name = "issue_id")
    private Issue issue;

    public Long getResolutionId() {

        return resolutionId;
    }

    public void setResolutionId(Long resolutionId) {

        this.resolutionId = resolutionId;
    }

    public Long getOfficerId() {

        return officerId;
    }

    public void setOfficerId(Long officerId) {

        this.officerId = officerId;
    }

    public String getActions() {

        return actions;
    }

    public void setActions(String actions) {

        this.actions = actions;
    }

    public LocalDate getDate() {

        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getStatus() {

        return status;
    }

    public void setStatus(String status) {

        this.status = status;
    }

    public Issue getIssue() {

        return issue;
    }

    public void setIssue(Issue issue) {
        this.issue = issue;
    }
}

