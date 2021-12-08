package com.example.demo.controllers;

import com.example.demo.services.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("rental")
public class RentalController {
    @Autowired
    public RentalController(RentalService rentalService){
        this.rentalService = rentalService;
    }

    RentalService rentalService;

    @GetMapping("incomeByMonth")
    public ResponseEntity getIncomeByMonth(@RequestParam int year){
        return ResponseEntity.ok(rentalService.getIncomeByMonth(year));
    }


    @GetMapping("incomeByMonth.jpg")
    public ResponseEntity getIncomeByMonth(@RequestParam String chart, @RequestParam int year) throws IOException {
        switch (chart) {
            case "linear":
                return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG)
                        .body(rentalService.generateRentalLinearChart(
                                "Income by month",
                                "Months",
                                "Income",
                                rentalService.getIncomeByMonth(year)));
            case "bar":
                return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG)
                        .body(rentalService.generateRentalBarChart(
                                "Income by month",
                                "Months",
                                "Income",
                                rentalService.getIncomeByMonth(year)));
            case "pie":
                return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG)
                        .body(rentalService.generateRentalPieChart(
                                "Income by month",
                                rentalService.getIncomeByMonth(year)));
        }
        return ResponseEntity.ok(HttpStatus.BAD_REQUEST);
    }
}
