package com.tasks.spring_boot.pp_3_1_1.service;

import com.tasks.spring_boot.pp_3_1_1.model.User;
import com.tasks.spring_boot.pp_3_1_1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    public List<User> getListOfAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    public void updateUser(User user) {
        userRepository.save(user);
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public User getUser(int id) {
        return userRepository.findById(id).get();
    }
}
