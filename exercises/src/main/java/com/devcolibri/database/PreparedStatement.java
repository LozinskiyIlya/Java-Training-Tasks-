package com.devcolibri.database;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Calendar;

public class PreparedStatement {

    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    private static final String INSERT_NEW = "INSERT INTO dish VALUES(?,?,?,?,?,?)";

    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        java.sql.PreparedStatement preparedStatement = null;

        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            preparedStatement = connection.prepareStatement(INSERT_NEW);

            preparedStatement.setInt(1, 2);
            preparedStatement.setDate(2, new Date(Calendar.getInstance().getTimeInMillis()));
            preparedStatement.setString(3,"Inserted desc");
            preparedStatement.setBlob(4,new FileInputStream("C:\\Users\\РС\\Desktop\\Без названия.jpg"));
            preparedStatement.setBoolean(5,true);
            preparedStatement.setString(6,"Inserted title");

            preparedStatement.execute();
        } catch (SQLException | FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            assert connection != null;
            connection.close();
        }

    }
}
