package UI;

import Class.*;
import Enum.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class VentanaPrincipal extends JFrame
{
    private ClaseGestorObras gestorObras;
    private ClaseGestorTrabajadores gestorTrabajadores;

    private DefaultTableModel modeloTablaObras;
    private DefaultTableModel modeloTablaTrabajadores;
    private JTable tablaObras;
    private JTable tablaTrabajadores;


    //CONSTRUCTOR
    public VentanaPrincipal(ClaseGestorObras gestorObras, ClaseGestorTrabajadores gestorTrabajadores)
    {
        this.gestorObras = gestorObras;
        this.gestorTrabajadores = gestorTrabajadores;

        inicializarVentana();
        crearComponentes();
        actualizarTablaObras();
        actualizarTablaTrabajadores();
    }

    //Función que configura las propiedades básicas de la ventana
    private void inicializarVentana()
    {
        setTitle("GREG — Gestión y Registro de Obras");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 700);
        setMinimumSize(new Dimension(900, 500));
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
    }

    //Función que construye todos los componentes de la ventana
    private void crearComponentes()
    {
        add(crearHeader(), BorderLayout.NORTH);
        add(crearTabbedPane(), BorderLayout.CENTER);
        add(crearStatusBar(), BorderLayout.SOUTH);
    }

    //La cabecera superior con el nombre de la aplicación
    private JPanel crearHeader()
    {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(44, 62, 80));
        panel.setPreferredSize(new Dimension(0, 56));

        JLabel titulo = new JLabel("   GREG — Gestión y Registro de Obras");
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        titulo.setForeground(Color.WHITE);
        panel.add(titulo, BorderLayout.CENTER);

        return panel;
    }

    //Barra de estado inferior
    private JPanel crearStatusBar()
    {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.setBackground(new Color(236, 240, 241));
        panel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.LIGHT_GRAY));
        panel.add(new JLabel("   Sistema listo."));
        return panel;
    }

    //Panel con las tres pestañas principales
    private JTabbedPane crearTabbedPane()
    {
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setFont(new Font("Arial", Font.PLAIN, 14));
        tabbedPane.addTab("Obras", crearPanelObras());
        tabbedPane.addTab("Trabajadores", crearPanelTrabajadores());
        tabbedPane.addTab("Estadísticas", crearPanelEstadisticas());
        return tabbedPane;
    }



    // PESTAÑA OBRAS
    private JPanel crearPanelObras()
    {
        JPanel panel = new JPanel(new BorderLayout(8, 8));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Tabla
        String[] columnas = {"Código", "Descripción", "Tipo", "Estado", "Prioridad", "Comunidad", "Beneficio (€)"};
        modeloTablaObras = new DefaultTableModel(columnas, 0)
        {
            @Override
            public boolean isCellEditable(int row, int col) { return false; }
        };

        tablaObras = new JTable(modeloTablaObras);
        tablaObras.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tablaObras.setRowHeight(28);
        tablaObras.getTableHeader().setFont(new Font("Arial", Font.BOLD, 13));
        tablaObras.setFont(new Font("Arial", Font.PLAIN, 13));
        panel.add(new JScrollPane(tablaObras), BorderLayout.CENTER);

        // Botones
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 8));
        JButton btnAnadir = crearBoton("+ Añadir obra", new Color(0, 0,0));
        JButton btnVer = crearBoton("Más información", new Color(41, 128, 185));
        JButton btnEliminar = crearBoton("Eliminar", new Color(192, 57, 43));
        JButton btnExportTxt = crearBoton("Exportar informe", new Color(127, 140, 141));
        JButton btnExportCSV = crearBoton("Guardar CSV", new Color(127, 140, 141));

        panelBotones.add(btnAnadir);
        panelBotones.add(btnVer);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnExportTxt);
        panelBotones.add(btnExportCSV);
        panel.add(panelBotones, BorderLayout.SOUTH);

        // Eventos
        btnAnadir.addActionListener(e ->
        {
            new DialogoObra(this, gestorObras).setVisible(true);
            actualizarTablaObras();
        });

        btnVer.addActionListener(e ->
        {
            int fila = tablaObras.getSelectedRow();
            if (fila == -1) { avisar("Seleccione una obra primero."); return; }
            int codigo = (int) modeloTablaObras.getValueAt(fila, 0);
            ClaseObra obra = gestorObras.buscar(String.valueOf(codigo));
            if (obra != null) mostrarDetalle(obra.toString(), "Detalle de obra");
        });

        btnEliminar.addActionListener(e ->
        {
            int fila = tablaObras.getSelectedRow();
            if (fila == -1) { avisar("Seleccione una obra primero."); return; }
            int codigo = (int) modeloTablaObras.getValueAt(fila, 0);
            if (confirmar("¿Eliminar la obra con código " + codigo + "?"))
            {
                gestorObras.eliminar(String.valueOf(codigo));
                ClaseGestorFicheros.guardarObras(gestorObras.getObras());
                actualizarTablaObras();
            }
        });

        btnExportTxt.addActionListener(e ->
        {
            gestorObras.exportarTxt("obras_informe.txt");
            exito("Informe exportado a obras_informe.txt");
        });

        btnExportCSV.addActionListener(e ->
        {
            gestorObras.exportarTxt("obras.txt"); //<-- Aquí he cambiado de exportarCSV a exportarTXT
            exito("Datos guardados en obras.txt");
        });

        return panel;
    }



    //PESTAÑA TRABAJADORES
    private JPanel crearPanelTrabajadores()
    {
        JPanel panel = new JPanel(new BorderLayout(8, 8));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Tabla
        String[] columnas = {"DNI", "Nombre", "Apellidos", "Rol", "Estado", "Contrato", "Salario (€)"};
        modeloTablaTrabajadores = new DefaultTableModel(columnas, 0)
        {
            @Override
            public boolean isCellEditable(int row, int col) { return false; }
        };
        tablaTrabajadores = new JTable(modeloTablaTrabajadores);
        tablaTrabajadores.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tablaTrabajadores.setRowHeight(28);
        tablaTrabajadores.getTableHeader().setFont(new Font("Arial", Font.BOLD, 13));
        tablaTrabajadores.setFont(new Font("Arial", Font.PLAIN, 13));
        panel.add(new JScrollPane(tablaTrabajadores), BorderLayout.CENTER);

        // Botones
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 8));
        JButton btnAnadir    = crearBoton("+ Añadir trabajador", new Color(39, 174, 96));
        JButton btnVer       = crearBoton("Más información",          new Color(41, 128, 185));
        JButton btnEliminar  = crearBoton("Eliminar",             new Color(192, 57, 43));
        JButton btnExportTxt = crearBoton("Exportar informe",     new Color(127, 140, 141));

        panelBotones.add(btnAnadir);
        panelBotones.add(btnVer);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnExportTxt);
        panel.add(panelBotones, BorderLayout.SOUTH);

        // Eventos
        btnAnadir.addActionListener(e ->
        {
            new DialogoTrabajador(this, gestorTrabajadores).setVisible(true);
            actualizarTablaTrabajadores();
        });

        btnVer.addActionListener(e ->
        {
            int fila = tablaTrabajadores.getSelectedRow();
            if (fila == -1) { avisar("Seleccione un trabajador primero."); return; }
            String dni = (String) modeloTablaTrabajadores.getValueAt(fila, 0);
            ClaseTrabajador t = gestorTrabajadores.buscar(dni);
            if (t != null) mostrarDetalle(t.toString(), "Detalle de trabajador");
        });

        btnEliminar.addActionListener(e ->
        {
            int fila = tablaTrabajadores.getSelectedRow();
            if (fila == -1) { avisar("Seleccione un trabajador primero."); return; }
            String dni = (String) modeloTablaTrabajadores.getValueAt(fila, 0);
            if (confirmar("¿Eliminar al trabajador con DNI " + dni + "?"))
            {
                gestorTrabajadores.eliminar(dni);
                ClaseGestorFicheros.guardarTrabajadores(gestorTrabajadores.getTrabajadores());
                actualizarTablaTrabajadores();
            }
        });

        btnExportTxt.addActionListener(e ->
        {
            gestorTrabajadores.exportarTxt("trabajadores_informe.txt");
            exito("Informe exportado a trabajadores_informe.txt");
        });

        return panel;
    }



    //PESTAÑA ESTADÍSTICAS
    private JPanel crearPanelEstadisticas()
    {
        JPanel panel = new JPanel(new BorderLayout(8, 8));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Área de resultados
        JTextArea areaResultado = new JTextArea();
        areaResultado.setEditable(false);
        areaResultado.setFont(new Font("Monospaced", Font.PLAIN, 13));
        areaResultado.setLineWrap(true);
        areaResultado.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
        panel.add(new JScrollPane(areaResultado), BorderLayout.CENTER);

        // Grid de botones
        JPanel panelBotones = new JPanel(new GridLayout(2, 4, 8, 8));
        panelBotones.setBorder(BorderFactory.createEmptyBorder(8, 0, 0, 0));

        JButton btnBeneficioTotal = crearBoton("Beneficio total", new Color(41, 128, 185));
        JButton btnNominaTotal = crearBoton("Nómina total", new Color(41, 128, 185));
        JButton btnActivos = crearBoton("Trabajadores activos", new Color(41, 128, 185));
        JButton btnResumenObras = crearBoton("Resumen obras", new Color(41, 128, 185));
        JButton btnResumenTrabajadores = crearBoton("Resumen trabajadores", new Color(41, 128, 185));
        JButton btnObrasPorEstado = crearBoton("Obras por estado", new Color(39, 174, 96));
        JButton btnObrasPorPrioridad = crearBoton("Obras por prioridad", new Color(39, 174, 96));
        JButton btnTrabajadoresPorRol = crearBoton("Trabajadores por rol", new Color(39, 174, 96));

        panelBotones.add(btnBeneficioTotal);
        panelBotones.add(btnNominaTotal);
        panelBotones.add(btnActivos);
        panelBotones.add(btnResumenObras);
        panelBotones.add(btnResumenTrabajadores);
        panelBotones.add(btnObrasPorEstado);
        panelBotones.add(btnObrasPorPrioridad);
        panelBotones.add(btnTrabajadoresPorRol);
        panel.add(panelBotones, BorderLayout.SOUTH);

        // Eventos
        btnBeneficioTotal.addActionListener(e ->
            areaResultado.setText("Beneficio total estimado: " + gestorObras.calcularBeneficioTotal() + " €")
        );

        btnNominaTotal.addActionListener(e ->
            areaResultado.setText("Nómina mensual total: " + gestorTrabajadores.calcularNominaTotal() + " €")
        );

        btnActivos.addActionListener(e ->
            areaResultado.setText("Trabajadores activos: " + gestorTrabajadores.contarActivos())
        );

        btnResumenObras.addActionListener(e ->
        {
            StringBuilder sb = new StringBuilder("=== RESUMEN DE OBRAS (ordenadas por beneficio) ===\n\n");
            gestorObras.ordenarPorBeneficio().forEach(o ->
                sb.append("Código: ").append(o.getCodigoObra())
                .append(" | Beneficio: ").append(o.getBeneficioEstipulado()).append(" €")
                .append(" | Estado: ").append(o.getEstadoObra())
                .append(" | Prioridad: ").append(o.getPrioridad())
                .append("\n")
            );
            areaResultado.setText(sb.toString());
        });

        btnResumenTrabajadores.addActionListener(e ->
        {
            StringBuilder sb = new StringBuilder("=== RESUMEN DE TRABAJADORES ===\n\n");
            gestorTrabajadores.getTrabajadores().forEach(t ->
                sb.append(t.getNombre()).append(" ").append(t.getPrApellido())
                .append(" | DNI: ").append(t.getDni())
                .append(" | Rol: ").append(t.getRol())
                .append(" | Estado: ").append(t.getEstado())
                .append(" | Salario: ").append(t.getSalarioMensual()).append(" €\n")
            );
            areaResultado.setText(sb.toString());
        });

        btnObrasPorEstado.addActionListener(e ->
        {
            EnumEstadoObra[] estados = EnumEstadoObra.values();
            EnumEstadoObra sel = (EnumEstadoObra) JOptionPane.showInputDialog(
                this, "Seleccione el estado:", "Filtrar obras por estado",
                JOptionPane.QUESTION_MESSAGE, null, estados, estados[0]
            );
            if (sel == null) return;
            StringBuilder sb = new StringBuilder("=== OBRAS EN ESTADO: " + sel + " ===\n\n");
            List<ClaseObra> filtradas = gestorObras.filtrarPorEstado(sel);
            if (filtradas.isEmpty()) sb.append("No hay obras en ese estado.");
            else filtradas.forEach(o -> sb.append(o.toString()).append("\n─────────────────────\n"));
            areaResultado.setText(sb.toString());
        });

        btnObrasPorPrioridad.addActionListener(e ->
        {
            EnumPrioridadTarea[] prioridades = EnumPrioridadTarea.values();
            EnumPrioridadTarea sel = (EnumPrioridadTarea) JOptionPane.showInputDialog(
                this, "Seleccione la prioridad:", "Filtrar obras por prioridad",
                JOptionPane.QUESTION_MESSAGE, null, prioridades, prioridades[0]
            );
            if (sel == null) return;
            StringBuilder sb = new StringBuilder("=== OBRAS CON PRIORIDAD: " + sel + " ===\n\n");
            List<ClaseObra> filtradas = gestorObras.filtrarPorPrioridad(sel);
            if (filtradas.isEmpty()) sb.append("No hay obras con esa prioridad.");
            else filtradas.forEach(o -> sb.append(o.toString()).append("\n─────────────────────\n"));
            areaResultado.setText(sb.toString());
        });

        btnTrabajadoresPorRol.addActionListener(e ->
        {
            EnumRolTrabajador[] roles = EnumRolTrabajador.values();
            EnumRolTrabajador sel = (EnumRolTrabajador) JOptionPane.showInputDialog(
                this, "Seleccione el rol:", "Filtrar trabajadores por rol",
                JOptionPane.QUESTION_MESSAGE, null, roles, roles[0]
            );
            if (sel == null) return;
            StringBuilder sb = new StringBuilder("=== TRABAJADORES CON ROL: " + sel + " ===\n\n");
            List<ClaseTrabajador> filtrados = gestorTrabajadores.filtrarPorRol(sel);
            if (filtrados.isEmpty()) sb.append("No hay trabajadores con ese rol.");
            else filtrados.forEach(t -> sb.append(t.toString()).append("\n─────────────────────\n"));
            areaResultado.setText(sb.toString());
        });

        return panel;
    }



    //MÉTODOS AUXILIARES
    // Refresca la tabla de obras con los datos actuales del gestor
    public void actualizarTablaObras()
    {
        modeloTablaObras.setRowCount(0);
        for (ClaseObra o : gestorObras.getObras())
        {
            modeloTablaObras.addRow(new Object[]{
                o.getCodigoObra(),
                o.getDescripcion(),
                o.getTipoObra(),
                o.getEstadoObra(),
                o.getPrioridad(),
                o.getComunidadObra(),
                o.getBeneficioEstipulado()
            });
        }
    }

    // Refresca la tabla de trabajadores con los datos actuales del gestor
    public void actualizarTablaTrabajadores()
    {
        modeloTablaTrabajadores.setRowCount(0);
        for (ClaseTrabajador t : gestorTrabajadores.getTrabajadores())
        {
            modeloTablaTrabajadores.addRow(new Object[]{
                t.getDni(),
                t.getNombre(),
                t.getPrApellido() + " " + t.getSgApellido(),
                t.getRol(),
                t.getEstado(),
                t.getContrato(),
                t.getSalarioMensual()
            });
        }
    }

    // Crea un botón con el estilo visual del programa
    private JButton crearBoton(String texto, Color color)
    {
        JButton btn = new JButton(texto);
        btn.setBackground(color);
        btn.setForeground(Color.BLACK);
        btn.setFocusPainted(false);
        btn.setFont(new Font("Arial", Font.BOLD, 13));
        btn.setBorder(BorderFactory.createEmptyBorder(8, 14, 8, 14));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return btn;
    }

    // Muestra el detalle completo de una obra o trabajador en un diálogo
    private void mostrarDetalle(String texto, String titulo)
    {
        JTextArea area = new JTextArea(texto);
        area.setEditable(false);
        area.setFont(new Font("Monospaced", Font.PLAIN, 13));
        area.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
        JScrollPane scroll = new JScrollPane(area);
        scroll.setPreferredSize(new Dimension(500, 400));
        JOptionPane.showMessageDialog(this, scroll, titulo, JOptionPane.INFORMATION_MESSAGE);
    }

    private void avisar(String mensaje)
    {
        JOptionPane.showMessageDialog(this, mensaje, "Aviso", JOptionPane.WARNING_MESSAGE);
    }

    private boolean confirmar(String mensaje)
    {
        return JOptionPane.showConfirmDialog(this, mensaje, "Confirmar",
            JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
    }

    private void exito(String mensaje)
    {
        JOptionPane.showMessageDialog(this, mensaje, "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }
}