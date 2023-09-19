package com.memoire.benapay.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="transtype")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id;

    @Column(unique = true)
    String TransTitle;

}
