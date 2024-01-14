package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import domain.Dueño;
import domain.Paciente;
import domain.TipoPaciente;

public class PacienteTest {

    @Test
  public  void testConstructorDefault() {
        Paciente paciente = new Paciente();
        assertNotNull(paciente);
        assertEquals(0, paciente.getId());
        assertEquals(null, paciente.getNombrePaciente());
        assertEquals(0, paciente.getMicroChip());
        assertEquals(null, paciente.getEnfermedad());
        assertEquals(0, paciente.getId_Veterinario());
        assertNull(paciente.getTipoPaciente());
        assertNull(paciente.getDueño());
    }

    @Test
   public void testConstructorParametrizado() {
        TipoPaciente tipoPaciente = TipoPaciente.GATO;
        Dueño dueño = new Dueño("Juan", "Pérez", "juan@example.com", null, null, 0, null, null);
        Paciente paciente = new Paciente(1, "Pelusa", 123456, "Fiebre", 2, tipoPaciente, dueño);

        assertEquals(1, paciente.getId());
        assertEquals("Pelusa", paciente.getNombrePaciente());
        assertEquals(123456, paciente.getMicroChip());
        assertEquals("Fiebre", paciente.getEnfermedad());
        assertEquals(2, paciente.getId_Veterinario());
        assertEquals(tipoPaciente, paciente.getTipoPaciente());
        assertEquals(dueño, paciente.getDueño());
    }
    @Test
  public  void testGettersAndSetters() {
        Paciente paciente = new Paciente();

        // Setter y Getter para Id
        paciente.setId(1);
        assertEquals(1, paciente.getId());

        // Setter y Getter para NombrePaciente
        paciente.setNombrePaciente("Firulais");
        assertEquals("Firulais", paciente.getNombrePaciente());

        // Setter y Getter para MicroChip
        paciente.setMicroChip(987654);
        assertEquals(987654, paciente.getMicroChip());

        // Setter y Getter para Enfermedad
        paciente.setEnfermedad("Gripe canina");
        assertEquals("Gripe canina", paciente.getEnfermedad());

        // Setter y Getter para Id_Veterinario
        paciente.setId_Veterinario(3);
        assertEquals(3, paciente.getId_Veterinario());

        // Setter y Getter para TipoPaciente
        TipoPaciente tipoPaciente = TipoPaciente.BURRO;
        paciente.setTipoPaciente(tipoPaciente);
        assertEquals(tipoPaciente, paciente.getTipoPaciente());

        // Setter y Getter para Dueño
        Dueño dueño = new Dueño("Carlos", "González", "carlos@example.com", null, null, 0, null, null);
        paciente.setDueño(dueño);
        assertEquals(dueño, paciente.getDueño());
    }

    @Test
    public void testToString() {
        TipoPaciente tipoPaciente = TipoPaciente.PERRO;
        Dueño dueño = new Dueño("Ana", "Gómez", "ana@example.com", null, null, 0, null, null);
        Paciente paciente = new Paciente(2, "Buddy", 789012, "Dolor de oído", 3, tipoPaciente, dueño);

        assertEquals("PERRO (Buddy) ", paciente.toString());
    }
}
