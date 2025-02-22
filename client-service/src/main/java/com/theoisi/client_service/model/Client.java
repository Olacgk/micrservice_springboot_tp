package com.theoisi.client_service.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "client")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Client {
    @Id
    private String id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String profession;
}
