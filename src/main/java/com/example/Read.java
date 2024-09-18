package com.example;

public class Read {
    private String quote;
    
    public Read(String quote) {
        this.quote = quote;
    }

    public Read(){}

    public String getQuote(){
        return quote;
    }

    public void setQuote(String quote){
        this.quote = quote;
    }
}
