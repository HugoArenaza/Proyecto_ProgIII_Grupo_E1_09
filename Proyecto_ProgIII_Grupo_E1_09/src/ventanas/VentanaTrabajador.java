package ventanas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import domain.Cita;
import domain.Paciente;

public class VentanaTrabajador extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Logger logger = java.util.logging.Logger.getLogger("Logger");
	protected JFrame vActual;
	protected Cita citaActual;
	
	protected JMenuBar BarraMenu;
	
	//Slots de la Barra de Menu
	protected JMenu visualizarPacientes;
	protected JMenu visualizarCalendario;
	protected JMenu visualizarMedicamentos;
	protected JMenu visualizarCitas;
	protected JMenu visualizarCuenta;
	
	//Elementos de Pacientes
	protected JMenuItem pacientes;
	
	//Elementos de Citas
	protected JMenuItem citas;
	protected JMenuItem anular;
	protected JMenuItem aniadir;
	
	//Elementos de Calendario
	protected JMenuItem calendario;
	
	//Elementos de Medicamentos
	protected JMenuItem medicamentos;
	
	//Elementos de Cuenta
	protected JMenuItem perfil;
	protected JMenuItem cerrarSesion;
	
	//Paneles
	protected JPanel pArriba;
	protected JPanel pAbajo;
	protected JPanel pPacientes;
	protected JPanel pCitas;
	protected JPanel pAniadirAnular;
	protected JPanel pCalendario;
	protected JPanel pMedicamentos;
	protected JPanel pCuenta;
	protected JPanel pDisplay;
	
	protected JButton btnSalir;
	
	//Tabla pacientes
	protected ModeloHistorialPacientes modeloPacientes;
	protected JTable tablaPacientes;
	protected JScrollPane scrollTablaPacientes;
	
	protected List<Paciente> lPacientes;
	
	//Tabla medicamentos
	protected ModeloMedicamentos modeloMedicamentos;
	protected JTable tablaMedicamentos;
	protected JScrollPane scrollTablaMedicamentos;
	
	

	
	
	
	

	
	
	
	public VentanaTrabajador() {
		
		pArriba= new JPanel();
		getContentPane().add(pArriba, BorderLayout.NORTH);
		
		pAbajo = new JPanel();
		getContentPane().add(pAbajo, BorderLayout.SOUTH);
		
		pDisplay = new JPanel();
		getContentPane().add(pDisplay,BorderLayout.CENTER);
		
		pPacientes = new JPanel();
		pCalendario = new JPanel();
		pCitas = new JPanel();
		pAniadirAnular = new JPanel();
		pCuenta = new JPanel();
		pMedicamentos = new JPanel();
		
		btnSalir = new JButton("Salir");
		pAbajo.add(btnSalir);
		
		int ancho = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getWidth();
		int alto = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight();
		
		BarraMenu = new JMenuBar();
		BarraMenu.setPreferredSize(new Dimension(ancho-400 ,44 ));
		BarraMenu.setPreferredSize(new Dimension(ancho-400 ,44 ));
		BarraMenu.setFont(new Font("Baskerville", Font.PLAIN, 4));
		
		visualizarPacientes = new JMenu("Pacientes");
		pacientes = new JMenuItem("Mis pacientes");
		
		visualizarCitas = new JMenu("Citas");
		citas = new JMenuItem("Mis citas");
		aniadir = new JMenuItem("Añadir cita");
		anular = new JMenuItem("Anular cita");
		
		visualizarCalendario = new JMenu("Agenda");
		calendario = new JMenuItem("Mi agenda");
		
		visualizarMedicamentos = new JMenu("Lista de Medicamentos");
		medicamentos = new JMenuItem();
		
		visualizarCuenta = new JMenu("Cuenta");
		perfil = new JMenuItem("Mi perfil");
		cerrarSesion = new JMenuItem("Cerrar sesion");
		
		BarraMenu.add(visualizarPacientes);
		BarraMenu.add(visualizarCitas);
		BarraMenu.add(visualizarCalendario);
		BarraMenu.add(visualizarMedicamentos);
		BarraMenu.add(visualizarCuenta);
		
		visualizarCitas.add(citas);
		visualizarCitas.add(aniadir);
		visualizarCitas.add(anular);
		
		visualizarCuenta.add(perfil);
		visualizarCuenta.add(cerrarSesion);
		
		visualizarPacientes.add(pacientes);
		
		visualizarCalendario.add(calendario);
		 
		visualizarMedicamentos.add(medicamentos);
		
		
		//JTable Pacientes
		
		
		modeloPacientes = new ModeloHistorialPacientes(lPacientes);
		tablaPacientes = new JTable(modeloPacientes);
		scrollTablaPacientes = new JScrollPane(tablaPacientes);
	
		
		//JTable Medicamentos
		modeloMedicamentos = new ModeloMedicamentos();
		tablaMedicamentos = new JTable(modeloMedicamentos);
		scrollTablaMedicamentos = new JScrollPane(tablaMedicamentos);
		
		
		
		pDisplay.add(pPacientes);
		pDisplay.add(pCitas);
		pDisplay.add(pAniadirAnular);
		pDisplay.add(pCalendario);
		pDisplay.add(pMedicamentos);
		pDisplay.add(pCuenta);
		
		
		
		pArriba.add(BarraMenu, BorderLayout.NORTH);
		pPacientes.add(scrollTablaPacientes,BorderLayout.NORTH);
		pMedicamentos.add(scrollTablaMedicamentos,BorderLayout.SOUTH);
		
		
		
		cerrarSesion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new VentanaInicio();
			}
		});
		pacientes.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				quitaPanel();
				pPacientes.setVisible(true);
				logger.info("Se ha visualizado la tabla de pacientes");
			}
		});
		citas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				quitaPanel();
				pCitas.setVisible(true);
			}
		});
		aniadir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				quitaPanel();
				pAniadirAnular.setVisible(true);
				}
		});
		calendario.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				quitaPanel();
				pCalendario.setVisible(true);
			}
		});
		medicamentos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				quitaPanel();
				pMedicamentos.setVisible(true);
			}
		});
		perfil.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				quitaPanel();
				pCuenta.setVisible(true);
				
			}
		});
		
		
		
		
		
		/*btnVerPacientes = new JButton("Visualizar los pacientes");
		
	
		btnAniadirCita = new JButton("Añadir cita");
		
		
		
		btnAniadirCita.addActionListener((e)->{
			Contenedora.aniadirCita(citaActual);
			logger.info("Se ha agregado una nueva cita");
			
		});
		
		btnAnularCita.addActionListener((e)->{
			Contenedora.eliminarCita(citaActual);
			logger.info("Se ha eliminado una cita");
		});
		btnVerPacientes.addActionListener((e)->{
			Contenedora.imprimirListaPacientes();
			logger.info("Se ha impreso la lista de pacientes");
		});*/
		btnSalir.addActionListener((e)->{
			dispose();
		});

		
		setSize(ancho, alto);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Trabajador");
	
	}
	public void quitaPanel() {
		pPacientes.setVisible(false);
		pCitas.setVisible(false);
		pCalendario.setVisible(false);
		pMedicamentos.setVisible(false);
		pCuenta.setVisible(false);
	}
}
