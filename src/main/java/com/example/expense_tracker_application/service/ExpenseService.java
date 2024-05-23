package com.example.expense_tracker_application.service;

import com.example.expense_tracker_application.model.Expense;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.List;

public interface ExpenseService {
    List<Expense> getAllExpenses();
    Expense getExpenseById(Long id);
    Expense createExpense(Expense expense);
    Expense updateExpense(Long id, Expense expense);
    void deleteExpense(Long id);

    // Custom Operation
    void updateExpenseAmount(Long id, Double amount);
    void deleteByCategory(String category);
    void updateExpenseDescription(Long id, String description);
    void updateExpenseCategory(Long id, String category);
    void deleteByDateRange(LocalDate startDate, LocalDate endDate);
    void updateExpenseDate(Long id, LocalDate date);
    void updateExpenseUser(Long id, Long userId);
    void deleteByUser(Long userId);
    void updateMultipleExpenses(List<Long> ids, Double amount);
    void deleteById(Long id);
}
