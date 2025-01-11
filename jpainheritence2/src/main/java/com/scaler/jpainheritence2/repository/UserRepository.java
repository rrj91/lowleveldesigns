package com.scaler.jpainheritence2.repository;

import com.scaler.jpainheritence2.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
