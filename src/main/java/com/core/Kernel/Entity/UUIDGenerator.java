package com.core.Kernel.Entity;

import java.util.UUID;

public final class UUIDGenerator {

    public static String generateUUID() {
        return UUID.randomUUID().toString();
    }
}
