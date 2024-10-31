package com.example.usermanager.service;

import com.example.usermanager.model.User;

import java.util.List;

public interface IUserService {
    public void insertUser(User user);

    User selectUser(int id);

    List<User> selectAllUsers();

    boolean deleteUser(int id);

    boolean updateUser(User user);

    List<User> softByUserName();

    String insertUpdateUserTransaction();

}
