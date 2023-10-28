package ventanas;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaJefe extends JFrame {
public VentanaJefe() {
	setTitle("Ventana Jefe");
	setBounds(400, 100, 800, 600);
	setVisible(true);
	setDefaultCloseOperation(EXIT_ON_CLOSE);	

	JPanel panelArriba= new JPanel();

	JButton botonClinicas = new JButton("Clinicas");
	panelArriba.add(botonClinicas);
	
	getContentPane().add(panelArriba,BorderLayout.NORTH);
	
	
	
	
	
	





}
}
