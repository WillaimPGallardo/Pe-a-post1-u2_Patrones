package com.patrones.u2;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class NotifierFactory {
    private static final Map<String, Supplier<Notifier>> REGISTRY = new HashMap<>();

    static {
        // Registro inicial de factory methods
        REGISTRY.put("email", EmailNotifier::new);
        REGISTRY.put("sms", SmsNotifier::new);
        REGISTRY.put("push", PushNotifier::new);
    }

    public static void register(String type, Supplier<Notifier> factory) {
        REGISTRY.put(type.toLowerCase(), factory);
    }

    public static Notifier create(String type) {
        Supplier<Notifier> factory = REGISTRY.get(type.toLowerCase());
        if (factory == null) {
            throw new IllegalArgumentException("Tipo no registrado: " + type);
        }
        return factory.get();
    }
}