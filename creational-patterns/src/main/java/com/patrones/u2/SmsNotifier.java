package com.patrones.u2;

/**
 * Concrete Product: Implementación para envío de SMS.
 */
public class SmsNotifier implements Notifier {
    
    @Override
    public String channel() { 
        return "SMS"; // Identificador del canal 
    }

    @Override
    public void send(String recipient, String message) {
        // Registra el envío en el logger único 
        NotificationLogger.INSTANCE.log(channel(), recipient, message);
    }
}