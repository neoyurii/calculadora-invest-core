package com.core.Kernel.ValueObject;

import com.core.Kernel.Result.Result;

public interface IValidate<TInput, TOutput> {
    Result<TOutput> validate(TInput value);
}
