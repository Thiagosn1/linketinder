package model.DAO


import model.Classes.Candidato
import model.Classes.ConnectionFactory

import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException

class CandidatoDAO {

    Connection connection

    CandidatoDAO() {
        this.connection = new ConnectionFactory().getConnection()
    }

    void adiciona(Candidato candidato) {

        def sql = "INSERT INTO candidato(nome, sobrenome, dt_nasc, email, cpf, pais, cep, descricaoPessoal, senha) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)"

        try {
            PreparedStatement stmt = connection.prepareStatement(sql)

            stmt.setString(1, candidato.getNome())
            stmt.setString(2, candidato.getSobrenome())
            stmt.setString(3, candidato.getDt_nasc())
            stmt.setString(4, candidato.getEmail())
            stmt.setString(5, candidato.getCpf())
            stmt.setString(6, candidato.getPais())
            stmt.setString(7, candidato.getCep())
            stmt.setString(8, candidato.getDescricaoPessoal())
            stmt.setString(9, candidato.getSenha())

            stmt.execute()
            stmt.close()

        } catch (SQLException ex) {
            throw new Exception(ex)
        }
    }

    void atualiza(Candidato candidato) {
        def sql = "UPDATE candidato SET email = ?, pais = ?, cep = ?, descricaoPessoal = ?, senha = ?  WHERE id = ?"

        try {
            PreparedStatement stmt = connection.prepareStatement(sql)

            stmt.setString(1, candidato.getEmail())
            stmt.setString(2, candidato.getPais())
            stmt.setString(3, candidato.getCep())
            stmt.setString(4, candidato.getDescricaoPessoal())
            stmt.setString(5, candidato.getSenha())
            stmt.setInt(6, candidato.getId())

            stmt.execute()
            stmt.close()

        } catch (SQLException ex) {
            throw new Exception(ex)
        }
    }

    void remove(Candidato candidato) {
        def sql = "DELETE FROM candidato WHERE id = ?"

        try {
            PreparedStatement stmt = connection.prepareStatement(sql)

            stmt.setInt(1, candidato.getId())

            stmt.execute()
            stmt.close()

        } catch (SQLException ex) {
            throw new Exception(ex)
        }
    }

    List<Candidato> listar() {
        def sql = "SELECT * FROM candidato"

        try {
            List<Candidato> candidatos = new ArrayList<Candidato>()
            PreparedStatement stmt = connection.prepareStatement(sql)
            ResultSet rs = stmt.executeQuery()

            while(rs.next()) {
                Candidato candidato = new Candidato()

                candidato.setId(rs.getInt("id"))
                candidato.setNome(rs.getString("nome"))
                candidato.setSobrenome(rs.getString("sobrenome"))
                candidato.setEmail(rs.getString("email"))
                candidato.setPais(rs.getString("pais"))
                candidato.setDescricaoPessoal(rs.getString("descricaoPessoal"))

                candidatos.add(candidato)
            }
            rs.close()
            stmt.close()
            return candidatos
        } catch (SQLException ex) {
            throw new Exception(ex)
        }
    }
}
