package com.core.Kernel.ValueObject;

import com.core.Kernel.Result.Result;

public abstract class BaseValueObject<T> {
    private final T value;

    protected BaseValueObject(T value) {
        Result<T> result = validateValue(value);
        if (result.isFailed()) {
            throw new IllegalArgumentException(result.getError());
        }
        this.value = result.getValue().get();
    }

    private Result<T> validateValue(T value) {
        if (value == null) {
            return Result.fail("O valor não pode ser nulo");
        }
        return Result.sucess(value);
    }

    public T getValue() {
        return this.value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof BaseValueObject<?> other))
            return false;
        return this.value.equals(other.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
