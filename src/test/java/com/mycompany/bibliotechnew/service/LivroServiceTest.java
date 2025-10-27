/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bibliotechnew.service;

import com.mycompany.bibliotechnew.model.Livro;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LivroServiceTest {

    @Test
    void testDisponibilidadeLivro() {
        Livro livro = new Livro(1, "O Senhor dos Anéis", true);
        
        // Verifica se o livro está disponível
        assertTrue(livro.isDisponivel());
        
        // Simula empréstimo
        livro.setDisponivel(false);
        assertFalse(livro.isDisponivel());
    }
}
