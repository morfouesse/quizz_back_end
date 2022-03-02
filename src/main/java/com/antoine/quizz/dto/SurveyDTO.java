package com.antoine.quizz.dto;

// une classe qui permet de receuillir les données d'un client via de l'HTML ou JSON
public class SurveyDTO {
    private String id;

    private String name;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
