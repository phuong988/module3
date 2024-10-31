package com.example.usermanager.service;

import com.example.usermanager.model.User;
import com.example.usermanager.repository.IUserRepository;
import com.example.usermanager.repository.UserRepository;

import java.util.List;

public class UserService implements IUserService {
    IUserRepository userRepository = new UserRepository();
    @Override
    public void insertUser(User user)  {
        userRepository.insertUser(user);
    }

    @Override
    public User selectUser(int id) {
        return userRepository.selectUser(id)  ;
    }

    @Override
    public List<User> selectAllUsers() {
        return userRepository.selectAllUsers();
    }

    @Override
    public boolean deleteUser(int id)  {
        return userRepository.deleteUser(id) ;
    }

    @Override
    public boolean updateUser(User user)  {
        return userRepository.updateUser(user)  ;
    }

    public List<User> softByUserName(){
        return userRepository.softByUserName();
    }

    @Override
    public String insertUpdateUserTransaction() {
        return userRepository.insertUpdateUserTransaction();
    }
}
