package com.codecool.runner;

import com.codecool.model.Breed;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("app")
public class RoboDogApplication implements ApplicationRunner {

    @Value("${app.name}")
    private String dogName;

    @Value("${app.age}")
    private String age;

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        System.out.println(dogName + " " + age);
    }
}
