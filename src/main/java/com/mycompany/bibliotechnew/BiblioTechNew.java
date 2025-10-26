package com.mycompany.bibliotechnew;

import com.mycompany.bibliotechnew.model.Livro;
import com.mycompany.bibliotechnew.model.Usuario;
import com.mycompany.bibliotechnew.model.Emprestimo;
import com.mycompany.bibliotechnew.service.LivroService;
import com.mycompany.bibliotechnew.service.UsuarioService;
import com.mycompany.bibliotechnew.service.EmprestimoService;

import java.time.LocalDate;
import java.util.List;

public class BiblioTechNew {
    public static void main(String[] args) {

        // Serviços
        LivroService livroService = new LivroService();
        UsuarioService usuarioService = new UsuarioService();
        EmprestimoService emprestimoService = new EmprestimoService();

        // 1️⃣ Criar ou buscar usuário
        Usuario u1 = usuarioService.buscarUsuarioPorEmail("tiago@email.com");
        if (u1 == null) {
            u1 = new Usuario("Tiago Neneve", "tiago@email.com", "123456", "Bibliotecário", "ADMIN");
            u1 = usuarioService.cadastrarUsuario(u1);
        }

        // 2️⃣ Criar ou buscar livros
        Livro l1 = livroService.buscarLivroPorTitulo("O Senhor dos Anéis");
        if (l1 == null) {
            l1 = new Livro(0, "O Senhor dos Anéis", "J.R.R. Tolkien", "Fantasia", "Disponível");
            l1 = livroService.cadastrarLivro(l1);
        }

        Livro l2 = livroService.buscarLivroPorTitulo("1984");
        if (l2 == null) {
            l2 = new Livro(0, "1984", "George Orwell", "Distopia", "Disponível");
            l2 = livroService.cadastrarLivro(l2);
        }

        // 3️⃣ Listar livros
        System.out.println("=== Livros cadastrados ===");
        List<Livro> livros = livroService.listarLivros();
        for (Livro l : livros) {
            System.out.println(l.getId() + " - " + l.getTitulo() + " - " + l.getStatus());
        }

        // 4️⃣ Registrar empréstimo
        Emprestimo e1 = new Emprestimo(0, l1.getId(), u1.getId(),
                LocalDate.now().toString(),
                LocalDate.now().plusDays(7).toString(),
                null);
        emprestimoService.registrarEmprestimo(e1);

        System.out.println("Empréstimo registrado para livro: " + l1.getTitulo());

        // 5️⃣ Listar empréstimos
        System.out.println("=== Empréstimos ===");
        List<Emprestimo> emprestimos = emprestimoService.listarEmprestimos();
        for (Emprestimo e : emprestimos) {
            System.out.println(e.getId() + " - Livro ID: " + e.getIdLivro() + " - Usuário ID: " + e.getIdLeitor());
        }

        // 6️⃣ Registrar devolução
        e1.setDataDevolucaoReal(LocalDate.now().plusDays(5).toString());
        emprestimoService.registrarDevolucao(e1);
        System.out.println("Livro devolvido: " + l1.getTitulo());

        // 7️⃣ Atualizar e deletar
        l2.setStatus("Indisponível");
        livroService.atualizarLivro(l2);
        livroService.deletarLivro(l1.getId());

        System.out.println("Teste finalizado!");
    }
}
