package com.example.lab2_2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB implements Diary {

    private final ObservableList<DiaryB> dataBase = FXCollections.observableArrayList();

    public DB() {
        loadFromDatabase();
    }

    private void loadFromDatabase() {
        try (Statement stmt = DataBase.getConnection().createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM diary3")) {

            while (rs.next()) {
                int ratingValue = 0;
                try {
                    ratingValue = Integer.parseInt(rs.getString("rating"));
                } catch (Exception ignore) {}

                DiaryB diary = new DiaryB(
                        rs.getInt("id"),
                        rs.getString("couple"),
                        rs.getString("time"),
                        rs.getString("monday"),
                        rs.getString("tuesday"),
                        rs.getString("wednesday"),
                        rs.getString("thursday"),
                        rs.getString("friday"),
                        rs.getString("subject"),
                        rs.getString("homework"),
                        rs.getString("dedlain"),
                        rs.getString("status"),
                        rs.getString("date"),
                        rs.getString("typework"),
                        ratingValue,
                        rs.getString("abcde"),
                        rs.getString("working"),
                        rs.getString("category") // підтягуємо category
                );

                dataBase.add(diary);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ObservableList<DiaryB> getAll() {
        return dataBase;
    }

    @Override
    public void add(DiaryB diary) {
        dataBase.add(diary);

        try (PreparedStatement ps = DataBase.getConnection().prepareStatement(
                "INSERT INTO diary3 (" +
                        "couple,time,monday,tuesday,wednesday,thursday,friday," +
                        "subject,homework,dedlain,status,date,typework,rating,abcde,working,category" +
                        ") VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)")) {

            ps.setString(1, diary.getCouple());
            ps.setString(2, diary.getTime());
            ps.setString(3, diary.getMonday());
            ps.setString(4, diary.getTuesday());
            ps.setString(5, diary.getWednesday());
            ps.setString(6, diary.getThursday());
            ps.setString(7, diary.getFriday());
            ps.setString(8, diary.getSubject());
            ps.setString(9, diary.getHomeWork());
            ps.setString(10, diary.getDedlain());
            ps.setString(11, diary.getStatus());
            ps.setString(12, diary.getDate());
            ps.setString(13, diary.getTypeWork());
            ps.setString(14, diary.getRating());
            ps.setString(15, diary.getAbcde());
            ps.setString(16, diary.getWorking());
            ps.setString(17, diary.getCategory());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(DiaryB diary) {
        try (PreparedStatement ps = DataBase.getConnection().prepareStatement(
                "UPDATE diary3 SET " +
                        "couple=?, time=?, monday=?, tuesday=?, wednesday=?, thursday=?, friday=?," +
                        "subject=?, homework=?, dedlain=?, status=?, date=?, typework=?, rating=?, abcde=?, working=?, category=? " +
                        "WHERE id=?")) {

            ps.setString(1, diary.getCouple());
            ps.setString(2, diary.getTime());
            ps.setString(3, diary.getMonday());
            ps.setString(4, diary.getTuesday());
            ps.setString(5, diary.getWednesday());
            ps.setString(6, diary.getThursday());
            ps.setString(7, diary.getFriday());
            ps.setString(8, diary.getSubject());
            ps.setString(9, diary.getHomeWork());
            ps.setString(10, diary.getDedlain());
            ps.setString(11, diary.getStatus());
            ps.setString(12, diary.getDate());
            ps.setString(13, diary.getTypeWork());
            ps.setString(14, diary.getRating());
            ps.setString(15, diary.getAbcde());
            ps.setString(16, diary.getWorking());
            ps.setString(17, diary.getCategory());
            ps.setInt(18, diary.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(DiaryB diary) {
        dataBase.remove(diary);

        try (PreparedStatement ps = DataBase.getConnection().prepareStatement(
                "DELETE FROM diary3 WHERE id=?")) {

            ps.setInt(1, diary.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
