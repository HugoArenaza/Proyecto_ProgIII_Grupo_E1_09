package main;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOError;
import java.io.IOException;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import ventanas.VentanaInicio;



public class ClinicaVeterinaria {
	public static void main(String[] args) {
		Logger logger = java.util.logging.Logger.getLogger("Logger");
		
		try {
			FileInputStream fis = new FileInputStream("config/logger.properties");
			LogManager.getLogManager().readConfiguration(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e ) {
			e.printStackTrace();
		}catch (IOException e ) {
			e.printStackTrace();
		}
		

		new VentanaInicio();
	

}
}
