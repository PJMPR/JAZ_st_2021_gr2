package com.example.demo.controllers;

import com.example.demo.model.Customer;
import com.example.demo.repositories.CustomerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RestController
@RequestMapping("customers")
@Transactional
public class CustomerController {

    CustomerRepository repository;

    public CustomerController( CustomerRepository repository) {
      //  this.weatherClient = weatherClient;
        this.repository = repository;
    }
    @GetMapping
    public ResponseEntity getAll(){
        //var customers = repository.findAll();
        var result = repository.findAll().stream().map(x->new CustomerResult(x.getFirstName(), x.getPayments().stream()
                .map(y->y
                .getAmount())
                .reduce(BigDecimal.ZERO, BigDecimal::add))
        ).sorted((a,b)->(a.spent.subtract(b.spent)).intValue()).limit(10).collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }

    @GetMapping
    @RequestMapping("{id}")
    public ResponseEntity get(@PathVariable("id") int id){
        Timestamp t = Timestamp.valueOf("2021-01-10 00:00:00");
        return ResponseEntity.ok(repository.getById(id)
                .getPayments()
                .stream()
                .map(x->x.getAmount())
                .collect(Collectors.toList()));
    }

    record CustomerResult(String customer, BigDecimal spent){
    }
}
