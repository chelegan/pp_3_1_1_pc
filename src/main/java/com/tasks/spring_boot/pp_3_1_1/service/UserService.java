package com.tasks.spring_boot.pp_3_1_1.service;

import com.tasks.spring_boot.pp_3_1_1.model.User;

import java.util.List;

public interface UserService {
    List<User> getListOfAllUsers();
    void deleteUser(Integer id);
    void updateUser(User user);
    void addUser(User user);
    User getUser(Integer id);
}
