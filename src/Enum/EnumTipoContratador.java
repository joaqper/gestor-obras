package Enum;

public enum EnumTipoContratador 
{
    //Lista que especifíca quién es el contratador para saber qué se requiere en la obra
    PARTICULAR("Cliente privado", false, false),
    EMPRESA_PRIVADA("Empresa privada", true, false),
    ADMINISTRACION_PUBLICA("Administración pública", true, true),
    COMUNIDAD_PROPIETARIOS("Comunidad de propietarios", false, false),
    PROMOTORA("Promotora inmobiliaria", true, false),
    SUBCONTRATA("Subcontrata", true, false);


    //ATRIBUTOS
    private String descripcion;
    private boolean requiereContratoFormal;
    private boolean tieneRegulacionPublica;


    //CONSTRUCTOR
    EnumTipoContratador(String descripcion, boolean requiereContratoFormal, boolean tieneRegulacionPublica) 
    {
        this.descripcion = descripcion;
        this.requiereContratoFormal = requiereContratoFormal;
        this.tieneRegulacionPublica = tieneRegulacionPublica;
    }


    //GETTERS
    public String getDescripcion() 
    {
        return descripcion;
    }
    public boolean isRequiereContratoFormal() 
    {
        return requiereContratoFormal;
    }
    public boolean isTieneRegulacionPublica() 
    {
        return tieneRegulacionPublica;
    }
}