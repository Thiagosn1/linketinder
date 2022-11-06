package model.DAO

import groovy.sql.Sql
import model.Classes.Vaga

import java.sql.SQLException

class VagaDAO {

    static void adicionaVaga() {

        Vaga vaga = new Vaga()

        def sql = Sql.newInstance('jdbc:postgresql://localhost:5432/linketinder', 'thiago', '123456789', 'org.postgresql.Driver')

        print "Digite o nome da vaga: "
        vaga.nome = System.in.newReader().readLine()
        print "Digite a descrição da vaga: "
        vaga.descricao = System.in.newReader().readLine()
        print "Digite o local da vaga: "
        vaga.localVaga = System.in.newReader().readLine()
        print "Digite o id da empresa: "
        vaga.idEmpresa = System.in.newReader().readLine()

        def sqlInsert = "INSERT INTO vaga(nome,descricao, localvaga, idempresa) VALUES ($vaga.nome,$vaga.descricao, $vaga.localVaga, $vaga.idEmpresa)"

        try {
            sql.execute(sqlInsert)
            println("Vaga adicionada")
        } catch(SQLException ex) {
            println("Erro ao adicionar vaga " + ex)
        }
        sql.close()
    }

    static void atualizaVaga() {

        Vaga vaga = new Vaga()

        def sql = Sql.newInstance('jdbc:postgresql://localhost:5432/linketinder', 'thiago', '123456789', 'org.postgresql.Driver')

        print "Digite o nome da vaga que deseja atualizar: "
        def nome = System.in.newReader().readLine()

        println()

        print "Digite o novo nome da Vaga: "
        vaga.nome = System.in.newReader().readLine()
        print "Digite a nova descrição da vaga: "
        vaga.descricao = System.in.newReader().readLine()
        print "Digite o novo local da vaga: "
        vaga.localVaga = System.in.newReader().readLine()

        def sqlUpdate = "UPDATE vaga SET nome = $vaga.nome, descricao = $vaga.descricao, localVaga = $vaga.localVaga WHERE nome = $nome"

        try {
            sql.execute(sqlUpdate)
            println("Vaga atualizada")
        } catch(SQLException ex) {
            println("Erro ao atualizar vaga " + ex)
        }
        sql.close()
    }

    static void deletaVaga() {

        def sql = Sql.newInstance('jdbc:postgresql://localhost:5432/linketinder', 'thiago', '123456789', 'org.postgresql.Driver')

        print "Digite o nome da vaga que deseja remover: "
        def nome = System.in.newReader().readLine()

        def sqlDelete = "DELETE FROM vaga WHERE ID = $nome"

        try {
            sql.execute(sqlDelete)
            println("Vaga removida")
        } catch(SQLException ex) {
            println("Erro ao remover vaga " + ex)
        }
        sql.close()
    }

    static void listaVagas() {

        println()
        println 'Lista de Vagas'

        def sql = Sql.newInstance('jdbc:postgresql://localhost:5432/linketinder', 'thiago', '123456789', 'org.postgresql.Driver')

        sql.eachRow("SELECT * FROM vaga") { rs ->
            println "Nome: " + (rs.descricao)
            println "Descrição: " + (rs.descricao)
            println "Local da Vaga: " + (rs.localVaga)
            println()
        }
        sql.close()
    }
}
