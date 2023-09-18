package com.memoire.benapay.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="transaction")
@Data

public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id;

    @Column()
    String dateTrans;
    
    @Column() //to be incremented
    int montant;

    @Column()
    String devise;

    @Column()
    int merch;

    @Column()
    int transactorId;

    @Column()
    int transAmount;

    @ManyToOne //Many to Many
    @JoinColumn(name="client_id") //where is the relation
    private Client client;

    @Column()
    boolean statut;


}
