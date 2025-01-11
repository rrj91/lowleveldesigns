package com.scaler.jpainheritence1.repository;

import com.scaler.jpainheritence1.models.Instructor;
import com.scaler.jpainheritence1.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository extends JpaRepository<Instructor,Long> {
}
