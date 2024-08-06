package com.theoisi.contract_service.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContractRequest {
    private String client;
    private String type_of_contract;
    private Date date_fin;
    private Double contract_amount;
}
