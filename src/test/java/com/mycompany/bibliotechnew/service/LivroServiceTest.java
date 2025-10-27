package com.mycompany.bibliotechnew.service;

import com.mycompany.bibliotechnew.model.Livro;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class LivroServiceTest {

    @Test
    public void testDisponibilidadeLivro() {
        // Cria um livro usando o construtor que define status como "Disponível"
        Livro livro = new Livro("O Senhor dos Anéis", "J.R.R. Tolkien", "Fantasia");

        // Verifica se o status inicial é "Disponível"
        assertTrue(livro.getStatus().equals("Disponível"));

        // Simula empréstimo
        livro.setStatus("Emprestado");
        assertTrue(livro.getStatus().equals("Emprestado"));

        // Devolução
        livro.setStatus("Disponível");
        assertTrue(livro.getStatus().equals("Disponível"));
    }
}
