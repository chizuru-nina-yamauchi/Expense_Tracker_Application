package com.example.expense_tracker_application.service;

import com.example.expense_tracker_application.model.Expense;
import com.example.expense_tracker_application.repositroy.ExpenseRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class ExpenseServiceImplTest {

    @Mock
    private ExpenseRepository expenseRepository;

    @InjectMocks
    private ExpenseServiceImpl expenseService;

    @Test
    public void testGetAllExpenses(){

        List<Expense> expenseList = new ArrayList<>();

        expenseList.add(new Expense(100.0,"test1", "testCategory1", LocalDate.now(), null));
        expenseList.add(new Expense(200.0,"test2", "testCategory2", LocalDate.now(), null));
        when(expenseRepository.findAll()).thenReturn(expenseList);

        List<Expense> result = expenseService.getAllExpenses();

        assertEquals(2, result.size());
        assertEquals(100.0, result.get(0).getAmount());
        assertEquals(200.0, result.get(1).getAmount());

    }

    @Test
    public void testGetExpenseById() {
        Expense testExpense = new Expense(100.0,"test1", "testCategory1", LocalDate.now(), null);
        when(expenseRepository.findById(1L)).thenReturn(java.util.Optional.of(testExpense));

        Expense result = expenseService.getExpenseById(1L);

        assertNotNull(result);
        assertEquals(100.0, result.getAmount());
    }

    @Test
    public void testCreateExpense() {
        Expense testExpense = new Expense(100.0,"test1", "testCategory1", LocalDate.now(), null);
        when(expenseRepository.save(testExpense)).thenReturn(testExpense);

        Expense result = expenseService.createExpense(testExpense);

        assertNotNull(result);
        assertEquals(100.0, result.getAmount());
    }

    @Test
    public void testUpdateExpense(){

        Expense existingExpense = new Expense(100.0,"test1", "testCategory1", LocalDate.now(), null);
        Expense updatedExpense = new Expense(200.0,"test2", "testCategory2", LocalDate.now(), null);

        when(expenseRepository.findById(1L)).thenReturn(Optional.of(existingExpense));
        when(expenseRepository.save(existingExpense)).thenReturn(updatedExpense);

        Expense result = expenseService.updateExpense(1L, updatedExpense);

        assertNotNull(result);
        assertEquals(200.0, result.getAmount());
        assertEquals("testCategory2", result.getDescription());

    }


    @Test
    public void testDeleteExpense() {
        Expense testExpense = new Expense(100.0,"test1", "testCategory1", LocalDate.now(), null);
        when(expenseRepository.findById(1L)).thenReturn(Optional.of(testExpense));

        expenseService.deleteExpense(1L);

        when(expenseRepository.findById(1L)).thenReturn(Optional.empty());
        Expense result = expenseService.getExpenseById(1L);

        assertNull(result);
    }


    @Test
    public void testUpdateExpenseAmount() {
        Long expenseId = 1L;
        Double amount = 200.0;

        expenseService.updateExpenseAmount(expenseId, amount);
        verify(expenseRepository, times(1)).updateExpenseAmount(expenseId, amount);

    }

    @Test
    public void testDeleteByCategory() {
        String category = "testCategory";
        expenseService.deleteByCategory(category);
        verify(expenseRepository, times(1)).deleteByCategory(category);
    }

    @Test
    public void testUpdateExpenseDescription() {
        Long expenseId = 1L;
        String description = "testDescription";

        expenseService.updateExpenseDescription(expenseId, description);
        verify(expenseRepository, times(1)).updateExpenseDescription(expenseId, description);
    }

    @Test
    public void testDeleteByDateRange() {
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = LocalDate.now().plusDays(1);

        expenseService.deleteByDateRange(startDate, endDate);
        verify(expenseRepository, times(1)).deleteByDateRange(startDate, endDate);
    }


    @Test
    public void testUpdateExpenseDate() {
        Long expenseId = 1L;
        LocalDate date = LocalDate.now();

        expenseService.updateExpenseDate(expenseId, date);
        verify(expenseRepository, times(1)).updateExpenseDate(expenseId, date);
    }

    @Test
    public void testUpdateExpenseUser() {
        Long expenseId = 1L;
        Long userId = 1L;

        expenseService.updateExpenseUser(expenseId, userId);
        verify(expenseRepository, times(1)).updateExpenseUser(expenseId, userId);
    }

    @Test
    public void testDeleteByUser() {
        Long userId = 1L;
        expenseService.deleteByUser(userId);
        verify(expenseRepository, times(1)).deleteByUser(userId);
    }

    @Test
    public void testUpdateMultipleExpenses() {
        List<Long> ids = new ArrayList<>();
        ids.add(1L);
        ids.add(2L);
        Double amount = 200.0;
        String description = "testDescription";

        expenseService.updateMultipleExpenses(ids, amount, description);
        verify(expenseRepository, times(1)).updateMultipleExpenses(ids, amount, description);
    }

    @Test
    public void testDeleteById() {
        Long expenseId = 1L;
        expenseService.deleteById(expenseId);
        verify(expenseRepository, times(1)).deleteById(expenseId);
    }





}