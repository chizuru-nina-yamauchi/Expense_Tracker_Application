package com.example.expense_tracker_application.repositroy;

import com.example.expense_tracker_application.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
