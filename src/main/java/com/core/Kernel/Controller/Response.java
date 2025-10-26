package com.core.Kernel.Controller;

import com.core.Kernel.Result.Result;

public abstract class Response<T> {
    private final T body;
    private final String message;
    private final Boolean status;
    private final String error;

    public Response(T body, String message, Boolean status, String error){
        this.body = body;
        this.message = message;
        this.status = status;
        this.error = error;
    }

    public T getBody(){
        return this.body;
    }

    public String getMessage(){
        return this.message;
    }

    public Boolean getStatus(){
        return this.status;
    }

    public String getError(){
        return this.error;
    }

}
