package com.todowithjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todowithjwt.entity.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}
