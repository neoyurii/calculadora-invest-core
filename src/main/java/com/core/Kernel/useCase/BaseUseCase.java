package com.core.Kernel.useCase;

import com.core.Kernel.Controller.Request;
import com.core.Kernel.Controller.Response;
import com.core.Kernel.Result.Result;

public interface BaseUseCase {
    Result<Response> execute(Request req);
}
