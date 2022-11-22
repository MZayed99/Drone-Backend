package com.example.dronebackend.models;

import lombok.*;

import javax.persistence.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity(name = "drones")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Drones {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @Size(max= 100) @NotNull
    private String serial_number;
    @Max(value = 500) @NotNull
    private int weight;
    private int battery;
    private Model model;
    private State state;
    @OneToMany(mappedBy = "drones", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Medication> medications;

    public enum Model {
        Lightweight, Middleweight, Cruiserweight, Heavyweight
    }

    public enum State {
        IDLE, LOADING, LOADED, DELIVERING, DELIVERED, RETURNING
    }


}
