package com.tasks.spring_boot.pp_3_1_1.service;

import com.tasks.spring_boot.pp_3_1_1.model.User;
import com.tasks.spring_boot.pp_3_1_1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getListOfAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public void updateUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User getUser(Integer id) {
        return userRepository.findById(id).get();
    }
}
