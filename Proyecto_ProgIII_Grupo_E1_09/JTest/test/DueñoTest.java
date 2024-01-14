package test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

import domain.Clinica;
import domain.Dueño;

public class DueñoTest {
	@Test
    public void testDueñoConstructor() {
        Clinica clinica = new Clinica(); // Asegúrate de tener una clase Clinica válida
        Dueño dueño = new Dueño("NombreDueñoTest", "ApellidoTest", "12345678X", clinica, "01-01-1990", 123456789, "correo@test.com", "contrasenaTest");

        assertEquals("NombreDueñoTest", dueño.getNombreDueño());
        assertEquals("ApellidoTest", dueño.getApellidos());
        assertEquals("12345678X", dueño.getDni());
        assertEquals(clinica, dueño.getClinicaAsociada());
        assertEquals("01-01-1990", dueño.getfNac());
        assertEquals(123456789, dueño.getNumeroTlf());
        assertEquals("correo@test.com", dueño.getCorreo());
        assertEquals("contrasenaTest", dueño.getContraseña());
    }

    @Test
    public void testDueñoDefaultConstructor() {
        Dueño dueño = new Dueño();

        assertEquals("Sin NombreDueño", dueño.getNombreDueño());
        assertEquals("Sin apellido", dueño.getApellidos());
        assertEquals("Sin dni", dueño.getDni());
        assertNull(dueño.getClinicaAsociada());
        assertEquals("01-01-1970", dueño.getfNac());
        assertEquals(000, dueño.getNumeroTlf());
        assertEquals("Sin correo", dueño.getCorreo());
        assertEquals("Sin contraseña", dueño.getContraseña());
    }

    @Test
    public void testGettersAndSetters() {
        Dueño dueño = new Dueño();

        dueño.setNombreDueño("NuevoNombreDueño");
        assertEquals("NuevoNombreDueño", dueño.getNombreDueño());

        dueño.setApellidos("NuevoApellido");
        assertEquals("NuevoApellido", dueño.getApellidos());

        dueño.setDni("98765432Y");
        assertEquals("98765432Y", dueño.getDni());

        Clinica nuevaClinica = new Clinica();
        dueño.setClinicaAsociada(nuevaClinica);
        assertEquals(nuevaClinica, dueño.getClinicaAsociada());

        dueño.setFnac("02-02-1980");
        assertEquals("02-02-1980", dueño.getfNac());

        dueño.setNumeroTlf(987654321);
        assertEquals(987654321, dueño.getNumeroTlf());

        dueño.setCorreo("nuevo@correo.com");
        assertEquals("nuevo@correo.com", dueño.getCorreo());

        dueño.setContraseña("nuevaContraseña");
        assertEquals("nuevaContraseña", dueño.getContraseña());
    }

    @Test
    public void testToString() {
        Clinica clinica = new Clinica(); // Asegúrate de tener una clase Clinica válida
        Dueño dueño = new Dueño("NombreDueñoTest", "ApellidoTest", "12345678X", clinica, "01-01-1990", 123456789, "correo@test.com", "contrasenaTest");

        String expected = "Dueño [NombreDueño=NombreDueñoTest, apellidos=ApellidoTest, dni=12345678X, clinicaAsociada=" + clinica + ", fNac=01-01-1990, numeroTlf=123456789, correo=correo@test.com, contraseña=contrasenaTest]";
        assertEquals(expected, dueño.toString());
    }
}

