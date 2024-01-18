package ventanas;

import java.awt.BorderLayout;
import java.util.logging.Logger;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
//import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import base_de_datos.BD;
import domain.Proveedor;

public class VentanaJefe extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnProveedores, btnPacientes, btnTrabajadores, btnSalir;
	private JPanel panelCentro, panelAbajo;
	
	public VentanaJefe() {
		Logger logger = java.util.logging.Logger.getLogger("Logger");

		JPanel panelIzquierda = new JPanel();
		panelIzquierda.setLayout(new GridLayout(0, 1));
		panelCentro = new JPanel();

		panelAbajo = new JPanel();

		btnProveedores = new JButton("Proveedores"); // Boton que mostrara un combobox de los proveedores disponibles
		btnPacientes = new JButton("Pacientes"); // Boton que mostrara un jtable con todos los pacientes
		btnTrabajadores = new JButton("Trabajadores"); // Boton que mostrara una JTable con todos los trabajadores, mas
														// funcionalidades por agregar

		btnSalir = new JButton("Salir");
		Dimension dimensionPanelCentro = new Dimension(100, 80);
		panelCentro.setMinimumSize(dimensionPanelCentro);
		Dimension tamañoBotones = new Dimension(150, 40);

		btnProveedores.setMaximumSize(tamañoBotones);
		btnPacientes.setMaximumSize(tamañoBotones);
		btnTrabajadores.setMaximumSize(tamañoBotones);
		JButton botonAñadirTrabajador = new JButton("Añadir Trabajador");
		JButton botonAñadirPaciente = new JButton("Añadir paciente");

		panelIzquierda.add(btnProveedores);
		panelIzquierda.add(btnPacientes);
		panelIzquierda.add(btnTrabajadores);
		panelAbajo.add(btnSalir);

		getContentPane().add(panelIzquierda, BorderLayout.WEST);
		getContentPane().add(panelCentro, BorderLayout.CENTER);
		getContentPane().add(panelAbajo, BorderLayout.SOUTH);


		btnProveedores.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panelCentro.removeAll(); // vacio el panel para cambiar contenido que quiero mostrar
				panelAbajo.removeAll();

				JPanel panelComboBox = new JPanel();
				panelComboBox.setLayout(new BorderLayout());

				JComboBox<Proveedor> proveedores = new JComboBox<>();
				DefaultComboBoxModel<Proveedor> model = new DefaultComboBoxModel<>();

				proveedores.setModel(model);

				JButton botonAbrir = new JButton("Abrir proveedor");

				botonAbrir.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						System.out.println("Prueba de boton"); // Prueba funcionalidad, este boton se usara para abrir
																// la
																// clinica seleccionada en una nueva ventana con todos
																// los datos

					}
				});

				panelComboBox.add(proveedores, BorderLayout.CENTER);
				JPanel panelBotonAbrir = new JPanel();
				panelBotonAbrir.add(botonAbrir);
				panelCentro.add(panelComboBox);
				panelCentro.revalidate();
				panelCentro.repaint();
				panelAbajo.add(btnSalir);
				panelAbajo.revalidate();
				panelAbajo.repaint();

				panelComboBox.add(panelBotonAbrir, BorderLayout.SOUTH);
				
			}
		});
		btnPacientes.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panelCentro.removeAll();
				panelAbajo.removeAll();

				JTable tablePacientes = new JTable();
				DefaultTableModel model = (DefaultTableModel) tablePacientes.getModel();

				model.addColumn("Identificativo");
				model.addColumn("Nombre Paciente");
				model.addColumn("MicroChip");
				model.addColumn("Enfermedad");
				model.addColumn("Veterinario");
				model.addColumn("Tipo Paciente");
				model.addColumn("Telefono Dueño");

				try {
					Connection conn = BD.initBD("clinicaFurwell.db");
				    String consulta = "SELECT * FROM Paciente";
				    PreparedStatement statement = conn.prepareStatement(consulta);
				    ResultSet resultado = statement.executeQuery();
				    while (resultado.next()) {
				        int ID = resultado.getInt("ID");
				        String Nombre = resultado.getString("Nombre");
				        int MicroChip = resultado.getInt("MicroChip");
				        String Enfermedad = resultado.getString("Enfermedad");
				        String TipoAnimal = resultado.getString("TipoAnimal");
				        String Dueño = resultado.getString("Dueño");
				        

				        model.addRow(new Object[]{ID, Nombre, MicroChip, Enfermedad, TipoAnimal, Dueño});
				    }

				    resultado.close();
				    statement.close();
				    conn.close();
				} catch (SQLException ex) {
				    ex.printStackTrace();
				    // Manejar la excepción apropiadamente
				}

				
				JTableHeader tableHeader = tablePacientes.getTableHeader();
				tableHeader.setReorderingAllowed(false);  // Deshabilitar la reordenación de columnas
				tableHeader.setResizingAllowed(false);     

				tablePacientes.setPreferredScrollableViewportSize(new Dimension(1000, 10000)); // Reemplaza ancho y alto con los valores deseados

				tablePacientes.setEnabled(true);
				
				panelCentro.add(new JScrollPane(tablePacientes));
				panelCentro.revalidate();
				panelCentro.repaint();
				
				panelAbajo.add(btnSalir);
				panelAbajo.add(botonAñadirPaciente);
				panelAbajo.revalidate();
				panelAbajo.repaint();

			}
		});
		btnTrabajadores.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panelCentro.removeAll();
				Dimension dimensionPanelCentro = new Dimension(1000, 10000);
				panelCentro.setPreferredSize(dimensionPanelCentro);
				

			
				JTable tableVeterinarios = new JTable();
				DefaultTableModel model = (DefaultTableModel) tableVeterinarios.getModel();
				

				model.addColumn("Id");
				model.addColumn("Nombre");
				model.addColumn("Apellidos");
				model.addColumn("Usuario");
				model.addColumn("Contraseña");
				model.addColumn("DNI");
				model.addColumn("Sueldo");
				model.addColumn("Numero Empleados");
				model.addColumn("Numero Pacientes");
				model.addColumn("Especialidad");
				model.addColumn("Tipo");
				
				
				
				
				
				try {
					Connection conn = BD.initBD("clinicaFurwell.db");
				    String consulta = "SELECT * FROM Veterinario";
				    PreparedStatement statement = conn.prepareStatement(consulta);
				    ResultSet resultado = statement.executeQuery();
				    while (resultado.next()) {
				        int Id = resultado.getInt("Id");
				        String nombre = resultado.getString("nombre");
				        String apellidos = resultado.getString("apellidos");
				        String usuario = resultado.getString("usuario");
				        String contraseña = resultado.getString("contraseña");
				        String dni = resultado.getString("dni");
				        Float sueldo = resultado.getFloat("sueldo");
				        int numEmpleados= resultado.getInt("numero_empleados");
				        int numPacientes= resultado.getInt("numero_pacientes");
				        String especialidad = resultado.getString("Especialidad");
				        String tipo = resultado.getString("TIPO_VETERINARIO");
				        

				        model.addRow(new Object[]{Id, nombre, apellidos, usuario, contraseña, dni, sueldo,numEmpleados,numPacientes, especialidad, tipo});
				    }

				    resultado.close();
				    statement.close();
				    conn.close();
				} catch (SQLException ex) {
				    ex.printStackTrace();
				    // Manejar la excepción apropiadamente
				}

				
				
				

				
				
				
				JTableHeader tableHeader = tableVeterinarios.getTableHeader();
				tableHeader.setReorderingAllowed(false);  // Deshabilitar la reordenación de columnas
				tableHeader.setResizingAllowed(false);     // Deshabilitar el redimensionamiento de columnas

				
				
				panelCentro.add(tableHeader);
				
				tableVeterinarios.setPreferredScrollableViewportSize(new Dimension(1000, 10000)); // Reemplaza ancho y alto con los valores deseados

				tableVeterinarios.setEnabled(true);
				panelCentro.add(new JScrollPane(tableVeterinarios));
				panelCentro.revalidate();
				panelCentro.repaint();
				panelAbajo.add(botonAñadirTrabajador);
				tableVeterinarios.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

			}
		});
		btnSalir.addActionListener((e) -> {
			dispose();
			logger.info("Se ha cerrado la sesion");
		});
		botonAñadirTrabajador.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaAnyadirTrabajador();
				
			}
		});
		botonAñadirPaciente.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new VentanaAñadirPaciente();
				
			}
		});

		setTitle("Ventana Jefe");
		setBounds(200, 50, 1200, 800);		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
}


