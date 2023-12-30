package ventanas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import base_de_datos.BD;
import domain.Cita;
import domain.Medicamento;
import domain.MedicamentosAnimales;
import domain.Paciente;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class VentanaTrabajador extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Logger logger = java.util.logging.Logger.getLogger("Logger");
	protected JFrame vActual;
	protected Cita citaActual;
	
	protected JMenuBar BarraMenu;
	
	private JLabel lblReloj;	
	
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
	protected JMenuItem agenda;
	protected JMenuItem Itemcalendario;
	protected JCalendar calendario;
	
	
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
	protected ModeloMedicamentosVentanaTrabajador modeloMedicamentos;
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
		
		calendario = new JCalendar();
				
		Connection con = BD.initBD("clinicaFurwell.db");
		List<Medicamento> lM = new ArrayList<>();
		BD.volcarTablaMedicamentosALista(con,lM);
		
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
		Itemcalendario = new JMenuItem("Calendario");
		
		visualizarMedicamentos = new JMenu("Lista de Medicamentos");
		medicamentos = new JMenuItem("Lista de medicamentos");
		
		
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
		
		visualizarCalendario.add(Itemcalendario);
		 
		visualizarMedicamentos.add(medicamentos);
		
		
		//JTable Pacientes
		
		
		modeloPacientes = new ModeloHistorialPacientes(lPacientes);
		tablaPacientes = new JTable(modeloPacientes);
		scrollTablaPacientes = new JScrollPane(tablaPacientes);
		
		//JTable Medicamentos
		modeloMedicamentos = new ModeloMedicamentosVentanaTrabajador(lM);
		tablaMedicamentos = new JTable(modeloMedicamentos);
		scrollTablaMedicamentos = new JScrollPane(tablaMedicamentos);
		
		pPacientes.setVisible(false);
		pMedicamentos.setVisible(false);
		pCalendario.setVisible(false);
		pDisplay.add(pPacientes);
		pDisplay.add(pCitas);
		pDisplay.add(pAniadirAnular);
		pDisplay.add(pCalendario);
		pDisplay.add(pMedicamentos);
		pDisplay.add(pCuenta);
		
		
		
		//Hilo
		lblReloj = new JLabel();
		pArriba.add(lblReloj);
		
		
		Thread hiloReloj = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true) {
					actualizarReloj();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			}
		});
		hiloReloj.start();
		
		
		
		
		pArriba.add(BarraMenu, BorderLayout.NORTH);
		pPacientes.add(scrollTablaPacientes,BorderLayout.NORTH);
		pMedicamentos.add(scrollTablaMedicamentos,BorderLayout.SOUTH);
		pCalendario.add(calendario, BorderLayout.NORTH);
		
		
		
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
		Itemcalendario.addActionListener(new ActionListener() {
			
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
	
	private void actualizarReloj() {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		String horaActual = sdf.format(new Date());
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				lblReloj.setText(horaActual);
				
			}
		});
	}
}
