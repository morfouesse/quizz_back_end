package com.antoine.quizz.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// https://programmingtechie.com/2021/01/06/spring-data-mongodb-tutorial/
// https://www.invivoo.com/replay/replay-invivoo-documenter-api-springboot-swagger.mp4

// avec auth
// https://spring.io/guides/tutorials/spring-security-and-angular-js/

//tuto localhost mongodb
// https://zellwk.com/blog/local-mongodb/
//lombock gérère à la compilation ces differentes méthodes
//@AllArgsConstructor
//@NoArgsConstructor
//@Data
@Document(collection = "surveys")
public class Survey {
    // @Indexed(unique = true)

    @Id
    private String id;

    //@Field("name")
    private String name;

    public Survey() {
    }

    public Survey(String id, String name) {
        this.id = id;
        this.name = name;
    }

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
