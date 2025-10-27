package com.core.Controllers;

import com.core.Kernel.Controller.Response;

public class CalculateResponse extends Response<CalculateResponseDTO> {

    protected CalculateResponse(CalculateResponseDTO res, String message, Boolean status, String error) {
        super(res, message, status, error);
    }

    public static CalculateResponse create(CalculateResponseDTO res, String message, Boolean status, String error) {
        return new CalculateResponse(res, message, status, error);
    }
}
