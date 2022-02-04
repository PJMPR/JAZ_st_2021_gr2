package com.prSecurity.service;

import org.springframework.data.repository.CrudRepository;
import com.prSecurity.User;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import lombok.NonNull;


import java.util.List;

public interface UsersRepository extends CrudRepository<User, Long>//,JpaRepository<User, Long>
{
    User findById(long id);

    List<User> findAll();

    User deleteById(long id);
}