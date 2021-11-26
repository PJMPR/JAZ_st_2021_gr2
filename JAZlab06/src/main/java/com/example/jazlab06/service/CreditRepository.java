package com.example.jazlab06.service;

import com.example.jazlab06.credit.Credit;
import org.springframework.data.repository.CrudRepository;

public interface CreditRepository extends CrudRepository<Credit, Long> {
    public Credit findById(long id);
}
