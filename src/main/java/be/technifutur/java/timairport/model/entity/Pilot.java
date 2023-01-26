package be.technifutur.java.timairport.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter @Setter
public class Pilot extends Person{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pilot_id")
    private long id;

    @Column(name = "license_id", nullable = false, unique = true)
    private String licenseId;

    @Column(name = "license_acquired", nullable = false)
    private LocalDate licenseAcquired;


}
