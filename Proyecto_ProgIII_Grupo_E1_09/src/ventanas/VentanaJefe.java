package ventanas;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class VentanaJefe extends JFrame {
	
	private JButton btnAnadirPaciente, btnAnadirProducto, btnAnadirProveedor, btnSalir;
	private JPanel  pCentro, pSur;	
	public VentanaJefe() {
		
	JPanel panelArriba= new JPanel();
	pCentro = new JPanel();
	pSur = new JPanel();

	btnAnadirPaciente = new JButton("Añadir Paciente");
	btnAnadirProducto = new JButton("Añadir Producto");
	btnAnadirProveedor = new JButton("Añadir Proveedor");
	btnSalir = new JButton("Salir")	;
	JButton botonClinicas = new JButton("Clinicas");
	pCentro.add(btnAnadirPaciente);
	pCentro.add(btnAnadirProveedor);
	pCentro.add(btnAnadirProducto);
	pSur.add(btnSalir);
	panelArriba.add(botonClinicas);
	
	
	getContentPane().add(panelArriba,BorderLayout.NORTH);
	getContentPane().add(pCentro, BorderLayout.CENTER);
	getContentPane().add(pSur,BorderLayout.SOUTH);
	
	
	
	btnSalir.addActionListener((e)->{
		dispose();
	});
	
	
	
	
	
	
	
	
	
	
	setTitle("Ventana Jefe");
	setBounds(400, 100, 800, 600);
	setVisible(true);
	setDefaultCloseOperation(EXIT_ON_CLOSE);





}
}
