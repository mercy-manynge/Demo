package com.example;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest // Annotation to signal that this is a Micronaut test
class SumControllerTest {

    @Inject
    @Client("/")  // Inject an HTTP client to make requests
    HttpClient client;

    @Test
    void testAddition() {
        HttpRequest<String> request = HttpRequest.GET("/sum/addition/3/5");// Define the HTTP request to call the controller method

        HttpResponse<String> response = client.toBlocking().exchange(request, String.class);// Execute the request and get the response

        assertEquals(HttpStatus.OK, response.getStatus());// Assert the status code is OK (200)
        // Make sure that the response body is correct
        assertEquals("The sum is: 8", response.body());
    }
}
