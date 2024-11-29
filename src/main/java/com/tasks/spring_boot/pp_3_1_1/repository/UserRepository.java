package com.tasks.spring_boot.pp_3_1_1.repository;

import com.tasks.spring_boot.pp_3_1_1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
