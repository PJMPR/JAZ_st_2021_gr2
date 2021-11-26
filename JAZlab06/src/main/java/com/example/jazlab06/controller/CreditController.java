package com.example.jazlab06.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.jazlab06.credit.Credit;
import com.example.jazlab06.service.CreditService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CreditController {
    CreditService creditService;

    @Autowired
    public CreditController(CreditService creditService) {
        this.creditService = creditService;
    }

    @GetMapping("/credit/{id}")
    public ResponseEntity<Credit> getCredit(@PathVariable long id) {
        Credit credit = creditService.getCreditFromRepo(id);

        return new ResponseEntity<>(credit, HttpStatus.OK);
    }

    @PostMapping("/credit/add")
    public ResponseEntity<Long> createCredit(@RequestBody Credit credit) {
        long createdId = creditService.insertCreditIntoRepo(credit);

        return new ResponseEntity<>(createdId, HttpStatus.CREATED);
    }

    @DeleteMapping("/credit/delete/{id}")
    public ResponseEntity<Long> deleteCredit(@PathVariable long id) {
        long deletedId = creditService.removeCreditFromRepo(id);

        return new ResponseEntity<>(deletedId, HttpStatus.OK);
    }

    @PutMapping("/credit/update")
    public ResponseEntity<Long> updateCredit(@RequestBody Credit credit) {
        long updatedId = creditService.updateCreditInRepo(credit);

        return new ResponseEntity<>(updatedId, HttpStatus.OK);
    }
}

