package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;

import org.junit.Test;

import domain.Especialidades;
import domain.Paciente;
import domain.Veterinario;


public class VeterinarioTest {
	 @Test
	    public void testVeterinarioConstructor() {
	        ArrayList<Paciente> pacientes = new ArrayList<>();
	        Especialidades especialidad = Especialidades.CIRUGIA; 
	        Veterinario veterinario = new Veterinario(1, "NombreTest", "ApellidoTest", "UsuarioTest", "ContraseñaTest", 123, pacientes, 1000.0f, especialidad, "12345678X");

	        assertEquals(1, veterinario.getId());
	        assertEquals("NombreTest", veterinario.getNombre());
	        assertEquals("ApellidoTest", veterinario.getApellidos());
	        assertEquals("UsuarioTest", veterinario.getUsuario());
	        assertEquals("ContraseñaTest", veterinario.getContraseña());
	        assertEquals(123, veterinario.getClinica());
	        assertEquals(pacientes, veterinario.getPaciente());
	        assertEquals(1000.0f, veterinario.getSueldo(), 0.001); // Utilizamos delta para comparar valores de punto flotante
	        assertEquals(especialidad, veterinario.getespecialidad());
	        assertEquals("12345678X", veterinario.getDni());
	    }

	 @Test
	 public void testVeterinarioDefaultConstructor() {
	     Veterinario veterinario = new Veterinario();

	     assertEquals("Sin nombre", veterinario.getNombre());
	     assertEquals("Sin apellidos", veterinario.getApellidos());
	     assertEquals("Sin nombre de usuario", veterinario.getUsuario());
	     assertEquals("Sin contraseña", veterinario.getContraseña());
	     assertEquals(0, veterinario.getClinica());
	     assertNotNull(veterinario.getPaciente()); 
	     assertEquals(0, veterinario.getPaciente().size()); // La lista está vacía
	     assertEquals(0.0f, veterinario.getSueldo(), 0.001);
	     assertNull(veterinario.getespecialidad());
	     assertEquals("sin dni", veterinario.getDni());
	 }

	    @Test
	    public void testGettersAndSetters() {
	        Veterinario veterinario = new Veterinario();

	        veterinario.setId(2);
	        assertEquals(2, veterinario.getId());

	        veterinario.setNombre("NuevoNombre");
	        assertEquals("NuevoNombre", veterinario.getNombre());

	        veterinario.setApellidos("NuevoApellido");
	        assertEquals("NuevoApellido", veterinario.getApellidos());

	        veterinario.setUsuario("NuevoUsuario");
	        assertEquals("NuevoUsuario", veterinario.getUsuario());

	        veterinario.setContraseña("NuevaContraseña");
	        assertEquals("NuevaContraseña", veterinario.getContraseña());

	        veterinario.setClinica(456);
	        assertEquals(456, veterinario.getClinica());

	        ArrayList<Paciente> nuevosPacientes = new ArrayList<>();
	        veterinario.setPaciente(nuevosPacientes);
	        assertEquals(nuevosPacientes, veterinario.getPaciente());

	        veterinario.setSueldo(1500.0f);
	        assertEquals(1500.0f, veterinario.getSueldo(), 0.001);

	        Especialidades nuevaEspecialidad = Especialidades.CIRUGIA; 
	        veterinario.setespecialidad(nuevaEspecialidad);
	        assertEquals(nuevaEspecialidad, veterinario.getespecialidad());

	        veterinario.setDni("98765432Y");
	        assertEquals("98765432Y", veterinario.getDni());
	    }

	    @Test
	    public void testToString() {
	        ArrayList<Paciente> pacientes = new ArrayList<>();
	        Especialidades especialidad = Especialidades.CIRUGIA;
	        Veterinario veterinario = new Veterinario(1, "NombreTest", "ApellidoTest", "UsuarioTest", "ContraseñaTest", 123, pacientes, 1000.0f, especialidad, "12345678X");

	        String expected = "Veterinario [Id = 1, nombre=NombreTest, apellidos=ApellidoTest, usuario=UsuarioTest, contraseña=ContraseñaTest, clinica=123, paciente=" + pacientes + ", sueldo=1000.0, especialidad=CIRUGIA, dni=12345678X]";
	        assertEquals(expected, veterinario.toString());
	    }

	    @Test
	    public void testAnyadirPaciente() {
	        Veterinario veterinario = new Veterinario();
	        Paciente paciente = new Paciente(); 

	        assertNotNull(veterinario.getPaciente());
	        veterinario.anyadirPaciente(paciente);
	        assertEquals(1, veterinario.getPaciente().size());
	        assertEquals(paciente, veterinario.getPaciente().get(0));
	    }

	    @Test
	    public void testCompareTo() {
	        Veterinario veterinario1 = new Veterinario(1, "NombreA", "ApellidoA", "UsuarioA", "ContraseñaA", 123, null, 1000.0f, Especialidades.CIRUGIA, "12345678X");
	        Veterinario veterinario2 = new Veterinario(2, "NombreB", "ApellidoB", "UsuarioB", "ContraseñaB", 456, null, 1200.0f, Especialidades.CIRUGIA, "98765432Y");

	        assertEquals(-1, veterinario1.compareTo(veterinario2));
	        assertEquals(1, veterinario2.compareTo(veterinario1));
	        assertEquals(0, veterinario1.compareTo(veterinario1));
	    }

}
