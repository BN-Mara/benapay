package com.memoire.benapay.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="transaction")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id;

    @Column()
    LocalDateTime dateTrans;

    @Column()
    String devise;

    @Column(unique=true)
    String reference;

    @Column()
    int transAmount;

    @ManyToOne //Many to Many
    @JoinColumn(name="sender_id") //where is the relation
    private Account sender;

    @ManyToOne //Many to Many
    @JoinColumn(name="receiver_id") //where is the relation
    private Account receiver;

    @Column()
    boolean statut;


}
