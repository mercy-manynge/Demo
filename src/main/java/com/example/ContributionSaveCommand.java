package com.example;

import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.NotNull;

@Serdeable
public class ContributionSaveCommand {

    @NotNull
    private final Long hwai_id;

    @NotNull
    private final Float amount;

    public ContributionSaveCommand(Long hwai_id, Float amount) {
        this.hwai_id = hwai_id;
        this.amount = amount;
    }

    public Long getHwai_id() {
        return hwai_id;
    }

    public Float getAmount() {
        return amount;
    }

}
