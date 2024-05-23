package com.example.expense_tracker_application.repositroy;

import com.example.expense_tracker_application.model.Expense;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE Expense e SET e.amount = :amount WHERE e.id = :id")
    void updateExpenseAmount(Long id, Double amount);

    @Modifying
    @Transactional
    @Query("DELETE FROM Expense e WHERE e.category = :category")
    void deleteByCategory(String category);

    @Modifying
    @Transactional
    @Query("UPDATE Expense e SET e.description = :description WHERE e.id = :id")
    void updateExpenseDescription(Long id, String description);

    @Modifying
    @Transactional
    @Query("UPDATE Expense e SET e.category = :category WHERE e.id = :id")
    void updateExpenseCategory(Long id, String category);


    @Modifying
    @Transactional
    @Query("DELETE FROM Expense e WHERE e.date BETWEEN :startDate AND :endDate")
    void deleteByDateRange(LocalDate startDate, LocalDate endDate);

    @Modifying
    @Transactional
    @Query("UPDATE Expense e SET e.date = :date WHERE e.id = :id")
    void updateExpenseDate(Long id, LocalDate date);

    @Modifying
    @Transactional
    @Query("UPDATE Expense e SET e.user.id = :userId WHERE e.id = :id")
    void updateExpenseUser(Long id, Long userId);

    @Modifying
    @Transactional
    @Query("DELETE FROM Expense e WHERE e.user.id = :userId")
    void deleteByUser(Long userId);


    // Todo
    @Modifying
    @Transactional
    @Query("UPDATE Expense e SET ")
    void updateMultipleExpenses(List<Long> ids, );


    @Modifying
    @Transactional
    @Query("DELETE FROM Expense e WHERE e.id = :id")
    void deleteById(Long id);



}
