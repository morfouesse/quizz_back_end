package com.antoine.quizz.model;

import org.springframework.data.annotation.Id;
import org.springframework.lang.NonNull;

public class Question {

    @Id
    @NonNull
    public String id;

    @NonNull
    public String name;


    public Question(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Question{" + "id='" + id + '\'' + ", name='" + name + '\'' + '}';
    }
}