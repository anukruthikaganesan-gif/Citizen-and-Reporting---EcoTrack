package com.ecotrack.citizenship.service;
import com.ecotrack.citizenship.entity.Citizen;
import java.util.List;

public interface CitizenService {

    Citizen saveCitizen(Citizen citizen);

    List<Citizen> getAllCitizens();
    Citizen getCitizenById(Long id);
    Citizen updateCitizen(Long id,Citizen citizen);
    void deleteCitizen(Long id);
}
