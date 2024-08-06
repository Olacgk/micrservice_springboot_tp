package com.theoisi.contract_service.repository;

import com.theoisi.contract_service.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository<Contract, Long> {

}
