package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import domain.Especialidades;
import domain.Paciente;
import domain.Trabajador;

public class TrabajadorTest {

	@Test
    public void testTrabajadorConstructor() {
        ArrayList<Paciente> pacientes = new ArrayList<>();
        Especialidades especialidad = Especialidades.CIRUGIA; 
        Trabajador trabajador = new Trabajador(1, "NombreTest", "ApellidoTest", "UsuarioTest", "ContraseñaTest", 123, pacientes, 1000.0f, especialidad, "12345678X", 5);

        assertEquals(5, trabajador.getNum_pacientes());
        assertEquals("12345678X", trabajador.getDni());
        assertEquals("NombreTest", trabajador.getNombre());
        assertEquals("ApellidoTest", trabajador.getApellidos());
        assertEquals("UsuarioTest", trabajador.getUsuario());
        assertEquals("ContraseñaTest", trabajador.getContraseña());
        assertEquals(123, trabajador.getClinica());
        assertEquals(pacientes, trabajador.getPaciente());
        assertEquals(1000.0f, trabajador.getSueldo(), 0.001);
        assertEquals(especialidad, trabajador.getespecialidad());
    }

    @Test
    public void testGetNum_pacientes() {
        Trabajador trabajador = new Trabajador(0, null, null, null, null, 0, null, null, null, null, 0);
        trabajador.setNum_pacientes(10);

        assertEquals(10, trabajador.getNum_pacientes());
    }

    @Test
    public void testSetNum_pacientes() {
        Trabajador trabajador = new Trabajador(0, null, null, null, null, 0, null, null, null, null, 0);
        trabajador.setNum_pacientes(20);

        assertEquals(20, trabajador.getNum_pacientes());
    }

    @Test
    public void testToString() {
        ArrayList<Paciente> pacientes = new ArrayList<>();
        Especialidades especialidad = Especialidades.CIRUGIA; 
        Trabajador trabajador = new Trabajador(1, "NombreTest", "ApellidoTest", "UsuarioTest", "ContraseñaTest", 123, pacientes, 1000.0f, especialidad, "12345678X", 5);

        String expected = "Trabajador [num_pacientes=5, Dni=12345678X, Nombre=NombreTest, Apellidos=ApellidoTest, Usuario=UsuarioTest, Contraseña=ContraseñaTest, Clinica=123, Paciente=[], Sueldo=1000.0, Especialidad=CIRUGIA]";
        assertEquals(expected, trabajador.toString());    }

}
