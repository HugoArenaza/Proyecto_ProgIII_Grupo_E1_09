package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

import domain.Especialidades;
import domain.Veterinario;
import domain.VeterinarioComparatorPorDni;

public class VeterinarioComparatorPorDniTest {
	 @Test
	    public void testComparatorPorDni() {
	        Veterinario vet1 = new Veterinario(1, "Nombre1", "Apellido1", "Usuario1", "Contraseña1", 123, new ArrayList<>(), 1000.0f, Especialidades.CIRUGIA, "12345678A");
	        Veterinario vet2 = new Veterinario(2, "Nombre2", "Apellido2", "Usuario2", "Contraseña2", 123, new ArrayList<>(), 1200.0f, Especialidades.CARDIOLOGIA, "12345678B");
	        Veterinario vet3 = new Veterinario(3, "Nombre3", "Apellido3", "Usuario3", "Contraseña3", 123, new ArrayList<>(), 900.0f, Especialidades.EXOTICOS, "12345678C");

	        ArrayList<Veterinario> veterinarios = new ArrayList<>();
	        veterinarios.add(vet3);
	        veterinarios.add(vet1);
	        veterinarios.add(vet2);

	        // Orden ascendente por DNI
	        Collections.sort(veterinarios, new VeterinarioComparatorPorDni());

	        assertEquals(vet1, veterinarios.get(0));
	        assertEquals(vet2, veterinarios.get(1));
	        assertEquals(vet3, veterinarios.get(2));
	    }

	    @Test
	    public void testComparatorPorDniConIgualdad() {
	        Veterinario vet1 = new Veterinario(1, "Nombre1", "Apellido1", "Usuario1", "Contraseña1", 123, new ArrayList<>(), 1000.0f, Especialidades.CIRUGIA, "12345678A");
	        Veterinario vet2 = new Veterinario(2, "Nombre2", "Apellido2", "Usuario2", "Contraseña2", 123, new ArrayList<>(), 1200.0f, Especialidades.CARDIOLOGIA, "12345678A");
	        Veterinario vet3 = new Veterinario(3, "Nombre3", "Apellido3", "Usuario3", "Contraseña3", 123, new ArrayList<>(), 900.0f, Especialidades.EXOTICOS, "12345678C");

	        ArrayList<Veterinario> veterinarios = new ArrayList<>();
	        veterinarios.add(vet3);
	        veterinarios.add(vet1);
	        veterinarios.add(vet2);

	        // Orden ascendente por DNI
	        Collections.sort(veterinarios, new VeterinarioComparatorPorDni());

	        assertEquals(vet1, veterinarios.get(0));
	        assertEquals(vet2, veterinarios.get(1));
	        assertEquals(vet3, veterinarios.get(2));
	    }

	    @Test
	    public void testComparatorPorDniDescendente() {
	        Veterinario vet1 = new Veterinario(1, "Nombre1", "Apellido1", "Usuario1", "Contraseña1", 123, new ArrayList<>(), 1000.0f, Especialidades.CIRUGIA, "12345678A");
	        Veterinario vet2 = new Veterinario(2, "Nombre2", "Apellido2", "Usuario2", "Contraseña2", 123, new ArrayList<>(), 1200.0f, Especialidades.CARDIOLOGIA, "12345678B");
	        Veterinario vet3 = new Veterinario(3, "Nombre3", "Apellido3", "Usuario3", "Contraseña3", 123, new ArrayList<>(), 900.0f, Especialidades.EXOTICOS, "12345678C");

	        ArrayList<Veterinario> veterinarios = new ArrayList<>();
	        veterinarios.add(vet3);
	        veterinarios.add(vet1);
	        veterinarios.add(vet2);

	        // Orden descendente por DNI
	        Collections.sort(veterinarios, Collections.reverseOrder(new VeterinarioComparatorPorDni()));

	        assertEquals(vet3, veterinarios.get(0));
	        assertEquals(vet2, veterinarios.get(1));
	        assertEquals(vet1, veterinarios.get(2));
	    }
}
