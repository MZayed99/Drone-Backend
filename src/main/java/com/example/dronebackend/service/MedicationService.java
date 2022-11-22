package com.example.dronebackend.service;

import com.example.dronebackend.models.Drones;
import com.example.dronebackend.models.Medication;
import com.example.dronebackend.repo.DroneRepository;
import com.example.dronebackend.repo.MedicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicationService {
    @Autowired
    private MedicationRepository medicationRepository;
    @Autowired
    private DroneRepository droneRepository;

    public Medication addMedication(Medication addedMedication, Long droneId) {

        Drones drones = droneRepository.findDronesById(droneId);
        int medicationWeight = addedMedication.getMedWeight();
        boolean isOverWeight = droneOverWeight(drones, addedMedication);
        if (isOverWeight) {
            return null;
        } else {
            Medication medication = new Medication(addedMedication.getId(), addedMedication.getMedName(), addedMedication.getMedWeight(), addedMedication.getCode(), addedMedication.getMedImage(), drones);
            drones.setWeight(drones.getWeight() + addedMedication.getMedWeight());
            return medicationRepository.save(medication);
        }

    }

    public void deleteMedication(Medication medication, Drones drone) {

        boolean isWeightEqualZero = droneOverWeight(drone, medication);
        if (!isWeightEqualZero) {
            drone.setWeight(drone.getWeight() - medication.getMedWeight());
            medicationRepository.delete(medication);
        }

    }


    private boolean droneOverWeight(Drones drones, Medication addmedication) {
        System.out.println("drone weight before is " + drones.getWeight());
        int newWeight = drones.getWeight() + addmedication.getMedWeight();
        if (newWeight <= 500 || newWeight >= 0) {
            System.out.println("drone weight after is " + drones.getWeight());
            return false;
        } else {
            return true;
        }

    }
}
