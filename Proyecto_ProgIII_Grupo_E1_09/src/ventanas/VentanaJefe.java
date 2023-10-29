package ventanas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import domain.Clinica;
import domain.Proveedor;

public class VentanaJefe extends JFrame {
	
	private JButton btnProveedores, btnPacientes, btnTrabajadores , btnSalir;
	private JPanel  panelDerecha, panelAbajo;	
	public VentanaJefe() {
		
	JPanel panelIzquierda= new JPanel();
	panelIzquierda.setLayout(new GridLayout(0,1));
	panelDerecha = new JPanel();
	panelAbajo = new JPanel();

	btnProveedores = new JButton("Proveedores"); //Boton que mostrara un combobox de los proveedores disponibles
	btnPacientes = new JButton("Pacientes"); //Boton que mostrara un jtable con todos los pacientes
	btnTrabajadores=new JButton("Trabajadores"); //Boton que mostrara una JTable con todos los trabajadores, mas funcionalidades por agregar
	
	
	JButton botonClinicas = new JButton("Clinicas"); //Boton que muestra clinicas mediante un ComboBox
	
	btnSalir = new JButton("Salir")	;
	
	Dimension tamañoBotones= new Dimension(150,40);
	botonClinicas.setMaximumSize(tamañoBotones);
	btnProveedores.setMaximumSize(tamañoBotones);
	btnPacientes.setMaximumSize(tamañoBotones);
	btnTrabajadores.setMaximumSize(tamañoBotones);
	
	
	panelIzquierda.add(btnProveedores);
	panelIzquierda.add(btnPacientes);
	panelIzquierda.add(botonClinicas);
	panelIzquierda.add(btnTrabajadores);
	panelAbajo.add(btnSalir);
	
	getContentPane().add(panelIzquierda,BorderLayout.WEST);
	getContentPane().add(panelDerecha, BorderLayout.CENTER);
	getContentPane().add(panelAbajo,BorderLayout.SOUTH);
	
	
	botonClinicas.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			panelDerecha.removeAll(); //vacio el panel para cambiar contenido que quiero mostrar
			
			
			JPanel panelComboBox=new JPanel();
			panelComboBox.setLayout(new BorderLayout());
				
			JComboBox<Clinica> clinicas= new JComboBox<>();
			DefaultComboBoxModel<Clinica> model= new DefaultComboBoxModel<>();
			
			clinicas.setModel(model);
			
			JButton botonAbrir = new JButton("Abrir clinca");
			
			botonAbrir.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("Prueba de boton"); // Prueba funcionalidad, este boton se usara para abrir la 
															// clinica seleccionada en una nueva ventana con todos los datos
					
					
				}
			});
			
			panelComboBox.add(clinicas,BorderLayout.CENTER);
			JPanel panelBotonAbrir= new JPanel();
			panelBotonAbrir.add(botonAbrir);
			panelDerecha.add(panelComboBox);
			panelDerecha.revalidate();
			panelDerecha.repaint();
			panelComboBox.add(panelBotonAbrir, BorderLayout.SOUTH);
			
			
			
		}
	});
	
	btnProveedores.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			panelDerecha.removeAll(); //vacio el panel para cambiar contenido que quiero mostrar
			
			
			JPanel panelComboBox=new JPanel();
			panelComboBox.setLayout(new BorderLayout());
				
			JComboBox<Proveedor> proveedores= new JComboBox<>();
			DefaultComboBoxModel<Proveedor> model= new DefaultComboBoxModel<>();
			
			proveedores.setModel(model);
			
			JButton botonAbrir = new JButton("Abrir proveedor");
			
			botonAbrir.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("Prueba de boton"); // Prueba funcionalidad, este boton se usara para abrir la 
															// clinica seleccionada en una nueva ventana con todos los datos
					
					
				}
			});
			
			panelComboBox.add(proveedores,BorderLayout.CENTER);
			JPanel panelBotonAbrir= new JPanel();
			panelBotonAbrir.add(botonAbrir);
			panelDerecha.add(panelComboBox);
			panelDerecha.revalidate();
			panelDerecha.repaint();
			panelComboBox.add(panelBotonAbrir, BorderLayout.SOUTH);
			
		}
	});
	btnPacientes.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			panelDerecha.removeAll();
			
			JTable tablePacientes= new JTable();
			DefaultTableModel model= (DefaultTableModel) tablePacientes.getModel();
			
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
					
			
			
			
			
			panelDerecha.add(new JScrollPane(tablePacientes));
			panelDerecha.revalidate();
			panelDerecha.repaint();
			
			
			
		}
	});
	btnTrabajadores.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			panelDerecha.removeAll();
			
			JTable tableVeterinarios= new JTable();
			DefaultTableModel model= (DefaultTableModel) tableVeterinarios.getModel();
			
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
			
			
			
			
			
			panelDerecha.add(new JScrollPane(tableVeterinarios));
			panelDerecha.revalidate();
			panelDerecha.repaint();
			
			
			
			
			
			
		}
	});
	btnSalir.addActionListener((e)->{
		dispose();
	});
	
	
	
	
	
	
	
	
	
	
	setTitle("Ventana Jefe");
	setBounds(400, 100, 800, 600);
	setVisible(true);
	setDefaultCloseOperation(EXIT_ON_CLOSE);





}
}
