package com.example.demo.controllers;

import com.example.demo.model.CustomerStats;
import com.example.demo.repositories.CustomerRepository;
import com.example.demo.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("customers")
public class CustomerController {
    @Autowired
    public CustomerController(CustomerRepository repository, CustomerService customerService) {
        this.repository = repository;
        this.customerService = customerService;
    }

    CustomerRepository repository;
    CustomerService customerService;

    @GetMapping
    @RequestMapping("{id}")
    public ResponseEntity get(@PathVariable("id") int id){
        Timestamp t = Timestamp.valueOf("2021-01-10 00:00:00");
        return ResponseEntity.ok(repository.getById(id)
                .getRentalsByCustomerId()
                .stream()
                .map(x->x.getLastUpdate())
                .collect(Collectors.toList()));
    }

/*    @GetMapping
    @RequestMapping("/payments/{id}")
    public ResponseEntity getPayments(@PathVariable("id") int id){
        return ResponseEntity.ok(repository.getById(id)
                .getPaymentsByCustomerId()
                .stream()
                .map(x->x.getLastUpdate())
                .collect(Collectors.toList()));
    }*/

    @GetMapping
    @RequestMapping("/ranking/bySpentMoney")
    public ResponseEntity<List<CustomerStats>> getByMoney() {
        return ResponseEntity.ok(customerService.rankCustomersByMoneySpent());
    }

    @GetMapping
    @RequestMapping("/ranking/byWatchedMovies")
    public ResponseEntity<List<CustomerStats>> getByMovies() {
        return ResponseEntity.ok(customerService.rankCustomersByWatchedMovies());
    }

}
