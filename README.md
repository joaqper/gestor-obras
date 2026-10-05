# GREM · Gestor de obras y trabajadores

Aplicación de escritorio en Java para gestionar las obras y los trabajadores de una empresa de albañilería. Proyecto de fin de curso de 1.º de Desarrollo de Aplicaciones Multiplataforma (DAM).

<img width="1917" height="988" alt="image" src="https://github.com/user-attachments/assets/e9681a35-320b-443c-9bbd-999ebefdc41c" />


## Funcionalidades

La aplicación se organiza en tres pestañas:

### Obras
- Añadir y eliminar obras
- Consultar información detallada de cada obra
- Exportar un informe de la obra
- Guardar los datos de las obras en CSV

### Trabajadores
- Añadir y eliminar trabajadores
- Consultar información detallada de cada trabajador
- Exportar un informe del trabajador

### Estadísticas
Panel donde se genera un resumen según lo que elija el usuario:
- Beneficio total
- Nómina total
- Trabajadores activos
- Resumen de obras
- Resumen de trabajadores
- Obras por estado
- Obras por prioridad
- Trabajadores por rol

## Tecnologías

- **Java** [V.25]
- **[Swing / JavaFX]** para la interfaz gráfica
- Programación orientada a objetos (clases, enumerados, separación en gestores)
- Persistencia de datos en ficheros con `FileWriter`, `BufferedWriter` y `BufferedReader`

## Estructura del proyecto

```
├── src/
│   ├── Class/     # Clases del modelo y gestores (Obra, Trabajador, GestorObras...)
│   ├── Enum/      # Enumerados (estados, comunidades, equipos de protección...)
│   ├── Interface/ # Interfaces (exportable, gestionable)
│   ├── Main/      # Fichero principal
│   └── UI/        # Interfaz gráfica. Hecha con JavaSwing/JavaFX
├── obras.txt          # Fichero donde se guardan las obras
├── trabajadores.txt   # Fichero donde se guardan los trabajadores
└── README.md
```

## Cómo ejecutarlo

1. Clona el repositorio:
```bash
   git clone https://github.com/joaqper/gestor-obras.git
```
2. Ábrelo con [Eclipse / IntelliJ / VS Code] como proyecto Java.
3. Ejecuta la clase principal `[Main]`.

Los ficheros `obras.txt` y `trabajadores.txt` deben estar en la raíz del proyecto para que la aplicación cargue los datos de ejemplo.

## Capturas de pantalla

| Obras | Trabajadores | Estadísticas |
|-------|--------------|--------------|
| <img width="1917" height="988" alt="image" src="https://github.com/user-attachments/assets/e9681a35-320b-443c-9bbd-999ebefdc41c" /> | <img width="1917" height="985" alt="image" src="https://github.com/user-attachments/assets/1af80f59-f1ba-4470-b09e-334be508aa59" />
 | <img width="1917" height="983" alt="image" src="https://github.com/user-attachments/assets/6254a32d-ed33-4f52-be4f-456ebd79a0f7" />|

## Posibles mejoras

- Migrar el almacenamiento de ficheros a una base de datos MySQL con JDBC
- Renombrar nombres de ficheros al gusto del usuario.
- Añadir funcionalidades y mejorar la flexibilidad general del programa.

## Autor

**Joaquín Pérez Sánchez** · [GitHub](https://github.com/joaqper)
