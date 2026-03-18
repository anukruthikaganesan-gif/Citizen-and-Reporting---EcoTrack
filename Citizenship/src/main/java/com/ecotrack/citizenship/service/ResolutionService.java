package com.ecotrack.citizenship.service;

import com.ecotrack.citizenship.entity.Resolution;
import java.util.List;

public interface ResolutionService {

    Resolution addResolution(Resolution resolution);

    List<Resolution> getAllResolutions();

    List<Resolution> getResolutionByIssue(Long issueId);

    Resolution updateResolution(Long id, Resolution resolution);

    void deleteResolution(Long id);


}
