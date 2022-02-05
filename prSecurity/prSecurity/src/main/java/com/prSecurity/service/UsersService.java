package com.prSecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import com.prSecurity.model.User;

@Component
public class UsersService {
    UsersRepository usersRepository;

    @Autowired
    public UsersService(UsersRepository userRepository) {
        this.usersRepository = userRepository;
        userRepository.save(new User(0,"", "", ""));
    }

    public User getUserFromRepo(long id) {
        return usersRepository.findById(id);
    }

    public List<User> getUsersFromRepo() {
        return usersRepository.findAll();
    }

    public long insertUserIntoRepo(User user) {
        if (usersRepository.existsById(user.getId())) {
            return 0;
        }
        return usersRepository.save(user).getId();
    }
}
