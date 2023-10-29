package ventanas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentanaEleccion extends JFrame{
	
	private JButton jefe, mini_jefe, trabajador, dueño, cancelar;
	private JLabel info;
	private JPanel panel, pArriba, panelBotones, pAbajo;
	
	public VentanaEleccion() {
		
		panel = new JPanel();
		pArriba = new JPanel();
		pAbajo = new JPanel();
		panelBotones = new JPanel();
		cancelar = new JButton("Cancelar");
		info = new JLabel("¿Como te quieres registrar?");
		
		ImageIcon jefeI = new ImageIcon("src/imagenes/jefe.jpg");
		ImageIcon mini_jefeI = new ImageIcon("src/imagenes/mini_jefe.jpg");
		ImageIcon trbajadorI = new ImageIcon("src/imagenes/veterinario.jpg");
		ImageIcon dueñoI = new ImageIcon("src/imagenes/dueño.jpg");
		
		
		Image imagenEscaladaJefe = jefeI.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon jefeEscalado = new ImageIcon(imagenEscaladaJefe);
        Image imagenEscaladaMiniJefe = mini_jefeI.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon minijefeEscalado = new ImageIcon(imagenEscaladaMiniJefe);
        Image imagenEscaladaTrabajador = trbajadorI.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon TrabajadorEscalado = new ImageIcon(imagenEscaladaTrabajador);
        Image imagenEscaladaDueño = dueñoI.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon TrabajadorDueño = new ImageIcon(imagenEscaladaDueño);
        
        jefe = new JButton("JEFE", jefeEscalado);
		mini_jefe = new JButton("JEFE DE CLINICA",minijefeEscalado);
		trabajador = new JButton("TRABAJADOR",TrabajadorEscalado);
		dueño = new JButton("DUEÑO",TrabajadorDueño);
		
		panel.setLayout(new BorderLayout());
		panel.add(panelBotones, BorderLayout.CENTER);
		panel.add(pArriba, BorderLayout.NORTH);
		panel.add(pAbajo, BorderLayout.SOUTH);
		
		panelBotones.setLayout(new FlowLayout());
		panelBotones.add(jefe);
		panelBotones.add(mini_jefe);
		panelBotones.add(trabajador);
		panelBotones.add(dueño);
		
		pArriba.add(info);
		
		pAbajo.add(cancelar);
		
		jefe.addActionListener((e)->{
			new VentanaRegistroJefe();
		});
		
		mini_jefe.addActionListener((e)->{
			new VentanaRegistroMiniJefe();
		});
		
		trabajador.addActionListener((e)->{
			new VentanaRegistroTrabajador();
		});
		
		dueño.addActionListener((e)->{
			new VentanaRegistroDueño();
		});
		
		cancelar.addActionListener((e)->{
			dispose();
		});
		
		getContentPane().add(panel, BorderLayout.CENTER);
		setTitle("");
		setBounds(300, 50, 700, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
