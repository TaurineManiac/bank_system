package org.example.banksystemfromjavaacademy.utils;

import io.github.robsonkades.uuidv7.UUIDv7;

import java.util.UUID;

public class BankUtils {
    public static UUID generatePublicId() {
        return UUIDv7.randomUUID();
    }
}
