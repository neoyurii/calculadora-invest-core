package com.core.Kernel.Controller;

public abstract class Response{
    private final RequestAndResponseData<?> data;
    private final String message;
    private final RequestAndResponseStatus status;

    public Response(RequestAndResponseData<?> data, String message, RequestAndResponseStatus status){
        this.data = data;
        this.message = message;
        this.status = status;
    }

    public RequestAndResponseData<?> getResponseData(){
        return this.data;
    }

    public String getMessage(){
        return this.message;
    }

    public RequestAndResponseStatus getStatus(){
        return this.status;
    }
}
