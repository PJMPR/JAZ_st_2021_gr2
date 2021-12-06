package com.example.demo.controllers;
import com.example.demo.repositories.CustomerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.sql.Timestamp;
import java.util.stream.Collectors;
import java.io.IOException;
import com.example.demo.model.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import com.example.demo.charts.ChartType;

@RestController
@RequestMapping("customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;
    CustomerRepository repository;

    public CustomerController(CustomerRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    @RequestMapping("{id}")
    public ResponseEntity getCustomer(@PathVariable("id") int id){
        Timestamp t = Timestamp.valueOf("2021-01-10 00:00:00");
        return ResponseEntity.ok(repository.getById(id).getPayments().stream().map(x->x.getLastUpdate()).collect(Collectors.toList()));
    }

    @GetMapping
    @RequestMapping("/ranking/bySpentMoney")
    public ResponseEntity displayCustomerRankingBySpentMoney(){
        return ResponseEntity.ok(customerService.getCustomersByMoneySpent(10));
    }

    @GetMapping
    @RequestMapping("ranking/bySpentMoney.jpg/pie")
    public ResponseEntity displayCustomerBySpentMoneyChart() throws IOException {
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(customerService.makeChart(ChartType.PIE));
    }

    @GetMapping
    @RequestMapping("/ranking/byWatchedMovies")
    public ResponseEntity displayCustomerRankingByWatchedMovies(){
        return ResponseEntity.ok(customerService.getCustomersByWatchedMovies(10));
    }
    @GetMapping
    @RequestMapping("ranking/byWatchedMovies.jpg/bar")
    public ResponseEntity displayCustomerByWatchedMoviesChart() throws IOException {
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(customerService.makeChart(ChartType.BAR));
    }
}
