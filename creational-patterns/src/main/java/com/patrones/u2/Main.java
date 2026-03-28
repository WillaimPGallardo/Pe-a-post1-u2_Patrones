package com.patrones.u2;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Demo: Singleton + Factory Method ===\n"); [cite: 231]

        // Prueba Singleton
        NotificationLogger logger1 = NotificationLogger.INSTANCE; [cite: 234, 235]
        NotificationLogger logger2 = NotificationLogger.INSTANCE; [cite: 236, 237]
        System.out.println("Misma instancia: " + (logger1 == logger2)); [cite: 238]

        // Prueba Factory
        Notifier email = NotifierFactory.create("email"); [cite: 240, 241]
        email.send("estudiante@udes.edu.co", "Tarea lista"); [cite: 243, 244]

        // Registro Dinámico (OCP)
        NotifierFactory.register("slack", () -> new Notifier() { [cite: 248]
            public String channel() { return "SLACK"; }
            public void send(String r, String m) { 
                NotificationLogger.INSTANCE.log(channel(), r, m); 
            }
        });

        NotifierFactory.create("slack").send("#general", "Notificación Slack"); [cite: 265]

        // Mostrar historial centralizado
        NotificationLogger.INSTANCE.printAll(); [cite: 269]
    }
}