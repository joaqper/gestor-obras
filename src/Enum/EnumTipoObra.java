package Enum;

public enum EnumTipoObra 
{

    //Obras de la categoría 'Edificación'
    OBRA_NUEVA("Edificación", true, 5),
    REFORMA("Edificación", false, 3),
    REHABILITACION("Edificación", true, 4),


    //Obras de la categoría 'Infraestructura'
    OBRA_PUBLICA("Infraestructura", true, 5),
    INFRAESTRUCTURA_VIAL("Infraestructura", true, 5),
    OBRA_HIDRAULICA("Infraestructura", true, 5),


    //Obras de la categoría 'Industrial' y 'Edificación'
    INDUSTRIAL("Industrial", true, 5),
    COMERCIAL("Edificación", true, 4),


    //Obras de la categoría 'Demolición' y 'Urbanismo'
    DEMOLICION("Demolición", true, 5),
    URBANIZACION("Urbanismo", true, 4),


    //Obras de la cetegoría 'Mantenimiento'
    MANTENIMIENTO("Mantenimiento", false, 2);


    //ATRIBUTOS
    private String categoria;
    private boolean requiereLicencia;
    private int nivelComplejidad; // 1 (bajo) - 5 (muy alto)


    //CONSTRUCTOR
    EnumTipoObra(String categoria, boolean requiereLicencia, int nivelComplejidad) 
    {
        this.categoria = categoria;
        this.requiereLicencia = requiereLicencia;
        this.nivelComplejidad = nivelComplejidad;
    }


    //GETTERS
    public String getCategoria() 
    {
        return categoria;
    }
    public boolean isRequiereLicencia() 
    {
        return requiereLicencia;
    }
    public int getNivelComplejidad() 
    {
        return nivelComplejidad;
    }
}