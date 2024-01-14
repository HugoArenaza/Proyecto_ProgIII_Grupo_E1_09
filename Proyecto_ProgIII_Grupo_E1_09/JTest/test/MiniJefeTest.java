package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import domain.Especialidades;
import domain.MiniJefe;
import domain.Paciente;

public class MiniJefeTest {
	  @Test
	    public void testMiniJefeConstructor() {
	        ArrayList<Paciente> pacientes = new ArrayList<>();
	        Especialidades especialidad = Especialidades.CIRUGIA; 
	        MiniJefe miniJefe = new MiniJefe(1, "NombreTest", "ApellidoTest", "UsuarioTest", "ContraseñaTest", 123, pacientes, 1000.0f, especialidad, "12345678X", 5, 10);

	        assertEquals(10, miniJefe.getNum_empleados());
	        assertEquals(5, miniJefe.getNum_pacientes());
	        assertEquals("12345678X", miniJefe.getDni());
	        assertEquals("NombreTest", miniJefe.getNombre());
	        assertEquals("ApellidoTest", miniJefe.getApellidos());
	        assertEquals("UsuarioTest", miniJefe.getUsuario());
	        assertEquals("ContraseñaTest", miniJefe.getContraseña());
	        assertEquals(123, miniJefe.getClinica());
	        assertEquals(pacientes, miniJefe.getPaciente());
	        assertEquals(1000.0f, miniJefe.getSueldo(), 0.001);
	        assertEquals(especialidad, miniJefe.getespecialidad());
	    }

	    @Test
	    public void testMiniJefeToString() {
	        ArrayList<Paciente> pacientes = new ArrayList<>();
	        Especialidades especialidad = Especialidades.CIRUGIA; 
	        MiniJefe miniJefe = new MiniJefe(1, "NombreTest", "ApellidoTest", "UsuarioTest", "ContraseñaTest", 123, pacientes, 1000.0f, especialidad, "12345678X", 5, 10);

	        String expected = "MiniJefe [num_empleados=10, " +
	                          "Trabajador [num_pacientes=5, Dni=12345678X, Nombre=NombreTest, Apellidos=ApellidoTest, Usuario=UsuarioTest, Contraseña=ContraseñaTest, Clinica=123, Paciente=[], Sueldo=1000.0, Especialidad=CIRUGIA]" +
	                          "]";
	        assertEquals(expected, miniJefe.toString());
	    }

	    @Test
	    public void testMiniJefeEquality() {
	        ArrayList<Paciente> pacientes = new ArrayList<>();
	        Especialidades especialidad = Especialidades.CIRUGIA; 
	        MiniJefe miniJefe1 = new MiniJefe(1, "NombreTest", "ApellidoTest", "UsuarioTest", "ContraseñaTest", 123, pacientes, 1000.0f, especialidad, "12345678X", 5, 10);
	        MiniJefe miniJefe2 = new MiniJefe(2, "NombreTest", "ApellidoTest", "UsuarioTest", "ContraseñaTest", 123, pacientes, 1000.0f, especialidad, "12345678X", 5, 10);

	        assertTrue(miniJefe1.equals(miniJefe1));
	        assertFalse(miniJefe1.equals(miniJefe2));
	    }
}
