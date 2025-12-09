package com.example.lab2_2;

import javafx.collections.ObservableList;

public interface Diary {
    ObservableList<DiaryB> getAll();
   // void cancel(Diary diary) ;

    void add(DiaryB diary);

    void update(DiaryB diary);

    void delete(DiaryB diary);
}
