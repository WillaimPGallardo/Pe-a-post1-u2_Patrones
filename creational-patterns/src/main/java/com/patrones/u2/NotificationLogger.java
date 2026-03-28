package com.patrones.u2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public enum NotificationLogger {
    INSTANCE; [cite: 76]

    private final List<String> entries = new ArrayList<>(); [cite: 86]
    private static final DateTimeFormatter FMT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); [cite: 87]

    public void log(String channel, String recipient, String message) {
        String entry = String.format("[%s] [%s] -> %s : %s", 
            LocalDateTime.now().format(FMT), channel, recipient, message); [cite: 88, 90]
        entries.add(entry); [cite: 91]
        System.out.println(entry); [cite: 92]
    }

    public void printAll() {
        System.out.println("\n=== Historial de Notificaciones ==="); [cite: 97]
        entries.forEach(System.out::println); [cite: 98]
        System.out.println("Total: " + entries.size() + " notificaciones"); [cite: 99, 100]
    }
}