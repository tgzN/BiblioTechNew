/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bibliotechnew.service;

import com.mycompany.bibliotechnew.model.Emprestimo;
import com.mycompany.bibliotechnew.model.Livro;
import com.mycompany.bibliotechnew.repository.EmprestimoRepository;
import com.mycompany.bibliotechnew.repository.LivroRepository;
import java.util.List;

public class EmprestimoService {
    private EmprestimoRepository emprestimoRepo;
    private LivroRepository livroRepo;

    public EmprestimoService() {
        this.emprestimoRepo = new EmprestimoRepository();
        this.livroRepo = new LivroRepository();
    }

    public void registrarEmprestimo(Emprestimo emprestimo) {
        Livro livro = livroRepo.buscarPorId(emprestimo.getIdLivro());
        if (livro == null) {
            throw new IllegalArgumentException("Livro não encontrado");
        }
        if (!livro.getStatus().equals("Disponível")) {
            throw new IllegalArgumentException("Livro indisponível");
        }
        livro.setStatus("Emprestado");
        livroRepo.atualizar(livro);
        emprestimoRepo.salvar(emprestimo);
    }

    public void registrarDevolucao(Emprestimo emprestimo) {
        Livro livro = livroRepo.buscarPorId(emprestimo.getIdLivro());
        if (livro != null) {
            livro.setStatus("Disponível");
            livroRepo.atualizar(livro);
        }
        emprestimoRepo.atualizar(emprestimo);
    }

    public Emprestimo buscarEmprestimo(int id) {
        return emprestimoRepo.buscarPorId(id);
    }

    public List<Emprestimo> listarEmprestimos() {
        return emprestimoRepo.listarTodos();
    }
}
