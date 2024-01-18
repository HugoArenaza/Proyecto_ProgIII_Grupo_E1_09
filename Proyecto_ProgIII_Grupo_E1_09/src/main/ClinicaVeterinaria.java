package main;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.FileReader;
<<<<<<< HEAD

=======
>>>>>>> branch 'Proyecto_Main' of https://github.com/HugoArenaza/Proyecto_ProgIII_Grupo_E1_09.git
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import base_de_datos.BD;
import domain.Contenedora;
<<<<<<< HEAD

=======
>>>>>>> branch 'Proyecto_Main' of https://github.com/HugoArenaza/Proyecto_ProgIII_Grupo_E1_09.git
import ventanas.VentanaInicio;
import ventanas.VentanaJefe;

<<<<<<< HEAD



=======
>>>>>>> branch 'Proyecto_Main' of https://github.com/HugoArenaza/Proyecto_ProgIII_Grupo_E1_09.git


public class ClinicaVeterinaria {
	public static void main(String[] args) {
		
		@SuppressWarnings("unused")
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
			@SuppressWarnings("unused")
			String nombreBD = prop.getProperty("nombreBD");
			@SuppressWarnings("unused")
			String nombreAplicacion = prop.getProperty("nombreAplicacion");
			@SuppressWarnings("unused")
			String fechaCreacion = prop.getProperty("fechaCreacion");
		} catch (FileNotFoundException e) { 
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		
		
		
		
		new VentanaJefe();

		
		new VentanaTrabajador();



		//new VentanaTrabajador();


		//new VentanaInicio();


		//new VentanaInicio();



		//new VentanaDueño();

		//new VentanaInicio();
		//new VentanaJefe();


}
}
