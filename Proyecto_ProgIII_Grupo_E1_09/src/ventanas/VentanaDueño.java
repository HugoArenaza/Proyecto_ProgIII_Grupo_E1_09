package ventanas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class VentanaDueño extends JFrame{
	private JButton btnSalir;
	private JPanel pAbajo;
	private JPanel pMascotas;
	private JPanel pHistorial;
	private JPanel pArriba;
	private JPanel contenido;
	private JPanel pFacturas;
	
	
	private JMenuBar menuBar;
	private JMenu visualizarMascotas;
	private JMenu visualizarFacturas;
	private JMenu visualizarHistorial;
	private JMenu visualizarAgenda;
	private JMenu visualizarMiPerfil;
	private JMenu visualizarClinica;
	
	private JMenuItem perfil;
	private JMenuItem pedido;
	private JMenuItem cerrarSesion;
	private JMenuItem hist;
	private JMenuItem masc;
	private JMenuItem fact;
	
	private DefaultTreeModel modeloArbol;
	private JTree arbol;
	private JScrollPane scrollArbol;
	
	private ModeloHistorial modeloHistorial;
	private JTable tablaHistorial;
	private JScrollPane scrollHistorial;
	
	private JComboBox<String> comboMascotas;
	
	
	public VentanaDueño(){
		
	/*CREACION DE PANELES*/
	pAbajo = new JPanel();
	pMascotas = new JPanel();
	pArriba = new JPanel();
	pHistorial = new JPanel();
	pMascotas = new JPanel();
	pFacturas = new JPanel();
	contenido = new JPanel();
	

	/*CREACION DE BOTONES*/
	btnSalir = new JButton("Salir");
	

	/*CREACION DE JTREE*/
	DefaultMutableTreeNode nraiz = new DefaultMutableTreeNode("FACTURAS");
	modeloArbol = new DefaultTreeModel(nraiz);
	arbol = new JTree(modeloArbol);
	scrollArbol = new JScrollPane(arbol);
	

	/*CREACION DE JMENUBAR*/
	menuBar = new JMenuBar();
	menuBar.setPreferredSize(new Dimension(1900, 44));
	menuBar.setFont(new Font("Baskerville", Font.PLAIN, 4));
	
	visualizarMascotas = new JMenu("Mascotas");
	
	masc = new JMenuItem("Mis Mascotas");
	 
    visualizarFacturas = new JMenu("Facturas");
    
    fact = new JMenuItem("Mis facturas");
    
    visualizarHistorial = new JMenu("Historial");
    
    hist = new JMenuItem("Mi Historial");
    
    visualizarAgenda = new JMenu("Agenda");
    visualizarMiPerfil = new JMenu("Cuenta");
    visualizarClinica = new JMenu("Clinica");
  
    perfil = new JMenuItem("Mi Perfil");
    pedido = new JMenuItem("Mis Pedidos");
    cerrarSesion = new JMenuItem("Cerrar sesion");
    
    
    menuBar.add(visualizarMascotas);
    menuBar.add(visualizarFacturas);
    menuBar.add(visualizarClinica);
    menuBar.add(visualizarHistorial);
    menuBar.add(visualizarAgenda);
    menuBar.add(visualizarMiPerfil);
   
   
    visualizarMiPerfil.add(perfil);
    visualizarMiPerfil.add(pedido);
    visualizarMiPerfil.addSeparator();
    visualizarMiPerfil.add(cerrarSesion);
    
    visualizarHistorial.add(hist);
    
    visualizarMascotas.add(masc);
    
    visualizarFacturas.add(fact);
    

	/*CREACION DE JTABLE*/
   modeloHistorial = new ModeloHistorial();
   tablaHistorial = new JTable(modeloHistorial);
   scrollHistorial = new JScrollPane(tablaHistorial);
    
   /*CREACION DEL JCOMBOBOX*/
   comboMascotas = new JComboBox<String>();

	
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
		/*QUITAMOS TODOS LOS PANELES QUE NO NOS INTERESAN*/
			pHistorial.setVisible(false);
			pFacturas.setVisible(false);
		/*AÑADIMOS TODOS LOS PANELES QUE  NOS INTERESAN*/
			pMascotas.setVisible(true);
			
		}
	});
	
	
	hist.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
	/*QUITAMOS TODOS LOS PANELES QUE NO NOS INTERESAN*/
			pMascotas.setVisible(false);
			pFacturas.setVisible(false);
	/*AÑADIMOS TODOS LOS PANELES QUE  NOS INTERESAN*/
			pHistorial.setVisible(true);
			
		}
	});
	
	fact.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
	/*QUITAMOS TODOS LOS PANELES QUE NO NOS INTERESAN*/
			pMascotas.setVisible(false);
			pHistorial.setVisible(false);
	/*AÑADIMOS TODOS LOS PANELES QUE  NOS INTERESAN*/
			pFacturas.setVisible(true);
			
		}
	});
	
	
	
	int anchoPantalla = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getWidth();
	int altoPantalla = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight();
	setSize(anchoPantalla, altoPantalla);
	setExtendedState(MAXIMIZED_BOTH);
	setResizable(false);
	setVisible(true);
	
	
	
	}

}
