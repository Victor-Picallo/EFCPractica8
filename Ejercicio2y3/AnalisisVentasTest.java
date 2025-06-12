package Ejercicio2y3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class AnalisisVentasTest {
    @Test
    void testContarVentasAltas() {
        AnalisisVentas av = new AnalisisVentas();
        int r = av.contarVentasAltas();
        assertEquals(5, r);
    }

    @Test
    void testContarVentasAltasNulo() {
        AnalisisVentas av = new AnalisisVentas();
        av.ventas = null;
        assertThrows(IllegalArgumentException.class, () -> av.contarVentasAltas());
    }

    @Test
    void testContarVentasAltasVacio() {
        AnalisisVentas av = new AnalisisVentas();
        av.ventas = new double[0];
        assertThrows(IllegalArgumentException.class, () -> av.contarVentasAltas());
    }

    @Test
    void testContarVentasAltasMixtos() {
        AnalisisVentas av = new AnalisisVentas();
        av.ventas = new double[] { 160.0, -180.0, 190.0 };
        int r = av.contarVentasAltas();
        assertEquals(2, r);
    }

    @Test
    void testVentaMasRepetida() {
        AnalisisVentas av = new AnalisisVentas();
        av.ventas = new double[] {160.0, 170.0, 170.0, 150.0};
        double r = av.ventaMasRepetida();
        assertEquals(170.0, r, 0.01);
    }

    @Test
    void testVentaMasRepetidaDoble() {
        AnalisisVentas av = new AnalisisVentas();
        double r = av.ventaMasRepetida();
        assertTrue(r == 120.5 || r == 85.0);
    }

    @Test
    void testVentaMasRepetidaNulo() {
        AnalisisVentas av = new AnalisisVentas();
        av.ventas = null;
        assertThrows(IllegalArgumentException.class,() -> av.ventaMasRepetida());
    }

    @Test
    void testVentaMasRepetidaVacio() {
        AnalisisVentas av = new AnalisisVentas();
        av.ventas = new double[0];
        assertThrows(IllegalArgumentException.class,() -> av.ventaMasRepetida());
    }

    @Test
    void testVentaMinima() {
        AnalisisVentas av = new AnalisisVentas();
        double r = av.ventaMinima();
        assertEquals(85.0,r, 0.01);
    }

    @Test
    void testVentaMinimaNulo() {
        AnalisisVentas av = new AnalisisVentas();
        av.ventas = null;
        assertThrows(IllegalArgumentException.class,() -> av.ventaMinima());
    }

    @Test
    void testVentaMinimaVacio() {
        AnalisisVentas av = new AnalisisVentas();
        av.ventas = new double[0];
        assertThrows(IllegalArgumentException.class,() -> av.ventaMinima());
    }

    @Test
    void testVentaMinimaMixto() {
        AnalisisVentas av = new AnalisisVentas();
        av.ventas = new double[] {-10.0, 75.0, 100.0};
        double r = av.ventaMinima();
        assertEquals(-10.0,r, 0.01);
    }
}
