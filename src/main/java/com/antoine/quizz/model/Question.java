package com.antoine.quizz.model;

import org.springframework.data.annotation.Id;

public class Question {

    @Id
    public String id;

    public  String name;

    public Question() {
        super();
    }

    public Question(String id) {
        this.id = id;
    }

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
        return "Question{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}