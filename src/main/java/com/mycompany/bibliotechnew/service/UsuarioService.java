package com.mycompany.bibliotechnew.service;

import com.mycompany.bibliotechnew.model.Usuario;
import com.mycompany.bibliotechnew.repository.UsuarioRepository;
import java.util.List;

public class UsuarioService {
    private UsuarioRepository usuarioRepo;

    public UsuarioService() {
        this.usuarioRepo = new UsuarioRepository();
    }

    public Usuario cadastrarUsuario(Usuario usuario) {
        if (usuario.getNome() == null || usuario.getNome().isEmpty()) {
            throw new IllegalArgumentException("Nome obrigatório");
        }
        if (usuario.getEmail() == null || usuario.getEmail().isEmpty()) {
            throw new IllegalArgumentException("Email obrigatório");
        }
        usuarioRepo.salvar(usuario); // salva no banco
        return usuario; // retorna o usuário com ID atualizado
    }

    public void atualizarUsuario(Usuario usuario) {
        usuarioRepo.atualizar(usuario);
    }

    public void deletarUsuario(int id) {
        usuarioRepo.deletar(id);
    }

    public Usuario buscarUsuario(int id) {
        return usuarioRepo.buscarPorId(id);
    }

    public Usuario buscarUsuarioPorEmail(String email) {
    return usuarioRepo.buscarPorEmail(email);
}

    public List<Usuario> listarUsuarios() {
        return usuarioRepo.listarTodos();
    }
}
