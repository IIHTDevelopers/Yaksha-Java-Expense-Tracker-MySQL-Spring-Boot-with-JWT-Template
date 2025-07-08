package com.todowithjwt.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.todowithjwt.entity.Expense;
import com.todowithjwt.exception.ResourceNotFoundException;
import com.todowithjwt.service.ExpenseService;

@Service
public class ExpenseServiceImpl implements ExpenseService {

	@Override
	public Expense createExpense(Expense expense, int userId) throws ResourceNotFoundException {
		// write your logic here
		return null;
	}

	@Override
	public Expense getExpenseById(Long expenseId) throws ResourceNotFoundException {
		// write your logic here
		return null;
	}

	@Override
	public Expense updateExpense(Long expenseId, Expense expenseDetails) throws ResourceNotFoundException {
		// write your logic here
		return null;
	}

	@Override
	public void deleteExpense(Long expenseId) throws ResourceNotFoundException {
		// write your logic here
	}

	@Override
	public List<Expense> getAllExpensesForUser(int userId) {
		// write your logic here
		return null;
	}
}