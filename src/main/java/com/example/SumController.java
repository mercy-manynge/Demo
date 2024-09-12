package com.example;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.http.annotation.Produces;

@Controller("/sum")//The @Controller annotation defines the class as a controller mapped to the path /sum
public class SumController {

    @Get("/addition/{a}/{b}")// The @Get annotation maps the index method to all requests that use an HTTP GET, but Here it maps to /sum/addition/{a}/{b}
    @Produces(MediaType.TEXT_PLAIN)// Specifies that the response will be of plain text typeReturns a string and an int
    public String add(@QueryValue int a, @QueryValue int b) {  
        int c = a + b;
        return "The sum is: " + c;  // Returns a string and an int value
    }
}
