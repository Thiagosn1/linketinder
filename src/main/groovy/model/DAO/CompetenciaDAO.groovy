package model.DAO

import model.Classes.Competencia
import model.Classes.ConnectionFactory

import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException

class CompetenciaDAO {

    Connection connection

    CompetenciaDAO() {
        this.connection = new ConnectionFactory().getConnection()
    }

    void adiciona(Competencia competencia) {

        def sql = "INSERT INTO competencia(descricao) VALUES (?)"

        try {
            PreparedStatement stmt = connection.prepareStatement(sql)

            stmt.setString(1, competencia.getDescricao())

            stmt.execute()
            stmt.close()

        } catch (SQLException ex) {
            throw new Exception(ex)
        }
    }

    void atualiza(Competencia competencia) {
        def sql = "UPDATE competencia SET descricao= ? WHERE ID = ?"

        try {
            PreparedStatement stmt = connection.prepareStatement(sql)

            stmt.setString(1, competencia.getDescricao())

            stmt.execute()
            stmt.close()

        } catch (SQLException ex) {
            throw new Exception(ex)
        }
    }

    void remove(Competencia competencia) {
        def sql = "DELETE FROM competencia WHERE id = ?"

        try {
            PreparedStatement stmt = connection.prepareStatement(sql)

            stmt.setInt(1, competencia.getId())

            stmt.execute()
            stmt.close()

        } catch (SQLException ex) {
            throw new Exception(ex)
        }
    }

    List<Competencia> listar() {
        def sql = "SELECT * FROM competencia"

        try {
            List<Competencia> competencias = new ArrayList<Competencia>()
            PreparedStatement stmt = connection.prepareStatement(sql)
            ResultSet rs = stmt.executeQuery()

            while(rs.next()) {
                Competencia competencia = new Competencia()

                competencia.setId(rs.getInt("id"))
                competencia.setDescricao(rs.getString("descricao"))

                competencias.add(competencia)
            }
            rs.close()
            stmt.close()
            return competencias
        } catch (SQLException ex) {
            throw new Exception(ex)
        }
    }
}