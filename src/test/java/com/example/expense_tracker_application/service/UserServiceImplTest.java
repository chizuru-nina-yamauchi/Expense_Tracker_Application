package com.example.expense_tracker_application.service;

import com.example.expense_tracker_application.model.AppUser;
import com.example.expense_tracker_application.repositroy.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllUsers(){
        List<AppUser> appUserList = new ArrayList<>();

        appUserList.add(new AppUser("test1", "testPassword1", "test1@test.com"));
        appUserList.add(new AppUser("test2", "testPassword2", "test2@test.com"));
        when(userRepository.findAll()).thenReturn(appUserList);

        List<AppUser> result = userService.getAllUsers();

        assertEquals(2, result.size());
        assertEquals("test1", result.get(0).getUsername());
        assertEquals("test2", result.get(1).getUsername());
    }

    @Test
    public void testGetUserById() {
        AppUser testUser = new AppUser("test1", "testPassword1", "test1@test.com");
        when(userRepository.findById(1L)).thenReturn(Optional.of(testUser));

        AppUser result = userService.getUserById(1L);

        assertNotNull(result);
        assertEquals("test1", result.getUsername());
    }




}