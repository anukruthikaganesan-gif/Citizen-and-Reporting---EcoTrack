package com.ecotrack.citizenship.controller;
import com.ecotrack.citizenship.entity.Citizen;
import com.ecotrack.citizenship.exception.ResourceNotFoundException;
import com.ecotrack.citizenship.service.CitizenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/citizens")
public class CitizenController {

    @Autowired
    private CitizenService citizenService;

    @PostMapping("/add")
    public Citizen addCitizen(@RequestBody Citizen citizen){

        return citizenService.saveCitizen(citizen);
    }

    @GetMapping("/all")
    public List<Citizen> getAllCitizens(){

        return citizenService.getAllCitizens();
    }

    @GetMapping("/test-error ")
    public String test(){
        throw new ResourceNotFoundException("Test working");
    }

    @PutMapping("/update/{id}")
    public Citizen updateCitizen(@PathVariable Long id, @RequestBody Citizen citizen){
        return citizenService.updateCitizen(id, citizen);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCitizen(@PathVariable Long id){
        citizenService.deleteCitizen(id);
        return "Citizen deleted successfully";
    }

    @GetMapping("/{id}")
    public Citizen getCitizenById(@PathVariable Long id){

        return citizenService.getCitizenById(id);
    }


}

