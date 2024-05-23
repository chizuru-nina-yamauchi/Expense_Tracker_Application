package com.example.expense_tracker_application.controller;


import com.example.expense_tracker_application.model.Expense;
import com.example.expense_tracker_application.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String saveExpense(@ModelAttribute("expense") Expense expense, Model model) {
        expenseService.createExpense(expense);
        model.addAttribute("expenses", expenseService.getAllExpenses());
        return "redirect:/expenses";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Expense expense = expenseService.getExpenseById(id);
        model.addAttribute("expense", expense);
        return "expense-form";
    }

    @PostMapping("/update/{id}")
    public String updateExpense(@PathVariable Long id, @ModelAttribute("expense") Expense expense, Model model) {
        expenseService.updateExpense(id, expense);
        model.addAttribute("expenses", expenseService.getAllExpenses());
        return "redirect:/expenses";
    }

    @GetMapping("/delete/{id}")
    public String deleteExpense(@PathVariable Long id, Model model) {
        expenseService.deleteExpense(id);
        model.addAttribute("expenses", expenseService.getAllExpenses());
        return "redirect:/expenses";
    }

    // Custom Operation
    @GetMapping("/updateAmount/{id}")
    public String updateExpenseAmount(@PathVariable Long id, @RequestParam Double amount, Model model){
        expenseService.updateExpenseAmount(id, amount);
        model.addAttribute()

    }



}
