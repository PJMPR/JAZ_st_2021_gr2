package com.example.demo.repositories;

import com.example.demo.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
<<<<<<< HEAD
import java.util.Objects;
=======
import java.util.stream.Stream;
>>>>>>> e1f1e6373e1d9e43263b72541030bb9e37d677da

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
