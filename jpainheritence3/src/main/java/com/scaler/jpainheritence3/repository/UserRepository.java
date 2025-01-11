package com.scaler.jpainheritence3.repository;

import com.scaler.jpainheritence3.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
