package com.example.domain;

import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.GeneratedValue;
import jakarta.validation.constraints.NotNull;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;


@Serdeable;
@MappedEntity
public class Contribution{
    @Id
    @GeneratedValue(GeneratedValue.Type.AUTO)
    private Long id;

    @NotNull
    private Long hwai_id;
    private Float amount;

    public Long getId(){
        return id;
    }
    public Long getHwai_id(){
        return hwai_id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public void setHwai_id(Long hwai_id){
        this.hwai_id = hwai_id;
    }

    public void setAmount(Float amount){
        this.amount = amount;
    }

}