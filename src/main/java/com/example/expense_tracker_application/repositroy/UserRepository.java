package com.example.expense_tracker_application.repositroy;

import com.example.expense_tracker_application.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<AppUser, Long> {

}
