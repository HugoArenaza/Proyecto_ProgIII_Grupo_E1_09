package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import domain.Medicamento;

public class MedicamentoTest {
	

	    @Test
	    public void testMedicamentoConstructor() {
	        Medicamento medicamento = new Medicamento("Ibuprofeno", 1, 5.0);

	        assertEquals("Ibuprofeno", medicamento.getNombreMedicamento());
	        assertEquals(1, medicamento.getId());
	        assertEquals(5.0, medicamento.getPrecioMedicamento(), 0.001);
	    }

	    @Test
	    public void testMedicamentoDefaultConstructor() {
	        Medicamento medicamento = new Medicamento();

	        assertEquals("", medicamento.getNombreMedicamento());
	        assertEquals(0, medicamento.getId());
	        assertEquals(0.0, medicamento.getPrecioMedicamento(), 0.001);
	    }

	    @Test
	    public void testGettersAndSetters() {
	        Medicamento medicamento = new Medicamento();

	        medicamento.setNombreMedicamento("Paracetamol");
	        assertEquals("Paracetamol", medicamento.getNombreMedicamento());

	        medicamento.setId(2);
	        assertEquals(2, medicamento.getId());

	        medicamento.setPrecioMedicamento(3.5);
	        assertEquals(3.5, medicamento.getPrecioMedicamento(), 0.001);
	    }

	    @Test
	    public void testToString() {
	        Medicamento medicamento = new Medicamento("Aspirina", 3, 2.5);

	        String expected = "Medicamento [nombreMedicamento=Aspirina, id=3, precioMedicamento=2.5]";
	        assertEquals(expected, medicamento.toString());
	    }

}
