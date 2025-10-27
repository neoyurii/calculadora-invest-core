package com.core.Presenters;

public class BasePresenterFactory {
    private final String factory;

    protected BasePresenterFactory(String factory){
        this.factory = factory;
    }

    public BasePresenterFactory createFactory(String factory){
        return new BasePresenterFactory(factory);
    }

    

}
