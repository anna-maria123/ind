package com.example.lab2_2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {

    private static final String URL = "jdbc:sqlite:diary.db";
    private static Connection connection;

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(URL);
        }
        return connection;
    }

    public static void initialize() {
        try (Statement stmt = getConnection().createStatement()) {

            // Створюємо таблицю, якщо її нема
            String sqlCreate = "CREATE TABLE IF NOT EXISTS diary3 (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "couple TEXT," +
                    "time TEXT," +
                    "monday TEXT," +
                    "tuesday TEXT," +
                    "wednesday TEXT," +
                    "thursday TEXT," +
                    "friday TEXT," +
                    "subject TEXT," +
                    "homework TEXT," +
                    "dedlain TEXT," +
                    "status TEXT," +
                    "date TEXT," +
                    "typework TEXT," +
                    "rating TEXT," +
                    "abcde TEXT," +
                    "working TEXT," +
                    "category TEXT" + // нове поле
                    ");";
            stmt.execute(sqlCreate);

            // Безпечне додавання колонок (для оновлення старих баз)
            addColumnIfNotExists(stmt, "diary3", "category", "TEXT");

            System.out.println("DATABASE CREATED / UPDATED");

        } catch (SQLException e) {
            System.out.println("DATABASE INIT ERROR");
            e.printStackTrace();
        }
    }

    private static void addColumnIfNotExists(Statement stmt, String table, String column, String type) {
        try {
            stmt.execute("ALTER TABLE " + table + " ADD COLUMN " + column + " " + type);
        } catch (SQLException ignore) {
            // колонка вже існує
        }
    }
}
