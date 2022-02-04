package com.prSecurity.service;


import com.prSecurity.CustomerDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomersRepository extends JpaRepository<CustomerDto, Long> {
    @Query( value = "" +
            "SELECT * " +
            "FROM customer " +
            "GROUP BY customer.customer_id " +
            "LIMIT :limit", nativeQuery = true)
    List<CustomerDto> customers(int limit);
}
