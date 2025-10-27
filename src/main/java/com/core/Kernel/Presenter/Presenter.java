package com.core.Kernel.Presenter;

import com.core.Kernel.Controller.Response;

public interface Presenter<T> {
    T show(Response res);
}
