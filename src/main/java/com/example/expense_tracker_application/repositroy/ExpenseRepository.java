package com.example.expense_tracker_application.repositroy;

import com.example.expense_tracker_application.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {


}
