package com.example.dronebackend.repo;

import com.example.dronebackend.models.Drones;
import com.example.dronebackend.models.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicationRepository extends JpaRepository<Medication,Long> {
    Medication findMedicationById(long id);
}
