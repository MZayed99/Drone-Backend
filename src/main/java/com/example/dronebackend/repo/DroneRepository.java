package com.example.dronebackend.repo;

import com.example.dronebackend.models.Drones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DroneRepository extends JpaRepository<Drones,Long> {
    Drones findDronesById(long id);
}
