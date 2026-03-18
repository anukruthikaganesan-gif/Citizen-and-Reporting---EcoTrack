package com.ecotrack.citizenship.repository;
import java.util.List;


import com.ecotrack.citizenship.entity.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRepository extends JpaRepository<Issue, Long> {
    List<Issue> findByCitizenCitizenId(Long citizenId);
    List<Issue> findByStatus(String status);

}