package model.DAO

import model.Classes.ConnectionFactory
import model.Classes.Empresa

import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException

class EmpresaDAO {

    Connection connection

    EmpresaDAO() {
        this.connection = new ConnectionFactory().getConnection()
    }

    void adiciona(Empresa empresa) {
        def sql = "INSERT INTO empresa(nome, cnpj, emailCorporativo, pais, cep, descricao, senha) VALUES (?, ?, ?, ?, ?, ?, ?)"

        try {
            PreparedStatement stmt = connection.prepareStatement(sql)

            stmt.setString(1, empresa.getNome())
            stmt.setString(2, empresa.getEmailCorporativo())
            stmt.setString(3, empresa.getPais())
            stmt.setString(4, empresa.getCep())
            stmt.setString(5, empresa.getDescricao())
            stmt.setString(6, empresa.getSenha())

            stmt.execute()
            stmt.close()

        } catch (SQLException ex) {
            throw new Exception(ex)
        }
    }

    void atualiza(Empresa empresa) {
        def sql = "UPDATE empresa SET email = ?, pais = ?, cep = ?, descricaoPessoal = ?, senha = ?  WHERE id = ?"

        try {
            PreparedStatement stmt = connection.prepareStatement(sql)

            stmt.setString(1, empresa.getNome())
            stmt.setString(2, empresa.getEmailCorporativo())
            stmt.setString(3, empresa.getPais())
            stmt.setString(4, empresa.getCep())
            stmt.setString(5, empresa.getDescricao())
            stmt.setString(6, empresa.getSenha())
            stmt.setInt(6, empresa.getId())

            stmt.execute()
            stmt.close()

        } catch (SQLException ex) {
            throw new Exception(ex)
        }
    }

    void remove(Empresa empresa) {
        def sql = "DELETE FROM empresa WHERE id = ?"

        try {
            PreparedStatement stmt = connection.prepareStatement(sql)

            stmt.setInt(1, empresa.getId())

            stmt.execute()
            stmt.close()

        } catch (SQLException ex) {
            throw new Exception(ex)
        }
    }

    List<Empresa> listar() {
        def sql = "SELECT * FROM empresa"

        try {
            List<Empresa> empresas = new ArrayList<Empresa>()
            PreparedStatement stmt = connection.prepareStatement(sql)
            ResultSet rs = stmt.executeQuery()

            while(rs.next()) {
                Empresa empresa = new Empresa()

                empresa.setId(rs.getInt("id"))
                empresa.setNome(rs.getString("nome"))
                empresa.setPais(rs.getString("pais"))
                empresa.setDescricao(rs.getString("descricao"))

                empresas.add(empresa)
            }
            rs.close()
            stmt.close()
            return empresas
        } catch (SQLException ex) {
            throw new Exception(ex)
        }
    }
}
