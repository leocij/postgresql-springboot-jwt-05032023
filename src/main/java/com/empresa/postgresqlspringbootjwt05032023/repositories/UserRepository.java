package com.empresa.postgresqlspringbootjwt05032023.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import com.empresa.postgresqlspringbootjwt05032023.models.User;

public class UserRepository {

    public List<User> findAll() {
        List<User> users = new ArrayList<User>();

        try {
            String url = "jdbc:postgresql://localhost:5432/postgresql_springboot_jwt_05032023_db";
            String myUser = "postgres";
            String myPassword = "postgres";
            String sql_query = "select * from users;";
            Connection connection = DriverManager.getConnection(url, myUser, myPassword);
            PreparedStatement preparedStatement = connection.prepareStatement(sql_query);
            ResultSet resultSet = preparedStatement.executeQuery();

            // while (resultSet.next()) {
            //     System.out.println(resultSet.getInt("id"));
            //     System.out.println(resultSet.getString("name"));
            //     System.out.println(resultSet.getTimestamp("created_at"));
            //     System.out.println(resultSet.getTimestamp("updated_at"));
            // }

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setCreatedAt(resultSet.getTimestamp("created_at"));
                user.setUpdatedAt(resultSet.getTimestamp("updated_at"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }

        return users;
    }
}