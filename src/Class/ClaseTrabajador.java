package Class;

import Enum.*;

public class ClaseTrabajador
{
    private String nombre;
    private String prApellido;
    private String sgApellido;
    private String dni;
    private int idObraActual; //0 Para indicar que no está en ninguna obra.
    private int edad;
    private int aniosExperiencia;
    private double salarioMensual;
    private EnumRolTrabajador rol;
    private EnumTipoContrato contrato;
    private EnumEstadoTrabajador estado;
    private EnumTipoJornada jornada;
    
    //CONSTRUCTOR
    public ClaseTrabajador(String nombre, String prApellido, String sgApellido, String dni, int edad, int experiencia, double salarioMensual, int idObraActual, EnumRolTrabajador rol, EnumTipoContrato contrato, EnumEstadoTrabajador estado, EnumTipoJornada jornada) 
    {
        setIdObraActual(idObraActual);
        setAniosExperiencia(experiencia);
        setNombre(nombre);
        setPrApellido(prApellido);
        this.sgApellido = sgApellido;
        setDni(dni);
        setEdad(edad);
        setSalarioMensual(salarioMensual);
        this.rol = rol;
        this.contrato = contrato;
        this.estado = estado;
        this.jornada = jornada;
    }


    //GETTERS Y SETTERS
    public String getNombre() 
    {
        return nombre;
    }
    public void setNombre(String nombre) 
    {
        if (nombre.isEmpty())
        {
            System.out.println("ERROR: Campo 'Nombre' del 'Trabajador' está vacío.");
        }
        else
        {
            this.nombre = nombre;
        }
    }
    public String getPrApellido() 
    {
        return prApellido;
    }
    public void setPrApellido(String prApellido) 
    {
        if (prApellido.isEmpty())
        {
            System.out.println("ERROR: Campo 'Primer Apellido' de 'Trabajador' está vacío.");
        }
        else
        {
            this.prApellido = prApellido;
        }
    }
    public String getSgApellido() 
    {
        return sgApellido;
    }
    public void setSgApellido(String sgApellido) 
    {
        this.sgApellido = sgApellido;
    }
    public String getDni() 
    {
        return dni;
    }
    public void setDni(String dni) 
    {
        if (!dni.matches("\\d{8}[A-Za-z]"))
        {
            System.out.println("ERROR: Campo 'DNI' de 'Trabajador' erróneo.");
        }
        else
        {
            this.dni = dni;
        }
    }
    public int getEdad() 
    {
        return edad;
    }
    public void setEdad(int edad) 
    {
        if (edad < 0 || edad > 70)
        {
            System.out.println("ERROR: Campo 'Edad' de 'Trabajador' erróneo.");
        }
        else
        {
            this.edad = edad;
        }
    }
    public int getIdObraActual() 
    {
        return idObraActual;
    }
    public void setIdObraActual(int idObraActual) 
    {
        if (idObraActual < 0)
        {
            System.out.println("ERROR: 'Id de la obra actual' es negativo en 'Trabajador'.");
        }
        else
        {
            this.idObraActual = idObraActual;
        }
    }
    public int getAniosExperiencia() 
    {
        return aniosExperiencia;
    }
    public void setAniosExperiencia(int aniosExperiencia) 
    {
        if (aniosExperiencia < 0 || aniosExperiencia > 100)
        {
            System.out.println("ERROR: 'Años de experienda' del 'Trabajador' erróneos.");
        }
        else
        {
            this.aniosExperiencia = aniosExperiencia;
        }
    }
    public double getSalarioMensual() 
    {
        return salarioMensual;
    }
    public void setSalarioMensual(double salarioMensual) 
    {
        if (salarioMensual < 0 || salarioMensual > 500000)
        {
            System.out.println("ERROR: Campo 'Salario mensual' de 'Trabajador' erróneo.");
        }
        else
        {
            this.salarioMensual = salarioMensual;
        }
    }
    public EnumRolTrabajador getRol() 
    {
        return rol;
    }
    public void setRol(EnumRolTrabajador rol) 
    {
        this.rol = rol;
    }
    public EnumTipoContrato getContrato() 
    {
        return contrato;
    }
    public void setContrato(EnumTipoContrato contrato) 
    {
        this.contrato = contrato;
    }
    public EnumEstadoTrabajador getEstado() 
    {
        return estado;
    }
    public void setEstado(EnumEstadoTrabajador estado) 
    {
        this.estado = estado;
    }
    public EnumTipoJornada getJornada() 
    {
        return jornada;
    }
    public void setJornada(EnumTipoJornada jornada) 
    {
        this.jornada = jornada;
    }


    //METODOS
    //Mostrar la información del trabajador en formato de string
    @Override
    public String toString() 
    {
        return 
        "\n── INFORMACIÓN PERSONAL ─────────────────" +
        "\nNombre:              " + nombre +
        "\nPrimer apellido:     " + prApellido +
        "\nSegundo apellido:    " + (sgApellido.isBlank() ? "No indicado" : sgApellido) +
        "\nDNI:                 " + dni +
        "\nEdad:                " + edad +

        "\n\n── INFORMACIÓN LABORAL ──────────────────" +
        "\nRol:                 " + rol +
        "\nContrato:            " + contrato +
        "\nEstado:              " + estado +
        "\nJornada:             " + jornada +
        "\nAños experiencia:    " + aniosExperiencia +
        "\nSalario mensual:     " + salarioMensual + " €" +
        "\nID obra actual:      " + (idObraActual == 0 ? "Sin asignar" : String.valueOf(idObraActual));
    }


    //Transforma al trabajador a un fichero
    public String toCSV()
    {
        return nombre + "§" + // <-- Este símbolo "§" indica el final de una línea, es la separación para saber dónde acaba una cosa y empieza otra
        prApellido + "§" + 
        sgApellido + "§" +
        dni + "§" + 
        edad + "§" + 
        aniosExperiencia + "§" +
        salarioMensual + "§" + 
        idObraActual + "§" +
        rol.name() + "§" + 
        contrato.name() + "§" +
        estado.name() + "§" + 
        jornada.name();
    }


    //Recupera el trabajador transformado en texto y lo transforma a un objeto
    public static ClaseTrabajador fromCSV(String linea)
    {
        String[] c = linea.split("§"); // <-- Indica que cada línea está separada por el símbolo "§"
        return 
        new ClaseTrabajador
        (
            c[0], // <-- Las líneas
            c[1],
            c[2], 
            c[3],
            Integer.parseInt(c[4]), 
            Integer.parseInt(c[5]),
            Double.parseDouble(c[6]), 
            Integer.parseInt(c[7]),
            EnumRolTrabajador.valueOf(c[8]),
            EnumTipoContrato.valueOf(c[9]),
            EnumEstadoTrabajador.valueOf(c[10]),
            EnumTipoJornada.valueOf(c[11])
        );
    }
}