package com.patrones.u2;

/**
 * Concrete Product: Implementación para notificaciones Push.
 */
public class PushNotifier implements Notifier {
    
    @Override
    public String channel() { 
        return "PUSH"; // Identificador del canal 
    }

    @Override
    public void send(String recipient, String message) {
        // Notifica al Singleton para persistir el log 
        NotificationLogger.INSTANCE.log(channel(), recipient, message);
    }
}