/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bibliotechnew.util;

import org.junit.jupiter.api.Test;

public class CalculoMultaTest {

    @Test
    public void testCalcularMulta() {
        assertEquals(10.0, CalculoMulta.calcularMulta(5));
        assertEquals(0.0, CalculoMulta.calcularMulta(0));
        assertEquals(0.0, CalculoMulta.calcularMulta(-3));
    }
}