package com.bej.User.service;

import com.bej.User.domain.User;
import com.bej.User.exception.UserAlreadyExistsException;
import com.bej.User.exception.UserNotFoundException;

import java.util.List;

public interface UserService {
    public User login(User user) throws UserNotFoundException;
    public User register(User user) throws UserAlreadyExistsException;
    public List<User> getAllUsers();
    public boolean deleteUser(int userId) throws UserNotFoundException;
}
