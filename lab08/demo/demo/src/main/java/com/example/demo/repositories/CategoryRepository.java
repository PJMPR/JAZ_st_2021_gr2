package com.example.demo.repositories;

import com.example.demo.model.Category;
import com.example.demo.repositories.interfaces.ICategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    @Query(value = "select c from Category c")
    List<ICategory> getAllCategories();
}
