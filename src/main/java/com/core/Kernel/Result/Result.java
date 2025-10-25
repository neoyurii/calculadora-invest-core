package com.core.Kernel.Result;

import java.util.Optional;

public class Result<T> {
    private final Boolean isSucess;
    private final T value;
    private final String error;

    public Result(Boolean isSucess, T value, String error) {
        this.isSucess = isSucess;
        this.value = value;
        this.error = error;
    }

    public static <T> Result<T> sucess(T value) {
        return new Result<>(true, value, null);
    }

    public static <T> Result<T> fail(String error) {
        return new Result<>(false, null, error);
    }

    public Boolean isSucess() {
        return isSucess;
    }

    public Boolean isFailed() {
        return !isSucess;
    }

    public String getError(){
        return error;
    }

    public Optional<T> getValue(){
        return Optional.ofNullable(value);
    }
}
