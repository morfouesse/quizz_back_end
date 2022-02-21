package com.antoine.quizz.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

// https://programmingtechie.com/2021/01/06/spring-data-mongodb-tutorial/

//tuto localhost mongodb
// https://zellwk.com/blog/local-mongodb/
//lombock gérère à la compilation ces differentes méthodes
//@AllArgsConstructor
//@NoArgsConstructor
//@Data
@Document(collection ="surveys")
public class Survey {
    // @Indexed(unique = true)

    @Id
    private String id;

    //@Field("name")
    private  String name;

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
