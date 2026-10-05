package Enum;

public enum EnumEquipoProteccion 
{
    //Lista del equipamiento de protección para el 'Trabajador'
    CASCO("Cabeza", true, 3),
    GUANTES("Manos", true, 2),
    BOTAS_SEGURIDAD("Pies", true, 3),
    CHALECO_REFLECTANTE("Visibilidad", true, 2),
    GAFAS_PROTECCION("Ojos", true, 3),
    PROTECTOR_AUDITIVO("Oído", false, 2),
    MASCARILLA("Respiración", false, 3),
    ARNÉS("Altura", true, 5),
    PANTALLA_FACIAL("Cara", false, 3),
    ROPA_ALTA_VISIBILIDAD("Visibilidad", true, 2),
    PROTECCION_RESPIRATORIA_AVANZADA("Respiración", true, 4);

    private String zonaProtegida;
    private boolean obligatorio;
    private int nivelProteccion; // 1 (bajo) - 5 (máximo)


    //CONSTRUCTOR
    EnumEquipoProteccion(String zonaProtegida, boolean obligatorio, int nivelProteccion) 
    {
        this.zonaProtegida = zonaProtegida;
        this.obligatorio = obligatorio;
        this.nivelProteccion = nivelProteccion;
    }


    //GETTERS Y SETTERS
    public String getZonaProtegida() 
    {
        return zonaProtegida;
    }
    public boolean isObligatorio() 
    {
        return obligatorio;
    }
    public int getNivelProteccion() 
    {
        return nivelProteccion;
    }
}