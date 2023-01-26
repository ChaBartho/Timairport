package be.technifutur.java.timairport.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class TypePlane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_id")
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column
    private int capacite;





}
