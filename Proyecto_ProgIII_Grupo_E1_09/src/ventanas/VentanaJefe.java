package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
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

		JButton botonClinicas = new JButton("Clinicas"); // Boton que muestra clinicas mediante un ComboBox

		btnSalir = new JButton("Salir");
		Dimension dimensionPanelCentro = new Dimension(100, 80);
		panelCentro.setMinimumSize(dimensionPanelCentro);
		Dimension tamañoBotones = new Dimension(150, 40);
		botonClinicas.setMaximumSize(tamañoBotones);
		btnProveedores.setMaximumSize(tamañoBotones);
		btnPacientes.setMaximumSize(tamañoBotones);
		btnTrabajadores.setMaximumSize(tamañoBotones);

		panelIzquierda.add(btnProveedores);
		panelIzquierda.add(btnPacientes);
		panelIzquierda.add(botonClinicas);
		panelIzquierda.add(btnTrabajadores);
		panelAbajo.add(btnSalir);

		getContentPane().add(panelIzquierda, BorderLayout.WEST);
		getContentPane().add(panelCentro, BorderLayout.CENTER);
		getContentPane().add(panelAbajo, BorderLayout.SOUTH);

		botonClinicas.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panelCentro.removeAll(); // vacio el panel para cambiar contenido que quiero mostrar

				JPanel panelComboBox = new JPanel();
				panelComboBox.setLayout(new BorderLayout());

				JComboBox<Clinica> clinicas = new JComboBox<>();
				DefaultComboBoxModel<Clinica> model = new DefaultComboBoxModel<>();

				clinicas.setModel(model);

				JButton botonAbrir = new JButton("Abrir clinca");

				botonAbrir.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						System.out.println("Prueba de boton"); // Prueba funcionalidad, este boton se usara para abrir
																// la
																// clinica seleccionada en una nueva ventana con todos
																// los datos

					}
				});

				panelComboBox.add(clinicas, BorderLayout.CENTER);
				JPanel panelBotonAbrir = new JPanel();
				panelBotonAbrir.add(botonAbrir);
				panelCentro.add(panelComboBox);
				panelCentro.revalidate();
				panelCentro.repaint();
				panelComboBox.add(panelBotonAbrir, BorderLayout.SOUTH);

			}
		});

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

				JTable tablePacientes = new JTable();
				DefaultTableModel model = (DefaultTableModel) tablePacientes.getModel();

				model.addColumn("Identificativo");
				model.addColumn("Nombre Paciente");
				model.addColumn("Nombre Dueño");
				model.addColumn("Apellidos Dueño");
				model.addColumn("MicroChip");
				model.addColumn("Enfermedad");
				model.addColumn("Veterinario");
				model.addColumn("Clinica");
				model.addColumn("Tipo Paciente");
				model.addColumn("Telefono Dueño");
				model.addColumn("Correo Dueño");

				panelCentro.add(new JScrollPane(tablePacientes));
				panelCentro.revalidate();
				panelCentro.repaint();

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

//				Connection conn = BD.initBD("clinicaFurwell.db");
//				
//				
//
//
//				Trabajador veterinario = new Trabajador(1, "Mario", "Diaz", "aijsdj", "uno", 23, new ArrayList<Paciente>(), (float) 1000.0, Especialidades.CARDIOLOGIA, "12344", 21);
//				Paciente paciente1 = new Paciente(1,"Matias",2839, "Escoliosis", veterinario.getId(), TipoPaciente.CERDO,null );
//				veterinario.anyadirPaciente(paciente1);
//				
//				Trabajador veterinario2 = new Trabajador(2, "Mario", "Apellidos", "Usuario", "Contraseña", 1, new ArrayList<Paciente>(),
//						(float) 5000.0, Especialidades.CIRUGIA, "bbbb", 12);
//				Trabajador veterinario3 = new Trabajador(45, "Antonio", "Apellidos", "Usuario", "Contraseña", 1, new ArrayList<Paciente>(),
//						(float) 5000.0, Especialidades.CIRUGIA, "ccccc", 12);
//				Trabajador veterinario4 = new Trabajador(3, "Bea", "Apellidos", "Usuario", "Contraseña", 1, new ArrayList<Paciente>(),
//						(float) 5000.0, Especialidades.CIRUGIA, "uuuu", 12);
//				Jefe jefe = new Jefe(3, "Jorge", "Apellidos", "Usuario", "Contraseña", 1, new ArrayList<Paciente>(),
//						(float) 5000.0, Especialidades.CIRUGIA, "bbbb", 12, getDefaultCloseOperation());
//				
//				ArrayList<Veterinario> veterinarios = new ArrayList<Veterinario>();
//				
//				veterinarios.add(veterinario);
//				veterinarios.add(veterinario2);
//				veterinarios.add(veterinario3);
//				veterinarios.add(veterinario4);
//				veterinarios.add(jefe);
//				Collections.sort(veterinarios);
//				veterinarios.sort(new VeterinarioComparatorPorDni());
//				
				JTable tableVeterinarios = new JTable();
				DefaultTableModel model = (DefaultTableModel) tableVeterinarios.getModel();
				
//
				model.addColumn("Id");
				model.addColumn("Nombre");
				model.addColumn("Apellidos");
				model.addColumn("Usuario");
				model.addColumn("Contraseña");
				model.addColumn("DNI");
				model.addColumn("Clinica");
				model.addColumn("Paciente");
				model.addColumn("Sueldo");
				model.addColumn("Especialidad");
				model.addColumn("Tipo");// Columna para diferenciar tipo de veterinario
//				
//				
//				for (Veterinario vet : veterinarios) {
//					model.addRow(new Object[] { vet.getId(),vet.getNombre(), vet.getApellidos(),
//						vet.getUsuario(), vet.getContraseña(), vet.getDni(),
//						vet.getClinica(), vet.getPaciente(), vet.getSueldo(),
//						vet.getespecialidad(), vet.getClass().getSimpleName()
//						});	
					
//					}
//				
				
				try {
					Connection conn = BD.initBD("clinicaFurwell.db");
				    String consulta = "SELECT * FROM Veterinario";
				    PreparedStatement statement = conn.prepareStatement(consulta);
				    ResultSet resultado = statement.executeQuery();
				    while (resultado.next()) {
				        int id = resultado.getInt("id");
				        String nombre = resultado.getString("nombre");
				        String apellidos = resultado.getString("apellidos");
				        String usuario = resultado.getString("usuario");
				        String contraseña = resultado.getString("contraseña");
				        String dni = resultado.getString("dni");
				        String clinica = resultado.getString("id_clinica");
				        String paciente = resultado.getString("pacientes");
				        Float sueldo = resultado.getFloat("sueldo");
				        String especialidad = resultado.getString("especialidad");
				        String tipo = resultado.getString("tipo_veterinario");

				        model.addRow(new Object[]{id, nombre, apellidos, usuario, contraseña, dni, clinica, paciente, sueldo, especialidad, tipo});
				    }

				    resultado.close();
				    statement.close();
				    conn.close();
				} catch (SQLException ex) {
				    ex.printStackTrace();
				    // Manejar la excepción apropiadamente
				}
								
				 TableColumn pacienteColumn = tableVeterinarios.getColumnModel().getColumn(7);
				        JComboBox<String> comboBox = new JComboBox<>(new String[]{"Gato", "Perro", "Otro"});
				        pacienteColumn.setCellEditor(new DefaultCellEditor(comboBox));

				        // Personalizar el renderer para la columna 'Paciente'
				        pacienteColumn.setCellRenderer((TableCellRenderer) new DefaultTableCellRenderer() {
				            /**
							 * 
							 */
							private static final long serialVersionUID = 1L;

							@Override
				            public void setValue(Object value) {
				                setText((value == null) ? "" : value.toString());
				            }
				        });
				JTableHeader tableHeader = tableVeterinarios.getTableHeader();
				tableHeader.setReorderingAllowed(false);  // Deshabilitar la reordenación de columnas
				tableHeader.setResizingAllowed(false);     // Deshabilitar el redimensionamiento de columnas

				
				
				panelCentro.add(tableHeader);
				
				tableVeterinarios.setPreferredScrollableViewportSize(new Dimension(1000, 10000)); // Reemplaza ancho y alto con los valores deseados

				tableVeterinarios.setEnabled(true);
				panelCentro.add(new JScrollPane(tableVeterinarios));
				panelCentro.revalidate();
				panelCentro.repaint();
				tableVeterinarios.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

			}
		});
		btnSalir.addActionListener((e) -> {
			dispose();
			logger.info("Se ha cerrado la sesion");
		});

		setTitle("Ventana Jefe");
		setBounds(200, 50, 1200, 800);		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
}

