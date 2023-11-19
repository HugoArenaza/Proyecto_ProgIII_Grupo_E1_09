package main;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOError;
import java.io.IOException;
import java.sql.Connection;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import base_de_datos.BD;
import ventanas.VentanaDueño;
import ventanas.VentanaInicio;
import ventanas.VentanaTrabajador;

import java.sql.Connection;



public class ClinicaVeterinaria {
	public static void main(String[] args) {
		Logger logger = java.util.logging.Logger.getLogger("Logger");
		
		
		
	
		Connection con = BD.initBD("clinicaFurwell.db");
		BD.cerrarBD(con);
		
		try {
			FileInputStream fis = new FileInputStream("config/logger.properties");
			LogManager.getLogManager().readConfiguration(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (SecurityException e ) {
			e.printStackTrace();
		}catch (IOException e ) {
			e.printStackTrace();
		}
		
		
		
		
		
		//new VentanaTrabajador();
		//new VentanaInicio();
		//new VentanaDueño();
}
}
