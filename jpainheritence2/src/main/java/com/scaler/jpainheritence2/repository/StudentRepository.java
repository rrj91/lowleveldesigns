package com.scaler.jpainheritence2.repository;

import com.scaler.jpainheritence2.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
