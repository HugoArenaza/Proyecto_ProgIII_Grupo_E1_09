package base_de_datos;
import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import domain.Paciente;



public class BDTest {
	private Connection con;
	@Before
	public void setUp()throws Exception{
		con = BD.initBD("clinicaFurwell.db");
	}
	
	@After 
	public void tearDown() throws Exception{
		BD.cerrarBD(con);
	}
	
	@Test
	public void testCrearTablas() {
		assertThrows(AssertionError.class, ()->{
			assertThrows(SQLException.class, ()->{BD.crearTablas(con);});
		});
	}
	
	/*@Test
	public void testInsertarPaciente() {
		Paciente p = new Paciente(0, null, 0, null, 0, null, null);
		BD.insertarPaciente(con,"Sin NombreDueño", p);
	}*/
	
}