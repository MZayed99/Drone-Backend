package com.example.dronebackend.controller;

import com.example.dronebackend.models.Drones;

import com.example.dronebackend.service.DroneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController("drones")
public class DroneController {
    @Autowired
    private DroneService droneService;

    @GetMapping()
    public ResponseEntity<List<Drones>> getDrones() {
        return new ResponseEntity<>(droneService.getDrones(), HttpStatus.OK);
    }

    @PostMapping("regiser")
    public ResponseEntity<Drones> registerDrone(@RequestBody @Valid Drones newDrone, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            bindingResult.getFieldErrors().forEach(f -> System.out.println(f.getField() + ": " + f.getDefaultMessage()));

            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        } else {
            Drones drone = droneService.registerDrone(newDrone);
            return new ResponseEntity<Drones>(drone, HttpStatus.CREATED);
        }
    }
}
