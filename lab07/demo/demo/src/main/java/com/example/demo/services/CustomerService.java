package com.example.demo.services;

import com.example.demo.model.CustomerStats;
import com.example.demo.repositories.CustomerRepository;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerService {
        public CustomerRepository customerRepository;

        CustomerService(CustomerRepository customerRepository){
            this.customerRepository = customerRepository;
        }


    public List<CustomerStats> getCustomerStats() {
        return customerRepository.findAll().stream()
                .map(customer ->
                        new CustomerStats(
                                customer.getCustomerId(),
                                customer.getFirstName(),
                                customer.getLastName(),
                                customer.amountSpent(),
                                customer.moviesWatched())
                )
                .collect(Collectors.toList());
    }



    public List<CustomerStats> rankCustomersByMoneySpent() {
        return getCustomerStats().stream()
                .sorted(Comparator.comparing(CustomerStats::getMoneySpent).reversed())
                .limit(10)
                .collect(Collectors.toList());
    }

    public List<CustomerStats> rankCustomersByWatchedMovies() {
        return getCustomerStats().stream()
                .sorted(Comparator.comparing(CustomerStats::getWatchedMovies).reversed())
                .limit(10)
                .collect(Collectors.toList());
    }



}
