package model.DAO

import model.Classes.Empresa
import groovy.sql.Sql

import java.sql.SQLException

class EmpresaDAO {

    static void adicionaEmpresa() {

        Empresa empresa = new Empresa()

        def sql = Sql.newInstance('jdbc:postgresql://localhost:5432/linketinder', 'thiago', '123456789', 'org.postgresql.Driver')

        print "Digite o nome da empresa: "
        empresa.nome = System.in.newReader().readLine()
        print "Digite o CNPJ da empresa: "
        empresa.cnpj = System.in.newReader().readLine()
        print "Digite o email da empresa: "
        empresa.email = System.in.newReader().readLine()
        print "Digite o país da empresa: "
        empresa.pais = System.in.newReader().readLine()
        print "Digite o cep da empresa: "
        empresa.cep = System.in.newReader().readLine()
        print "Digite a descricao da empresa: "
        empresa.descricao = System.in.newReader().readLine()
        print "Digite a senha da empresa: "
        empresa.senha = System.in.newReader().readLine()

        def sqlInsert = "INSERT INTO empresa(nome, cnpj, emailCorporativo, pais, cep, descricao, senha) VALUES ($empresa.nome, $empresa.cnpj, $empresa.email, $empresa.pais, $empresa.cep, $empresa.descricao, $empresa.senha)"

        try {
            sql.execute(sqlInsert)
            println("Empresa adicionada")
        } catch (SQLException ex) {
            println("Erro ao adicionar empresa" + ex)
        }
        sql.close()
    }

    static void atualizaEmpresa() {
        Empresa empresa = new Empresa()

        def sql = Sql.newInstance('jdbc:postgresql://localhost:5432/linketinder', 'thiago', '123456789', 'org.postgresql.Driver')

        print "Digite o nome da empresa que deseja atualizar: "
        def nome = System.in.newReader().readLine()

        print "Digite o novo nome da empresa: "
        empresa.nome = System.in.newReader().readLine()
        print "Digite o novo email da empresa: "
        empresa.email = System.in.newReader().readLine()
        print "Digite a senha da empresa: "
        empresa.senha = System.in.newReader().readLine()

        def sqlUpdate = "UPDATE empresa SET nome= $empresa.nome, emailcorporativo = $empresa.email, senha = $empresa.senha WHERE nome = $nome"

        try {
            sql.execute(sqlUpdate)
            println("Empresa atualizada")
        } catch (SQLException ex) {
            println("Erro ao atualizar empresa " + ex)
        }
        sql.close()
    }

    static void deletaEmpresa() {

        def sql = Sql.newInstance('jdbc:postgresql://localhost:5432/linketinder', 'thiago', '123456789', 'org.postgresql.Driver')

        print "Digite o nome da empresa que deseja remover: "
        def nome = System.in.newReader().readLine()

        def sqlDelete = "DELETE FROM empresa WHERE nome = $nome"

        try {
            sql.execute(sqlDelete)
            println("Empresa removida")
        } catch (SQLException ex) {
            println("Erro ao remover empresa " + ex)
        }
        sql.close()
    }

    static void listaEmpresas() {

        println()
        println 'Lista de Empresas'

        def sql = Sql.newInstance('jdbc:postgresql://localhost:5432/linketinder', 'thiago', '123456789', 'org.postgresql.Driver')

        sql.eachRow("SELECT * FROM empresa") { rs ->
            println "Nome: " + (rs.nome)
            println "Descrição: " + (rs.descricao)
            println "País: " + (rs.pais)
            println("Competências: ")
            println()
        }
        sql.close()
    }
}
