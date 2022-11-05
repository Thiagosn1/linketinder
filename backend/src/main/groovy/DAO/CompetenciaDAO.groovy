package DAO

import Classes.Competencia
import groovy.sql.Sql

class CompetenciaDAO {

    def sql = Sql.newInstance('jdbc:postgresql://localhost:5432/linketinder', 'thiago', '123456789', 'org.postgresql.Driver')

    Competencia competencia = new Competencia()

    void adicionaCompetencia() {

        print "Digite o nome da competencia: "
        competencia.descricao = System.in.newReader().readLine()

        def sqlInsert = "INSERT INTO competencia(descricao) VALUES ($competencia.descricao)"

        sql.execute(sqlInsert)
        sql.close()

        println()
        println 'Competência adicionada'
        println()
    }

    void atualizaCompetencia() {

        listaCompetencias()
        println()

        print "Digite o ID da competência que deseja atualizar: "
        def id = System.in.newReader().readLine()

        print "Digite o novo nome da competência: "
        competencia.descricao = System.in.newReader().readLine()

        def sqlUpdate = "UPDATE competencia SET descricao= $competencia.descricao WHERE ID = $id"

        sql.execute(sqlUpdate)
        sql.close()

        println()
        println 'Competência atualizada'
        println()
    }

     void deletaCompetencia() {

        print "Digite o ID da competência que deseja remover: "
        def id = System.in.newReader().readLine()

        def sqlDelete = "DELETE FROM competencia WHERE ID = $id"

        sql.execute(sqlDelete)
        sql.close()

        println()
        println 'Competência removida'
        println()
    }

    void listaCompetencias() {

        println()
        println 'Lista de Competencias'

        sql.eachRow("SELECT * FROM competencia") { rs ->
            println "Descrição: " + (rs.descricao)
            println()
        }
        sql.close()
    }
}
