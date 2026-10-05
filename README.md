# GREM · Gestor de obras y trabajadores

Aplicación de escritorio en Java para gestionar las obras y los trabajadores de una empresa de albañilería. Proyecto de fin de curso de 1.º de Desarrollo de Aplicaciones Multiplataforma (DAM).

![Pantalla principal](capturas/obras.png)

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

- **Java** [versión, por ejemplo 17]
- **[Swing / JavaFX]** para la interfaz gráfica
- Programación orientada a objetos (clases, enumerados, separación en gestores)
- Persistencia de datos en ficheros con `FileWriter`, `BufferedWriter` y `BufferedReader`

## Estructura del proyecto

```
├── src/
│   ├── Class/     # Clases del modelo y gestores (Obra, Trabajador, GestorObras...)
│   ├── Enum/      # Enumerados (estados, comunidades, equipos de protección...)
│   ├── Interface/ # Interfaces para cada clase (exportable, gestionable)
│   ├── Main/      # Codigo principal
│   ├── UI/        # Interfaz gráfica. Hecha con JavaSwing/JavaFX
│   └── [paquete de la interfaz]
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
| ![Obras](capturas/obras.png) | ![Trabajadores](capturas/trabajadores.png) | ![Estadísticas](capturas/estadisticas.png) |

## Posibles mejoras

- Migrar el almacenamiento de ficheros a una base de datos MySQL con JDBC
- Renombrar nombres de ficheros al gusto del usuario.

## Autor

**Joaquín Pérez Sánchez** · [GitHub](https://github.com/joaqper)
