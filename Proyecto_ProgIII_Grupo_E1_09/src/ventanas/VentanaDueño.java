package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import base_de_datos.BD;
import domain.Cita;
import domain.Compra;
import domain.Dueño;
import domain.Medicamento;
import domain.Paciente;
import domain.TipoPaciente;

public class VentanaDueño extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnSalir;
	private JButton btnAniadirPaciente;
	private JButton btnSolicitarCita;
	private JButton btnModificarCita;
	private JButton btnGuardarCitaModificada;
	private JButton btnanularCita;
	private JButton btnVisualizarContraseña;
	private JButton btnTramitarPedido;
	private JButton btnFinalizarPedido;
	
	private JLabel lblFecha;
	
	private JLabel lblHora;
	
	private JLabel lblFechaCita;
	private JLabel lblLugarCita;
	private JLabel lblHoraCita;
	private JLabel lblNumeroCita;
	
	private JLabel lblNombreApellidosVisualizar;

	private JLabel lblDniVisualizar;
	private JLabel lblCorreoVisualizar;
	private JLabel lblTelefonoVisualizar;
	private JLabel lblFechaNacVisualizar;
	private JLabel lblContraseñaVisualizar;
	private JLabel lblTextoMovimineto;
	
	
	private JTextField txtFechaCita;
	private JTextField txtLugarCita;
	private JTextField txtHoraCita;
	
	
	private JPanel pAbajo;
	private JPanel pMascotas;
	private JPanel pHistorial;
	private JPanel pArriba;
	private JPanel contenido;
	private JPanel pFotoPrincipal;
	private JPanel pFacturas;
	private JPanel pTienda;
	private JPanel pSolCitaIzq;
	private JPanel pSolCitaDerch;
	private JPanel pSolCita;
	private JPanel plblFecha;
	private JPanel plblHora;
	private JPanel pBtnSolCita;
	private JPanel pDateChooserSolCita;
	private JPanel pComboTiempo;
	private JPanel pComboHoras;
	private JPanel pComboMinutos;
	private JPanel pVisualizarAgenda;
	private JPanel pModificarCita;
	private JPanel pBtnModificarCita;
	private JPanel pCambiarLaCitaSeleccionada;
	private JPanel pBtnAnularCita;
	private JPanel pVisualizarMiPerfil;
	private JPanel pVisualizarMedicamentos;
	private JPanel pTextAreaMedicamento;
	private JPanel pBtnAniadirAlCarrito;
	private JPanel pMascotasArribaIzquierda;
	private JPanel pFotoMascotasAbajo;
	private JPanel pComboMascotasConBtnAniadirPaciente;
	private JPanel pMiCesta;
	private JPanel pMisPedidos;
	private JMenuBar menuBar;
	
	private JMenu visualizarMascotas;
	private JMenu visualizarFacturas;
	private JMenu visualizarHistorial;
	private JMenu visualizarAgenda;
	private JMenu visualizarMiPerfil;
	private JMenu visualizarTienda;

	private JMenuItem perfil;
	private JMenuItem pedido;
	private JMenuItem cerrarSesion;
	private JMenuItem cesta;
	
	private JMenuItem hist;
	private JMenuItem masc;
	private JMenuItem fact;

	private JMenuItem compMedicamentos;
	
	private JMenuItem solicitarCita;
	private JMenuItem modificarCita;
	
	
	private DefaultTreeModel modeloArbol;
	private JTree arbol;
	private JScrollPane scrollArbol;
	
	private ModeloHistorialPacientes modeloHistorialPacientes;
	private ModeloHistorialCompras modeloHistorialCompras;
	
	private JCalendar calendario;

	private JTable tablaHistorial;
	private JScrollPane scrollHistorial;
	
	private ModeloMedicamentosVentanaDueño modeloMedicamentos;
	private JTable tablaMedicamentos;
	private JScrollPane scrollMedicamentos;
	
	private JTable tablaCompras;
	private JScrollPane scrollCompras;
	
	private JTable tablaCompras2;
	private JScrollPane scrollCompras2;
	
	
	private JComboBox<Paciente> comboMascotas;
	private JComboBox<Paciente> comboMascotasCopia;
	private List<Paciente> listaPacientes = new ArrayList<>();
	private List<Compra> listaCompras = new ArrayList<>();
	
	private List<Compra> comprasFinalizadas = new ArrayList<>();
	
	private JComboBox<String> comboHistorial;
	
	private JComboBox<Integer> comboHoras;
	private JComboBox<Integer> comboMinutos;
	
	private List<Cita> listaCitasAlmacenamiento = new ArrayList<>();
	
	private DefaultListModel<Cita> modeloListaCitas;
	private JList<Cita> listaCitas;
	private JScrollPane scrollListaCitas;
	
	private DefaultListModel<Cita> modeloListaModificarCitas;
	private JList<Cita> listaModificarCitas;
	private JScrollPane scrollListaModificarCitas;
	
	
	
	private JDateChooser dateChooser;
	
	private Logger logger = java.util.logging.Logger.getLogger("Logger");
	
	private static int numcita = 000;
	private int fila;
	private int fila2;
	private Medicamento m;
	public VentanaDueño(){
		
	/*CREACION DE PANELES*/
	pAbajo = new JPanel();
	pMascotas = new JPanel(new BorderLayout());
	pArriba = new JPanel();
	pHistorial = new JPanel(new BorderLayout());
	pFacturas = new JPanel();
	pTienda = new JPanel(new GridLayout(2,2));
	contenido = new JPanel();
	pSolCita = new JPanel(new GridLayout(1,2));
	pSolCitaIzq = new JPanel(new GridLayout(5,1));
	pSolCitaDerch = new JPanel(new GridLayout(2,1));
	plblFecha = new JPanel();
	plblHora = new JPanel();
	pComboTiempo = new JPanel();
	pComboHoras = new JPanel();
	pComboMinutos = new JPanel();
	pVisualizarAgenda = new JPanel();
	pModificarCita = new JPanel(new GridLayout(2,1));
	pCambiarLaCitaSeleccionada = new JPanel(new GridLayout(8,1));
	pVisualizarMiPerfil = new JPanel(new GridLayout(9,1));
	pVisualizarMedicamentos = new JPanel(new GridLayout(7,2));
	pTextAreaMedicamento = new JPanel();
	pBtnAniadirAlCarrito = new JPanel(new BorderLayout());
	pMascotasArribaIzquierda = new JPanel(new GridLayout(2,1));
	pFotoMascotasAbajo = new JPanel();
	pComboMascotasConBtnAniadirPaciente = new JPanel();
	pFotoPrincipal = new JPanel();
	pMiCesta = new JPanel(new BorderLayout());
	pMisPedidos = new JPanel(new BorderLayout());
	
	/*CREACION DE BOTONES*/
	btnSalir = new JButton("Salir");
	btnSolicitarCita = new JButton("Solicitar Cita");

	/*CREACION DE JTREE*/
	DefaultMutableTreeNode nraiz = new DefaultMutableTreeNode("FACTURAS");
	modeloArbol = new DefaultTreeModel(nraiz);
	arbol = new JTree(modeloArbol);
	scrollArbol = new JScrollPane(arbol);
	
	//for (Compras c : ) {
		
	//}
	

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
    modificarCita = new JMenuItem("Modificar Cita");
    solicitarCita = new JMenuItem("Solicitar Cita");
    
    visualizarMiPerfil = new JMenu("Cuenta");
    perfil = new JMenuItem("Mi Perfil");
    pedido = new JMenuItem("Mis Pedidos");
    cesta = new JMenuItem("Mi Cesta");
    cerrarSesion = new JMenuItem("Cerrar sesion");
    
   
    
    visualizarTienda = new JMenu("Medicamentos");
    compMedicamentos = new JMenuItem("Comprar Medicamentos");
    
    
    menuBar.add(visualizarMascotas);
    menuBar.add(visualizarFacturas);
    menuBar.add(visualizarTienda);
    menuBar.add(visualizarHistorial);
    menuBar.add(visualizarAgenda);
    menuBar.add(visualizarMiPerfil);
   
    
  
    visualizarAgenda.add(solicitarCita);
    visualizarAgenda.add(modificarCita);
   
    
    visualizarMiPerfil.add(perfil);
    visualizarMiPerfil.add(cesta);
    visualizarMiPerfil.add(pedido);
    visualizarMiPerfil.addSeparator();
    visualizarMiPerfil.add(cerrarSesion);
    
    visualizarHistorial.add(hist);
    
    visualizarMascotas.add(masc);
    
    visualizarFacturas.add(fact);
    
    visualizarTienda.add(compMedicamentos);
    
  

    
    

	/*CREACION DE JTABLE*/
   modeloHistorialPacientes = new ModeloHistorialPacientes(listaPacientes);
   modeloHistorialCompras = new ModeloHistorialCompras(comprasFinalizadas);
   tablaHistorial = new JTable(modeloHistorialPacientes);
   scrollHistorial = new JScrollPane(tablaHistorial);
  
   
   List<Medicamento> listaMedicamentos = new ArrayList<>();
   modeloMedicamentos = new ModeloMedicamentosVentanaDueño(listaMedicamentos);
   tablaMedicamentos = new JTable(modeloMedicamentos);
   scrollMedicamentos = new JScrollPane(tablaMedicamentos);
   
   
   Connection conn = BD.initBD("clinicaFurwell.db");
   BD.volcarTablaMedicamentosALista(conn, listaMedicamentos);
 
  
    
   /*CREACION DEL JCOMBOBOX*/
   comboMascotas = new JComboBox<Paciente>();
   comboMascotasCopia = new JComboBox<Paciente>();
   rellenarInfo1();
   comboMascotas.updateUI();
   comboMascotasCopia.updateUI();
   listaPacientes = new ArrayList<>();
   
   
   comboHistorial = new JComboBox<String>();
   comboHistorial.addItem("Historial de mis mascotas");
   comboHistorial.addItem("Historial de compras");
   
   
   /*CREACION DEL JBUTTON PACIENTES*/
   btnAniadirPaciente = new JButton("Añadir mascota");

   /*CREACION DEL JLABEL Y JTEXTFIEL*/
   lblFecha = new JLabel("Fecha de la cita: ");
   lblHora = new JLabel("Hora de la cita: ");
   
     
   /*CREACION DEL JLIST*/
	modeloListaCitas = new DefaultListModel<>();
	listaCitas = new JList<Cita>(modeloListaCitas);
	scrollListaCitas = new JScrollPane(listaCitas);
	
	scrollListaCitas.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
	scrollListaCitas.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	Dueño dueño = VentanaInicio.getDueño();
	String nombre = dueño.getNombreDueño();
	String textoBienvenida = "¡Bienvenido "+ nombre.toUpperCase() +" !"+"  Esta es la pagina principal de nuestra clinica Furwell";
	
	/*HILO DE LABEL*/
	lblTextoMovimineto = new JLabel(textoBienvenida);
	pFotoPrincipal.add(lblTextoMovimineto);
	Runnable r = new Runnable() {
		
		@Override
		public void run() {
			
			while(true) {
				int x = lblTextoMovimineto.getBounds().x;
				for(int i=0;i<3;i++) {
					x = x + 50;
					lblTextoMovimineto.setBounds(x, lblTextoMovimineto.getY(), lblTextoMovimineto.getWidth(), lblTextoMovimineto.getHeight());
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				x = lblTextoMovimineto.getX();
				for(int i=0;i<3;i++) {
					x = x - 50;
					lblTextoMovimineto.setBounds(x, lblTextoMovimineto.getY(), lblTextoMovimineto.getWidth(), lblTextoMovimineto.getHeight());
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	};
	Thread t = new Thread(r);
	t.start();
	
	setVisible(true);

	/*AÑADIMOS TODOS LOS COMPONENTES A EL PANEL JEFE*/   
	getContentPane().add(pAbajo, BorderLayout.SOUTH);
	getContentPane().add(pArriba, BorderLayout.NORTH);
	getContentPane().add(contenido,BorderLayout.CENTER);
	contenido.add(pMascotas);
	contenido.add(pHistorial);
	contenido.add(pFacturas);
	contenido.add(pTienda, BorderLayout.CENTER);
	contenido.add(pSolCita);
	contenido.add(pVisualizarAgenda);
	contenido.add(pModificarCita);
	contenido.add(pCambiarLaCitaSeleccionada);
	contenido.add(pVisualizarMiPerfil);
	contenido.add(pVisualizarMedicamentos);
	contenido.add(pFotoPrincipal);
	contenido.add(pMiCesta);
	contenido.add(pMisPedidos);
	
	
	pMascotas.setVisible(false);
	pHistorial.setVisible(false);
	pFacturas.setVisible(false);
	pFacturas.setVisible(false);
	pTienda.setVisible(false);
	pSolCita.setVisible(false);
	pVisualizarAgenda.setVisible(false);
	pModificarCita.setVisible(false);
	pCambiarLaCitaSeleccionada.setVisible(false);
	pVisualizarMiPerfil.setVisible(false);
	pVisualizarMedicamentos.setVisible(false);
	pMiCesta.setVisible(false);
	pMisPedidos.setVisible(false);
	
	Dimension panelSize = new Dimension(anchoPantalla-400, altoPantalla-450);
	pModificarCita.setPreferredSize(panelSize);
	pFacturas.setPreferredSize(panelSize);
	
	/*AÑADIMOS A PANELES*/
	  pAbajo.add(btnSalir);
	  pArriba.add(menuBar);
	  pFacturas.add(scrollArbol, BorderLayout.WEST);
	  pHistorial.add(comboHistorial, BorderLayout.NORTH);
	  pHistorial.add(scrollHistorial, BorderLayout.SOUTH);
	  
	 

	  
	
	

	/*CREACION DE ACTIONLISTENER*/
	btnSalir.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
			logger.info("Se ha cerrado la ventana");
			
		}
	});
	cerrarSesion.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
			new VentanaInicio();
			logger.info("El usuario ha cerrado sesion");
			
		}
	});
	masc.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			ocultarPaneles();
			pMascotas.setVisible(true);
			logger.info("El usuario a visualizado sus mascotas");
			
		}
	});
	
	
	
	
	fact.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			ocultarPaneles();
			pFacturas.setVisible(true);
			logger.info("El usuario ha accedido a sus facturas");
	
			
			
		}
	});
	compMedicamentos.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			ocultarPaneles();
			pTienda.setVisible(true);
			pVisualizarMedicamentos.setVisible(true);
			logger.info("El usuario ha accedido a la compra de medicamentos");
			
			
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
					SpinnerNumberModel snm = new SpinnerNumberModel(1000, 1000, 10000, 1);
					JSpinner spinner = new JSpinner(snm);
			        
			        spinner.setFont(new Font("Arial", Font.PLAIN, 12));
			        
			       int opcionSeleccionada = JOptionPane.showOptionDialog(null, spinner, "Selecciona un valor", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);
			       int valorSeleccionado = 0;
			       if (opcionSeleccionada == JOptionPane.OK_OPTION) {
			            valorSeleccionado = (int) spinner.getValue();
			            
			        } else {
			        	JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario");
			        	logger.info("Se ha cancelado la implementacion de un nuevo paciente");
			        }
			        microchipInt = valorSeleccionado;
						b = false;
					
		        } catch (NumberFormatException e1) {
		            JOptionPane.showMessageDialog(null, "Error: Ingrese un número entero válido.");
		            logger.warning("El usuario ha introducido un numero incorrecto");
		           b = true;
		        }
				
			}
			
			
			String enfermedad = JOptionPane.showInputDialog("Escriba su enfermedad: ");
			int id_veterinario = 0;//por concretar
			TipoPaciente tipoMascota = null;
			Boolean b1 = true;
			while(b1==true) {
				
					
					JComboBox<TipoPaciente> comboPacientes = new JComboBox<>(TipoPaciente.values());
					
					int mascotaPos = JOptionPane.showOptionDialog(null, comboPacientes, "Seleccione el Tipo de Mascota", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);
					if (mascotaPos == JOptionPane.OK_OPTION) {
			            tipoMascota =  (TipoPaciente) comboPacientes.getSelectedItem();
			            
			        } else {
			        	JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario");
			        }
					
					
					b1 = false;
					
		       
				
			}
			
			
			Dueño d = new Dueño();//mas tarde coger dueño registrado
			Paciente p = new Paciente(id, NombrePaciente, microchipInt, enfermedad, id_veterinario, tipoMascota, d);
			listaPacientes.add(p);
			logger.info("Se ha añadido el paciente correctamente");
			Connection conn = BD.initBD("clinicaFurwell.db");
			BD.insertarPaciente(conn, d.getNombreDueño(), p);
			logger.info("Se ha añadido el paciente a la base de datos");
			BD.cerrarBD(conn);
			
			comboMascotas.addItem(p);
			comboMascotasCopia.addItem(p);
			
			
		}
	});
	solicitarCita.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			ocultarPaneles();
			pSolCita.setVisible(true);
			
			
			
			
			
		}
	});
	
	
	modificarCita.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			ocultarPaneles();
			pModificarCita.setVisible(true);
			
			
		}
	});
	
	
	/*CREACION DEL JLIST MODIFICARLISTA*/
	modeloListaModificarCitas = new DefaultListModel<Cita>();
	listaModificarCitas = new JList<Cita>(modeloListaModificarCitas);
	scrollListaModificarCitas = new JScrollPane(listaModificarCitas);
	pModificarCita.add(scrollListaModificarCitas);
	
	/*CREACION DEL PANEL SOLCITA*/
	comboHoras = new JComboBox<Integer>();
	comboHoras.addItem(8);
	comboHoras.addItem(9);
	comboHoras.addItem(10);
	comboHoras.addItem(11);
	comboHoras.addItem(12);
	comboHoras.addItem(13);
	comboHoras.addItem(17);
	comboHoras.addItem(18);
	comboHoras.addItem(19);
	comboHoras.addItem(20);
	
	
	comboMinutos = new JComboBox<Integer>();
	comboMinutos.addItem(10);
	comboMinutos.addItem(20);
	comboMinutos.addItem(30);
	comboMinutos.addItem(40);
	comboMinutos.addItem(50);
	
	
	pComboHoras.add(comboHoras);
	pComboMinutos.add(comboMinutos);
	pComboTiempo.add(pComboHoras);
	pComboTiempo.add(pComboMinutos);
	
	
	pDateChooserSolCita = new JPanel(new BorderLayout());
	dateChooser = new JDateChooser();
	pDateChooserSolCita.add(dateChooser, BorderLayout.NORTH);
	
	
	pBtnSolCita = new JPanel();
	 
	pSolCita.setPreferredSize(panelSize);
	
	pBtnSolCita.add(btnSolicitarCita);
	
	plblHora.add(lblHora);
	plblFecha.add(lblFecha);
	pSolCitaIzq.add(plblFecha);
	pSolCitaIzq.add(pDateChooserSolCita);
	pSolCitaIzq.add(plblHora);
	pSolCitaIzq.add(pComboTiempo);
	pSolCitaIzq.add(pBtnSolCita);
	pBtnAnularCita = new JPanel();
	btnanularCita = new JButton("Anular cita");
	pBtnAnularCita.add(btnanularCita);
	pSolCitaDerch.add(scrollListaCitas, BorderLayout.WEST);
	pSolCitaDerch.add(pBtnAnularCita);
	listaCitasAlmacenamiento = new ArrayList<>();
	pSolCita.add(pSolCitaIzq);
	pSolCita.add(pSolCitaDerch);
	btnSolicitarCita.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Object [] lista = {"Clinica1", "Clinica2","Clinica3", "Clinica4" } ;
			
			Date diaElegida = dateChooser.getDate();
			if(diaElegida != null) {
				//int pos = (int) Math.random();
				int pos = (int) (Math.floor(Math.random()*(lista.length)));
				String lugar = (String) lista[pos];
				numcita++;
				int hora = (int) comboHoras.getSelectedItem();
				int minutos = (int) comboMinutos.getSelectedItem();
				String horaCita = hora + " : " + minutos; 			
				Cita c = new Cita(diaElegida , lugar, horaCita, numcita); 					
				JOptionPane.showMessageDialog(null, "Se le esta asignando una cita, si desea cambiarla \n la podra modificar en el apartado de Modificar Cita \n Gracias ", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
				modeloListaCitas.addElement(c);
				listaCitasAlmacenamiento.add(c);
				modeloListaModificarCitas.addElement(c);
				logger.info("Se ha solicitado la cita correctamete");
			}else {
				JOptionPane.showMessageDialog(null, "Primero debes seleccionar una fecha");
				logger.warning("Fallo en la solicitud de la cita por falta de fecha");
			}
		}
	});
	
	
	/*CREACION DEL PANEL MODIFICARCITA*/
	
	pBtnModificarCita = new JPanel();
	btnModificarCita = new JButton("Modificar cita");
	pBtnModificarCita.add(btnModificarCita);
	pModificarCita.add(pBtnModificarCita);
	btnModificarCita.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			pCambiarLaCitaSeleccionada.removeAll();
			int pos = listaModificarCitas.getSelectedIndex();
			if(pos == -1) {
				JOptionPane.showMessageDialog(null, "Primero debes seleccionar una cita!");
				logger.warning("El paciente no ha seleccionado la cita por modificar");
			}else {
				
				Cita c = modeloListaModificarCitas.getElementAt(pos);
				logger.info("Se ha seleccionado la cita "+ c+ " paar modificar");
				ocultarPaneles();
				lblFechaCita = new JLabel("Cambie la fecha: ");
				DateFormat sdfDia = new SimpleDateFormat("dd-MM-YYYY");
				txtFechaCita = new JTextField(""+sdfDia.format(c.getFecha_cita()));
				lblLugarCita = new JLabel("Cambie el Lugar: ");
				txtLugarCita = new JTextField(c.getLugar());
				lblHoraCita = new JLabel("Cambie la Hora: ");
				txtHoraCita = new JTextField(c.getHora());
				lblNumeroCita = new JLabel("El numero de su cita es: "+c.getNum_cita());
				pCambiarLaCitaSeleccionada.add(lblFechaCita);
				pCambiarLaCitaSeleccionada.add(txtFechaCita);
				pCambiarLaCitaSeleccionada.add(lblLugarCita);
				pCambiarLaCitaSeleccionada.add(txtLugarCita);
				pCambiarLaCitaSeleccionada.add(lblHoraCita);
				pCambiarLaCitaSeleccionada.add(txtHoraCita);
				pCambiarLaCitaSeleccionada.add(lblNumeroCita);
				btnGuardarCitaModificada = new JButton("Guardar Modificacion");
				pCambiarLaCitaSeleccionada.add(btnGuardarCitaModificada);
				pCambiarLaCitaSeleccionada.setVisible(true);
				btnGuardarCitaModificada.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						String diaCambiadoStr = txtFechaCita.getText();
						Date diaCambiadoDate;
						try{
							diaCambiadoDate = sdfDia.parse(diaCambiadoStr);
						}catch(ParseException e1){
							diaCambiadoDate = new Date();
						}
						String lugarCambiado = txtLugarCita.getText();
						String horaCambiada = txtHoraCita.getText();
						int numeroDeSiempre = c.getNum_cita();
						Cita citaCambiada = new Cita(diaCambiadoDate, lugarCambiado, horaCambiada, numeroDeSiempre);
						logger.info("La cita se ha modificado correctamente a  "+citaCambiada);
						modeloListaModificarCitas.removeElementAt(pos);
						modeloListaModificarCitas.addElement(citaCambiada);
						modeloListaCitas.removeElement(c);
						modeloListaCitas.addElement(citaCambiada);
						ocultarPaneles();
						pModificarCita.setVisible(true);
						
					}
				});
				
				
				
				
				
				
			
			}
			
		}
	});
	
	btnanularCita.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			int pos = listaCitas.getSelectedIndex();
			if(pos == -1) {
				JOptionPane.showMessageDialog(null, "Primero debes seleccionar una cita!");
				logger.warning("El paciente no ha seleccionado la cita por modificar");
				
			}else {
				Cita c = modeloListaCitas.getElementAt(pos);
				modeloListaCitas.removeElement(c);
				modeloListaModificarCitas.removeElement(c);
				logger.info("El paciente ha anulado una cita correctamnte");
			
		}
			}
	});
	
	

	
	calendario = new JCalendar();
	
	pVisualizarAgenda.add(calendario);
	
	
	comboMascotas.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			@SuppressWarnings("unused")
			String selec = comboMascotas.getSelectedItem().toString();
			
			
		}
	});
	
	
	perfil.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			ocultarPaneles();
			pVisualizarMiPerfil.setVisible(true);
			pVisualizarMiPerfil.removeAll();
			Dueño dueño = VentanaInicio.getDueño();
			String nombre = dueño.getNombreDueño();
			String apellido = dueño.getApellidos();
			String correo = dueño.getCorreo();
			String dni = dueño.getDni();
			String fechaNacimiento = dueño.getfNac();
			int telefono = dueño.getNumeroTlf();
			String contraseña = dueño.getContraseña();
			Font f1 = new Font("Agency FB", Font.BOLD, 40);
			Font f2 = new Font("Tahoma", Font.CENTER_BASELINE, 20);
			lblNombreApellidosVisualizar = new JLabel(nombre.toUpperCase()+", " +apellido);
			lblContraseñaVisualizar = new JLabel("********");
			lblCorreoVisualizar = new JLabel(correo);
			lblDniVisualizar = new JLabel(dni);
			lblFechaNacVisualizar = new JLabel(fechaNacimiento);
			
			lblNombreApellidosVisualizar.setFont(f1);
			lblContraseñaVisualizar.setFont(f2);
			lblCorreoVisualizar.setFont(f2);
			lblDniVisualizar.setFont(f2);
			lblFechaNacVisualizar.setFont(f2);
			
			
			lblTelefonoVisualizar = new JLabel(""+telefono);
			btnVisualizarContraseña = new JButton("Visualizar Contraseña");
			logger.info("El paciente ha visualizado su perfil");
			
			btnVisualizarContraseña.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					logger.info("El paciente ha visualizado su contraseña");
					lblContraseñaVisualizar.setText(contraseña);
					
				}
			});
			pVisualizarMiPerfil.add(lblNombreApellidosVisualizar);
			pVisualizarMiPerfil.add(lblDniVisualizar);
			pVisualizarMiPerfil.add(lblCorreoVisualizar);
			pVisualizarMiPerfil.add(lblFechaNacVisualizar);
			pVisualizarMiPerfil.add(lblTelefonoVisualizar);
			pVisualizarMiPerfil.add(lblContraseñaVisualizar);
			pVisualizarMiPerfil.add(btnVisualizarContraseña);
			
		}
	});
	
	
	
	
	pTienda.setPreferredSize(panelSize);
	
	
	
	
	
	pTienda.add(scrollMedicamentos);
	pTienda.add(pVisualizarMedicamentos);
	//pTienda.add(pVisualizarCarrito);
	
	JButton btnAniadirCarrito = new JButton("Añadir al carrito");
	JLabel labelVacio1 = new JLabel("");
	JLabel labelVacio2 = new JLabel("");
	JLabel labelVacio3 = new JLabel("");
	JLabel labelVacio4 = new JLabel("");
	JLabel labelVacio5 = new JLabel("");
	
	
	JLabel labelTituloNombre = new JLabel("Nombre del medicamento: ");
	JLabel labelTituloId = new JLabel("ID del medicamento: ");
	JLabel labelTituloPrecio = new JLabel("Precio del medicamento: ");
	JLabel labelNombre = new JLabel("");
	JLabel labelId = new JLabel("");
	JLabel labelPrecio = new JLabel("");
	
	JTextArea textoArea = new JTextArea();
	
	
	
	Font f1 = new Font("Impact", Font.BOLD, 25);
	Font f2 = new Font("Courier New", Font.CENTER_BASELINE, 18);
	labelTituloNombre.setFont(f1);
	labelTituloId.setFont(f1);
	labelTituloPrecio.setFont(f1);
	labelNombre.setFont(f2);
	labelId.setFont(f2);
	labelPrecio.setFont(f2);
	pVisualizarMedicamentos.add(labelTituloNombre);
	pTextAreaMedicamento.add(textoArea);
	pVisualizarMedicamentos.add(labelVacio3);
	pVisualizarMedicamentos.add(labelNombre);
	pVisualizarMedicamentos.add(labelVacio2);
	pVisualizarMedicamentos.add(labelTituloId);
	pVisualizarMedicamentos.add(pTextAreaMedicamento);
	pVisualizarMedicamentos.add(labelId);
	pVisualizarMedicamentos.add(labelVacio4);
	pVisualizarMedicamentos.add(labelTituloPrecio);
	pVisualizarMedicamentos.add(labelVacio5);
	pVisualizarMedicamentos.add(labelPrecio);
	pVisualizarMedicamentos.add(labelVacio1);
	pBtnAniadirAlCarrito.add(btnAniadirCarrito, BorderLayout.WEST);
	pVisualizarMedicamentos.add(pBtnAniadirAlCarrito);
	rellenarInfo2();
	listaCompras = new ArrayList<>();
	btnAniadirCarrito.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String textoActual = textoArea.getText();
			String nombreMedicamento = (String) tablaMedicamentos.getModel().getValueAt(fila, 0);
			int idMedicamento = (int) tablaMedicamentos.getModel().getValueAt(fila, 1);
			Double precioMedicamento = (Double) tablaMedicamentos.getModel().getValueAt(fila, 2);
			Date fechaDeCompraMedicamento = new Date();
			Paciente paciente = new Paciente();
			System.out.println("Botón añadir");
			int pos = JOptionPane.showOptionDialog(null, comboMascotasCopia, "Seleccione el Tipo de Mascota", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);
			if (pos == JOptionPane.OK_OPTION) {
	            paciente = (Paciente) comboMascotasCopia.getSelectedItem();
	            
	        } else {
	        	JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario");
	        	logger.info("El paciente ha cancelado la operacion de añadir al carrito");
	        }
			
			Connection con = BD.initBD("clinicaFurwell.db");
			Compra c = new Compra(nombreMedicamento, precioMedicamento, idMedicamento, fechaDeCompraMedicamento, paciente);
			BD.insertarCompra(conn, c);
			logger.info("Se ha actualizado la base de datos con la nueva compra realizada por el usuario");
			BD.cerrarBD(con);
			listaCompras.add(c);
			modeloHistorialCompras = new ModeloHistorialCompras(comprasFinalizadas);
		
			
			textoArea.setText(textoActual + "Se ha añadido al carrito correctamente (" +m.getNombreMedicamento()+ ") \nPara consultar tu carrito y finalizar la compra ve a 'Cuenta' y 'Mi cesta'\n ");	
			logger.info("El paciente ha añadido la compra a su carrito correctamente");
			
			
			
			
		}
	});

	tablaMedicamentos.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			Point p = e.getPoint();
			fila = tablaMedicamentos.rowAtPoint(p);
			String nombre = (String) tablaMedicamentos.getModel().getValueAt(fila, 0);
			Connection con = BD.initBD("clinicaFurwell.db");
			m = BD.buscarMedicamento(con, nombre);
			BD.cerrarBD(con);
			if (m != null) {
				labelNombre.setText(m.getNombreMedicamento());
				labelId.setText(""+m.getId());
				labelPrecio.setText(""+m.getPrecioMedicamento()+ "€");
			}
							
			
		}
	});
	
	
	hist.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			ocultarPaneles();
			pHistorial.setVisible(true);
			
			pHistorial.setPreferredSize(panelSize);

			   comboHistorial.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					if(comboHistorial.getSelectedItem().toString().equals("Historial de compras")) {
						tablaHistorial.setModel(modeloHistorialCompras);
						tablaHistorial.updateUI();
						logger.info("Se ha visualizado el historial de compras");
						
						
					}else if(comboHistorial.getSelectedItem().toString().equals("Historial de mis mascotas")) {
						tablaHistorial.setModel(modeloHistorialPacientes);
						tablaHistorial.updateUI();
						hist.updateUI();
						logger.info("Se ha visualizado el historial de mascotas");
						
					}
					
					
				}
			});
			
		}
	});
	
	
	
	Dimension panelSize2 = new Dimension(anchoPantalla-400, altoPantalla-350);
	pMiCesta.setPreferredSize(panelSize);
	pMisPedidos.setPreferredSize(panelSize);
	
	tablaCompras = new JTable();
	@SuppressWarnings("unused")
	List<Compra> lc = new ArrayList<>(BD.cogerCompra(conn));
	scrollCompras = new JScrollPane(tablaCompras);
	
	tablaCompras2 = new JTable();
	scrollCompras2 = new JScrollPane(tablaCompras2);
	
	cesta.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			ocultarPaneles();
			pMiCesta.setVisible(true);
			tablaCompras.setModel(modeloHistorialCompras = new ModeloHistorialCompras(listaCompras));
			
			
			
			
		}
	});
	
	tablaCompras.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			Point p = e.getPoint();
			fila2 = tablaCompras.rowAtPoint(p);
			}
		});
	                   
	btnTramitarPedido = new JButton("Tramitar Pedido");
	btnTramitarPedido.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			
			String nombreMedicamento = (String) tablaCompras.getModel().getValueAt(fila2, 0);
			Double precio = (Double) tablaCompras.getModel().getValueAt(fila2, 2);
			int id = (int) tablaCompras.getModel().getValueAt(fila2, 1);
			Date fechaCompra = (Date) tablaCompras.getModel().getValueAt(fila2, 3);
			Paciente paciente = (Paciente) tablaCompras.getModel().getValueAt(fila2, 4);
			System.out.println(nombreMedicamento+"\t"+precio+"\t"+id+"\t"+fechaCompra+"\t"+paciente);
			Compra c = new Compra(nombreMedicamento, precio, id, fechaCompra, paciente);
			
			listaCompras.remove(c);
			
			tablaCompras.setModel(new ModeloHistorialCompras(listaCompras));
			comprasFinalizadas.add(c);
			
		
			
			logger.info("Se ha tramitado el pedido correctamente");
			
			
			
		}
	});
	btnFinalizarPedido = new JButton("Finalizar Pedido");
	btnFinalizarPedido.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showOptionDialog(null, "¿Estas seguro que quieres funalizar la compra \n con el valor de "+" ?", "Selecciona un valor", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);
			logger.info("Se ha finaliza la compra");
		}
	});
	
	pMiCesta.add(scrollCompras, BorderLayout.CENTER);
	pMiCesta.add(btnTramitarPedido, BorderLayout.SOUTH);
	pMisPedidos.add(scrollCompras2, BorderLayout.CENTER);
	pMisPedidos.add(btnFinalizarPedido, BorderLayout.SOUTH);
	

	
	
	pedido.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			ocultarPaneles();
			pMisPedidos.setVisible(true);
			tablaCompras.setModel(modeloHistorialCompras = new ModeloHistorialCompras(comprasFinalizadas));
			
			
			
		}
	});
	
	
	JLabel lblMascotas = new JLabel("MIS MASCOTAS: ");
	JLabel lblInfo = new JLabel("Aqui podras consultar todas tus mascotas.");
	ImageIcon fotoAnimales = new ImageIcon("src/imagenes/dedicate.png");
	JLabel fotoMascotas = new JLabel(fotoAnimales);
	
	ImageIcon fotoPrincipal = new ImageIcon("src/imagenes/safe.png");
	JLabel fotoPrincipal2 = new JLabel(fotoPrincipal);
	pFotoPrincipal.setPreferredSize(panelSize2);
	pFotoPrincipal.add(fotoPrincipal2);
	
	pFotoMascotasAbajo.add(fotoMascotas);
	lblMascotas.setFont(f1);
	lblInfo.setFont(f2);

	pMascotas.setPreferredSize(panelSize2);
	pMascotas.add(pMascotasArribaIzquierda, BorderLayout.NORTH);
	pMascotasArribaIzquierda.add(lblMascotas);
	pMascotasArribaIzquierda.add(lblInfo);
	pComboMascotasConBtnAniadirPaciente.add(comboMascotas);
	pComboMascotasConBtnAniadirPaciente.add(btnAniadirPaciente);
	pMascotas.add(pComboMascotasConBtnAniadirPaciente, BorderLayout.SOUTH);
	pMascotas.add(pFotoMascotasAbajo, BorderLayout.CENTER);
	
	setSize(anchoPantalla, altoPantalla);
	setExtendedState(MAXIMIZED_BOTH);
	setResizable(false);
	setVisible(true);
	
	
	
	}
	public void ocultarPaneles() {
		pMascotas.setVisible(false);
		pHistorial.setVisible(false);
		pFacturas.setVisible(false);
		pTienda.setVisible(false);
		pSolCita.setVisible(false);
		pVisualizarAgenda.setVisible(false);
		pModificarCita.setVisible(false);
		pCambiarLaCitaSeleccionada.setVisible(false);
		pVisualizarMiPerfil.setVisible(false);
		pVisualizarMedicamentos.setVisible(false);
		pFotoPrincipal.setVisible(false);
		pMiCesta.setVisible(false);
		pMisPedidos.setVisible(false);

		
		
		
		
	}
	public static void aniadirBordeAlJPanel(String titulo, JPanel panel) {
		LineBorder borde = new LineBorder(Color.BLACK, 7);
		TitledBorder bordeDelTitulo = new TitledBorder(borde, titulo);
		
		bordeDelTitulo.setTitleJustification(TitledBorder.CENTER);
		bordeDelTitulo.setTitleFont(new Font("verdana", Font.BOLD, 20));
		
		panel.setBorder(bordeDelTitulo);
	}
	
	public void rellenarInfo1() {
		/*CREACION DE DUEÑOS*/
		Dueño d = new Dueño("Pablo", "Romero Baroja", "78324454H", null, "12-06-2004", 656456456, "p.romero@opendeusto.es", "pablo");
		
		/*CREACION DE PACIENTES*/
		Paciente p1 = new Paciente(999, "Rocky", 1050, "Parvovirosis (Parvovirus Canino)", 1, TipoPaciente.PERRO, d);
		Paciente p2 = new Paciente(998, "Bella", 1051, "Moquillo Canino (Distemper)", 2, TipoPaciente.PERRO, d);
		Paciente p3 = new Paciente(997, "Max", 1052, "Dermatitis alérgica", 3, TipoPaciente.PERRO, d);
		Paciente p4 = new Paciente(996, "Luna", 1050, "Parásitos internos y externos (ácaros, pulgas)", 4, TipoPaciente.CERDO, d);
		Paciente p5 = new Paciente(995, "Simba", 1051, "Tumores", 5, TipoPaciente.LEÓN, d);
		Paciente p6 = new Paciente(994, "Gizmo", 1052, "Enfermedades dentales (maloclusión, abscesos)", 6, TipoPaciente.BURRO, d);
		
		comboMascotas.addItem(p1);
		comboMascotas.addItem(p2);
		comboMascotas.addItem(p3);
		comboMascotas.addItem(p4);
		comboMascotas.addItem(p5);
		comboMascotas.addItem(p6);
		
		comboMascotasCopia.addItem(p1);
		comboMascotasCopia.addItem(p2);
		comboMascotasCopia.addItem(p3);
		comboMascotasCopia.addItem(p4);
		comboMascotasCopia.addItem(p5);
		comboMascotasCopia.addItem(p6);
		
		
		listaPacientes.add(p1);
		listaPacientes.add(p2);
		listaPacientes.add(p3);
		listaPacientes.add(p4);
		listaPacientes.add(p5);
		listaPacientes.add(p6);
		
		
	}
	public void rellenarInfo2() {
		/*CREACION DE DUEÑOS*/
		Dueño d = new Dueño("Pablo", "Romero Baroja", "78324454H", null, "12-06-2004", 656456456, "p.romero@opendeusto.es", "pablo");
		
		/*CREACION DE PACIENTES*/
		Paciente p1 = new Paciente(999, "Rocky", 1050, "Parvovirosis (Parvovirus Canino)", 1, TipoPaciente.PERRO, d);
		Paciente p2 = new Paciente(998, "Bella", 1051, "Moquillo Canino (Distemper)", 2, TipoPaciente.PERRO, d);
		Paciente p3 = new Paciente(997, "Max", 1052, "Dermatitis alérgica", 3, TipoPaciente.PERRO, d);
		Paciente p4 = new Paciente(996, "Luna", 1050, "Parásitos internos y externos (ácaros, pulgas)", 4, TipoPaciente.CERDO, d);
		Paciente p5 = new Paciente(995, "Simba", 1051, "Tumores", 5, TipoPaciente.LEÓN, d);
		Paciente p6 = new Paciente(994, "Gizmo", 1052, "Enfermedades dentales (maloclusión, abscesos)", 6, TipoPaciente.BURRO, d);
		
		/*CREACION DE COMPRAS*/
		Compra c1 = new Compra("CLINDAMICINA", 10.5, 1051, new Date(), p1);
		Compra c2 = new Compra("PREDNISOLONA", 65.75, 1052, new Date(), p5);
		Compra c3 = new Compra("FAMCICLOVIR", 43.3, 1053, new Date(), p2);
		Compra c4 = new Compra("TRAMADOL", 65.45, 1054, new Date(), p4);
		Compra c5 = new Compra("METHIMAZOLE", 43.45, 1055, new Date(), p3);
		Compra c6 = new Compra("MILBEMICINA OXIMA", 23.5, 1056, new Date(), p6);
		
		
		
		
		listaCompras.add(c1);
		listaCompras.add(c2);
		listaCompras.add(c3);
		listaCompras.add(c4);
		listaCompras.add(c5);
		listaCompras.add(c6);
		
		
	}

}

