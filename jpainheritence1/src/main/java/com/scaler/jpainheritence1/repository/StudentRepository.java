package com.scaler.jpainheritence1.repository;

import com.scaler.jpainheritence1.models.Instructor;
import com.scaler.jpainheritence1.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
