package com.ecotrack.citizenship.controller;
import com.ecotrack.citizenship.entity.Resolution;
import com.ecotrack.citizenship.service.ResolutionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resolutions")
public class ResolutionController {

    @Autowired
    private ResolutionService resolutionService;

    @PostMapping("/add")
    public Resolution addResolution(@RequestBody Resolution resolution){
        return resolutionService.addResolution(resolution);
    }

    @GetMapping
    public List<Resolution> getAllResolutions(){
        return resolutionService.getAllResolutions();
    }

    @GetMapping("/issue/{id}")
    public List<Resolution> getResolutionByIssue(@PathVariable Long id){
        return resolutionService.getResolutionByIssue(id);
    }

    @PutMapping("/update/{id}")
    public Resolution updateResolution(@PathVariable Long id, @RequestBody Resolution resolution){
        return resolutionService.updateResolution(id, resolution);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteResolution(@PathVariable Long id){

        resolutionService.deleteResolution(id);
    }

}

