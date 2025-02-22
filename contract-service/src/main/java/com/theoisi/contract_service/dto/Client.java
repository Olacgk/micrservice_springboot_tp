package com.theoisi.contract_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    private String id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String profession;
}
