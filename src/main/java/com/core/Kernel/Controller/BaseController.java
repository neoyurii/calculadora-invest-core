package com.core.Kernel.Controller;

import com.core.Kernel.Presenter.PresenterFactory;
import com.core.Kernel.Result.Result;
import com.core.Kernel.useCase.BaseUseCase;

public abstract class BaseController {
    protected final Request req;
    protected final Response res;

    protected BaseController(Request req, Response res) {
        this.req = req;
        this.res = res;
    }

    public PresenterFactory handle(BaseUseCase useCase){
        
    }

    public RequestAndResponseStatus getRequestStatus() {
        return this.req.getStatus();
    }

    public RequestAndResponseStatus getResponseStatus() {
        return this.res.getStatus();
    }

    public Result<RequestAndResponseData<?>> getRequestData(){
        return getData(this.req.getStatus(), this.req.getRequestData(), "requisição");
    }

    public Result<RequestAndResponseData<?>> getResponseData(){
        return getData(this.res.getStatus(), this.res.getResponseData(), "response");
    }

    private Result<RequestAndResponseData<?>> getData(RequestAndResponseStatus status, RequestAndResponseData<?> data, String contextName){
        switch (status) {
            case PENDING:
                return Result.fail("A" + contextName + "está sendo processada, por favor aguarde");
            case FAIL:
                return Result.fail("A" + contextName + "falhou, tente novamente mais tarde");
            default:
                return Result.sucess(data);
        }
    }

}
