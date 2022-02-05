package com.prSecurity.service;

import org.springframework.data.repository.CrudRepository;
import com.prSecurity.model.User;


import java.util.List;

public interface UsersRepository extends CrudRepository<User, Long>//,JpaRepository<User, Long>
{
    User findById(long id);

    List<User> findAll();

    User deleteById(long id);
}