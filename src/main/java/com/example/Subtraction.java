package com.example;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.http.annotation.Post;


@Controller ("/subtraction")
public class Subtraction {
    @Get("/difference/{num}/{num1}")
    @Produces(MediaType.TEXT_PLAIN)
    public String subtract(@QueryValue int num, @QueryValue int num1){
        return "The differennce is: " + (num - num1);
    }
    
}
