package com.ecotrack.citizenship.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class Issue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long issueId;

    private String issueType;
    private String description;
    private String location;
    private String status;

    @ManyToOne
    @JoinColumn(name = "citizen_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Citizen citizen;

    public void setIssueId(Long issueId) {

        this.issueId = issueId;
    }

    public void setIssueType(String issueType) {
        this.issueType = issueType;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    public void setLocation(String location) {

        this.location = location;
    }

    public void setStatus(String status) {

        this.status = status;
    }

    public void setCitizen(Citizen citizen) {
        this.citizen = citizen;
    }


}




