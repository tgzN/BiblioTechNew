/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bibliotechnew.service;

import com.mycompany.bibliotechnew.model.Livro;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class LivroTest {

    @Test
    public void testStatusInicialLivro() {
        // Cria um livro sem passar o status, deve ser "Disponível"
        Livro livro = new Livro("O Senhor dos Anéis", "J.R.R. Tolkien", "Fantasia");

        // Verifica se o status inicial é "Disponível"
        assertEquals("Disponível", livro.getStatus());

        // Verifica se os getters retornam os valores corretos
        assertEquals("O Senhor dos Anéis", livro.getTitulo());
        assertEquals("J.R.R. Tolkien", livro.getAutor());
        assertEquals("Fantasia", livro.getGenero());

        // Testa alteração do status com setter
        livro.setStatus("Emprestado");
        assertEquals("Emprestado", livro.getStatus());
    }
}
