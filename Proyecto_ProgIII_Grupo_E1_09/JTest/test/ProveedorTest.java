package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import domain.Proveedor;

public class ProveedorTest {
    @Test
    public void testProveedorDefaultConstructor() {
        Proveedor proveedor = new Proveedor();

        assertEquals("Sin correo asociado", proveedor.getCorreo());
        assertEquals(0, proveedor.getNum_contacto());
    }

    @Test
    public void testProveedorParameterizedConstructor() {
        String correo = "proveedor@example.com";
        int num_contacto = 123456789;

        Proveedor proveedor = new Proveedor(correo, num_contacto);

        assertEquals(correo, proveedor.getCorreo());
        assertEquals(num_contacto, proveedor.getNum_contacto());
    }

    @Test
    public void testProveedorCopyConstructor() {
        String correo = "proveedor@example.com";
        int num_contacto = 123456789;

        Proveedor originalProveedor = new Proveedor(correo, num_contacto);
        Proveedor copiedProveedor = new Proveedor(originalProveedor);

        assertEquals(originalProveedor.getCorreo(), copiedProveedor.getCorreo());
        assertEquals(originalProveedor.getNum_contacto(), copiedProveedor.getNum_contacto());
    }

    @Test
    public void testProveedorToString() {
        String correo = "proveedor@example.com";
        int num_contacto = 123456789;

        Proveedor proveedor = new Proveedor(correo, num_contacto);

        String expectedString = "Proveedor [correo=" + correo + ", num_contacto=" + num_contacto + "]";
        assertEquals(expectedString, proveedor.toString());
    }

}
