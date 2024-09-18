package com.example;
import com.example.domain.Stock;
import io.micronaut.data.annotation.Id;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.PageableRepository;
import io.micronaut.data.exceptions.DataAccessException;

import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@JdbcRepository(dialect = Dialect.MYSQL)
public interface StockRepository extends PageableRepository<Stock, Long>{

    Stock save(@NonNull @NotBlank String item );

    @Transactional
    default Stock saveWithException(@NonNull @NotNull String item){
        save(item);
        throw new DataAccessException("test exception");
    }

    long update (@NonNull @NotNull @Id Long id, @NonNull @NotBlank String item);
} 
