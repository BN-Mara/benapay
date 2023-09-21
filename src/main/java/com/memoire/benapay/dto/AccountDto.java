package com.memoire.benapay.dto;

import com.memoire.benapay.model.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {
    private User user;
    private String currency;
    private double balance;
    //private LocalDateTime createdAt;
}
