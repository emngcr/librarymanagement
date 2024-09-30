package com.project.librarymanagement.repository;

import com.project.librarymanagement.entity.Fine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FineRepository extends JpaRepository<Fine, Long> {
}
