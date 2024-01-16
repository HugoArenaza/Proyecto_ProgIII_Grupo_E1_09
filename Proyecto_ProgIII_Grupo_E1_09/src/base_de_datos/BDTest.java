package base_de_datos;
import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import domain.Clinica;
import domain.Dueño;
import domain.Paciente;
import domain.TipoPaciente;



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
	
	@Test
	public void insertarPaciente() {
		Paciente p = new Paciente(999, "a", 999, "a", 1, TipoPaciente.ARAÑA	, new Dueño("A", "A", "1", new Clinica(1, "A", 1, new ArrayList<>(), new ArrayList<>(), null, 0, new ArrayList<>(), new ArrayList<>()), null, 0, null, null));
		int tam = BD.obtenerListaPacientes(con, "A").size();
		BD.insertarPaciente(con, "A", p);
		int tam2 = BD.obtenerListaPacientes(con, "A").size();
		assertTrue(tam+1==tam2);
	}
	
	@Test
    public void testObtenerListaPacientes() {
        // Insertar un paciente de prueba
		Paciente p = new Paciente(999, "a", 999, "a", 1, TipoPaciente.ARAÑA,
		        new Dueño("A", "A", "1", new Clinica(1, "A", 1, new ArrayList<>(), new ArrayList<>(), null, 0,
		                new ArrayList<>(), new ArrayList<>()), null, 0, null, null));
		BD.insertarPaciente(con, "A", p);

		// Obtener la lista de pacientes y verificar que contiene al menos un elemento
		List<Paciente> listaPacientes = BD.obtenerListaPacientes(con, "A");
		assertNotNull(listaPacientes);
		assertFalse(listaPacientes.isEmpty());
    }
	@Test
	public void testBuscarDueño() {
		Dueño d = BD.buscarDueño(con, "123456789");
		assertNotNull(d);
		d = BD.buscarDueño(con, "999Z");
		assertNull(d);
		
	}
	

	
}