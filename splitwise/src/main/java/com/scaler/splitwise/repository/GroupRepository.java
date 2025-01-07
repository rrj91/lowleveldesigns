package com.scaler.splitwise.repository;

import com.scaler.splitwise.model.Group;
import com.scaler.splitwise.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GroupRepository extends JpaRepository<Group,Long> {
    @Override
    Optional<Group> findById(Long Id);
}
