package com.example;

import com.example.domain.Contribution;
import io.micronaut.data.annotation.Id;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.PageableRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@JdbcRepository(dialect = Dialect.MYSQL)
public interface ContributionRepository extends PageableRepository<Contribution, Long> {
    
    // Contribution save(Contribution contribution);
    Contribution save(@NonNull @NotBlank Long hwai_id, @NonNull @NotBlank Float amount);

    long update(@NonNull @Id Long id, @NonNull Long hwai_id, @NonNull Float amount);
}
