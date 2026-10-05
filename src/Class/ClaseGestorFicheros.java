package Class;

import java.io.*;
import java.util.ArrayList;

public class ClaseGestorFicheros
{
    private static final String FICHERO_OBRAS = "obras.txt";
    private static final String FICHERO_TRABAJADORES = "trabajadores.txt";

    // Guarda todas las obras en el fichero
    public static void guardarObras(ArrayList<ClaseObra> obras)
    {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FICHERO_OBRAS)))
        {
            for (ClaseObra o : obras)
            {
                bw.write(o.toCSV());
                bw.newLine();
            }
        }
        catch (IOException e)
        {
            System.out.println("Error al guardar obras: " + e.getMessage());
        }
    }

    // Carga las obras desde el fichero
    public static ArrayList<ClaseObra> cargarObras()
    {
        ArrayList<ClaseObra> obras = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FICHERO_OBRAS)))
        {
            String linea;
            while ((linea = br.readLine()) != null)
            {
                if (!linea.isBlank())
                {
                    try 
                    { 
                        obras.add(ClaseObra.fromCSV(linea)); 
                    }
                    catch (Exception e) 
                    { 
                        System.out.println("Línea corrupta ignorada: " + linea); 
                    }
                }
            }
        }
        catch (IOException e)
        {
            System.out.println("Sin fichero de obras previo. Se inicia vacío.");
        }
        return obras;
    }

    // Guarda todos los trabajadores en el fichero
    public static void guardarTrabajadores(ArrayList<ClaseTrabajador> trabajadores)
    {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FICHERO_TRABAJADORES)))
        {
            for (ClaseTrabajador t : trabajadores)
            {
                bw.write(t.toCSV());
                bw.newLine();
            }
        }
        catch (IOException e)
        {
            System.out.println("Error al guardar trabajadores: " + e.getMessage());
        }
    }

    // Carga los trabajadores desde el fichero
    public static ArrayList<ClaseTrabajador> cargarTrabajadores()
    {
        ArrayList<ClaseTrabajador> trabajadores = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FICHERO_TRABAJADORES)))
        {
            String linea;
            while ((linea = br.readLine()) != null)
            {
                if (!linea.isBlank())
                {
                    try { trabajadores.add(ClaseTrabajador.fromCSV(linea)); }
                    catch (Exception e) { System.out.println("Línea corrupta ignorada: " + linea); }
                }
            }
        }
        catch (IOException e)
        {
            System.out.println("Sin fichero de trabajadores previo. Se inicia vacío.");
        }
        return trabajadores;
    }
}