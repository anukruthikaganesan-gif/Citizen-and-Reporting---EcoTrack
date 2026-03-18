package com.ecotrack.citizenship.repository;
import java.util.List;

import com.ecotrack.citizenship.entity.Resolution;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResolutionRepository extends JpaRepository<Resolution, Long> {
    List<Resolution> findByIssueIssueId(Long issueId);


}