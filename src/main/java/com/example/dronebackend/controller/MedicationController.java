package com.example.dronebackend.controller;

import com.example.dronebackend.models.Drones;
import com.example.dronebackend.models.Medication;
import com.example.dronebackend.repo.DroneRepository;

import com.example.dronebackend.repo.MedicationRepository;
import com.example.dronebackend.service.MedicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("medication")
public class MedicationController {
    @Autowired
    private MedicationService medicationService;
    @Autowired
    private MedicationRepository medicationRepository;

    @PostMapping("add/{droneId}")
    public ResponseEntity addMedication(@RequestBody @Valid Medication newMedication, @PathVariable("droneId") long droneId) {
        Medication medication = medicationService.addMedication(newMedication, droneId);
        if (medication == null) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity(HttpStatus.OK);
        }

    }

    @DeleteMapping("delete/{medicationId}")
    public ResponseEntity DeleteMedication(@PathVariable("medicationId") long medicationId) {
        Medication medication = medicationRepository.findMedicationById(medicationId);
        Drones drone = medication.getDrones();
        medicationService.deleteMedication(medication, drone);
        if (medication == null) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity(HttpStatus.OK);
        }
    }
}


