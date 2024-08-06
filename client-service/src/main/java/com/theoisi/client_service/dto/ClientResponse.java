package com.theoisi.client_service.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientResponse {
    private String id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String profession;
}
