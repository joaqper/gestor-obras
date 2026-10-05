package UI;

import Class.ClaseGestorFicheros;
import Class.ClaseGestorTrabajadores;
import Class.ClaseTrabajador;
import Enum.*;

import javax.swing.*;
import java.awt.*;

public class DialogoTrabajador extends JDialog
{
    private ClaseGestorTrabajadores gestorTrabajadores;

    // Campos de texto
    private JTextField txtNombre;
    private JTextField txtPrApellido;
    private JTextField txtSgApellido;
    private JTextField txtDni;
    private JTextField txtEdad;
    private JTextField txtExperiencia;
    private JTextField txtSalario;
    private JTextField txtIdObra;

    // Desplegables de enum
    private JComboBox<EnumRolTrabajador> cmbRol;
    private JComboBox<EnumTipoContrato> cmbContrato;
    private JComboBox<EnumEstadoTrabajador> cmbEstado;
    private JComboBox<EnumTipoJornada> cmbJornada;


    // CONSTRUCTOR
    public DialogoTrabajador(JFrame parent, ClaseGestorTrabajadores gestorTrabajadores)
    {
        super(parent, "Añadir trabajador", true);
        this.gestorTrabajadores = gestorTrabajadores;

        setSize(560, 580);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());
        setResizable(false);

        JScrollPane scroll = new JScrollPane(crearFormulario());
        scroll.getVerticalScrollBar().setUnitIncrement(16);
        add(scroll, BorderLayout.CENTER);
        add(crearPanelBotones(), BorderLayout.SOUTH);
    }

    // Construye el formulario con todos los campos
    private JPanel crearFormulario()
    {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(16, 16, 16, 16));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 6, 5, 6);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        txtNombre = new JTextField();
        txtPrApellido = new JTextField();
        txtSgApellido = new JTextField();
        txtDni = new JTextField();
        txtEdad = new JTextField();
        txtExperiencia = new JTextField();
        txtSalario = new JTextField();
        txtIdObra = new JTextField("0");
        cmbRol = new JComboBox<>(EnumRolTrabajador.values());
        cmbContrato = new JComboBox<>(EnumTipoContrato.values());
        cmbEstado = new JComboBox<>(EnumEstadoTrabajador.values());
        cmbJornada = new JComboBox<>(EnumTipoJornada.values());

        int fila = 0;
        fila = anadirCampo(panel, gbc, fila, "Nombre:", txtNombre);
        fila = anadirCampo(panel, gbc, fila, "Primer apellido:", txtPrApellido);
        fila = anadirCampo(panel, gbc, fila, "Segundo apellido (opcional):", txtSgApellido);
        fila = anadirCampo(panel, gbc, fila, "DNI (formato 12345678A):", txtDni);
        fila = anadirCampo(panel, gbc, fila, "Edad:", txtEdad);
        fila = anadirCampo(panel, gbc, fila, "Años de experiencia:", txtExperiencia);
        fila = anadirCampo(panel, gbc, fila, "Salario mensual (€):", txtSalario);
        fila = anadirCampo(panel, gbc, fila, "ID obra actual (0 = sin asignar):",txtIdObra);
        fila = anadirCampo(panel, gbc, fila, "Rol:", cmbRol);
        fila = anadirCampo(panel, gbc, fila, "Tipo de contrato:", cmbContrato);
        fila = anadirCampo(panel, gbc, fila, "Estado:", cmbEstado);
                anadirCampo(panel, gbc, fila, "Tipo de jornada:", cmbJornada);

        return panel;
    }

    // Añade una fila de etiqueta + componente al formulario
    private int anadirCampo(JPanel panel, GridBagConstraints gbc, int fila, String etiqueta, JComponent campo)
    {
        gbc.gridx = 0; gbc.gridy = fila; gbc.weightx = 0;
        panel.add(new JLabel(etiqueta), gbc);
        gbc.gridx = 1; gbc.weightx = 1;
        panel.add(campo, gbc);
        return fila + 1;
    }

    // Panel inferior con los botones de acción
    private JPanel crearPanelBotones()
    {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        panel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.LIGHT_GRAY));

        JButton btnCancelar = new JButton("Cancelar");
        JButton btnGuardar  = new JButton("Guardar trabajador");
        btnGuardar.setBackground(new Color(39, 174, 96));
        btnGuardar.setForeground(Color.BLACK);
        btnGuardar.setFocusPainted(false);
        btnGuardar.setFont(new Font("Arial", Font.BOLD, 13));

        panel.add(btnCancelar);
        panel.add(btnGuardar);

        btnCancelar.addActionListener(e -> dispose());
        btnGuardar.addActionListener(e -> guardar());

        return panel;
    }

    // Valida los campos y guarda el trabajador si todo es correcto
    private void guardar()
    {
        try
        {
            String nombre = txtNombre.getText().trim();
            String prApellido = txtPrApellido.getText().trim();
            String sgApellido = txtSgApellido.getText().trim();
            String dni = txtDni.getText().trim();
            int edad = Integer.parseInt(txtEdad.getText().trim());
            int experiencia = Integer.parseInt(txtExperiencia.getText().trim());
            int salario = Integer.parseInt(txtSalario.getText().trim());
            int idObra = Integer.parseInt(txtIdObra.getText().trim());

            if (nombre.isEmpty() || prApellido.isEmpty() || dni.isEmpty())
            {
                JOptionPane.showMessageDialog(this,
                    "Nombre, primer apellido y DNI son obligatorios.",
                    "Campos vacíos", JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (!dni.matches("\\d{8}[A-Za-z]"))
            {
                JOptionPane.showMessageDialog(this,
                    "El DNI debe tener el formato 12345678A.",
                    "DNI inválido", JOptionPane.ERROR_MESSAGE);
                return;
            }

            ClaseTrabajador trabajador = new ClaseTrabajador(
                nombre, prApellido, sgApellido, dni, edad, experiencia, salario, idObra,
                (EnumRolTrabajador) cmbRol.getSelectedItem(),
                (EnumTipoContrato) cmbContrato.getSelectedItem(),
                (EnumEstadoTrabajador) cmbEstado.getSelectedItem(),
                (EnumTipoJornada) cmbJornada.getSelectedItem()
            );

            gestorTrabajadores.agregar(trabajador);
            ClaseGestorFicheros.guardarTrabajadores(gestorTrabajadores.getTrabajadores());

            JOptionPane.showMessageDialog(this,
                "Trabajador añadido correctamente.",
                "Éxito", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        }
        catch (NumberFormatException e)
        {
            JOptionPane.showMessageDialog(this,
                "Los campos numéricos (edad, experiencia, salario, ID obra) deben ser números enteros.",
                "Error de formato", JOptionPane.ERROR_MESSAGE);
        }
    }
}