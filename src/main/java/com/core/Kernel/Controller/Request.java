package com.core.Kernel.Controller;

import java.time.LocalDateTime;

import com.core.Kernel.Entity.Identifier;

public abstract class Request {
    private final Identifier id;
    private final RequestAndResponseData<?> data;
    private final RequestAndResponseStatus status;
    private final String error;
    private final LocalDateTime date;

    public Request(RequestAndResponseData<?> data, RequestAndResponseStatus status, String error) {
        this.id = Identifier.generateUUID();
        this.data = data;
        this.status = status;
        this.error = error;
        this.date = LocalDateTime.now();
    }

    public RequestAndResponseData<?> getRequestData(){
        return this.data;
    }

    public RequestAndResponseStatus getStatus() {
        return this.status;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Identifier getId() {
        return id;
    }

    public String getError() {
        return this.error;
    }

}
