package ventanas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import domain.Clinica;
import domain.Contenedora;
import domain.Dueño;
import domain.Paciente;
import domain.TipoPaciente;

public class VentanaDueño extends JFrame{
	private JButton btnSalir;
	private JButton btnAniadirPaciente;
	

	
	private JPanel pAbajo;
	private JPanel pMascotas;
	private JPanel pHistorial;
	private JPanel pArriba;
	private JPanel contenido;
	private JPanel pFacturas;
	private JPanel pTienda;
	
	private JMenuBar menuBar;
	
	private JMenu visualizarMascotas;
	private JMenu visualizarFacturas;
	private JMenu visualizarHistorial;
	private JMenu visualizarAgenda;
	private JMenu visualizarMiPerfil;
	private JMenu visualizarClinica;
	private JMenu visualizarTienda;

	private JMenuItem perfil;
	private JMenuItem pedido;
	private JMenuItem cerrarSesion;
	private JMenuItem cesta;
	
	private JMenuItem hist;
	private JMenuItem masc;
	private JMenuItem fact;

	private JMenuItem compMedicamentos;
	
	private DefaultTreeModel modeloArbol;
	private JTree arbol;
	private JScrollPane scrollArbol;
	
	private ModeloHistorial modeloHistorial;
	private JTable tablaHistorial;
	private JScrollPane scrollHistorial;
	
	private JComboBox<Paciente> comboMascotas;
	private List<Paciente> listaPacientes;
	
	private Contenedora c;
	
	public VentanaDueño(){
		
	/*CREACION DE PANELES*/
	pAbajo = new JPanel();
	pMascotas = new JPanel(new GridLayout(2,2));
	pArriba = new JPanel();
	pHistorial = new JPanel();
	pMascotas = new JPanel();
	pFacturas = new JPanel();
	pTienda = new JPanel();
	contenido = new JPanel();
	

	/*CREACION DE BOTONES*/
	btnSalir = new JButton("Salir");
	

	/*CREACION DE JTREE*/
	DefaultMutableTreeNode nraiz = new DefaultMutableTreeNode("FACTURAS");
	modeloArbol = new DefaultTreeModel(nraiz);
	arbol = new JTree(modeloArbol);
	scrollArbol = new JScrollPane(arbol);
	

	/*CREACION DE JMENUBAR*/
	int anchoPantalla = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getWidth();
	int altoPantalla = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight();
	
	menuBar = new JMenuBar();
	menuBar.setPreferredSize(new Dimension(anchoPantalla-400, 44));
	menuBar.setFont(new Font("Baskerville", Font.PLAIN, 4));
	
	visualizarMascotas = new JMenu("Mascotas");
	masc = new JMenuItem("Mis Mascotas");
	 
    visualizarFacturas = new JMenu("Facturas");
    fact = new JMenuItem("Mis facturas");
    
    visualizarHistorial = new JMenu("Historial");
    hist = new JMenuItem("Mi Historial");
    
    visualizarAgenda = new JMenu("Agenda");
    
    visualizarMiPerfil = new JMenu("Cuenta");
    perfil = new JMenuItem("Mi Perfil");
    pedido = new JMenuItem("Mis Pedidos");
    cesta = new JMenuItem("Mi Cesta");
    cerrarSesion = new JMenuItem("Cerrar sesion");
    
    visualizarClinica = new JMenu("Clinica");
    
    visualizarTienda = new JMenu("Medicamentos");
    compMedicamentos = new JMenuItem("Comprar Medicamentos");
    
    
    menuBar.add(visualizarMascotas);
    menuBar.add(visualizarFacturas);
    menuBar.add(visualizarClinica);
    menuBar.add(visualizarTienda);
    menuBar.add(visualizarHistorial);
    menuBar.add(visualizarAgenda);
    menuBar.add(visualizarMiPerfil);
   
   
    visualizarMiPerfil.add(perfil);
    visualizarMiPerfil.add(cesta);
    visualizarMiPerfil.add(pedido);
    visualizarMiPerfil.addSeparator();
    visualizarMiPerfil.add(cerrarSesion);
    
    visualizarHistorial.add(hist);
    
    visualizarMascotas.add(masc);
    
    visualizarFacturas.add(fact);
    
    visualizarClinica.add(compMedicamentos);
    
    

	/*CREACION DE JTABLE*/
   modeloHistorial = new ModeloHistorial();
   tablaHistorial = new JTable(modeloHistorial);
   scrollHistorial = new JScrollPane(tablaHistorial);
    
   /*CREACION DEL JCOMBOBOX*/
   comboMascotas = new JComboBox<Paciente>();
   listaPacientes = new ArrayList<>();
   
   /*CREACION DEL JBUTTON PACIENTES*/
   btnAniadirPaciente = new JButton("Añadir mascota");

   /*CREACION DEL JLABEL*/
   
   
   
	getContentPane().add(pAbajo, BorderLayout.SOUTH);
	getContentPane().add(pArriba, BorderLayout.NORTH);
	getContentPane().add(contenido,BorderLayout.CENTER);
	contenido.add(pMascotas);
	contenido.add(pHistorial);
	contenido.add(pFacturas);
	
	pMascotas.setVisible(false);
	pHistorial.setVisible(false);
	pFacturas.setVisible(false);
	
	/*AÑADIMOS A PANELES*/
	  pAbajo.add(btnSalir);
	  pArriba.add(menuBar);
	  pFacturas.add(scrollArbol, BorderLayout.WEST);
	  pHistorial.add(scrollHistorial);
	  
	  pMascotas.add(comboMascotas);
	  pMascotas.add(btnAniadirPaciente);

	
	
	

	/*CREACION DE ACTIONLISTENER*/
	btnSalir.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
			
		}
	});
	cerrarSesion.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
			new VentanaInicio();
			
		}
	});
	masc.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			ocultarPaneles();
			pMascotas.setVisible(true);
			
		}
	});
	
	
	hist.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			ocultarPaneles();
			pHistorial.setVisible(true);
			
		}
	});
	
	fact.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			ocultarPaneles();
			pFacturas.setVisible(true);
	
			
			
		}
	});
	btnAniadirPaciente.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			int id = 0;
			id++;
			String NombrePaciente = JOptionPane.showInputDialog("Escriba su nombre: ");
			int microchipInt = 0;
			Boolean b = true;
			while(b==true) {
				try {
					
						String microchip = JOptionPane.showInputDialog("Escriba sus microchip (numero): ");
						microchipInt = Integer.parseInt(microchip);
						b = false;
					
		        } catch (NumberFormatException e1) {
		            JOptionPane.showMessageDialog(null, "Error: Ingrese un número entero válido.");
		           b = true;
		        }
				
			}
			
			
			String enfermedad = JOptionPane.showInputDialog("Escriba su enfermedad: ");
			int id_veterinario = 0;//por concretar
			TipoPaciente tipoMascota = null;
			Boolean b1 = true;
			while(b1==true) {
				try {
					
					String mascota = JOptionPane.showInputDialog("Escriba el tipo de mascota: ").toUpperCase();
					tipoMascota = TipoPaciente.valueOf(mascota); 
					b1 = false;
					
		        } catch (Exception e2) {
		            JOptionPane.showMessageDialog(null, "Error: Ingrese un tipo de mascota valido.");
		           b1 = true;
		        }
				
			}
			
			
			Dueño d = new Dueño();//mas tarde coger dueño registrado
			Paciente p = new Paciente(id, NombrePaciente, microchipInt, enfermedad, id_veterinario, tipoMascota, d);
			listaPacientes.add(p);
			for(Paciente pAlCombo: listaPacientes) {
				comboMascotas.addItem(pAlCombo);
				
			}
			
		}
	});
	comboMascotas.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String selec = comboMascotas.getSelectedItem().toString();
			System.out.println(selec);
			
		}
	});
	
	
	
	
	setSize(anchoPantalla, altoPantalla);
	setExtendedState(MAXIMIZED_BOTH);
	setResizable(false);
	setVisible(true);
	
	
	
	}
	public void ocultarPaneles() {
		pMascotas.setVisible(false);
		pHistorial.setVisible(false);
		pFacturas.setVisible(false);
		
		
	}

}
