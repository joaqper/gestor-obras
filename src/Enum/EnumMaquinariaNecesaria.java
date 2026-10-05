package Enum;

public enum EnumMaquinariaNecesaria 
{
    //Lista para saber la maquinaria que se necesita por obra
    //Movimiento de tierra
    EXCAVADORA("Movimiento de tierra", true, true),
    RETROEXCAVADORA("Movimiento de tierra", true, true),
    BULLDOZER("Movimiento de tierra", true, true),
    PALA_CARGADORA("Movimiento de tierra", true, true),

    //Elevación
    GRUA_TORRE("Elevación", true, true),
    GRUA_MOVIL("Elevación", true, true),
    PLATAFORMA_ELEVADORA("Elevación", true, true),
    MONTACARGAS("Elevación", true, true),

    //Compactación
    RODILLO_COMPACTADOR("Compactación", true, true),
    APISONADORA("Compactación", false, false),

    //Hormigón
    HORMIGONERA("Hormigón", false, false),
    BOMBA_HORMIGON("Hormigón", true, true),
    VIBRADOR_HORMIGON("Hormigón", false, false),

    //Corte y demolición
    MARTILLO_NEUMATICO("Demolición", false, false),
    CORTADORA_HORMIGON("Corte", false, false),
    RADIAL("Corte", false, false),

    //Transporte
    CAMION_VOLQUETE("Transporte", true, true),
    DUMPER("Transporte", true, true),
    CARRETILLA_ELEVADORA("Transporte", true, true),

    //Otros
    GENERADOR_ELECTRICO("Energía", false, false),
    COMPRESOR("Energía", false, false),
    SOLDADORA("Herramienta", false, false),
    EQUIPAMIENTO_PERSONAL_SIMPLE("Herramienta", false, false);


    //ATRIBUTOS
    private String tipo;
    private boolean requiereLicencia;
    private boolean altoRiesgo;

    //CONSTRUCTOR
    EnumMaquinariaNecesaria(String tipo, boolean requiereLicencia, boolean altoRiesgo) 
    {
        this.tipo = tipo;
        this.requiereLicencia = requiereLicencia;
        this.altoRiesgo = altoRiesgo;
    }

    //GETTERS
    public String getTipo() 
    {
        return tipo;
    }
    public boolean isRequiereLicencia() 
    {
        return requiereLicencia;
    }
    public boolean isAltoRiesgo() 
    {
        return altoRiesgo;
    }
}