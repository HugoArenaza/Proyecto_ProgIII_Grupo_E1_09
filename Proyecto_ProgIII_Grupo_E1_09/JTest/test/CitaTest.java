package test;

import static org.junit.Assert.*;

import java.util.Date;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import domain.Cita;
import java.text.SimpleDateFormat;

public class CitaTest {

	private Cita citaBase; // Objeto que se utilizará como base en los casos de prueba

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setup() {
		// Inicializar una cita base con valores predeterminados
		citaBase = new Cita(null, "", null, 0);
	}

	@Test
	public void testGetFecha_cita() {

		Date fechaEsperada = new Date();
		Cita cita = new Cita(fechaEsperada, "Lugar de prueba", "10:00", 1);

		Date fechaObtenida = cita.getFecha_cita();

		assertEquals(fechaEsperada, fechaObtenida);
	}

	@Test
	public void testGetFecha_citaCuandoEsNula() {

		Date fechaObtenida = citaBase.getFecha_cita();

		assertNull(fechaObtenida);
	}

	@Test
	public void testSetFecha_cita() {

		Cita cita = new Cita();

		Date nuevaFecha = new Date();
		cita.setFecha_cita(nuevaFecha);

		Date fechaObtenida = cita.getFecha_cita();

		assertEquals(nuevaFecha, fechaObtenida);
	}

	@Test
	public void testGetLugar() {

		Cita cita = new Cita(null, "Lugar de prueba", "10:00", 1);

		String lugarObtenido = cita.getLugar();

		assertEquals("Lugar de prueba", lugarObtenido);
	}

	@Test
	public void testSetLugar() {

		Cita cita = new Cita();

		cita.setLugar("Nuevo lugar de prueba");

		String lugarObtenido = cita.getLugar();

		assertEquals("Nuevo lugar de prueba", lugarObtenido);
	}

	@Test
	public void testGetHora() {

		Cita cita = new Cita(null, "Lugar de prueba", "10:00", 1);

		String horaObtenida = cita.getHora();

		assertEquals("10:00", horaObtenida);
	}

	@Test
	public void testSetHora() {

		Cita cita = new Cita();

		cita.setHora("12:30");

		String horaObtenida = cita.getHora();

		assertEquals("12:30", horaObtenida);
	}

	@Test
	public void testGetNum_cita() {

		Cita cita = new Cita(null, "Lugar de prueba", "10:00", 5);

		int numCitaObtenido = cita.getNum_cita();

		assertEquals(5, numCitaObtenido);
	}

	@Test
	public void testSetNum_cita() {

		Cita cita = new Cita();

		cita.setNum_cita(10);

		int numCitaObtenido = cita.getNum_cita();

		assertEquals(10, numCitaObtenido);
	}

	@Test
	public void testToString() {

		Date fechaEsperada = new Date();
		Cita cita = new Cita(fechaEsperada, "Lugar de prueba", "10:00", 1);

		SimpleDateFormat sdfDia = new SimpleDateFormat("dd-MM-yyyy");

		String resultadoEsperado = "Su cita sera el " + sdfDia.format(fechaEsperada)
				+ " a las 10:00 en la Lugar de prueba y su numero de cita es el 1";
		String resultadoObtenido = cita.toString();

		assertEquals(resultadoEsperado, resultadoObtenido);
	}

}