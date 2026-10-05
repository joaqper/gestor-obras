package Class;

import Enum.*;

public class ClaseObra 
{
    private int codigoObra;
    private String descripcion;
    private String ubicacionExacta;
    private int personalDedicado;
    private String nombreEntidadContratadora;
    private EnumTipoContratador contratador;
    private EnumTipoObra tipoObra;
    private EnumComunidadEspania comunidadObra;
    private EnumProvinciaEspania provinciaObra;
    private EnumPrioridadTarea prioridad;
    private EnumMaquinariaNecesaria maquinariaNecesaria;
    private EnumEstadoObra estadoObra;
    private EnumEstadoFactura estadoFactura;
    private EnumTamanioObra tamanioObra;
    private int numeroEntidadContratadora;
    private int beneficioEstipulado;
    
    //CONSTRUCTOR
    public ClaseObra(int codigoObra, String descripcion, String ubicacionExacta, int personalDedicado, String nombreEntidadContratadora, int numeroEntidadContratadora, int beneficioEstipulado, EnumTipoContratador contratador, EnumTipoObra tipoObra, EnumTamanioObra tamanioObra,EnumComunidadEspania comunidadObra, EnumProvinciaEspania provinciaObra, EnumPrioridadTarea prioridad, EnumMaquinariaNecesaria maquinariaNecesaria, EnumEstadoObra estadoObra, EnumEstadoFactura estadoFactura)     
    {
        setCodigoObra(codigoObra);
        setDescripcion(descripcion);
        setUbicacionExacta(ubicacionExacta);
        setPersonalDedicado(personalDedicado);
        setNombreEntidadContratadora(nombreEntidadContratadora);
        setNumeroEntidadContratadora(numeroEntidadContratadora);
        setBeneficioEstipulado(beneficioEstipulado);
        this.contratador = contratador;
        this.tipoObra = tipoObra;
        this.tamanioObra = tamanioObra;
        this.comunidadObra = comunidadObra;
        this.provinciaObra = provinciaObra;
        this.prioridad = prioridad;
        this.maquinariaNecesaria = maquinariaNecesaria;
        this.estadoObra = estadoObra;
        this.estadoFactura = estadoFactura;
    }

    //GETTERS Y SETTERS
    public int getCodigoObra() 
    {
        return codigoObra;
    }
    public void setCodigoObra(int codigoObra) 
    {
        if (codigoObra < 0)
        {
            System.out.println("ERROR: Código de obra negativo.");
        }
        else
        {
            this.codigoObra = codigoObra;
        }
    }
    public String getDescripcion() 
    {
        return descripcion;
    }
    public void setDescripcion(String descripcion) 
    {
        if (descripcion.isEmpty())
        {
            System.out.println("ERROR: Descripción vacía.");
        }
        else
        {
            this.descripcion = descripcion;
        }
    }
    public String getUbicacionExacta() 
    {
        return ubicacionExacta;
    }
    public void setUbicacionExacta(String ubicacionExacta) 
    {
        if (ubicacionExacta.isEmpty())
        {
            System.out.println("ERROR: Ubicación exacta vacía.");
        }
        else
        {
            this.ubicacionExacta = ubicacionExacta;
        }
    }
    public int getPersonalDedicado() 
    {
        return personalDedicado;
    }
    public void setPersonalDedicado(int personalDedicado) 
    {
        if (personalDedicado < 0)
        {
            System.out.println("ERROR: Personal dedicado negativo.");
        }
        else
        {
            this.personalDedicado = personalDedicado;
        }
    }
    public String getNombreEntidadContratadora() 
    {
        return nombreEntidadContratadora;
    }
    public void setNombreEntidadContratadora(String nombreEntidadContratadora) 
    {
        if (nombreEntidadContratadora.isEmpty())
        {
            System.out.println("ERROR: Nombre de la entidad contratadora vacío.");
        }
        else
        {
            this.nombreEntidadContratadora = nombreEntidadContratadora;
        }
    }
    public EnumTipoContratador getContratador() 
    {
        return contratador;
    }
    public void setContratador(EnumTipoContratador contratador) 
    {
        this.contratador = contratador;
    }
    public EnumTipoObra getTipoObra() 
    {
        return tipoObra;
    }
    public void setTipoObra(EnumTipoObra tipoObra) 
    {
        this.tipoObra = tipoObra;
    }
    public EnumComunidadEspania getComunidadObra() 
    {
        return comunidadObra;
    }
    public void setComunidadObra(EnumComunidadEspania comunidadObra) 
    {
        this.comunidadObra = comunidadObra;
    }
    public EnumProvinciaEspania getProvinciaObra() 
    {
        return provinciaObra;
    }
    public void setProvinciaObra(EnumProvinciaEspania provinciaObra) 
    {
        this.provinciaObra = provinciaObra;
    }
    public EnumPrioridadTarea getPrioridad() 
    {
        return prioridad;
    }
    public void setPrioridad(EnumPrioridadTarea prioridad) 
    {
        this.prioridad = prioridad;
    }
    public EnumMaquinariaNecesaria getMaquinariaNecesaria() 
    {
        return maquinariaNecesaria;
    }
    public void setMaquinariaNecesaria(EnumMaquinariaNecesaria maquinariaNecesaria) 
    {
        this.maquinariaNecesaria = maquinariaNecesaria;
    }
    public EnumEstadoObra getEstadoObra() 
    {
        return estadoObra;
    }
    public void setEstadoObra(EnumEstadoObra estadoObra) 
    {
        this.estadoObra = estadoObra;
    }
    public EnumEstadoFactura getEstadoFactura() 
    {
        return estadoFactura;
    }
    public void setEstadoFactura(EnumEstadoFactura estadoFactura) 
    {
        this.estadoFactura = estadoFactura;
    }
    public int getNumeroEntidadContratadora() 
    {
        return numeroEntidadContratadora;
    }
    public void setNumeroEntidadContratadora(int numeroEntidadContratadora) 
    {
        if (numeroEntidadContratadora < 0 || numeroEntidadContratadora > 999999999)
        {
            System.out.println("ERROR: Número de entidad contratadora erróneo.");
        }
        else
        {
            this.numeroEntidadContratadora = numeroEntidadContratadora;
        }
    }
    public int getBeneficioEstipulado() 
    {
        return beneficioEstipulado;
    }
    public void setBeneficioEstipulado(int beneficioEstipulado) 
    {
        if (beneficioEstipulado < 0)
        {
            System.out.println("ERROR: Beneficio estipulado negativo.");
        }
        else
        {
            this.beneficioEstipulado = beneficioEstipulado;
        }
    }
    public EnumTamanioObra getTamanioObra() 
    {
        return tamanioObra;
    }
    public void setTamanioObra(EnumTamanioObra tamanioObra) 
    {
        this.tamanioObra = tamanioObra;
    }

    //METODOS
    //Muestra la información de la obra en un formato String
    @Override
    public String toString() 
    {
        return 
        "\n── INFORMACIÓN GENERAL ──────────────────" +
        "\nCódigo:              " + codigoObra +
        "\nDescripción:         " + descripcion +
        "\nTipo de obra:        " + tipoObra +
        "\nTamaño:              " + tamanioObra +
        "\nPrioridad:           " + prioridad +
        "\nEstado:              " + estadoObra +

        "\n\n── CONTRATADOR ──────────────────────────" +
        "\nEntidad:             " + nombreEntidadContratadora +
        "\nNúmero entidad:      " + numeroEntidadContratadora +
        "\nTipo contratador:    " + contratador +

        "\n\n── UBICACIÓN ────────────────────────────" +
        "\nComunidad:           " + comunidadObra +
        "\nProvincia:           " + provinciaObra +
        "\nUbicación exacta:    " + ubicacionExacta +

        "\n\n── RECURSOS ─────────────────────────────" +
        "\nPersonal dedicado:   " + personalDedicado +
        "\nMaquinaria:          " + maquinariaNecesaria +
        "\nEstado factura:      " + estadoFactura +
        "\nBeneficio estipulado:" + beneficioEstipulado + " euros";
    }

    //Transforma la obra en una línea de texto para guardarla en un fichero
    public String toCSV()
    {
        return 
        codigoObra + "§" + // <-- Símbolo usado para indicar el fin de una línea o de un atributo
        descripcion + "§" +
        ubicacionExacta + "§" +
        personalDedicado + "§" +
        nombreEntidadContratadora + "§" +
        numeroEntidadContratadora + "§" +
        beneficioEstipulado + "§" +
        contratador.name() + "§" +
        tipoObra.name() + "§" +
        tamanioObra.name() + "§" +
        comunidadObra.name() + "§" +
        provinciaObra.name() + "§" +
        prioridad.name() + "§" +
        maquinariaNecesaria.name() + "§" +
        estadoObra.name() + "§" +
        estadoFactura.name();
    }

    //Recupera la obra del fichero para usarla en la app
    public static ClaseObra fromCSV(String linea)
    {
        String[] c = linea.split("§");

        return new ClaseObra(
            Integer.parseInt(c[0]),                 // codigoObra
            c[1],                                   // descripcion
            c[2],                                   // ubicacionExacta
            Integer.parseInt(c[3]),                 // personalDedicado
            c[4],                                   // nombreEntidadContratadora
            Integer.parseInt(c[5]),                 // numeroEntidadContratadora
            Integer.parseInt(c[6]),                 // beneficioEstipulado
            EnumTipoContratador.valueOf(c[7]),      // contratador
            EnumTipoObra.valueOf(c[8]),             // tipoObra
            EnumTamanioObra.valueOf(c[9]),          // tamanioObra
            EnumComunidadEspania.valueOf(c[10]),    // comunidadObra
            EnumProvinciaEspania.valueOf(c[11]),    // provinciaObra
            EnumPrioridadTarea.valueOf(c[12]),      // prioridad
            EnumMaquinariaNecesaria.valueOf(c[13]), // maquinariaNecesaria
            EnumEstadoObra.valueOf(c[14]),          // estadoObra
            EnumEstadoFactura.valueOf(c[15])        // estadoFactura
        );
    }
}