package com.antoine.quizz.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCommandException;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

@Configuration
@EnableMongoRepositories(basePackages = "com.antoine.quizz.repository")
public class ApplicationConfig extends AbstractMongoClientConfiguration {

    @Autowired
    private Environment env;

    private MongoClient mongoClient;


    // mongodb.database.test ou mongodb.database.dev ou mongodb.database.prod (plus tard)
    @Override
    protected String getDatabaseName() {
        return env.getProperty("mongodb.database.test");
    }


    @Override
    public MongoClient mongoClient() {

        // si pb de "SocketTimeoutException: connect timed out”, redémarer le service lié à mongoDB
        // si l'ip sur mongodb atlas est lié à l'adresse ip de votre ordi, attention si vous avez
        // une adresse dynamique, l'adresse va changer et alors vous n'aurez plus l'autorisation
        // d'appeler la BDD

        try {

            String pass = "root";
            ConnectionString connectionString = new ConnectionString(
                    Objects.requireNonNull(env.getProperty("mongodb.connection.string")) + Objects.requireNonNull(
                            env.getProperty("mongodb.connection.string")));

            MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                    .credential(MongoCredential.createCredential("Chloe", this.getDatabaseName(), pass.toCharArray()))
                    .applyConnectionString(connectionString)
                    .build();

            return MongoClients.create(mongoClientSettings);
        } catch (MongoCommandException e) {
            return null;
        }


    }

    @Override
    protected Collection<String> getMappingBasePackages() {
        return Collections.singleton("com.antoine.QuizzApplication");
    }
}
