package com.ecotrack.citizenship.serviceimpl;

import com.ecotrack.citizenship.entity.Citizen;
import com.ecotrack.citizenship.exception.ResourceNotFoundException;
import com.ecotrack.citizenship.repository.CitizenRepository;
import com.ecotrack.citizenship.service.CitizenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitizenServiceImpl implements CitizenService{

    @Autowired
    private CitizenRepository citizenRepository;

    @Override
    public Citizen saveCitizen(Citizen citizen) {
        return citizenRepository.save(citizen);
    }

    @Override
    public List<Citizen> getAllCitizens() {
        return citizenRepository.findAll();
    }

    @Override
    public Citizen updateCitizen(Long id, Citizen citizen) {

        Citizen existingCitizen = citizenRepository.findById(id).orElse(null);

        if(existingCitizen != null){
            existingCitizen.setName(citizen.getName());
            existingCitizen.setEmail(citizen.getEmail());
            existingCitizen.setPhone(citizen.getPhone());
            existingCitizen.setAddress(citizen.getAddress());

            return citizenRepository.save(existingCitizen);
        }

        return null;
    }
    @Override
    public void deleteCitizen(Long id) {

        citizenRepository.deleteById(id);
    }
    @Override
    public Citizen getCitizenById(Long id){
        return citizenRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Citizen not found with id " + id));
    }




}