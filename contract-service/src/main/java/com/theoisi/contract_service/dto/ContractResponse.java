package com.theoisi.contract_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContractResponse {
    private long id;
    private String contract_number;
    private Client client;
    private String type_of_contract;
    private Date date_debut;
    private Date date_fin;
    private Double contract_amount;
    private boolean status;
}
