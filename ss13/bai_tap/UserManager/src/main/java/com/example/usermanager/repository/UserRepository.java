package com.example.usermanager.repository;

import com.example.usermanager.dao.UserDao;
import com.example.usermanager.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository {
    UserDao userDao = new UserDao();

    private static final String INSERT_USER = "insert into users(name,email,country) values(?,?,?)";
    private static final String UPDATE_USER = "call update_users(?,?,?,?)";
    private static final String DELETE_USER = "call delete_users(?)";
    private static final String SELECT_ALL_USERS = "call get_all_users()";
    private static final String SELECT_USER_BY_ID = "select * from users where id =?";
    private static final String SOFT_BY_NAME = "select * from users order by name,country";
    private static final String ADD_TRANSACTION = "insert into users(name,email,country) values(?,?,?)";
    private static final String UPDATE_TRANSACTION = "call update_users(?,?,?,?)";


    public UserRepository() {
    }


    @Override
    public void insertUser(User user) {
        try (Connection connection = userDao.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_USER)) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getCountry());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User selectUser(int id) {
        User user = null;
        try (Connection connection = userDao.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_USER_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int userId = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                user = new User(userId, name, email, country);
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return user;
    }

    @Override
    public List<User> selectAllUsers() {
        List<User> users = new ArrayList<>();
        try (Connection connection = userDao.getConnection();
             CallableStatement statement = connection.prepareCall(SELECT_ALL_USERS)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int userId = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                users.add(new User(userId, name, email, country));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public boolean deleteUser(int id) {
        try (Connection connection = userDao.getConnection();
             CallableStatement statement = connection.prepareCall(DELETE_USER)) {
            statement.setInt(1, id);
            int rows = statement.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateUser(User user) {
        try (Connection connection = userDao.getConnection();
             CallableStatement statement = connection.prepareCall(UPDATE_USER)) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getCountry());
            statement.setInt(4, user.getId());
            int rows = statement.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<User> softByUserName() {
        List<User> users = new ArrayList<>();
        try (Connection connection = userDao.getConnection();
             PreparedStatement statement = connection.prepareStatement(SOFT_BY_NAME);) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int userId = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                users.add(new User(userId, name, email, country));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }


    public String insertUpdateUserTransaction() {
        String mess = "Transaction failed! No user updated.";
        try (Connection connection = userDao.getConnection()) {
            connection.setAutoCommit(false);

            try (PreparedStatement statementAdd = connection.prepareStatement(ADD_TRANSACTION);
                 PreparedStatement statementUpdate = connection.prepareStatement(UPDATE_TRANSACTION)) {

                statementAdd.setString(1, "John Doe");
                statementAdd.setString(2, "john.doe@example.com");
                statementAdd.setString(3, "USA");
                statementAdd.executeUpdate();

                statementUpdate.setString(1, "Jack");
                statementUpdate.setString(2, "jack@gmail.com");
                statementUpdate.setString(3, "France");
                statementUpdate.setInt(4, 9);
                statementUpdate.executeUpdate();


                connection.commit();
                mess = "Transaction successful!";
            } catch (SQLException e) {
                connection.rollback();
                e.printStackTrace();
            }finally {
                connection.setAutoCommit(true);
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mess;
    }
}
