package dev.bkjulien.data_jpa.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity @Table(name = "TB_AUTHOR")
public class AhthorModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String name;

}