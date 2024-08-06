package com.theoisi.contract_service.service;


import com.theoisi.contract_service.dto.Client;
import com.theoisi.contract_service.dto.ContractRequest;
import com.theoisi.contract_service.dto.ContractResponse;
import com.theoisi.contract_service.model.Contract;
import com.theoisi.contract_service.repository.ContractRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ContractService {

    private final ContractRepository contractRepository;
    private final RestTemplate restTemplate;

    public void addContract(ContractRequest contractRequest) {
       Contract contract = new Contract();
       contract.setContract_number(UUID.randomUUID().toString());
       contract.setContract_amount(contractRequest.getContract_amount());
       contract.setType_of_contract(contractRequest.getType_of_contract());
       contract.setClient(contractRequest.getClient());
       contract.setDate_fin(contractRequest.getDate_fin());
       contractRepository.save(contract);
    }

    public ResponseEntity<?> getContract(Long id) {
        Optional<Contract> contract = contractRepository.findById(id);
        if (contract.isPresent()) {
            Client client = restTemplate.getForObject("http://client-service/api/client/" + contract.get().getClient(), Client.class);
            ContractResponse contractResponse = new ContractResponse(
                    contract.get().getId(),
                    contract.get().getContract_number(),
                    client,
                    contract.get().getType_of_contract(),
                    contract.get().getDate_debut(),
                    contract.get().getDate_fin(),
                    contract.get().getContract_amount(),
                    contract.get().isStatus()
            );
            return new ResponseEntity<>(contractResponse, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("No Contract Found",HttpStatus.NOT_FOUND);
        }
    }
}
