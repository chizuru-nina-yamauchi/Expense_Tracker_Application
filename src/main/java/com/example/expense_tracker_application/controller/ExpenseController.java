package com.example.expense_tracker_application.controller;


import com.example.expense_tracker_application.model.Expense;
import com.example.expense_tracker_application.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @GetMapping
    public String listExpenses(Model model) {
        model.addAttribute("expenses", expenseService.getAllExpenses());
        return "expense-list";
    }

    @GetMapping("/new")
    public String showExpenseForm(Model model) {
        Expense expense = new Expense();
        model.addAttribute("expense", expense);
        return "expense-form";
    }

    @PostMapping
    public String saveExpense(@ModelAttribute("expense") Expense expense) {
        expenseService.createExpense(expense);
        return "redirect:/expenses";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Expense expense = expenseService.getExpenseById(id);
        model.addAttribute("expense", expense);
        return "expense-form";
    }

    @PostMapping("/update/{id}")
    public String updateExpense(@PathVariable Long id, @ModelAttribute("expense") Expense expense) {
        expenseService.updateExpense(id, expense);
        return "redirect:/expenses";
    }

    @GetMapping("/delete/{id}")
    public String deleteExpense(@PathVariable Long id) {
        expenseService.deleteExpense(id);
        return "redirect:/expenses";
    }

    // Custom Operation
    @PostMapping("/updateAmount/{id}")
    public String updateExpenseAmount(@PathVariable Long id, @RequestParam Double amount){
        expenseService.updateExpenseAmount(id, amount);
        return "redirect:/expenses";
    }

    @PostMapping("/deleteByCategory")
    public String deleteByCategory(@RequestParam String category){
        expenseService.deleteByCategory(category);
        return "redirect:/expenses";
    }

    @PostMapping("/updateDescription/{id}")
    public String updateExpenseDescription(@PathVariable Long id, @RequestParam String description){
        expenseService.updateExpenseDescription(id, description);
        return "redirect:/expenses";
    }

    @PostMapping("/updateCategory/{id}")
    public String updateExpenseCategory(@PathVariable Long id, @RequestParam String category){
        expenseService.updateExpenseCategory(id, category);
        return "redirect:/expenses";
    }

    @PostMapping("/deleteByDateRange")
    public String deleteByDateRange(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate){
        expenseService.deleteByDateRange(startDate, endDate);
        return "redirect:/expenses";
    }

    @PostMapping("/updateDate/{id}")
    public String updateExpenseDate(@PathVariable Long id, @RequestParam LocalDate date){
        expenseService.updateExpenseDate(id, date);
        return "redirect:/expenses";
    }

    @PostMapping("/updateUser/{id}")
    public String updateExpenseUser(@PathVariable Long id, @RequestParam Long userId){
        expenseService.updateExpenseUser(id, userId);
        return "redirect:/expenses";
    }

    @PostMapping("/deleteByUser/{userId}")
    public String deleteByUser(@PathVariable Long userId){
        expenseService.deleteByUser(userId);
        return "redirect:/expenses";
    }

    @PostMapping("/updateMultipleExpenses")
    public String updateMultipleExpenses(@RequestParam List<Long> ids, @RequestParam Double amount, @RequestParam String description){
        expenseService.updateMultipleExpenses(ids, amount, description);
        return "redirect:/expenses";
    }

    @PostMapping("/deleteById/{id}")
    public String deleteById(@PathVariable Long id){
        expenseService.deleteById(id);
        return "redirect:/expenses";
    }





}
