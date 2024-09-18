package com.example;

import io.micronaut.http.annotation.QueryValue;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

@Controller("/hello")
public class ReadFiles {

    @Get
    public Read index(@QueryValue("file") String file) {
        // default file path is bestie
        String filePath = "Bestie.txt";
        if ( !file.isEmpty() ) {
            // if GET parameter not empty, use it instead
            filePath = file;
        }
        String contents = readQuotes(filePath);
        Read bestie = new Read(contents);
        return bestie;
    }

    public String readQuotes(String filename)  {
        String kwaari = "Users/sam/Desktop/quotes/";
        try {
            Path path = Paths.get(kwaari + filename);
            return Files.readString(path);
        } catch(IOException e) {
            e.printStackTrace();
            return "ZVAENDWA";
        }
    }
}
