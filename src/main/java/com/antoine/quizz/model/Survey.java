package com.antoine.quizz.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.NonNull;

// pour les notNull sur attributs
//https://stackoverflow.com/questions/42292359/spring-data-mongodb-not-null-annotation-like-spring-data-jpa

// https://programmingtechie.com/2021/01/06/spring-data-mongodb-tutorial/
// https://www.invivoo.com/replay/replay-invivoo-documenter-api-springboot-swagger.mp4

// avec auth
// https://spring.io/guides/tutorials/spring-security-and-angular-js/

//tuto localhost mongodb
// https://zellwk.com/blog/local-mongodb/ lombock
//génère à la compilation ces
// differentes méthodes (ne fonctionne pas avec
// la version actuelle d'intellij)
//@AllArgsConstructor
//@NoArgsConstructor
//@Data
@Document(collection = "surveys")
public class Survey {
    // @Indexed(unique = true)

    @Id
    @NonNull
    private String id;

    @NonNull
    private String name;


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

    @Override
    public String toString() {
        return "Survey{" + "id='" + id + '\'' + ", name='" + name + '\'' + '}';
    }
}
