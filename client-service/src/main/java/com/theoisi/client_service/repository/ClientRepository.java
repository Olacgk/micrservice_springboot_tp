package com.theoisi.client_service.repository;

import com.theoisi.client_service.model.Client;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClientRepository extends MongoRepository<Client, String> {
}
