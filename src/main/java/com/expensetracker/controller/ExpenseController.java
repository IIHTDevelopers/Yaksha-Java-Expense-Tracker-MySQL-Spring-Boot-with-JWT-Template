package com.expensetracker.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expensetracker.entity.Expense;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

	@GetMapping("/{expenseId}")
	public ResponseEntity<Expense> getExpenseById(@PathVariable Long expenseId) {
		// write your logic here
		return null;
	}

	@PostMapping("/{userId}")
	public ResponseEntity<Expense> createExpense(@RequestBody Expense expense, @PathVariable int userId) {
		// write your logic here
		return null;
	}

	@PutMapping("/{expenseId}")
	public ResponseEntity<Expense> updateExpense(@PathVariable Long expenseId, @RequestBody Expense expenseDetails) {
		// write your logic here
		return null;
	}

	@DeleteMapping("/{expenseId}")
	public ResponseEntity<Void> deleteExpense(@PathVariable Long expenseId) {
		// write your logic here
		return null;
	}

	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Expense>> getAllExpensesForUser(@PathVariable int userId) {
		// write your logic here
		return null;
	}
}