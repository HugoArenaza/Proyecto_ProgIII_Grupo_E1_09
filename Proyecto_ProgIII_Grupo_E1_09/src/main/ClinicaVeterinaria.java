package main;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOError;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import base_de_datos.BD;
import domain.Contenedora;
import ventanas.VentanaDueño;
import ventanas.VentanaInicio;
import ventanas.VentanaJefe;
import ventanas.VentanaTrabajador;

import java.sql.Connection;



public class ClinicaVeterinaria {
	public static void main(String[] args) {
		Logger logger = java.util.logging.Logger.getLogger("Logger");
		Properties prop = new Properties();

		Connection con = BD.initBD("clinicaFurwell.db");

		Contenedora.volcarCSVMedicamentos(con, "fichs/medicamentos.csv");
		BD.crearTablas(con);
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
		
		try {
			prop.load(new FileReader("config/config.properties"));
			String nombreBD = prop.getProperty("nombreBD");
			String nombreAplicacion = prop.getProperty("nombreAplicacion");
			String fechaCreacion = prop.getProperty("fechaCreacion");
		} catch (FileNotFoundException e) { 
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		
		
		
		
		//new VentanaJefe();

		//new VentanaTrabajador();
		//new VentanaInicio();
		new VentanaDueño();

		new VentanaTrabajador();
		//new VentanaInicio();
		//new VentanaDueño();

}
}
