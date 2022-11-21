package model.DAO

import model.Classes.ConnectionFactory
import model.Classes.Vaga

import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException

class VagaDAO {

    Connection connection

    VagaDAO() {
        this.connection = new ConnectionFactory().getConnection()
    }

    void adiciona(Vaga vaga) {
        def sql = "INSERT INTO vaga(nome,descricao, localvaga, idempresa) VALUES (?, ?, ?, ?)"

        try {
            PreparedStatement stmt = connection.prepareStatement(sql)

            stmt.setString(1, vaga.getNome())
            stmt.setString(2, vaga.getDescricao())
            stmt.setString(3, vaga.getLocalVaga())
            stmt.setInt(4, vaga.getIdEmpresa())

            stmt.execute()
            stmt.close()

        } catch (SQLException ex) {
            throw new Exception(ex)
        }
    }

    void atualiza(Vaga vaga) {
        def sql = "UPDATE vaga SET nome = ?, descricao = ?, localVaga = ? WHERE id = ?"

        try {
            PreparedStatement stmt = connection.prepareStatement(sql)

            stmt.setString(1, vaga.getNome())
            stmt.setString(2, vaga.getDescricao())
            stmt.setString(3, vaga.getLocalVaga())
            stmt.setInt(4, vaga.getId())

            stmt.execute()
            stmt.close()

        } catch (SQLException ex) {
            throw new Exception(ex)
        }
    }

    void remove(Vaga vaga) {

        def sql = "DELETE FROM vaga WHERE id = ?"

        try {
            PreparedStatement stmt = connection.prepareStatement(sql)

            stmt.setInt(1, vaga.getId())

            stmt.execute()
            stmt.close()

        } catch (SQLException ex) {
            throw new Exception(ex)
        }
    }

    List<Vaga> listar() {
        def sql = "SELECT * FROM vaga"

        try {
            List<Vaga> vagas = new ArrayList<Vaga>()
            PreparedStatement stmt = connection.prepareStatement(sql)
            ResultSet rs = stmt.executeQuery()

            while(rs.next()) {
                Vaga vaga = new Vaga()

                vaga.setNome(rs.getString("nome"))
                vaga.setLocalVaga(rs.getString("localVaga"))
                vaga.setDescricao(rs.getString("descricao"))

                vagas.add(vaga)
            }
            rs.close()
            stmt.close()
            return vagas
        } catch (SQLException ex) {
            throw new Exception(ex)
        }
    }
}
