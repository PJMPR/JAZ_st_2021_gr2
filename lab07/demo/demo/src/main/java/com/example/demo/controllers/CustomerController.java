package com.example.demo.controllers;

import com.example.demo.DTOStrategy.CustomerStatsDTO;
import com.example.demo.DTOStrategy.RentalStatsDTO;
import com.example.demo.repositories.CustomerRepository;
import com.example.demo.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
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
                .getRentals()
                .stream()
                .map(x->x.getLastUpdate())
                .collect(Collectors.toList()));
    }

    @GetMapping("ranking/bySpentMoney")
    public ResponseEntity<List<CustomerStatsDTO>> getTopTenCustomersBySpentMoney(){
        return ResponseEntity.ok(customerService.rankCustomersByMoneySpent());
    }

    @GetMapping("ranking/bySpentMoney.jpg")
    public ResponseEntity getByMoneyChart(@RequestParam("chart") String chart) throws IOException {
        if(chart.equals("pie")){
            return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG)
                    .body(customerService.generateCustomerPieChart(
                            "Customers by money spent",
                            "money",
                            customerService.rankCustomersByMoneySpent()));

        }else if (chart.equals("bar")){
            return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG)
                    .body(customerService.generateCustomerBarChart(
                            "Customers by money spent",
                            "money",
                            "",
                            "Money spent",
                            customerService.rankCustomersByMoneySpent()));
        }
        return (ResponseEntity) ResponseEntity.status(HttpStatus.BAD_REQUEST);
    }


    @GetMapping("ranking/byMoviesWatched")
    public ResponseEntity<List<CustomerStatsDTO>> getTopTenCustomersByMoviesWatched(){
        return ResponseEntity.ok(customerService.rankCustomersByMovieWatched());
    }

    @GetMapping("ranking/byMoviesWatched.jpg")
    public ResponseEntity getByMoviesChart(@RequestParam("chart") String chart) throws IOException {
        if(chart.equals("bar")){
            return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG)
                    .body(customerService.generateCustomerBarChart(
                            "Movies watched",
                            "movies",
                            "",
                            "movies",
                            customerService.rankCustomersByMovieWatched()));
        }else if(chart.equals("pie")){
            return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG)
                    .body(customerService.generateCustomerPieChart(
                            "Customers by movies watched",
                            "movies",
                            customerService.rankCustomersByMovieWatched()));
        }
        return ResponseEntity.ok(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("activity/rentMoviesByMonth")
    public ResponseEntity<List<RentalStatsDTO>> getRentMoviesByMonth(@RequestParam("year") int year) {
        return ResponseEntity.ok(customerService.rentMoviesByMonths(year));
    }

    @GetMapping("activity/rentMoviesByMonth/{year}")
    public ResponseEntity getMoviesForCustomer( @PathVariable int year, @RequestParam int id){
        return ResponseEntity.ok(customerService.getMoviesForCustomer(year, id));
    }

    @GetMapping("activity/rentMoviesByMonth.jpg")
    public ResponseEntity getRentMoviesByMonthChart(@RequestParam("chart") String chart, @RequestParam("year") int year) throws IOException {
        if(chart.equals("bar")){
            return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG)
                    .body(customerService.generateRentalBarChart(
                            "Movies rental by month",
                            "months",
                            "rentals",
                            customerService.rentMoviesByMonths(year)
                    ));
        }else if(chart.equals("pie")){
            return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG)
                    .body(customerService.generateRentalPieChart(
                            "Rentals by months",
                            customerService.rentMoviesByMonths(year)));
        }
        return ResponseEntity.ok(customerService.rentMoviesByMonths(year));
    }
}
