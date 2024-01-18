package ventanas;
import javax.swing.*;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class VentanaAnyadirTrabajador extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox<String> comboTipoVeterinario;

    public VentanaAnyadirTrabajador(){
        setTitle("Seleccionar Tipo de Veterinario");
        setSize(300, 150);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        String[] tiposVeterinario = {"Trabajador", "Jefe", "MiniJefe"};
        comboTipoVeterinario = new JComboBox<>(tiposVeterinario);

        panel.add(new JLabel("Seleccione el Tipo de Veterinario:"));
        panel.add(comboTipoVeterinario);

        JButton btnContinuar = new JButton("Continuar");
        panel.add(btnContinuar);

        add(panel);
    

  
        
        btnContinuar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String tipoVeterinarioSeleccionado = (String) comboTipoVeterinario.getSelectedItem();

                if ("Trabajador".equals(tipoVeterinarioSeleccionado)) {
                     new VentanaTrabajadorAgregar();
                } else if ("Jefe".equals(tipoVeterinarioSeleccionado)) {
                    new VentanaJefeAgregar();
                } else if ("MiniJefe".equals(tipoVeterinarioSeleccionado)) {
                   new VentanaMiniJefeAgregar();
                   
                }

                // Cierra la ventana actual
               
            }
        });
    }

  
       
    

    

    
}


