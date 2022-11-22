package com.example.dronebackend.models;

import com.example.dronebackend.validators.MedicationCode;
import com.example.dronebackend.validators.MedicationNameConstraint;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity(name = "medication")
@Getter
@Setter
@NoArgsConstructor

public class Medication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @MedicationNameConstraint
    private String medName;
    private int medWeight;
    @MedicationCode
    private String code;
    private String medImage;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "drone_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Drones drones;


    public Medication(Long id, String medName, int medWeight, String code, String medImage, Drones drones) {
        this.id = id;
        this.medName = medName;
        this.medWeight = medWeight;
        this.code = code;
        this.medImage = medImage;
        this.drones = drones;
    }
}