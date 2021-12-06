package com.example.demo.controllers;

<<<<<<< Updated upstream
import com.example.demo.repositories.CustomerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.stream.Collectors;

@RestController
@RequestMapping("customers")
public class CustomerController {

    public CustomerController(CustomerRepository repository) {
        this.repository = repository;
    }

    CustomerRepository repository;

    @GetMapping
    @RequestMapping("{id}")
    public ResponseEntity get(@PathVariable("id") int id){
        Timestamp t = Timestamp.valueOf("2021-01-10 00:00:00");
        return ResponseEntity.ok(repository.getById(id)
                .getRentalsByCustomerId()
                .stream()
                .map(x->x.getLastUpdate())
                .collect(Collectors.toList()));
=======
import com.example.demo.DTOModel.CustomerDTO;
import com.example.demo.repositories.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CustomerController {
    CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("customers/ranking/bySpentMoney")
    public ResponseEntity<List<CustomerDTO>> giveTopTenCustomersBySpentMoney(){
        return ResponseEntity.ok(customerService.setCustomers().stream()
                .sorted(Comparator.comparing(CustomerDTO::getSpent).reversed())
                .limit(10).collect(Collectors.toList()));
>>>>>>> Stashed changes
    }
}
