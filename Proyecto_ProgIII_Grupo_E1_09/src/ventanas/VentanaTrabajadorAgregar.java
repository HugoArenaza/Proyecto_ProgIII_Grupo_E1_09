package ventanas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import base_de_datos.BD;
import domain.Especialidades;

public class VentanaTrabajadorAgregar extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;
    private JTextField txtApellidos;
    private JTextField txtUsuario;
    private JTextField txtContraseña;
    private JTextField txtDNI;
    private JTextField txtSueldo;
    private JTextField num_pacientes;
    private JButton btnAgregarTrabajador;
    private JComboBox<Especialidades> comboEspecialidad;
    
    
    public VentanaTrabajadorAgregar() {
        setTitle("Ventana Trabajador");
        setSize(400, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        

        initComponents();
        initListeners();
        setVisible(true);

    }
    private void initComponents() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        txtNombre = new JTextField(20);
        txtApellidos = new JTextField(20);
        txtUsuario = new JTextField(20);
        txtContraseña = new JTextField(20);
        txtDNI = new JTextField(20);
        txtSueldo = new JTextField(20);
        num_pacientes = new JTextField(20);
      
        
        Especialidades[] valoresEspecialidades = Especialidades.values();
        comboEspecialidad = new JComboBox<Especialidades>(valoresEspecialidades);

        btnAgregarTrabajador = new JButton("Agregar Trabajador");

        panel.add(new JLabel("Nombre:"));
        panel.add(txtNombre);
        panel.add(new JLabel("Apellidos:"));
        panel.add(txtApellidos);
        panel.add(new JLabel("Usuario:"));
        panel.add(txtUsuario);
        panel.add(new JLabel("Contraseña:"));
        panel.add(txtContraseña);
        panel.add(new JLabel("DNI:"));
        panel.add(txtDNI);
        panel.add(new JLabel("Sueldo:"));
        panel.add(txtSueldo);
        panel.add(new JLabel("Numero De Pacientes:"));
        panel.add(num_pacientes);
        panel.add(new JLabel("Especialidad:"));
        panel.add(comboEspecialidad);
        panel.add(btnAgregarTrabajador);

        add(panel);
    }
    private void initListeners() {
        btnAgregarTrabajador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
               if(num_pacientes.getText().isEmpty() || txtSueldo.getText().isEmpty() || txtDNI.getText().isEmpty() || txtContraseña.getText().isEmpty() || txtUsuario.getText().isEmpty() || txtApellidos.getText().isEmpty() || txtNombre.getText().isEmpty()) {
            	   JOptionPane.showMessageDialog(null, "Rellena todos los campos!!");
            
            
            }else {
            	agregarTrabajador();	
            }
            
        }});
    }
    private void agregarTrabajador() {
    	try {
            Connection conn = BD.initBD("clinicaFurwell.db");
           
            // Incrementar el Id para el nuevo trabajador
            int nuevoId = obtenerUltimoId(conn) + 1;
            
            Especialidades especialidadSeleccionada = (Especialidades) comboEspecialidad.getSelectedItem();

            // Insertar el trabajador en la tabla Trabajador
            String consultaTrabajador = "INSERT INTO VETERINARIO (Id,nombre, apellidos, usuario, contraseña, dni, sueldo,numero_empleados,numero_pacientes, especialidad, TIPO_VETERINARIO) VALUES (?, ?, ?, ?, ?,  ?, ?, 0, ?,?,'Trabajador')";
            PreparedStatement statementTrabajador = conn.prepareStatement(consultaTrabajador);
            statementTrabajador.setInt(1, nuevoId);
            statementTrabajador.setString(2, txtNombre.getText());
            statementTrabajador.setString(3, txtApellidos.getText());
            statementTrabajador.setString(4, txtUsuario.getText());
            statementTrabajador.setString(5, txtContraseña.getText());
            statementTrabajador.setString(6, txtDNI.getText());
            statementTrabajador.setFloat(7, Float.parseFloat(txtSueldo.getText()));
            statementTrabajador.setString(8, num_pacientes.getText());
            statementTrabajador.setString(9, especialidadSeleccionada.name());
           

            statementTrabajador.executeUpdate();
            statementTrabajador.close();

            JOptionPane.showMessageDialog(this, "Trabajador agregado exitosamente");

            // Cierra los recursos
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al agregar trabajador", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private int obtenerUltimoId(Connection conn) throws SQLException {
        String consulta = "SELECT MAX(Id) FROM VETERINARIO";
        try (PreparedStatement statement = conn.prepareStatement(consulta);
             ResultSet resultado = statement.executeQuery()) {
            return resultado.next() ? resultado.getInt(1) : 0;
        }
    }

    
}
