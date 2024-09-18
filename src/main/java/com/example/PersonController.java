package com.example;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Produces;

@Controller("/")
public class PersonController {

    @Post("/hello")
    @Produces(MediaType.TEXT_PLAIN)  // Set the correct response type
    public String hello(@Body Person person) {
        return "Hello " + person.getName() + " " + person.getSurname() + "!";
    }
}
