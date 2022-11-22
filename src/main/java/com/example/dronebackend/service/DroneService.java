package com.example.dronebackend.service;

import com.example.dronebackend.models.Drones;
import com.example.dronebackend.repo.DroneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class DroneService {
    @Autowired
    private DroneRepository droneRepository;

    public List<Drones> getDrones(){
       return droneRepository.findAll();
    }

    public Drones registerDrone(Drones Drone){
        return droneRepository.save(Drone);


    }
}
