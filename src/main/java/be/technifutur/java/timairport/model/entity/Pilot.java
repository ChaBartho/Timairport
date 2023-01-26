package be.technifutur.java.timairport.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Pilot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pilot_id")
    private long id;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;





}