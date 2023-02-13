/*
 * Author : Ketki Keni
 * Date : 13-02-2023
 * Created with : IntelliJ IDEA Community Edition
 */

package com.bej.User.service;

import com.bej.User.domain.User;
import com.bej.User.exception.UserAlreadyExistsException;
import com.bej.User.exception.UserNotFoundException;
import com.bej.User.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User login(User user) throws UserNotFoundException {
        User user1= userRepository.findById(user.getUserId()).get();
        if(user1 != null){
            if (user1.getUserPassword().equals(user.getUserPassword())) {
                return user1;
            }
            else {
                return null;
            }
        }
        else {
            return null;
        }
    }

    @Override
    public User register(User user) throws UserAlreadyExistsException {
        if(userRepository.findById(user.getUserId()).isPresent()){
            throw new UserAlreadyExistsException();
        }
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public boolean deleteUser(int userId) throws UserNotFoundException {
        boolean flag= false;
        if(userRepository.findById(userId).isEmpty()){
            throw new UserNotFoundException();
        }
        else {
            userRepository.deleteById(userId);
            flag = true;
        }
        return flag;
    }
}
