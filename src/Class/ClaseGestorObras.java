package Class;

import Enum.EnumEstadoObra;
import Enum.EnumPrioridadTarea;
import Interface.InterfazExportable;
import Interface.InterfazGestionable;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ClaseGestorObras implements InterfazGestionable<ClaseObra>, InterfazExportable<ClaseGestorObras>
{
    private ArrayList<ClaseObra> obras = new ArrayList<>();

    //INTERFAZ GESTIONABLE
    //Añadir una obra
    @Override
    public void agregar(ClaseObra elemento)
    {
        obras.add(elemento);
    }

    //Eliminar una obra
    @Override
    public void eliminar(String id)
    {
        int codigo = Integer.parseInt(id);
        obras.removeIf(o -> o.getCodigoObra() == codigo);
    }

    //Buscar una obra
    @Override
    public ClaseObra buscar(String id)
    {
        int codigo = Integer.parseInt(id);
        for (ClaseObra o : obras)
        {
            if (o.getCodigoObra() == codigo) return o;
        }
        return null;
    }

    //Listar todas las obras
    @Override
    public void listar()
    {
        if (obras.isEmpty()) 
        {
            System.out.println("No hay obras registradas.");
        }
        else
        {
            obras.forEach(o -> System.out.println(o.toString()));
        }
    }

    // Genera el siguiente código disponible de forma autoincremental
    public int generarCodigoUnico()
    {
        int codigo = 0;
        do
        {
            codigo++;
        }
        while (buscar(String.valueOf(codigo)) != null);
        return codigo;
    }

    //STREAMS
    // Filtra obras por estado
    public List<ClaseObra> filtrarPorEstado(EnumEstadoObra estado)
    {
        Predicate<ClaseObra> filtro = o -> o.getEstadoObra() == estado;
        return obras.stream().filter(filtro).collect(Collectors.toList());
    }

    // Filtra obras por prioridad
    public List<ClaseObra> filtrarPorPrioridad(EnumPrioridadTarea prioridad)
    {
        Predicate<ClaseObra> filtro = o -> o.getPrioridad() == prioridad;
        return obras.stream().filter(filtro).collect(Collectors.toList());
    }

    // Devuelve las obras ordenadas por beneficio de mayor a menor
    public List<ClaseObra> ordenarPorBeneficio()
    {
        return obras.stream()
                    .sorted(Comparator.comparingInt(ClaseObra::getBeneficioEstipulado).reversed())
                    .collect(Collectors.toList());
    }

    // Devuelve las obras ordenadas por código ascendente
    public List<ClaseObra> ordenarPorCodigo()
    {
        return obras.stream()
                    .sorted(Comparator.comparingInt(ClaseObra::getCodigoObra))
                    .collect(Collectors.toList());
    }

    // Devuelve las obras ordenadas por estado
    public List<ClaseObra> ordenarPorEstado()
    {
        return obras.stream()
                    .sorted(Comparator.comparing(o -> o.getEstadoObra().name()))
                    .collect(Collectors.toList());
    }

    // Devuelve las obras ordenadas por prioridad
    public List<ClaseObra> ordenarPorPrioridad()
    {
        return obras.stream()
                    .sorted(Comparator.comparing(o -> o.getPrioridad().name()))
                    .collect(Collectors.toList());
    }

    // Calcula el beneficio total de todas las obras
    public int calcularBeneficioTotal()
    {
        return obras.stream()
                    .mapToInt(ClaseObra::getBeneficioEstipulado)
                    .reduce(0, Integer::sum);
    }

    // Cuenta obras en un estado concreto
    public long contarPorEstado(EnumEstadoObra estado)
    {
        Predicate<ClaseObra> filtro = o -> o.getEstadoObra() == estado;
        return obras.stream().filter(filtro).count();
    }

    // Genera resumen de cada obra usando
    public void mostrarResumen()
    {
        Function<ClaseObra, String> resumen = o ->
            "Cód: " + o.getCodigoObra() +
            " | " + o.getEstadoObra() +
            " | " + o.getPrioridad() +
            " | " + o.getBeneficioEstipulado() + " €";

        Consumer<ClaseObra> imprimir = o -> System.out.println(resumen.apply(o));
        obras.stream().forEach(imprimir);
    }

    //INTERFAZ EXPORTABLE
    //Exporta el texto txt para mostrarlo por la aplicación.
    @Override
    public void exportarTxt(String ruta)
    {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta)))
        {
            bw.write("═══════════════════════════════════════");
            bw.newLine();
            bw.write("       INFORME DE OBRAS — GREG         ");
            bw.newLine();
            bw.write("═══════════════════════════════════════");
            bw.newLine();
            bw.write("Total obras: " + obras.size());
            bw.newLine();
            bw.write("Beneficio total: " + calcularBeneficioTotal() + " €");
            bw.newLine();
            bw.newLine();
            for (ClaseObra o : obras)
            {
                bw.write(o.toString());
                bw.newLine();
                bw.write("────────────────────────────────────────");
                bw.newLine();
            }
        }
        catch (IOException e)
        {
            System.out.println("Error al exportar obras: " + e.getMessage());
        }
    }

    public ArrayList<ClaseObra> getObras() { return obras; }
}