package com.example.expense_tracker_application.service;

import com.example.expense_tracker_application.model.AppUser;

import java.util.List;

public interface UserService {
    List<AppUser> getAllUsers();
    AppUser getUserById(Long id);
    AppUser createUser(AppUser user);
    AppUser updateUser(Long id, AppUser user);
    void deleteUser(Long id);
}
