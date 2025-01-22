package com.scaler.cardinalities.repository;

import com.scaler.cardinalities.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}