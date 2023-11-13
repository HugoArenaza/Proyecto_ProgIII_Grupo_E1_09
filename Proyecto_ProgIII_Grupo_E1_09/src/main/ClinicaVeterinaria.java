package main;




//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.util.logging.LogManager;
//import java.util.logging.Logger;

import ventanas.VentanaInicio;




public class ClinicaVeterinaria {

	
	
	public static void main(String[] args) {

		/*Logger logger = java.util.logging.Logger.getLogger("Logger");
		try {
			FileInputStream fis = new FileInputStream("con/logger.properties");
			try {
				LogManager.getLogManager().readConfiguration(fis);
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}*/

		new VentanaInicio();
		
}
}
