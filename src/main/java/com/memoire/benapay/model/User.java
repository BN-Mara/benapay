package com.memoire.benapay.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
//import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="user")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name="role_id") //where is the relation
    private Role role;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String postNom;

    @Column(nullable = false)
    private String numPhone;

    @Column(nullable = false)
    private String bankAccount;

    @Column(nullable = false)
    private String sexe;

    @Column(nullable = false)
    private String adresse; 

    @Column(nullable = false)
    private boolean statut;

    @OneToMany(mappedBy = "user")
    private List<Transaction> transactions;
}
