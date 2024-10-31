package com.example.user_management.repository;


import com.example.user_management.model.User;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;


public class UserRepository implements IUserRepository {
    private static final String URL ="jdbc:mysql://localhost:3306/demo_users";
    private static final String USER ="root";
    private static final String PASS ="codegym";

    private static final String INSERT_USERS_SQL = "INSERT INTO users (name, email, country) VALUES (?, ?, ?);";
    private static final String SELECT_USER_BY_ID = "select id,name,email,country from users where id =?";
    private static final String SELECT_ALL_USERS = "select * from users";
    private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
    private static final String UPDATE_USERS_SQL = "update users set name = ?,email= ?, country =? where id = ?;";
    private static final String SELECT_USER_BY_COUNTRY="select id,name,email,country from users where country = ?;";


    public void insertUser(User user) throws SQLException {
        System.out.println(INSERT_USERS_SQL);
        try(Connection connection = BaseRepository.getConnectDB();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO users (name, email, country) VALUES (?, ?, ?);")) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        }
    }

    public User selectUser(int id) {
        User user = null;
        try (Connection connection = BaseRepository.getConnectDB(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID)) {
            preparedStatement.setInt(1,id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                user = new User(id,name,email,country);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> selectAllUsers() {
        List<User> user = new ArrayList<>();
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);){
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                user.add(new User(id,name,email,country));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }


    public boolean deleteUser(int id) throws SQLException {
        boolean rowDelete;
        try (Connection connection = BaseRepository.getConnectDB();
        PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL)) {
            statement.setInt(1,id);
            rowDelete = statement.executeUpdate() >0;
        }
        return rowDelete;
    }

    public boolean updateUser(User user) throws SQLException {
        boolean rowUpdate;
        try (Connection connection = BaseRepository.getConnectDB();
        PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL)) {
            statement.setString(1,user.getName());
            statement.setString(2,user.getEmail());
            statement.setString(3,user.getCountry());
            statement.setInt(4,user.getId());
            rowUpdate = statement.executeUpdate() > 0;
        }
        return rowUpdate;
    }

    @Override
    public List<User> searchCountry(String keyword) {
        List<User> result = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_COUNTRY);
            preparedStatement.setString(1, "%" + keyword + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");

                User user = new User(id, name, email, country);
                result.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    private void printSQLException(SQLException ex){
        for (Throwable e : ex) {
            if(e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState" + ((SQLException)e).getSQLState());
                System.err.println("Error Code" + ((SQLException)e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.err.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
