package Enum;

public enum EnumRolTrabajador 
{
    //Lista que especifíca el rol que puede tener el 'Trabajador'
    PEON(1), 
    OFICIAL(2), 
    OFICIAL_PRIMERA(2), 
    ENCARGADO(3), 
    JEFE_OBRA(4), 
    ARQUITECTO(4), 
    INGENIERO(4), 
    ADMINISTRATIVO(4), 
    RRHH(4), 
    PREVENCION_RIESGOS(3), 
    GERENTE(5);


    //ATRIBUTOS
    private int nivelAcceso; 
    //Nivel de acceso del trabajador basado en su rol 1 (Básico) - 5 (Total)

    //CONSTRUCTOR
    EnumRolTrabajador(int nivelAcceso) 
    {
        this.nivelAcceso = nivelAcceso;
    }


    //GETTERS
    public int getNivelAcceso() 
    {
        return nivelAcceso;
    }
}



