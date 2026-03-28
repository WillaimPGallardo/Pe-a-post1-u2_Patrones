package com.patrones.u2;

/**
 * Concrete Product: Implementación para envío de correos.
 */
public class EmailNotifier implements Notifier {
    
    @Override
    public String channel() { 
        return "EMAIL"; // Identificador del canal 
    }

    @Override
    public void send(String recipient, String message) {
        // Usa el Singleton para registrar la actividad 
        NotificationLogger.INSTANCE.log(channel(), recipient, message);
    }
}