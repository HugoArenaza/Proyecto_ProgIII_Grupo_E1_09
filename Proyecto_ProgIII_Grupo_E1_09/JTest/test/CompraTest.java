package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.sql.Date;

import org.junit.Test;

import domain.Compra;
import domain.Paciente;

public class CompraTest {
	@Test
    public void testCompraConstructor() {
        Paciente paciente = new Paciente(); 
        Compra compra = new Compra("MedicamentoTest", 20.0, 1, new Date(0), paciente);

        assertEquals("MedicamentoTest", compra.getNombreMedicamento());
        assertEquals(20.0, compra.getPrecio(), 0.001); // Utilizamos delta para comparar valores de punto flotante
        assertEquals(1, compra.getId());
        assertEquals(paciente, compra.getPaciente());
    }

    @Test
    public void testCompraDefaultConstructor() {
        Compra compra = new Compra();

        assertEquals("", compra.getNombreMedicamento());
        assertEquals(0.0, compra.getPrecio(), 0.001);
        assertEquals(0, compra.getId());
        assertNull(compra.getPaciente());
    }

    @Test
    public void testGettersAndSetters() {
        Compra compra = new Compra();

        compra.setNombreMedicamento("NuevoMedicamento");
        assertEquals("NuevoMedicamento", compra.getNombreMedicamento());

        compra.setPrecio(25.0);
        assertEquals(25.0, compra.getPrecio(), 0.001);

        compra.setId(2);
        assertEquals(2, compra.getId());

        Paciente nuevoPaciente = new Paciente();
        compra.setPaciente(nuevoPaciente);
        assertEquals(nuevoPaciente, compra.getPaciente());
    }

    @Test
    public void testToString() {
        Paciente paciente = new Paciente(); 
        Compra compra = new Compra("MedicamentoTest", 20.0, 1, new Date(0), paciente);

        String expected = "Compra [nombreMedicamento=MedicamentoTest, id=1, precio=20.0, fechaDeCompra=" + compra.getFechaDeCompra() + ", paciente=" + paciente + "]";
        assertEquals(expected, compra.toString());
    }
}
