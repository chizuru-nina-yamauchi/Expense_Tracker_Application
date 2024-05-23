package com.example.expense_tracker_application.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;
    private String category;
    private String description;
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Expense() {
    }

    public Expense(Double amount, String category, String description, LocalDate date, User user) {
        this.amount = amount;
        this.category = category;
        this.description = description;
        this.date = date;
        this.user = user;
    }

    public Expense(Long id, Double amount, String category, String description, LocalDate date, User user) {
        this.id = id;
        this.amount = amount;
        this.category = category;
        this.description = description;
        this.date = date;
        this.user = user;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
