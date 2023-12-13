package test;
import domain.Clinica;
import domain.MedicamentosAnimales;
import domain.Trabajador;
import domain.Proveedor;
import domain.Paciente;
import domain.MiniJefe;
import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
public class ClinicaTest {

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	

	private Clinica clinicaBase;
	
	    @Before
	    public void setup() {
	        clinicaBase = new Clinica(1, "Calle de prueba", 50, new ArrayList<>(), new ArrayList<>(), null, 10,
	                new ArrayList<>(), new ArrayList<>());
	    }
	
	    @Test
	    public void testGetId() {
	        assertEquals(1, clinicaBase.getId());
	    }
	
	    @Test
	    public void testSetId() {
	        clinicaBase.setId(2);
	        assertEquals(2, clinicaBase.getId());
	    }
	
	    @Test
	    public void testGetCalle() {
	        assertEquals("Calle de prueba", clinicaBase.getCalle());
	    }
	
	    @Test
	    public void testSetCalle() {
	        clinicaBase.setCalle("Nueva calle");
	        assertEquals("Nueva calle", clinicaBase.getCalle());
	    }
	
	    @Test
	    public void testGetCantidadPacientes() {
	        assertEquals(50, clinicaBase.getCantidadPacientes());
	    }
	
	    @Test
	    public void testSetCantidadPacientes() {
	        clinicaBase.setCantidadPacientes(60);
	        assertEquals(60, clinicaBase.getCantidadPacientes());
	    }
	
	    @Test
	    public void testGetMedicamentos() {
	        assertTrue(clinicaBase.getMedicamentos().isEmpty());
	    }
	
	    @Test
	    public void testSetMedicamentos() {
	        ArrayList<MedicamentosAnimales> nuevosMedicamentos = new ArrayList<>();
	        nuevosMedicamentos.add(MedicamentosAnimales.AMANTADINA);
	        nuevosMedicamentos.add(MedicamentosAnimales.CARPROFENO);
	        clinicaBase.setMedicamentos(nuevosMedicamentos);
	        assertEquals(nuevosMedicamentos, clinicaBase.getMedicamentos());
	    }
	
	    @Test
	    public void testGetTrabajadores() {
	        assertTrue(clinicaBase.getTrabajadores().isEmpty());
	    }
	
	    @Test
	    public void testSetTrabajadores() {
	        ArrayList<Trabajador> nuevosTrabajadores = new ArrayList<>();
	        nuevosTrabajadores.add(new Trabajador(0, "Juan", null, null, null, 0, null, null, null, null, 0));
	        nuevosTrabajadores.add(new Trabajador(0, "Maria", null, null, null, 0, null, null, null, null, 0));
	        clinicaBase.setTrabajadores(nuevosTrabajadores);
	        assertEquals(nuevosTrabajadores, clinicaBase.getTrabajadores());
	    }
	
	    @Test
	    public void testGetJefeVeterinario() {
	        assertNull(clinicaBase.getJefeVeterinario());
	    }
	
	    @Test
	    public void testSetJefeVeterinario() {
	        MiniJefe nuevoJefe = new MiniJefe(0, "Nuevo Jefe", null, null, null, 0, null, null, null, null, 0, 0);
	        clinicaBase.setJefeVeterinario(nuevoJefe);
	        assertEquals(nuevoJefe, clinicaBase.getJefeVeterinario());
	    }
	
	    @Test
	    public void testGetNumeroTrabajadores() {
	        assertEquals(10, clinicaBase.getNumeroTrabajadores());
	    }
	
	    @Test
	    public void testSetNumeroTrabajadores() {
	        clinicaBase.setNumeroTrabajadores(15);
	        assertEquals(15, clinicaBase.getNumeroTrabajadores());
	    }
	
	    @Test
	    public void testGetPacientes() {
	        assertTrue(clinicaBase.getPacientes().isEmpty());
	    }
	
	    @Test
	    public void testSetPacientes() {
	        ArrayList<Paciente> nuevosPacientes = new ArrayList<>();
	        nuevosPacientes.add(new Paciente(0, "Paciente1", 0, null, 0, null, null));
	        nuevosPacientes.add(new Paciente(0, "Paciente2", 0, null, 0, null, null));
	        clinicaBase.setPacientes(nuevosPacientes);
	        assertEquals(nuevosPacientes, clinicaBase.getPacientes());
	    }
	
	    @Test
	    public void testGetProveedores() {
	        assertTrue(clinicaBase.getProveedores().isEmpty());
	    }
	
	    @Test
	    public void testSetProveedores() {
	        ArrayList<Proveedor> nuevosProveedores = new ArrayList<>();
	        nuevosProveedores.add(new Proveedor("Proveedor1", 0));
	        nuevosProveedores.add(new Proveedor("Proveedor2", 0));
	        clinicaBase.setProveedores(nuevosProveedores);
	        assertEquals(nuevosProveedores, clinicaBase.getProveedores());
	    }
	
	    @Test
	    public void testToString() {
	        String resultadoEsperado = "Clinica [id = 1,   calle=Calle de prueba, cantidadPacientes=50, medicamentos=[], trabajador=[], jefeVeterinario=null, numeroTrabajadores=10, pacientes=[], proveedores=[]]";
	        String resultadoObtenido = clinicaBase.toString();
	        assertEquals(resultadoEsperado, resultadoObtenido);
	    }
	
	    @Test
	    public void testAdmitirPaciente() {
	        clinicaBase.admitirPaciente();
	        assertEquals(51, clinicaBase.getCantidadPacientes());
	    }
	
	    @Test
	    public void testAdmitirPacienteConMaximoAlcanzado() {
	        for (int i = 0; i < Clinica.num_maximo_pacientes; i++) {
	            clinicaBase.admitirPaciente();
	        }
	        clinicaBase.admitirPaciente();
	        assertEquals(Clinica.num_maximo_pacientes, clinicaBase.getCantidadPacientes());
	    }
	
}
