package com.core.Kernel.Controller;

import com.core.Kernel.Result.Result;

public interface BaseController<TReq extends Request<?>, TRes extends Response<?>> {

    Result<TRes> execute(TReq request);

}
