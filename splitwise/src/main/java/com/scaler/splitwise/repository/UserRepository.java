package com.scaler.splitwise.repository;

import com.scaler.splitwise.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    @Override
    Optional<User> findById(Long id);

    Optional<User> findByPhone(String phone);
}
