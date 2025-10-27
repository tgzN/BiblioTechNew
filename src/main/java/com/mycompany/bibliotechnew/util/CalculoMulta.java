/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bibliotechnew.util;

public class CalculoMulta {

    public static double calcularMulta(int diasAtraso) {
        if (diasAtraso <= 0) {
            return 0.0;
        }
        return diasAtraso * 2.0;
    }
}
