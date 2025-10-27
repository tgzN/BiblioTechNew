package com.mycompany.bibliotechnew.repository;

import com.mycompany.bibliotechnew.model.Emprestimo;
import com.mycompany.bibliotechnew.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmprestimoRepository {

    public void salvar(Emprestimo emprestimo) {
        String sql = "INSERT INTO emprestimos (idLivro, idLeitor, dataEmprestimo, dataDevolucaoPrevista, dataDevolucaoReal) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, emprestimo.getIdLivro());
            stmt.setInt(2, emprestimo.getIdLeitor());
            stmt.setString(3, emprestimo.getDataEmprestimo());
            stmt.setString(4, emprestimo.getDataDevolucaoPrevista());
            stmt.setString(5, emprestimo.getDataDevolucaoReal());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Emprestimo buscarPorId(int id) {
        String sql = "SELECT * FROM emprestimos WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Emprestimo(
                        rs.getInt("id"),
                        rs.getInt("idLivro"),
                        rs.getInt("idLeitor"),
                        rs.getString("dataEmprestimo"),
                        rs.getString("dataDevolucaoPrevista"),
                        rs.getString("dataDevolucaoReal")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Emprestimo> listarTodos() {
        List<Emprestimo> lista = new ArrayList<>();
        String sql = "SELECT * FROM emprestimos";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(new Emprestimo(
                        rs.getInt("id"),
                        rs.getInt("idLivro"),
                        rs.getInt("idLeitor"),
                        rs.getString("dataEmprestimo"),
                        rs.getString("dataDevolucaoPrevista"),
                        rs.getString("dataDevolucaoReal")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void atualizar(Emprestimo emprestimo) {
        String sql = "UPDATE emprestimos SET idLivro=?, idLeitor=?, dataEmprestimo=?, dataDevolucaoPrevista=?, dataDevolucaoReal=? WHERE id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, emprestimo.getIdLivro());
            stmt.setInt(2, emprestimo.getIdLeitor());
            stmt.setString(3, emprestimo.getDataEmprestimo());
            stmt.setString(4, emprestimo.getDataDevolucaoPrevista());
            stmt.setString(5, emprestimo.getDataDevolucaoReal());
            stmt.setInt(6, emprestimo.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletar(int id) {
        String sql = "DELETE FROM emprestimos WHERE id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
