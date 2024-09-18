package com.example;
import com.example.domain.Stock;
import io.micronaut.data.exceptions.DataAccessException;
import io.micronaut.data.model.Pageable;
import io.micronaut.http.HttpHeaders;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Put;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.http.annotation.Status;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import io.micronaut.http.annotation.QueryValue;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.annotation.ObjectIdGenerators.StringIdGenerator;

@ExecuteOn(TaskExecutors.BLOCKING)
@Controller("/stocks") 
public class StockController {

    protected final StockRepository stockRepository;

    public StockController(StockRepository stockRepository) { 
        this.stockRepository = stockRepository;
    }

    @Get
    public String index(@QueryValue("item") String item){
        stockRepository.save(item);
        return"OK";

    }
}
