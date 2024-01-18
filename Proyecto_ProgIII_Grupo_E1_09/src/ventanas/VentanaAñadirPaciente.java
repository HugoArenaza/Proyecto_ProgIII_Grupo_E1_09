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
import domain.TipoPaciente;

public class VentanaAñadirPaciente extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;
    private JTextField MicroChip;
    private JTextField Enfermedad;
    private JTextField Dueño;
   
    private JButton btnAgregarPaciente;
    private JComboBox<TipoPaciente> ComboPaciente;
    
    
    public VentanaAñadirPaciente() {
        setTitle("Ventana Paciente");
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
        MicroChip = new JTextField(20);
        Enfermedad = new JTextField(20);
        Dueño = new JTextField(20);
        
      
        
        TipoPaciente[] valoresPacientes = TipoPaciente.values();
        ComboPaciente = new JComboBox<TipoPaciente>(valoresPacientes);

        btnAgregarPaciente = new JButton("Agregar paciente");

        panel.add(new JLabel("Nombre:"));
        panel.add(txtNombre);
        panel.add(new JLabel("MicroChip:"));
        panel.add(MicroChip);
        panel.add(new JLabel("Enfermedad:"));
        panel.add(Enfermedad);
        panel.add(new JLabel("Nombre Dueño:"));
        panel.add(Dueño);
       
        panel.add(new JLabel("Paciente:"));
        panel.add(ComboPaciente);
        panel.add(btnAgregarPaciente);

        add(panel);
    }
    private void initListeners() {
        btnAgregarPaciente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarPaciente();
            }
        });
    }
    private void agregarPaciente() {
    	try {
            Connection conn = BD.initBD("clinicaFurwell.db");
           
            // Incrementar el Id para el nuevo trabajador
            int nuevoId = obtenerUltimoId(conn) + 1;
            
            TipoPaciente especialidadPacientes = (TipoPaciente) ComboPaciente.getSelectedItem();

            // Insertar el trabajador en la tabla Trabajador
            String consultaTrabajador = "INSERT INTO Paciente (Id, Nombre, MicroChip, Enfermedad, TipoAnimal, Dueño) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statementTrabajador = conn.prepareStatement(consultaTrabajador);
            statementTrabajador.setInt(1, nuevoId);
            statementTrabajador.setString(2, txtNombre.getText());
            statementTrabajador.setString(3, MicroChip.getText());
            statementTrabajador.setString(4, Dueño.getText());
            statementTrabajador.setString(5, especialidadPacientes.name());
            

            statementTrabajador.executeUpdate();
            statementTrabajador.close();

            JOptionPane.showMessageDialog(this, "Paciente agregado exitosamente");
            
            // Cierra los recursos
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al agregar Paciente", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private int obtenerUltimoId(Connection conn) throws SQLException {
        String consulta = "SELECT MAX(Id) FROM Paciente";
        try (PreparedStatement statement = conn.prepareStatement(consulta);
             ResultSet resultado = statement.executeQuery()) {
            return resultado.next() ? resultado.getInt(1) : 0;
        }
    }

}
