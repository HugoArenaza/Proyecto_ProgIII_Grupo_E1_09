package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import domain.TipoMaquinaria;

public class TipoMaquinariaTest {
	@Test
    public void testEnumValues() {
        TipoMaquinaria[] maquinarias = TipoMaquinaria.values();

        assertEquals(13, maquinarias.length); // Asegura que haya 13 elementos en el enum

       
        for (TipoMaquinaria maquinaria : maquinarias) {
            assertNotNull(maquinaria);
        }
    }

    @Test
    public void testEnumValidity() {
        
        for (TipoMaquinaria maquinaria : TipoMaquinaria.values()) {
            assertNotNull(maquinaria); // Asegura que el elemento no sea nulo
        }
    }
}
