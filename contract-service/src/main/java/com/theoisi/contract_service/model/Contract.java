package com.theoisi.contract_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "contract")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String contract_number;
    private String client;
    private String type_of_contract;
    private Date date_debut = new Date();
    private Date date_fin;
    private Double contract_amount;
    private boolean status = false;
}
