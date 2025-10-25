package com.core.Kernel.ValueObject;

public enum RegexTypes {
    UUID("^[0-9a-f]{8}-[0-9a-f]{4}-4[0-9a-f]{3}-[89ab][0-9a-f]{3}-[0-9a-f]{12}$", "Validação do UUID");

    private final String pattern;
    private final String description;

    RegexTypes(String pattern, String descrition){
        this.pattern = pattern;
        this.description = descrition;
    }

    public boolean isValid(String value){
        return value != null && value.matches(pattern);
    }

    public String getDescription(){
        return description;
    }
}
