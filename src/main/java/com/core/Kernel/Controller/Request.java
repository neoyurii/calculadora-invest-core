package com.core.Kernel.Controller;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.core.Kernel.Entity.Identifier;
import com.core.Kernel.Result.Result;

public abstract class Request<T> {
    private final Identifier id;
    private final T body;
    private final Boolean status;
    private final String error;
    private final LocalDateTime date;

    public Request(T body, Boolean status, String error){
        this.id = Identifier.generateUUID();
        this.body = body;
        this.status = status;
        this.error = error;
        this.date = LocalDateTime.now();
    }

    public T getBody(){
        return this.body;
    }

    public Boolean getStatus(){
        return this.status;
    }

    public String getError(){
        return this.error;
    }


}
