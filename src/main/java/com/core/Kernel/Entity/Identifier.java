package com.core.Kernel.Entity;

import com.core.Kernel.Result.Result;
import com.core.Kernel.ValueObject.BaseValueObject;
import com.core.Kernel.ValueObject.RegexTypes;

public class Identifier extends BaseValueObject<String>{
    private final static RegexTypes regex = RegexTypes.UUID;

    protected Identifier(String id){
        super(id);
    }

    private static Result<Identifier> validateUUID(String uuid){
        if(!regex.isValid(uuid)){
            return Result.fail("O UUID não é válido");
        }
        return Result.sucess(new Identifier(uuid));
    }

    public static Identifier generateUUID(){
        String uuid = UUIDGenerator.generateUUID();
        return validateUUID(uuid).getValue().orElseThrow();
    }
}
