package DAO

import Classes.Competencia
import groovy.sql.Sql

import java.sql.SQLException

class CompetenciaDAO {

    static void adicionaCompetencia() {

        Competencia competencia = new Competencia()

        def sql = Sql.newInstance('jdbc:postgresql://localhost:5432/linketinder', 'thiago', '123456789', 'org.postgresql.Driver')

        print "Digite o nome da competencia: "
        competencia.descricao = System.in.newReader().readLine()

        def sqlInsert = "INSERT INTO competencia(descricao) VALUES ($competencia.descricao)"

        try {
            sql.execute(sqlInsert)
            println("Competência adicionada")
        } catch (SQLException ex) {
            println("Erro ao adicionar competência " + ex)
        }
        sql.close()
    }

    static void atualizaCompetencia() {

        Competencia competencia = new Competencia()

        def sql = Sql.newInstance('jdbc:postgresql://localhost:5432/linketinder', 'thiago', '123456789', 'org.postgresql.Driver')

        print "Digite o nome da competência que deseja atualizar: "
        def nome = System.in.newReader().readLine()

        print "Digite o novo nome da competência: "
        competencia.descricao = System.in.newReader().readLine()

        def sqlUpdate = "UPDATE competencia SET descricao= $competencia.descricao WHERE ID = $nome"

        try {
            sql.execute(sqlUpdate)
            println("Competência atualizada")
        } catch (SQLException ex) {
            println("Erro ao atualizar competência" + ex)
        }
        sql.close()
    }

    static void deletaCompetencia() {

        def sql = Sql.newInstance('jdbc:postgresql://localhost:5432/linketinder', 'thiago', '123456789', 'org.postgresql.Driver')

        print "Digite o nome da competência que deseja remover: "
        def nome = System.in.newReader().readLine()

        def sqlDelete = "DELETE FROM competencia WHERE ID = $nome"

        try {
            sql.execute(sqlDelete)
            println("Competência removida")
        } catch (SQLException ex) {
            println("Erro ao remover competência" + ex)
        }
        sql.close()
    }

    static void listaCompetencias() {

        println()
        println 'Lista de Competencias'

        def sql = Sql.newInstance('jdbc:postgresql://localhost:5432/linketinder', 'thiago', '123456789', 'org.postgresql.Driver')

        sql.eachRow("SELECT * FROM competencia") { rs ->
            println "Descrição: " + (rs.descricao)
            println()
        }
        sql.close()
    }
}
