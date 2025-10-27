
package com.mycompany.bibliotechnew.model;

public class Usuario {
    private int id;
    private String nome;
    private String email;
    private String senha;
    private String cargo;
    private String permissoes;

    public Usuario(int id, String nome, String email, String senha, String cargo) {
    this.id = id;
    this.nome = nome;
    this.email = email;
    this.senha = senha;
    this.cargo = cargo;
}
    
    public Usuario(String nome, String email, String senha, String cargo, String permissoes) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cargo = cargo;
        this.permissoes = permissoes;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public String getCargo() {
        return cargo;
    }

    public String getPermissoes() {
        return permissoes;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setPermissoes(String permissoes) {
        this.permissoes = permissoes;
    }

    public String getPerfil() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
