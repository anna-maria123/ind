package com.example.lab2_2;

import javafx.beans.property.SimpleStringProperty;

public class DiaryB {
    // нове поле для вкладки/категорії


    private int id;

    private final SimpleStringProperty couple;
    private final SimpleStringProperty time;
    private final SimpleStringProperty monday;
    private final SimpleStringProperty tuesday;
    private final SimpleStringProperty wednesday;
    private final SimpleStringProperty thursday;
    private final SimpleStringProperty friday;

    private final SimpleStringProperty subject;
    private final SimpleStringProperty homeWork;
    private final SimpleStringProperty dedlain;
    private final SimpleStringProperty status;
    private final SimpleStringProperty date;
    private final SimpleStringProperty typeWork;
    private final SimpleStringProperty rating;
    private final SimpleStringProperty abcde;
    private final SimpleStringProperty working;
    private final SimpleStringProperty category;



    // -------------------------------------------------------
    // ПОВНИЙ КОНСТРУКТОР
    // -------------------------------------------------------
    public DiaryB(int id, String couple, String time,
                  String monday, String tuesday, String wednesday,
                  String thursday, String friday,
                  String subject, String homeWork, String dedlain,
                  String status, String date, String typeWork,
                  int rating, String abcde, String working,String category) {

        this.id = id;

        this.couple = new SimpleStringProperty(couple);
        this.time = new SimpleStringProperty(time);
        this.monday = new SimpleStringProperty(monday);
        this.tuesday = new SimpleStringProperty(tuesday);
        this.wednesday = new SimpleStringProperty(wednesday);
        this.thursday = new SimpleStringProperty(thursday);
        this.friday = new SimpleStringProperty(friday);

        this.subject = new SimpleStringProperty(subject);
        this.homeWork = new SimpleStringProperty(homeWork);
        this.dedlain = new SimpleStringProperty(dedlain);
        this.status = new SimpleStringProperty(status);
        this.date = new SimpleStringProperty(date);
        this.typeWork = new SimpleStringProperty(typeWork);

        this.rating = new SimpleStringProperty(String.valueOf(rating));
        this.abcde = new SimpleStringProperty(abcde);
        this.working = new SimpleStringProperty(working);
        this.category = new SimpleStringProperty(category);
    }


    // -------------------------------------------------------
    // Конструктор для розкладу (дні тижня)
    // -------------------------------------------------------
    public DiaryB(String couple, String time, String monday,
                  String tuesday, String wednesday,
                  String thursday, String friday) {

        this(0, couple, time, monday, tuesday, wednesday,
                thursday, friday,
                "", "", "",
                "", "", "",
                0, "", "","schedule");
    }


    // -------------------------------------------------------
    // ДЗ (предмет, д/з, дедлайн, статус)
    // -------------------------------------------------------
//    public DiaryB(String subject, String homeWork, String dedlain, String status) {
//
//        this(0, "", "", "", "", "", "", "",
//                subject, homeWork, dedlain, status,
//                "", "", 0, "", "","homework");
//    }
    public DiaryB(String subject, String homeWork, String dedlain, String status) {
        this(0, "", "", "", "", "", "", "",
                subject, homeWork, dedlain, status, // status передається сюди
                "", "", 0, "", "", "homework"); // category = "homework"
    }



    // -------------------------------------------------------
    // Работа з рейтингом
    // -------------------------------------------------------
    public DiaryB(String subject, String date, String typeWork,
                  int rating, String abcde) {

        this(0, "", "", "", "", "", "", "",
                subject, "", "", "",
                date, typeWork, rating, abcde, "","rating");
    }


    // -------------------------------------------------------
    // Работа зі статусом
    // -------------------------------------------------------
    public DiaryB(String subject, String date, String status,
                  String typeWork, String working) {

        this(0, "", "", "", "", "", "", "",
                subject, "", "", status,
                date, typeWork, 0, "", working,"visiting");
    }


    // -------------------------------------------------------
    // ГЕТТЕРИ + СЕТТЕРИ
    // -------------------------------------------------------

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getCouple() { return couple.get(); }
    public void setCouple(String value) { this.couple.set(value); }
    public SimpleStringProperty coupleProperty() { return couple; }

    public String getTime() { return time.get(); }
    public void setTime(String time) { this.time.set(time); }
    public SimpleStringProperty timeProperty() { return time; }

    public String getMonday() { return monday.get(); }
    public void setMonday(String value) { this.monday.set(value); }
    public SimpleStringProperty mondayProperty() { return monday; }

    public String getTuesday() { return tuesday.get(); }
    public void setTuesday(String value) { this.tuesday.set(value); }
    public SimpleStringProperty tuesdayProperty() { return tuesday; }

    public String getWednesday() { return wednesday.get(); }
    public void setWednesday(String value) { this.wednesday.set(value); }
    public SimpleStringProperty wednesdayProperty() { return wednesday; }

    public String getThursday() { return thursday.get(); }
    public void setThursday(String value) { this.thursday.set(value); }
    public SimpleStringProperty thursdayProperty() { return thursday; }

    public String getFriday() { return friday.get(); }
    public void setFriday(String value) { this.friday.set(value); }
    public SimpleStringProperty fridayProperty() { return friday; }

    public String getSubject() { return subject.get(); }
    public void setSubject(String value) { this.subject.set(value); }
    public SimpleStringProperty subjectProperty() { return subject; }

    public String getHomeWork() { return homeWork.get(); }
    public void setHomeWork(String value) { this.homeWork.set(value); }
    public SimpleStringProperty homeWorkProperty() { return homeWork; }

    public String getDedlain() { return dedlain.get(); }
    public void setDedlain(String value) { this.dedlain.set(value); }
    public SimpleStringProperty dedlainProperty() { return dedlain; }

    public String getStatus() { return status.get(); }
    public void setStatus(String value) { this.status.set(value); }
    public SimpleStringProperty statusProperty() { return status; }

    public String getDate() { return date.get(); }
    public void setDate(String value) { this.date.set(value); }
    public SimpleStringProperty dateProperty() { return date; }

    public String getTypeWork() { return typeWork.get(); }
    public void setTypeWork(String value) { this.typeWork.set(value); }
    public SimpleStringProperty typeWorkProperty() { return typeWork; }

    public String getRating() { return rating.get(); }
    public void setRating(String value) { this.rating.set(value); }
    public SimpleStringProperty ratingProperty() { return rating; }

    public String getAbcde() { return abcde.get(); }
    public void setAbcde(String value) { this.abcde.set(value); }
    public SimpleStringProperty abcdeProperty() { return abcde; }

    public String getWorking() { return working.get(); }
    public void setWorking(String value) { this.working.set(value); }
    public SimpleStringProperty workingProperty() { return working; }
    public String getCategory() { return category.get(); }
    public void setCategory(String value) { category.set(value); }
    public SimpleStringProperty categoryProperty() { return category; }

}
