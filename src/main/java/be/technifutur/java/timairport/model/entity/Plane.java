package be.technifutur.java.timairport.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter @Setter
public class Plane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "plane_id", nullable = false)
    private Long id;
    @Column(name = "call_sign", nullable = false)
    private String callSign;
    @Column(name = "registration_date", nullable = false)
    private LocalDate registrationDate;

    @Column(name = "in_maintenance", nullable = false)
    private boolean inMaintenance;



}
