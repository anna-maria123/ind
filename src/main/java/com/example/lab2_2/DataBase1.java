///package com.example.lab2_2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


//public class DataBase1 {
//    private static final String URL = "jdbc:sqlite:diary.db"; // файл бази
//    private static Connection connection;
//
//    public static Connection getConnection() throws SQLException {
//        if (connection == null || connection.isClosed()) {
//            connection = DriverManager.getConnection(URL);
//        }
//        return connection;
//    }
//
//    /**
//     * Ініціалізація таблиці: створює таблицю, якщо її немає, додає колонки, яких не вистачає
//     */
//    public static void initialize() {
//        try (Statement stmt = getConnection().createStatement()) {
//
//            // 1. Створити таблицю, якщо її немає
//            String sqlCreate = "CREATE TABLE IF NOT EXISTS diary (" +
//                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
//                    "couple TEXT," +
//                    "time TEXT," +
//                    "monday TEXT," +
//                    "tuesday TEXT," +
//                    "wednesday TEXT," +
//                    "thursday TEXT," +
//                    "friday TEXT," +
//                    "status TEXT," +
//                    "subject TEXT," +
//                    "homework TEXT," +
//                    "dedlain TEXT," +
//                    "typework TEXT," +
//                    "rating TEXT," +
//                    "date TEXT," +
//                    "abcde TEXT" +
//                    ");";
//            stmt.execute(sqlCreate);
//
//            // 2. Додати нові колонки, якщо їх ще немає
//            addColumnIfNotExists(stmt, "diary", "status", "TEXT");
//            addColumnIfNotExists(stmt, "diary", "subject", "TEXT");
//            addColumnIfNotExists(stmt, "diary", "homework", "TEXT");
//            addColumnIfNotExists(stmt, "diary", "dedlain", "TEXT");
//            addColumnIfNotExists(stmt, "diary", "typework", "TEXT");
//            addColumnIfNotExists(stmt, "diary", "rating", "TEXT");
//            addColumnIfNotExists(stmt, "diary", "date", "TEXT");
//            addColumnIfNotExists(stmt, "diary", "abcde", "TEXT");
//
//            System.out.println("DATABASE CREATED / UPDATED");
//
//        } catch (SQLException e) {
//            System.out.println("DATABASE INIT ERROR");
//            e.printStackTrace();
//        }
//    }
//
//    private static void addColumnIfNotExists(Statement stmt, String tableName, String columnName, String type) {
//        try {
//            stmt.execute("ALTER TABLE " + tableName + " ADD COLUMN " + columnName + " " + type + ";");
//        } catch (SQLException e) {
//            // колонка вже існує — нічого не робимо
//        }
//    }
//}

//    private static final String URL = "jdbc:sqlite:diary3.db";
//    private static Connection connection;
//
//    /**
//     * Повертає спільне підключення для всіх контролерів
//     */
//    public static Connection getConnection() throws SQLException {
//        if (connection == null || connection.isClosed()) {
//            connection = DriverManager.getConnection(URL);
//        }
//        return connection;
//    }
//
//    /**
//     * Створює таблицю (повністю відповідає класу DiaryB)
//     */
//    public static void initialize() {
//        try (Statement stmt = getConnection().createStatement()) {
//            // 1. Створити таблицю, якщо її немає
//            String sqlCreate = "CREATE TABLE IF NOT EXISTS diary2 (" +
//                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
//                    "couple TEXT," +
//                    "time TEXT," +
//                    "monday TEXT," +
//                    "tuesday TEXT," +
//                    "wednesday TEXT," +
//                    "thursday TEXT," +
//                    "friday TEXT," +
//                    "status TEXT," +
//                    "subject TEXT," +
//                    "homework TEXT," +
//                    "dedlain TEXT," +
//                    "typework TEXT," +
//                    "rating TEXT," +
//                    "date TEXT," +
//                    "abcde TEXT" +
//                    ");";
//            stmt.execute(sqlCreate);

            // 2. Додати нові колонки, якщо їх ще немає
//            try { stmt.execute("ALTER TABLE diary2 ADD COLUMN date TEXT;"); } catch (SQLException e) {}
//            try { stmt.execute("ALTER TABLE diary2 ADD COLUMN typework TEXT;"); } catch (SQLException e) {}
//            try { stmt.execute("ALTER TABLE diary2 ADD COLUMN rating TEXT;"); } catch (SQLException e) {}
//            try { stmt.execute("ALTER TABLE diary2 ADD COLUMN abcde TEXT;"); } catch (SQLException e) {}
//
//            System.out.println("DATABASE CREATED / UPDATED");
//
//        } catch (SQLException e) {
//            System.out.println("DATABASE INIT ERROR");
//            e.printStackTrace();
//        }
//    }

//    public static void addDiary(DiaryB diary) {
//        String sql = "INSERT INTO diary2 (couple, time, monday, tuesday, wednesday, thursday, friday) VALUES (?, ?, ?, ?, ?, ?, ?)";
//        try (var conn = getConnection(); var pstmt = conn.prepareStatement(sql)) {
//            pstmt.setString(1, diary.getCouple());
//            pstmt.setString(2, diary.getTime());
//            pstmt.setString(3, diary.getMonday());
//            pstmt.setString(4, diary.getTuesday());
//            pstmt.setString(5, diary.getWednesday());
//            pstmt.setString(6, diary.getThursday());
//            pstmt.setString(7, diary.getFriday());
//            pstmt.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//    public static void updateDiary(DiaryB diary) {
//        String sql = "UPDATE diary2 SET couple=?, time=?, monday=?, tuesday=?, wednesday=?, thursday=?, friday=? WHERE id=?";
//        try (var conn = getConnection(); var pstmt = conn.prepareStatement(sql)) {
//            pstmt.setString(1, diary.getCouple());
//            pstmt.setString(2, diary.getTime());
//            pstmt.setString(3, diary.getMonday());
//            pstmt.setString(4, diary.getTuesday());
//            pstmt.setString(5, diary.getWednesday());
//            pstmt.setString(6, diary.getThursday());
//            pstmt.setString(7, diary.getFriday());
//            pstmt.setInt(8, diary.getId()); // треба додати поле id у DiaryB
//            pstmt.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//



