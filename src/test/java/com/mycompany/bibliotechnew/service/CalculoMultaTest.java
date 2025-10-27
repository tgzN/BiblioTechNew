package com.mycompany.bibliotechnew.service;

import com.mycompany.bibliotechnew.util.CalculoMulta;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CalculoMultaTest {

    @Test
    public void testCalcularMulta() {
        assertEquals(10.0, CalculoMulta.calcularMulta(5), 0.001);
        assertEquals(0.0, CalculoMulta.calcularMulta(0), 0.001);
        assertEquals(0.0, CalculoMulta.calcularMulta(-3), 0.001);
    }
}
