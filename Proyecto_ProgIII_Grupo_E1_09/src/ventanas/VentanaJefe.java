package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.util.logging.Logger;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
//import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
//import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import base_de_datos.BD;
import domain.Clinica;
import domain.Especialidades;
import domain.Jefe;
import domain.Proveedor;
import domain.TipoPaciente;
import domain.Trabajador;
import domain.Veterinario;
import domain.VeterinarioComparatorPorDni;
import domain.Paciente;

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
				model.addColumn("Nombre Dueño");
				model.addColumn("Apellidos Dueño");
				model.addColumn("MicroChip");
				model.addColumn("Enfermedad");
				model.addColumn("Veterinario");
				model.addColumn("Tipo Paciente");
				model.addColumn("Telefono Dueño");
				model.addColumn("Correo Dueño");

				panelCentro.add(new JScrollPane(tablePacientes));
				panelCentro.revalidate();
				panelCentro.repaint();
				panelAbajo.add(btnSalir);
				panelAbajo.revalidate();
				panelAbajo.repaint();

			}
		});
		btnTrabajadores.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panelCentro.removeAll();
				Dimension dimensionPanelCentro = new Dimension(1000, 10000);
				Border borderResaltado = BorderFactory.createLineBorder(Color.BLUE, 2);
				panelCentro.setPreferredSize(dimensionPanelCentro);
				panelCentro.setBorder(borderResaltado);

			
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
				model.addColumn("Tipo");// Columna para diferenciar tipo de veterinario

				
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
				        
//				        String consultaPaciente = "SELECT nombre FROM Pacientes WHERE id = ?";
//				        PreparedStatement statementPaciente = conn.prepareStatement(consultaPaciente);
//				        statementPaciente.setString(1, pacienteId);
//				        ResultSet resultadoPaciente = statementPaciente.executeQuery();
//
//				        // Procesa el resultado y obtén el nombre del paciente
//				        String nombrePaciente = "";
//				        if (resultadoPaciente.next()) {
//				            nombrePaciente = resultadoPaciente.getString("nombre");
//				        }
//
//				        // Limpia los recursos de la consulta del paciente
//				        resultadoPaciente.close();
//				        statementPaciente.close();
//				        
//				        ArrayList<String> pacientesList = obtenerPacientesDelVeterinario(Id);
//
//				     // Crear un JComboBox con la lista de pacientes
//				     JComboBox<String> comboBox = new JComboBox<>(pacientesList.toArray(new String[0]));
//
//				     // Configurar el editor de la celda para usar el JComboBox
//				     TableColumn pacienteColumn = tableVeterinarios.getColumnModel().getColumn(7);
//				     pacienteColumn.setCellEditor(new DefaultCellEditor(comboBox));
//
//				     // Personalizar el renderizador para mostrar el JComboBox en lugar de texto
//				     pacienteColumn.setCellRenderer(new DefaultTableCellRenderer() {
//				         /**
//						 * 
//						 */
//						private static final long serialVersionUID = 1L;
//
//						@Override
//				         public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
//				             return comboBox;
//				         }
//				     });
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
			public ArrayList<String> obtenerPacientesDelVeterinario(int idVeterinario) {
			    ArrayList<String> pacientesList = new ArrayList<>();

			    try {
			        Connection conn = BD.initBD("clinicaFurwell.db");
			        String consulta = "SELECT nombre FROM Paciente WHERE Id_veterinario = ?";
			        PreparedStatement statement = conn.prepareStatement(consulta);
			        statement.setInt(1, idVeterinario);
			        ResultSet resultado = statement.executeQuery();

			        while (resultado.next()) {
			            String nombrePaciente = resultado.getString("nombre");
			            pacientesList.add(nombrePaciente);
			        }

			        resultado.close();
			        statement.close();
			        conn.close();
			    } catch (SQLException ex) {
			        ex.printStackTrace();
			        // Manejar la excepción apropiadamente
			    }

			    return pacientesList;
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

		setTitle("Ventana Jefe");
		setBounds(200, 50, 1200, 800);		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
}

