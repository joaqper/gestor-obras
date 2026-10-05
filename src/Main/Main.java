package Main;

import Class.ClaseGestorFicheros;
import Class.ClaseGestorObras;
import Class.ClaseGestorTrabajadores;
import UI.VentanaPrincipal;

import javax.swing.*;

public class Main
{
    public static void main(String[] args)
    {
        // Intenta aplicar el aspecto visual del sistema operativo y si no funciona salta la excepción
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e)
        {
            System.out.println("No se pudo aplicar el look and feel del sistema.");
        }

        // Crea los gestores
        ClaseGestorObras gestorObras = new ClaseGestorObras();
        ClaseGestorTrabajadores gestorTrabajadores = new ClaseGestorTrabajadores();

        // Carga lo que contienen los ficheros
        gestorObras.getObras().addAll(ClaseGestorFicheros.cargarObras());
        gestorTrabajadores.getTrabajadores().addAll(ClaseGestorFicheros.cargarTrabajadores());

        // Lanza la interfaz gráfica en el hilo de Swing
        SwingUtilities.invokeLater(() ->
        {
            VentanaPrincipal ventana = new VentanaPrincipal(gestorObras, gestorTrabajadores);
            ventana.setVisible(true);
        });
    }
}