package ventanas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;


import domain.Cita;


import domain.Dueño;
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
	
	
	private JTextField txtFechaCita;
	private JTextField txtLugarCita;
	private JTextField txtHoraCita;
	
	
	private JPanel pAbajo;
	private JPanel pMascotas;
	private JPanel pHistorial;
	private JPanel pArriba;
	private JPanel contenido;
	private JPanel pFacturas;
	private JPanel pTienda;
	private JPanel pSolCitaIzq;
	private JPanel pSolCitaDerch;
	private JPanel pSolCita;
	private JPanel pBtnSolCita;
	private JPanel pDateChooserSolCita;
	private JPanel pComboHoras;
	private JPanel pVisualizarAgenda;
	private JPanel pModificarCita;
	private JPanel pBtnModificarCita;
	private JPanel pCambiarLaCitaSeleccionada;
	private JPanel pBtnAnularCita;
	private JPanel pVisualizarMiPerfil;
	
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
	
	private JMenuItem solicitarCita;
	private JMenuItem verCalendario;
	private JMenuItem modificarCita;
	
	private JMenuItem solicitarTranslado;
	private JMenuItem verMiClinica;
	
	private DefaultTreeModel modeloArbol;
	private JTree arbol;
	private JScrollPane scrollArbol;
	
	private ModeloHistorialPacientes modeloHistorialPacientes;
	
	private JCalendar calendario;

	private JTable tablaHistorial;
	private JScrollPane scrollHistorial;
	
	
	private JComboBox<Paciente> comboMascotas;
	private List<Paciente> listaPacientes = new ArrayList<>();
	
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
	
	private static int numcita = 000;
	
	public VentanaDueño(){
		
	/*CREACION DE PANELES*/
	pAbajo = new JPanel();
	pMascotas = new JPanel(new GridLayout(2,2));
	pArriba = new JPanel();
	pHistorial = new JPanel(new BorderLayout());
	pMascotas = new JPanel();
	pFacturas = new JPanel();
	pTienda = new JPanel();
	contenido = new JPanel();
	pSolCitaIzq = new JPanel(new GridLayout(6,1));
	pSolCitaDerch = new JPanel(new GridLayout(2,1));
	pSolCita = new JPanel(new BorderLayout());
	pComboHoras = new JPanel(new GridLayout(1,1));
	pVisualizarAgenda = new JPanel();
	pModificarCita = new JPanel(new GridLayout(2,1));
	pCambiarLaCitaSeleccionada = new JPanel(new GridLayout(8,1));
	pVisualizarMiPerfil = new JPanel(new GridLayout(9,1));
	
	/*CREACION DE BOTONES*/
	btnSalir = new JButton("Salir");
	btnSolicitarCita = new JButton("Solicitar Cita");

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
    modificarCita = new JMenuItem("Modificar Cita");
    verCalendario = new JMenuItem("Visualizar Calendario");
    solicitarCita = new JMenuItem("Solicitar Cita");
    
    visualizarMiPerfil = new JMenu("Cuenta");
    perfil = new JMenuItem("Mi Perfil");
    pedido = new JMenuItem("Mis Pedidos");
    cesta = new JMenuItem("Mi Cesta");
    cerrarSesion = new JMenuItem("Cerrar sesion");
    
    visualizarClinica = new JMenu("Clinica");
    solicitarTranslado = new JMenuItem("Solicitar Translado");
    verMiClinica = new JMenuItem("Mi clinica");
    
    visualizarTienda = new JMenu("Medicamentos");
    compMedicamentos = new JMenuItem("Comprar Medicamentos");
    
    
    menuBar.add(visualizarMascotas);
    menuBar.add(visualizarFacturas);
    menuBar.add(visualizarClinica);
    menuBar.add(visualizarTienda);
    menuBar.add(visualizarHistorial);
    menuBar.add(visualizarAgenda);
    menuBar.add(visualizarMiPerfil);
   
    
  
    visualizarAgenda.add(solicitarCita);
    visualizarAgenda.add(modificarCita);
    visualizarAgenda.addSeparator();
    visualizarAgenda.add(verCalendario);
    
    visualizarMiPerfil.add(perfil);
    visualizarMiPerfil.add(cesta);
    visualizarMiPerfil.add(pedido);
    visualizarMiPerfil.addSeparator();
    visualizarMiPerfil.add(cerrarSesion);
    
    visualizarHistorial.add(hist);
    
    visualizarMascotas.add(masc);
    
    visualizarFacturas.add(fact);
    
    visualizarTienda.add(compMedicamentos);
    
    visualizarClinica.add(solicitarTranslado);
    visualizarClinica.add(verMiClinica);
    
    

	/*CREACION DE JTABLE*/
   modeloHistorialPacientes = new ModeloHistorialPacientes(listaPacientes);
   tablaHistorial = new JTable(modeloHistorialPacientes);
   scrollHistorial = new JScrollPane(tablaHistorial);
   DefaultTableModel tablaDefault = new DefaultTableModel();
   
   
    
   /*CREACION DEL JCOMBOBOX*/
   comboMascotas = new JComboBox<Paciente>();
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
	
	/*AÑADIMOS TODOS LOS COMPONENTES A EL PANEL JEFE*/   
	getContentPane().add(pAbajo, BorderLayout.SOUTH);
	getContentPane().add(pArriba, BorderLayout.NORTH);
	getContentPane().add(contenido,BorderLayout.CENTER);
	contenido.add(pMascotas);
	contenido.add(pHistorial);
	contenido.add(pFacturas);
	contenido.add(pTienda);
	contenido.add(pSolCita);
	contenido.add(pVisualizarAgenda);
	contenido.add(pModificarCita);
	contenido.add(pCambiarLaCitaSeleccionada);
	contenido.add(pVisualizarMiPerfil);
	
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
	
	
	/*AÑADIMOS A PANELES*/
	  pAbajo.add(btnSalir);
	  pArriba.add(menuBar);
	  pFacturas.add(scrollArbol, BorderLayout.WEST);
	  pHistorial.add(comboHistorial, BorderLayout.NORTH);
	  pHistorial.add(scrollHistorial, BorderLayout.SOUTH);
	  
	  pMascotas.add(comboMascotas);
	  pMascotas.add(btnAniadirPaciente);

	  pSolCita.add(pSolCitaIzq, BorderLayout.WEST);
	  pSolCita.add(pSolCitaDerch, BorderLayout.EAST);
	
	

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

			   comboHistorial.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(comboHistorial.getSelectedItem().toString().equals("Historial de compras")) {
						tablaHistorial.setModel(tablaDefault);
						tablaDefault.setRowCount(0);
						//tablaDefault
						Object [] titulos = {"NOMBRE DEL MEDICAMENTO","PRECIO" ,"FECHA DE COMPRA", "MASCOTA ASOCIADA"};
						
						tablaDefault.setColumnIdentifiers(titulos);
						
						
					}else if(comboHistorial.getSelectedItem().toString().equals("Historial de mis mascotas")) {
						modeloHistorialPacientes = new ModeloHistorialPacientes(listaPacientes);
						tablaHistorial.setModel(modeloHistorialPacientes);
						tablaHistorial.updateUI();
						
					}
					
					
				}
			});
			
		}
	});
	
	fact.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			ocultarPaneles();
			pFacturas.setVisible(true);
	
			
			
		}
	});
	compMedicamentos.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			ocultarPaneles();
			pTienda.setVisible(true);
			
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
			comboMascotas.addItem(p);
			
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
	pComboHoras.add(comboMinutos);
	
	
	pDateChooserSolCita = new JPanel();
	dateChooser = new JDateChooser();
	pDateChooserSolCita.add(dateChooser);
	
	
	pBtnSolCita = new JPanel();
	
	pBtnSolCita.add(btnSolicitarCita);
	
	pSolCitaIzq.add(lblFecha);
	pSolCitaIzq.add(pDateChooserSolCita);
	pSolCitaIzq.add(lblHora);
	pSolCitaIzq.add(pComboHoras);
	pSolCitaIzq.add(pBtnSolCita);
	pBtnAnularCita = new JPanel();
	btnanularCita = new JButton("Anular cita");
	pBtnAnularCita.add(btnanularCita);
	pSolCitaDerch.add(scrollListaCitas, BorderLayout.WEST);
	pSolCitaDerch.add(pBtnAnularCita);
	listaCitasAlmacenamiento = new ArrayList<>();
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
			}else {
				JOptionPane.showMessageDialog(null, "Primero debes seleccionar una fecha");
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
			}else {
				Cita c = modeloListaModificarCitas.getElementAt(pos);
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
			}else {
				Cita c = modeloListaCitas.getElementAt(pos);
				modeloListaCitas.removeElement(c);
				modeloListaModificarCitas.removeElement(c);
			
		}
			}
	});
	
	

	verCalendario.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			ocultarPaneles();
			pVisualizarAgenda.setVisible(true);
			
			
		}
	});
	calendario = new JCalendar();
	
	pVisualizarAgenda.add(calendario);
	
	
	comboMascotas.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String selec = comboMascotas.getSelectedItem().toString();
			System.out.println(selec);
			
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
			btnVisualizarContraseña.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
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

		
		
		
		
	}

}
