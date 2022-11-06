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

        try {
            sql.execute(sqlInsert)
            sql.commit()
            println("Competência adicionada")
        } catch(Exception ex) {
            sql.rollback()
            println("Erro ao adicionar competência")
        }
        sql.close()
    }

    void atualizaCompetencia() {

        listaCompetencias()
        println()

        print "Digite o ID da competência que deseja atualizar: "
        def id = System.in.newReader().readLine()

        print "Digite o novo nome da competência: "
        competencia.descricao = System.in.newReader().readLine()

        def sqlUpdate = "UPDATE competencia SET descricao= $competencia.descricao WHERE ID = $id"

        try {
            sql.execute(sqlUpdate)
            sql.commit()
            println("Competência atualizada")
        } catch(Exception ex) {
            sql.rollback()
            println("Erro ao atualizar competência")
        }
        sql.close()
    }

     void deletaCompetencia() {

        print "Digite o ID da competência que deseja remover: "
        def id = System.in.newReader().readLine()

        def sqlDelete = "DELETE FROM competencia WHERE ID = $id"

        try {
            sql.execute(sqlDelete)
            sql.commit()
            println("Competência removida")
        } catch(Exception ex) {
            sql.rollback()
            println("Erro ao remover competência")
        }
        sql.close()
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
