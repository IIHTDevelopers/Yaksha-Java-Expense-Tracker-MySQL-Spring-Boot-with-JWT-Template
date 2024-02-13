package com.expensetracker.functional;

import static com.expensetracker.utils.TestUtils.businessTestFile;
import static com.expensetracker.utils.TestUtils.currentTest;
import static com.expensetracker.utils.TestUtils.testReport;
import static com.expensetracker.utils.TestUtils.yakshaAssert;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.expensetracker.controller.ExpenseController;
import com.expensetracker.entity.Expense;
import com.expensetracker.exception.ResourceNotFoundException;
import com.expensetracker.service.ExpenseService;

@ExtendWith(MockitoExtension.class)
public class ExpenseControllerTest {

	@Mock
	private ExpenseService expenseService;

	@InjectMocks
	private ExpenseController expenseController;

	@AfterAll
	public static void afterAll() {
		testReport();
	}

	@Test
	public void testGetExpenseById_WhenExpenseExists() throws Exception {
		try {
			Long expenseId = 1L;
			Expense expense = new Expense();
			expense.setId(expenseId);
			when(expenseService.getExpenseById(expenseId)).thenReturn(expense);
			ResponseEntity<Expense> response = expenseController.getExpenseById(expenseId);
			yakshaAssert(currentTest(),
					response.getStatusCode() == HttpStatus.OK && response.getStatusCode() == HttpStatus.OK,
					businessTestFile);
		} catch (Exception ex) {
			yakshaAssert(currentTest(), false, businessTestFile);
		}
	}

	@Test
	public void testGetExpenseById_WhenExpenseDoesNotExist() throws Exception {
		try {
			Long expenseId = 1L;
			when(expenseService.getExpenseById(expenseId)).thenThrow(new ResourceNotFoundException(""));
			ResponseEntity<Expense> response = expenseController.getExpenseById(expenseId);
			yakshaAssert(currentTest(), response.getStatusCode() == HttpStatus.NOT_FOUND && response.getBody() == null,
					businessTestFile);
		} catch (Exception ex) {
			yakshaAssert(currentTest(), false, businessTestFile);
		}
	}

	@Test
	public void testCreateExpense() throws Exception {
		try {
			Expense expense = new Expense();
			int userId = 1;
			when(expenseService.createExpense(expense, userId)).thenReturn(expense);
			ResponseEntity<Expense> response = expenseController.createExpense(expense, userId);
			yakshaAssert(currentTest(), response.getStatusCode() == HttpStatus.CREATED && response.getBody() == expense,
					businessTestFile);
		} catch (Exception ex) {
			yakshaAssert(currentTest(), false, businessTestFile);
		}
	}

	@Test
	public void testUpdateExpense() throws Exception {
		try {
			Long expenseId = 1L;
			Expense expenseDetails = new Expense();
			when(expenseService.updateExpense(expenseId, expenseDetails)).thenReturn(expenseDetails);
			ResponseEntity<Expense> response = expenseController.updateExpense(expenseId, expenseDetails);
			yakshaAssert(currentTest(),
					response.getStatusCode() == HttpStatus.OK && response.getBody() == expenseDetails,
					businessTestFile);
		} catch (Exception ex) {
			yakshaAssert(currentTest(), false, businessTestFile);
		}
	}

	@Test
	public void testDeleteExpense() throws Exception {
		try {
			Long expenseId = 1L;
			ResponseEntity<Void> response = expenseController.deleteExpense(expenseId);
			yakshaAssert(currentTest(), response.getStatusCode() == HttpStatus.NO_CONTENT, businessTestFile);
		} catch (Exception ex) {
			yakshaAssert(currentTest(), false, businessTestFile);
		}
	}

	@Test
	public void testGetAllExpensesForUser() throws Exception {
		try {
			int userId = 1;
			List<Expense> expenses = new ArrayList<>();
			when(expenseService.getAllExpensesForUser(userId)).thenReturn(expenses);
			ResponseEntity<List<Expense>> response = expenseController.getAllExpensesForUser(userId);
			yakshaAssert(currentTest(), response.getBody() == expenses && response.getStatusCode() == HttpStatus.OK,
					businessTestFile);
		} catch (Exception ex) {
			yakshaAssert(currentTest(), false, businessTestFile);
		}
	}
}