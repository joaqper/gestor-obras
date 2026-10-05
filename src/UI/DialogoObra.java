package UI;

import Class.ClaseGestorFicheros;
import Class.ClaseGestorObras;
import Class.ClaseObra;
import Enum.*;

import javax.swing.*;
import java.awt.*;

public class DialogoObra extends JDialog
{
    private ClaseGestorObras gestorObras;

    // Campos de texto
    private JTextField txtCodigo;
    private JTextField txtDescripcion;
    private JTextField txtNombreEntidad;
    private JTextField txtNumeroEntidad;
    private JTextField txtUbicacion;
    private JTextField txtPersonal;
    private JTextField txtBeneficio;

    // Desplegables de enum
    private JComboBox<EnumTipoContratador> cmbContratador;
    private JComboBox<EnumTipoObra> cmbTipoObra;
    private JComboBox<EnumTamanioObra> cmbTamanio;
    private JComboBox<EnumComunidadEspania> cmbComunidad;
    private JComboBox<EnumProvinciaEspania> cmbProvincia;
    private JComboBox<EnumPrioridadTarea> cmbPrioridad;
    private JComboBox<EnumMaquinariaNecesaria> cmbMaquinaria;
    private JComboBox<EnumEstadoObra> cmbEstadoObra;
    private JComboBox<EnumEstadoFactura> cmbEstadoFactura;


    // CONSTRUCTOR
    public DialogoObra(JFrame parent, ClaseGestorObras gestorObras)
    {
        super(parent, "Añadir obra", true);
        this.gestorObras = gestorObras;

        setSize(620, 680);
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

        int fila = 0;

        txtCodigo = new JTextField(String.valueOf(gestorObras.generarCodigoUnico()));
        txtCodigo.setEditable(false);
        txtCodigo.setBackground(new Color(236, 240, 241));

        txtDescripcion = new JTextField();
        txtNombreEntidad = new JTextField();
        cmbContratador = new JComboBox<>(EnumTipoContratador.values());
        txtNumeroEntidad = new JTextField();
        cmbTipoObra = new JComboBox<>(EnumTipoObra.values());
        cmbTamanio = new JComboBox<>(EnumTamanioObra.values());
        cmbComunidad = new JComboBox<>(EnumComunidadEspania.values());
        cmbProvincia = new JComboBox<>(EnumProvinciaEspania.values());
        txtUbicacion = new JTextField();
        cmbPrioridad = new JComboBox<>(EnumPrioridadTarea.values());
        txtPersonal = new JTextField();
        cmbMaquinaria = new JComboBox<>(EnumMaquinariaNecesaria.values());
        cmbEstadoObra = new JComboBox<>(EnumEstadoObra.values());
        cmbEstadoFactura = new JComboBox<>(EnumEstadoFactura.values());
        txtBeneficio = new JTextField();

        fila = anadirCampo(panel, gbc, fila, "Código de la obra:", txtCodigo);
        fila = anadirCampo(panel, gbc, fila, "Descripción:", txtDescripcion);
        fila = anadirCampo(panel, gbc, fila, "Nombre entidad contratadora:", txtNombreEntidad);
        fila = anadirCampo(panel, gbc, fila, "Tipo de contratador:", cmbContratador);
        fila = anadirCampo(panel, gbc, fila, "Número entidad contratadora:",txtNumeroEntidad);
        fila = anadirCampo(panel, gbc, fila, "Tipo de obra:", cmbTipoObra);
        fila = anadirCampo(panel, gbc, fila, "Tamaño de la obra:", cmbTamanio);
        fila = anadirCampo(panel, gbc, fila, "Comunidad autónoma:", cmbComunidad);
        fila = anadirCampo(panel, gbc, fila, "Provincia:", cmbProvincia);
        fila = anadirCampo(panel, gbc, fila, "Ubicación exacta:", txtUbicacion);
        fila = anadirCampo(panel, gbc, fila, "Prioridad:", cmbPrioridad);
        fila = anadirCampo(panel, gbc, fila, "Personal dedicado:", txtPersonal);
        fila = anadirCampo(panel, gbc, fila, "Maquinaria necesaria:", cmbMaquinaria);
        fila = anadirCampo(panel, gbc, fila, "Estado de la obra:", cmbEstadoObra);
        fila = anadirCampo(panel, gbc, fila, "Estado de la factura:", cmbEstadoFactura);
        anadirCampo(panel, gbc, fila, "Beneficio estipulado (€):", txtBeneficio);

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
        JButton btnGuardar  = new JButton("Guardar obra");
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

    // Valida los campos y guarda la obra si todo es correcto
    private void guardar()
    {
        try
        {
            int codigo = Integer.parseInt(txtCodigo.getText().trim());
            String descripcion = txtDescripcion.getText().trim();
            String nombreEntidad = txtNombreEntidad.getText().trim();
            int numeroEntidad = Integer.parseInt(txtNumeroEntidad.getText().trim());
            String ubicacion = txtUbicacion.getText().trim();
            int personal = Integer.parseInt(txtPersonal.getText().trim());
            int beneficio = Integer.parseInt(txtBeneficio.getText().trim());

            if (descripcion.isEmpty() || nombreEntidad.isEmpty() || ubicacion.isEmpty())
            {
                JOptionPane.showMessageDialog(this,
                    "Por favor, rellene todos los campos de texto.",
                    "Campos vacíos", JOptionPane.WARNING_MESSAGE);
                return;
            }

            ClaseObra obra = new ClaseObra(
                codigo, 
                descripcion, 
                ubicacion, 
                personal, 
                nombreEntidad,
                numeroEntidad,
                beneficio,
                (EnumTipoContratador) cmbContratador.getSelectedItem(),
                (EnumTipoObra) cmbTipoObra.getSelectedItem(),
                (EnumTamanioObra) cmbTamanio.getSelectedItem(),
                (EnumComunidadEspania) cmbComunidad.getSelectedItem(),
                (EnumProvinciaEspania) cmbProvincia.getSelectedItem(),
                (EnumPrioridadTarea) cmbPrioridad.getSelectedItem(),
                (EnumMaquinariaNecesaria) cmbMaquinaria.getSelectedItem(),
                (EnumEstadoObra) cmbEstadoObra.getSelectedItem(),
                (EnumEstadoFactura) cmbEstadoFactura.getSelectedItem()
            );

            gestorObras.agregar(obra);
            ClaseGestorFicheros.guardarObras(gestorObras.getObras());

            JOptionPane.showMessageDialog(this,
                "Obra añadida correctamente.",
                "Éxito", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        }
        catch (NumberFormatException e)
        {
            JOptionPane.showMessageDialog(this,
                "Los campos numéricos (código, número entidad, personal, beneficio) deben ser números enteros.",
                "Error de formato", JOptionPane.ERROR_MESSAGE);
        }
    }
}