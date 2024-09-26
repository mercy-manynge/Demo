package com.example;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Optional;
import java.util.HashMap;
import java.util.Map;

@Controller("/bible")// controller that listens to /bible
public class BibleController {

    private final OkHttpClient client = new OkHttpClient();//client for sending HTTP requests
    private final ObjectMapper objectMapper = new ObjectMapper();// ObjectMapper is used to convert java objects to and from JSON

    @Get("/{book}/{chapter}{?verse}")
    public Map<String, Object> getBibleVerse(String book, int chapter, Optional<Integer> verse) throws IOException {
        StringBuilder url = new StringBuilder("https://bible-api.com/" + book + "+" + chapter);
        verse.ifPresent(v -> url.append(":").append(v));

        Request request = new Request.Builder().url(url.toString()).build();//sends the HTTP request and waits for the server's response.

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                Map<String, Object> errorResponse = new HashMap<>();
                errorResponse.put("error", "Failed to fetch the verse. Status: " + response.code());
                return errorResponse;
            }

            
            String responseBody = response.body().string();
            JsonNode jsonResponse = objectMapper.readTree(responseBody);// JsonNode is a class provided by jackson fro working with JSON in a tree structure

            
            String reference = jsonResponse.get("reference").asText();// Extract only the refence and the verse 
            JsonNode versesNode = jsonResponse.get("verses");

            
            String[] verses = new String[versesNode.size()];// Extract the verse text into an array
            for (int i = 0; i < versesNode.size(); i++) {
                verses[i] = versesNode.get(i).get("text").asText();
            }

            
            Map<String, Object> result = new HashMap<>();//Use HashMap to map the key to the value, the refence to the verse
            result.put("reference", reference);
            result.put("verses", verses);

            return result;// Returned result 
        }
    }
}
