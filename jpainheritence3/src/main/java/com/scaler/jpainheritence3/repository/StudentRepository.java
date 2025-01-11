package com.scaler.jpainheritence3.repository;

import com.scaler.jpainheritence3.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
