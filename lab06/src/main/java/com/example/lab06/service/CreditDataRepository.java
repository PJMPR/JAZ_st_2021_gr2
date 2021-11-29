package com.example.lab06.service;

import com.example.lab06.credit.Credit;
import org.springframework.data.repository.CrudRepository;

public interface CreditDataRepository extends CrudRepository<Credit, Integer> {
    Credit findById(int id);
}