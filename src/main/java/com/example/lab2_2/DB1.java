//package com.example.lab2_2;

//public class DB1 implements Diary {
//    private final ObservableList<DiaryB> dataBase = FXCollections.observableArrayList();
//
//    public DB() {
//        loadFromDatabase();
//    }
//
//    private void loadFromDatabase() {
//        try (Statement stmt = DataBase.getConnection().createStatement();
//             ResultSet rs = stmt.executeQuery(
//                     "SELECT * FROM diary")) {
//
//            while (rs.next()) {
//                DiaryB diary = new DiaryB(
//                        rs.getInt("id"),
//                        rs.getString("couple"),
//                        rs.getString("time"),
//                        rs.getString("monday"),
//                        rs.getString("tuesday"),
//                        rs.getString("wednesday"),
//                        rs.getString("thursday"),
//                        rs.getString("friday"),
//                        rs.getString("subject"),
//                        rs.getString("homework"),
//                        rs.getString("dedlain"),
//                        rs.getString("status"),
//                        rs.getString("date"),
//                        rs.getString("typework"),
//                        rs.getString("rating"),
//                        rs.getString("abcde")
//                );
//                dataBase.add(diary);
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public ObservableList<DiaryB> getAll() {
//        return dataBase;
//    }
//
//    @Override
//    public void add(DiaryB diary) {
//        try (PreparedStatement ps = DataBase.getConnection().prepareStatement(
//                "INSERT INTO diary(couple,time,monday,tuesday,wednesday,thursday,friday," +
//                        "subject,homework,dedlain,status,date,typework,rating,abcde) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
//                Statement.RETURN_GENERATED_KEYS)) {
//
//            ps.setString(1, diary.getCouple());
//            ps.setString(2, diary.getTime());
//            ps.setString(3, diary.getMonday());
//            ps.setString(4, diary.getTuesday());
//            ps.setString(5, diary.getWednesday());
//            ps.setString(6, diary.getThursday());
//            ps.setString(7, diary.getFriday());
//            ps.setString(8, diary.getSubject());
//            ps.setString(9, diary.getHomeWork());
//            ps.setString(10, diary.getDedlain());
//            ps.setString(11, diary.getStatus());
//            ps.setString(12, diary.getDate());
//            ps.setString(13, diary.getTypeWork());
//            ps.setString(14, diary.getRating());
//            ps.setString(15, diary.getAbcde());
//
//            ps.executeUpdate();
//
//            // отримати згенерований id та поставити у DiaryB
//            try (ResultSet keys = ps.getGeneratedKeys()) {
//                if (keys.next()) diary.setId(keys.getInt(1));
//            }
//
//            dataBase.add(diary);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void update(DiaryB diary) {
//        try (PreparedStatement ps = DataBase.getConnection().prepareStatement(
//                "UPDATE diary SET couple=?, time=?, monday=?, tuesday=?, wednesday=?, thursday=?, friday=?," +
//                        "subject=?, homework=?, dedlain=?, status=?, date=?, typework=?, rating=?, abcde=? WHERE id=?")) {
//
//            ps.setString(1, diary.getCouple());
//            ps.setString(2, diary.getTime());
//            ps.setString(3, diary.getMonday());
//            ps.setString(4, diary.getTuesday());
//            ps.setString(5, diary.getWednesday());
//            ps.setString(6, diary.getThursday());
//            ps.setString(7, diary.getFriday());
//            ps.setString(8, diary.getSubject());
//            ps.setString(9, diary.getHomeWork());
//            ps.setString(10, diary.getDedlain());
//            ps.setString(11, diary.getStatus());
//            ps.setString(12, diary.getDate());
//            ps.setString(13, diary.getTypeWork());
//            ps.setString(14, diary.getRating());
//            ps.setString(15, diary.getAbcde());
//            ps.setInt(16, diary.getId());
//
//            ps.executeUpdate();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void delete(DiaryB diary) {
//        try (PreparedStatement ps = DataBase.getConnection().prepareStatement(
//                "DELETE FROM diary WHERE id=?")) {
//
//            ps.setInt(1, diary.getId());
//            ps.executeUpdate();
//            dataBase.remove(diary);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

//    private final ObservableList<DiaryB> dataBase = FXCollections.observableArrayList();
//
//    public DB() {
//        loadFromDatabase();
//    }
//
//    private void loadFromDatabase() {
//        try (Statement stmt = DataBase.getConnection().createStatement();
//             ResultSet rs = stmt.executeQuery(
//                     "SELECT id, couple, time, monday, tuesday, wednesday, thursday, friday, " +
//                             " subject, homework, dedlain,status,date, typework, rating,abcde FROM diary3")) {
//
//            while (rs.next()) {
//                DiaryB diary = new DiaryB(
//                        rs.getInt("id"),
//                        rs.getString("couple"),
//                        rs.getString("time"),
//                        rs.getString("monday"),
//                        rs.getString("tuesday"),
//                        rs.getString("wednesday"),
//                        rs.getString("thursday"),
//                        rs.getString("friday"),
//                        rs.getString("subject"),
//                        rs.getString("homework"),
//                        rs.getString("dedlain"),
//                        rs.getString("status"),
//                        rs.getString("date"),
//                        rs.getString("typework"),
//                        rs.getString("rating"),
//                        rs.getString("abcde")
//                );
//                dataBase.add(diary);
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public ObservableList<DiaryB> getAll() {
//        return dataBase;
//    }
//
//    @Override
//    public void add(DiaryB diary) {
//        dataBase.add(diary);
//        try (PreparedStatement ps = DataBase.getConnection().prepareStatement(
//                "INSERT INTO diary3(couple,time,monday,tuesday,wednesday,thursday,friday," +
//                        "subject,homework,dedlain,status,date,typework,rating,abcde) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)")) {
//
//            ps.setString(1, diary.getCouple());
//            ps.setString(2, diary.getTime());
//            ps.setString(3, diary.getMonday());
//            ps.setString(4, diary.getTuesday());
//            ps.setString(5, diary.getWednesday());
//            ps.setString(6, diary.getThursday());
//            ps.setString(7, diary.getFriday());
//            ps.setString(8, diary.getSubject());
//            ps.setString(9, diary.getHomeWork());
//            ps.setString(10, diary.getDedlain());
//            ps.setString(11, diary.getStatus());
//            ps.setString(13, diary.getDate());
//            ps.setString(12, diary.getTypeWork());
//            ps.setString(15, diary.getRating());
//            ps.setString(14, diary.getAbcde());
//
//            ps.executeUpdate();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//
////    @Override
////    public void update(DiaryB diary) {
////        try (PreparedStatement ps = DataBase.getConnection().prepareStatement(
////                "UPDATE diary2 SET monday=?, tuesday=?, wednesday=?, thursday=?, friday=?," +
////                        " subject=?, homework=?, dedlain=?,status=?, typework=?, rating=? " +
////                        "WHERE couple=? AND time=?")) {
////
////            ps.setString(1, diary.getMonday());
////            ps.setString(2, diary.getTuesday());
////            ps.setString(3, diary.getWednesday());
////            ps.setString(4, diary.getThursday());
////            ps.setString(5, diary.getFriday());
////            ps.setString(6, diary.getSubject());
////            ps.setString(7, diary.getHomeWork());
////            ps.setString(8, diary.getDedlain());
////            ps.setString(9, diary.getStatus());
////            ps.setString(10, diary.getTypeWork());
////            ps.setString(11, diary.getRating());
////            ps.setString(12, diary.getCouple());
////            ps.setString(13, diary.getTime());
////
////            ps.executeUpdate();
////
////        } catch (SQLException e) {
////            e.printStackTrace();
////        }
////    }
//@Override
//public void update(DiaryB diary) {
//    try (PreparedStatement ps = DataBase.getConnection().prepareStatement(
//            "UPDATE diary3 SET couple=?, time=?, monday=?, tuesday=?, wednesday=?, thursday=?, friday=?," +
//                    "subject=?, homework=?, dedlain=?, status=?, date=?,typework=?,  rating=?, abcde=? WHERE id=?")) {
//
//        ps.setString(1, diary.getCouple());
//        ps.setString(2, diary.getTime());
//        ps.setString(3, diary.getMonday());
//        ps.setString(4, diary.getTuesday());
//        ps.setString(5, diary.getWednesday());
//        ps.setString(6, diary.getThursday());
//        ps.setString(7, diary.getFriday());
//        ps.setString(8, diary.getSubject());
//        ps.setString(9, diary.getHomeWork());
//        ps.setString(10, diary.getDedlain());
//        ps.setString(11, diary.getStatus());
//        ps.setString(12, diary.getDate());
//        ps.setString(13, diary.getTypeWork());
//        ps.setString(14, diary.getRating());
//        ps.setString(15, diary.getAbcde());
//        ps.setInt(16, diary.getId()); // <-- оновлюємо по id
//
//        ps.executeUpdate();
//
//    } catch (SQLException e) {
//        e.printStackTrace();
//    }
//}
//
//
//    @Override
//    public void delete(DiaryB diary) {
//        dataBase.remove(diary);
//        try (PreparedStatement ps = DataBase.getConnection().prepareStatement(
//                "DELETE FROM diary3 WHERE couple=? AND time=?")) {
//
//            ps.setString(1, diary.getCouple());
//            ps.setString(2, diary.getTime());
//            ps.executeUpdate();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//}
