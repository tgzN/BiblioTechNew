/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bibliotechnew.service;

import com.mycompany.bibliotechnew.model.Livro;
import com.mycompany.bibliotechnew.repository.LivroRepository;
import java.util.List;

public class LivroService {
    private LivroRepository livroRepo;

    public LivroService() {
        this.livroRepo = new LivroRepository();
    }

    public Livro cadastrarLivro(Livro livro) {
    if (livro.getTitulo() == null || livro.getTitulo().isEmpty()) {
        throw new IllegalArgumentException("Título obrigatório");
    }
    if (livro.getAutor() == null || livro.getAutor().isEmpty()) {
        throw new IllegalArgumentException("Autor obrigatório");
    }
    livro.setStatus("Disponível");
    livroRepo.salvar(livro);
    return livro;
}

    public Livro buscarLivroPorTitulo(String titulo) {
    return livroRepo.buscarPorTitulo(titulo);
}


    public void atualizarLivro(Livro livro) {
        livroRepo.atualizar(livro);
    }

    public void deletarLivro(int id) {
        livroRepo.deletar(id);
    }

    public Livro buscarLivro(int id) {
        return livroRepo.buscarPorId(id);
    }

    public List<Livro> listarLivros() {
        return livroRepo.listarTodos();
    }
}
