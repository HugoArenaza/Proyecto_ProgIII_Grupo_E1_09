package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import domain.Especialidades;
import domain.Jefe;
import domain.Paciente;


public class JefeTest {
	 @Test
	    public void testJefeConstructor() {
	       
	        int id = 1;
	        String nombre = "NombreTest";
	        String apellidos = "ApellidoTest";
	        String usuario = "UsuarioTest";
	        String contraseña = "ContraseñaTest";
	        int idClinica = 123;
	        ArrayList<Paciente> pacientes = new ArrayList<>();
	        float sueldo = 1000.0f;
	        Especialidades especialidad = Especialidades.CIRUGIA;
	        String dni = "12345678X";
	        int numPacientes = 5;
	        int numEmpleados = 10;

	        
	        Jefe jefe = new Jefe(id, nombre, apellidos, usuario, contraseña, idClinica, pacientes, sueldo, especialidad,
	                dni, numPacientes, numEmpleados);

	       
	        assertEquals(id, jefe.getId());
	        assertEquals(nombre, jefe.getNombre());
	        assertEquals(apellidos, jefe.getApellidos());
	        assertEquals(usuario, jefe.getUsuario());
	        assertEquals(contraseña, jefe.getContraseña());
	        assertEquals(idClinica, jefe.getClinica());
	        assertEquals(pacientes, jefe.getPaciente());
	        assertEquals(sueldo, jefe.getSueldo(), 0.001);
	        assertEquals(especialidad, jefe.getespecialidad());
	        assertEquals(dni, jefe.getDni());
	        assertEquals(numPacientes, jefe.getNum_pacientes());
	        assertEquals(numEmpleados, jefe.getNum_empleados());
	    }
	
	
	@Test
	   public void testToString() {
	        
		 Jefe jefe = new Jefe(1, "NombreTest", "ApellidoTest", "UsuarioTest", "ContraseñaTest",
		            123, new ArrayList<>(), 1000.0f, Especialidades.CIRUGIA, "12345678X", 5, 10);


		   
		    String expected = "Jefe [getNum_empleados()=10, toString()=MiniJefe [num_empleados=10, "
		            + "Trabajador [num_pacientes=5, Dni=12345678X, Nombre=NombreTest, Apellidos=ApellidoTest, "
		            + "Usuario=UsuarioTest, Contraseña=ContraseñaTest, Clinica=123, Paciente=[], Sueldo=1000.0, "
		            + "Especialidad=CIRUGIA]], getNum_pacientes()=5, getDni()=12345678X, getNombre()=NombreTest, "
		            + "getApellidos()=ApellidoTest, getUsuario()=UsuarioTest, getContraseña()=ContraseñaTest, "
		            + "getClinica()=123, getPaciente()=[], getSueldo()=1000.0, getespecialidad()=CIRUGIA]";

		 
		    assertEquals(expected, jefe.toString());
	    }
}
