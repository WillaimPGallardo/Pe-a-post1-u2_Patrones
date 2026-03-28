Sistema de Notificaciones – Patrones Creacionales
Descripción del Proyecto

Este proyecto implementa un sistema de notificaciones para una aplicación de e-commerce utilizando dos patrones de diseño creacionales:

Singleton (variante enum, thread-safe)
Factory Method (con registro dinámico)

El sistema permite enviar notificaciones a través de distintos canales (Email, SMS, Push, etc.) mientras registra todas las acciones en un único gestor de logs compartido.

Problema que se Resuelve

En aplicaciones reales se presentan dos problemas comunes:

Gestión centralizada de logs
Se necesita una única instancia para registrar eventos.
Evita inconsistencias y duplicación de datos.
Creación flexible de objetos
El sistema debe permitir agregar nuevos tipos de notificación sin modificar el código existente.
Se busca cumplir con el principio OCP (Open/Closed Principle).

Análisis de los Patrones Implementados
1. Singleton (NotificationLogger)

Problema que resuelve:
Garantiza que exista una única instancia del gestor de logs en toda la aplicación.

Solución aplicada:
Se implementa usando un enum, lo que asegura:

Thread-safe por diseño de la JVM
Una única instancia global (INSTANCE)
Acceso sencillo desde cualquier clase

Ventajas:

Evita múltiples instancias del logger
Centraliza el historial de notificaciones
Seguro en entornos concurrentes
2. Factory Method (NotifierFactory)

Problema que resuelve:
Permite crear objetos sin acoplar el código a clases concretas.

Solución aplicada:
Se utiliza una fábrica con un registro dinámico basado en Map<String, Supplier<Notifier>>.

Características clave:

Creación de objetos según un tipo (email, sms, push)
Posibilidad de registrar nuevos tipos en tiempo de ejecución
No es necesario modificar la fábrica para extender funcionalidades

Ventajas:

Bajo acoplamiento
Alta extensibilidad
Cumple con el principio OCP

<img width="1919" height="1035" alt="image" src="https://github.com/user-attachments/assets/b3e6b826-bfbe-44ab-8c42-f0ae057361e9" />

