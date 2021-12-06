package com.example.demo.repositories;

<<<<<<< Updated upstream
import com.example.demo.model.Customer;
=======
import com.example.demo.DBModel.Customer;
>>>>>>> Stashed changes
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
