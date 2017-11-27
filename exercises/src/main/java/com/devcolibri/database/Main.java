package com.devcolibri.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {
        DbWorker worker = new DbWorker();

        String query = "select * from users where id=11";

        try {
            Statement statement = worker.getConnection().createStatement();
            ResultSet result = statement.executeQuery(query);
            while (result.next()) {
                User first  = new User();
                first.setId(result.getInt("id"));
                first.setUsername(result.getString("name"));
                first.setPassword(result.getString("email"));
                System.out.println(first);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
