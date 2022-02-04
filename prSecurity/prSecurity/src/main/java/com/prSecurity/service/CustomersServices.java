package com.prSecurity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.prSecurity.CustomerDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomersServices {
    private final List<CustomerDto> customers;

    public List<CustomerDto> getCustomers() {
        var result = customers.stream()
                .map(c->
                        new CustomerDto(c.getId(), c.getName(), c.getSurname(), c.getEmail()))
                .collect(Collectors.toList());
        //   customers.stream().forEach(customer -> System.out.println(customer);
        return result;
    }
}