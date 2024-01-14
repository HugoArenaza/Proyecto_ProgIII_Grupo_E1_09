package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import domain.TipoPaciente;

public class TipoPacienteTest {
	 @Test
	    public void testEnumValues() {
	        TipoPaciente[] tipos = TipoPaciente.values();

	        assertEquals(63, tipos.length); // Asegura que haya 60 elementos en el enum

	        
	        for (TipoPaciente tipo : tipos) {
	            assertNotNull(tipo);
	        }
	    }

	    @Test
	    public void testEnumValidity() {
	       
	        for (TipoPaciente tipo : TipoPaciente.values()) {
	            assertNotNull(tipo); // Asegura que el elemento no sea nulo
	        }
	    }
}
