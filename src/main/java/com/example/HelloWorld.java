package main.java.com.example;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/hello") // 	The @Controller annotation defines the class as a controller mapped to the path /hello
public class HelloWorld {

    @Get(produces = MediaType.TEXT_PLAIN) // The @Get annotation maps the index method to all requests that use an HTTP GET
    public String index() {
        return "Hello World"; // A String that is returnd as a response sice it has a return type of string or plain text
    }
}