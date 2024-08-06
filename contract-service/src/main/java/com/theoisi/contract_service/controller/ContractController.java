package com.theoisi.contract_service.controller;


import com.theoisi.contract_service.dto.ContractRequest;
import com.theoisi.contract_service.service.ContractService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contract")
@RequiredArgsConstructor
public class ContractController {

    private final ContractService contractService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String addContract(@RequestBody ContractRequest contractRequest) {
        contractService.addContract(contractRequest);
        return "Contract added";
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> getContractById(@PathVariable("id") Long id) {
        return contractService.getContract(id);
    }
}
