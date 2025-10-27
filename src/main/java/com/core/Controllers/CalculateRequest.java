package com.core.Controllers;

import com.core.Kernel.Controller.Request;
import com.core.Kernel.Controller.RequestAndResponseStatus;

public class CalculateRequest extends Request<CalculateRequestDTO> {
    
    protected CalculateRequest(CalculateRequestDTO req, RequestAndResponseStatus status, String error){
        super(req,status,error);
    }

    public static CalculateRequest create(CalculateRequestDTO req, RequestAndResponseStatus status, String error){
        return new CalculateRequest(req, status, error);
    }


}
