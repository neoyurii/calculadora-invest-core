package com.core.Kernel.Controller;

public abstract class RequestAndResponseData<T> {
    private final T data;

    protected RequestAndResponseData(T data){
        this.data = data;
    }

    public T getData(){
        return this.data;
    }
}
