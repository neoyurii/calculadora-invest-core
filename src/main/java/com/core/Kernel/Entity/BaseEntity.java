package com.core.Kernel.Entity;

public abstract class BaseEntity {
    private final Identifier id;

    protected BaseEntity(){
        this.id = Identifier.generateUUID();
    }

    protected BaseEntity(Identifier uuid){
        this.id = uuid;
    }

    public Identifier getId(){
        return id;
    }
}
