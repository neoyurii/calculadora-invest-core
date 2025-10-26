package com.core.Controllers;

import com.core.Kernel.Controller.Request;

public class CalculateRequest extends Request<CalculateRequestDTO> {
    
    protected CalculateRequest(CalculateRequestDTO req, Boolean status, String error){
        super(req,status,error);
    }

    public static CalculateRequest create(CalculateRequestDTO req, Boolean status, String error){
        return new CalculateRequest(req, status, error);
    }


}
