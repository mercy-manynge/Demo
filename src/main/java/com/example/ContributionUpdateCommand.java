package com.example;

import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.NotNull;

@Serdeable
public class ContributionUpdateCommand {
    @NotNull
    private  final Long id;

    @NotNull
    private final Long hwai_id;

    @NotNull
    private final Float amount;

    public ContributionUpdateCommand ( Long id, Long hwai_id , Float amount){
        this.id = id;
        this.hwai_id = hwai_id;
        this.amount = amount;
    }

    public Long getId(){
        return id;

    }

    public  Long getHwai_id(){
        return hwai_id;

    }
    public Float getAmount(){
        return amount;

    }
}
