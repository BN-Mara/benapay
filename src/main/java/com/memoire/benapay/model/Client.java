package com.memoire.benapay.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="client")
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String nomClient;

    @Column(nullable = false)
    private String postNomClient;

    @Column(nullable = false)
    private String phoneClient;

    @Column(nullable = false)
    private String sexe;

    @Column(nullable = false)
    private String adresse; 

    @OneToMany(mappedBy = "client")
    private List<Transaction> transactions;
}
