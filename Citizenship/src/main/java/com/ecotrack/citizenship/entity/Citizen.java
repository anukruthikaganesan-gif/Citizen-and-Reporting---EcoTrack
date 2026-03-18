package com.ecotrack.citizenship.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Citizen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long citizenId;

    private String name;
    private String email;
    private String phone;
    private String address;

    @OneToMany(mappedBy= "citizen")
    @JsonIgnore
    private List<Issue> issues;

    public Long getCitizenId() {

        return citizenId;
    }

    public void setCitizenId(Long citizenId) {

        this.citizenId = citizenId;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {


        this.email = email;
    }

    public String getPhone() {

        return phone;
    }

    public void setPhone(String phone) {

        this.phone = phone;
    }

    public String getAddress() {

        return address;
    }

    public void setAddress(String address) {

        this.address = address;
    }
    public List<Issue> getIssues(){
        return issues;
    }

    public void setIssues(List<Issue> issues){
        this.issues = issues;
    }
}
