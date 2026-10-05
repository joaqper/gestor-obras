package Enum;

public enum EnumTipoIncidencia 
{
    //Incidencias de la categoría 'Seguridad y riesgos laborales (PRL)''
    ACCIDENTE_LEVE("PRL", true, 3),
    ACCIDENTE_GRAVE("PRL", true, 5),
    CASI_ACCIDENTE("PRL", true, 2),
    INCUMPLIMIENTO_SEGURIDAD("PRL", true, 4),

    //Incidencias de la categoría 'Maquinaria'
    AVERIA_MAQUINARIA("Maquinaria", false, 3),
    FALLO_TECNICO("Maquinaria", false, 3),
    MANTENIMIENTO_PENDIENTE("Maquinaria", false, 2),

    //Incidencias de la categoría 'Materiales'
    FALTA_MATERIAL("Materiales", false, 3),
    MATERIAL_DEFECTUOSO("Materiales", false, 4),

    //Incidencias de la categoría 'Personal'
    AUSENCIA_TRABAJADOR("Personal", false, 2),
    RETRASO_TRABAJADOR("Personal", false, 1),
    CONFLICTO_LABORAL("Personal", false, 3),

    //Incidencias de las categorías 'Obra' y 'Planificación'
    RETRASO_OBRA("Planificación", false, 4),
    ERROR_EJECUCION("Planificación", false, 4),
    CAMBIO_DISENO("Planificación", false, 3),

    //Incidencias de la categoría 'Clima'
    CONDICIONES_CLIMATICAS("Clima", false, 3),

    //Incidencias de las categorías 'Legal' e 'Inspecciones'
    INSPECCION_TRABAJO("Legal", true, 5),
    INCUMPLIMIENTO_LEGAL("Legal", true, 5),
    SANCION("Legal", true, 5),

    //Incidencias de la categoría 'Otros'
    OTROS("General", false, 1);


    //ATRIBUTOS
    private String categoria;
    private boolean requiereReporteOficial;
    private int nivelGravedad; // 1 (bajo) a 5 (crítico)


    //CONSTRUCTORES
    EnumTipoIncidencia(String categoria, boolean requiereReporteOficial, int nivelGravedad) 
    {
        this.categoria = categoria;
        this.requiereReporteOficial = requiereReporteOficial;
        this.nivelGravedad = nivelGravedad;
    }


    //GETTERS
    public String getCategoria() 
    {
        return categoria;
    }
    public boolean isRequiereReporteOficial() 
    {
        return requiereReporteOficial;
    }
    public int getNivelGravedad() 
    {
        return nivelGravedad;
    }
}