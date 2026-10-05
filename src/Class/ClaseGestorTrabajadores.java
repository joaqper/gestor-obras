package Class;

import Enum.EnumEstadoTrabajador;
import Enum.EnumRolTrabajador;
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

public class ClaseGestorTrabajadores implements InterfazGestionable<ClaseTrabajador>, InterfazExportable<ClaseGestorTrabajadores>
{
    private ArrayList<ClaseTrabajador> trabajadores = new ArrayList<>();

    //INTERFAZ GESTIONABLE

    //Función para agregar un trabajador
    @Override
    public void agregar(ClaseTrabajador elemento)
    {
        trabajadores.add(elemento);
    }

    //Función para eliminar un trabajador
    @Override
    public void eliminar(String dni)
    {
        trabajadores.removeIf(t -> t.getDni().equals(dni.toUpperCase()));
    }

    //Función para buscar trabajador por DNI
    @Override
    public ClaseTrabajador buscar(String dni)
    {
        for (ClaseTrabajador t : trabajadores)
        {
            if (t.getDni().equals(dni.toUpperCase())) return t;
        }
        return null;
    }

    //Función para listar todos los trabajadores
    @Override
    public void listar()
    {
        if (trabajadores.isEmpty()) 
        {
            System.out.println("No hay trabajadores registrados.");
        }
        else
        {
            trabajadores.forEach(t -> System.out.println(t.toString()));  
        } 
    }

    //STREAMS

    // Filtra por estado
    public List<ClaseTrabajador> filtrarPorEstado(EnumEstadoTrabajador estado)
    {
        Predicate<ClaseTrabajador> filtro = t -> t.getEstado() == estado;
        return trabajadores.stream().filter(filtro).collect(Collectors.toList());
    }

    // Filtra por rol
    public List<ClaseTrabajador> filtrarPorRol(EnumRolTrabajador rol)
    {
        Predicate<ClaseTrabajador> filtro = t -> t.getRol() == rol;
        return trabajadores.stream().filter(filtro).collect(Collectors.toList());
    }

    // Ordena por apellido
    public List<ClaseTrabajador> ordenarPorApellido()
    {
        return 
        trabajadores.stream()
        .sorted(Comparator.comparing(ClaseTrabajador::getPrApellido))
        .collect(Collectors.toList());
    }

    // Ordena por salario de mayor a menor
    public List<ClaseTrabajador> ordenarPorSalario()
    {
        return
        trabajadores.stream()
        .sorted(Comparator.comparingDouble(ClaseTrabajador::getSalarioMensual).reversed())
        .collect(Collectors.toList());
    }

    // Ordena por rol
    public List<ClaseTrabajador> ordenarPorRol()
    {
        return
        trabajadores.stream()
        .sorted(Comparator.comparing(t -> t.getRol().name()))
        .collect(Collectors.toList());
    }

    // Calcula la nómina total
    public double calcularNominaTotal()
    {
        return
        trabajadores.stream()
        .mapToDouble(ClaseTrabajador::getSalarioMensual)
        .reduce(0, Double::sum);
    }

    // Cuenta trabajadores activos
    public long contarActivos()
    {
        Predicate<ClaseTrabajador> activo = t -> t.getEstado() == EnumEstadoTrabajador.ACTIVO;
        return trabajadores.stream().filter(activo).count();
    }

    // Genera resumen
    public void mostrarResumen()
    {
        Function<ClaseTrabajador, String> resumen = t ->
            t.getDni() + " | " + t.getNombre() + " " + t.getPrApellido() +
            " | " + t.getRol() + " | " + t.getSalarioMensual() + " €";

        Consumer<ClaseTrabajador> imprimir = t -> System.out.println(resumen.apply(t));
        trabajadores.stream().forEach(imprimir);
    }

    //INTERFAZ EXPORTABLE

    @Override
    public void exportarTxt(String ruta)
    {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta)))
        {
            bw.write("═══════════════════════════════════════");
            bw.newLine();
            bw.write("   INFORME DE TRABAJADORES — GREG      ");
            bw.newLine();
            bw.write("═══════════════════════════════════════");
            bw.newLine();
            bw.write("Total trabajadores: " + trabajadores.size());
            bw.newLine();
            bw.write("Activos: " + contarActivos());
            bw.newLine();
            bw.write("Nómina total: " + calcularNominaTotal() + " €");
            bw.newLine();
            bw.newLine();
            for (ClaseTrabajador t : trabajadores)
            {
                bw.write(t.toString());
                bw.newLine();
                bw.write("────────────────────────────────────────");
                bw.newLine();
            }
        }
        catch (IOException e)
        {
            System.out.println("Error al exportar trabajadores: " + e.getMessage());
        }
    }

    public ArrayList<ClaseTrabajador> getTrabajadores() { return trabajadores; }
}