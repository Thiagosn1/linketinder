package DAO

import groovy.sql.Sql
import Classes.Vaga

class VagaDAO {

    def sql = Sql.newInstance('jdbc:postgresql://localhost:5432/linketinder', 'thiago', '123456789', 'org.postgresql.Driver')

    Vaga vaga = new Vaga()

    void adicionaVaga() {

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
            sql.commit()
            println("Vaga adicionada")
        } catch(Exception ex) {
            sql.rollback()
            println("Erro ao adicionar vaga")
        }
        sql.close()
    }

    void atualizaVaga() {

        listaVagas()
        println()

        print "Digite o ID da vaga que deseja atualizar: "
        def id = System.in.newReader().readLine()

        println()

        print "Digite o novo nome da Vaga: "
        vaga.nome = System.in.newReader().readLine()
        print "Digite a nova descrição da vaga: "
        vaga.descricao = System.in.newReader().readLine()
        print "Digite o novo local da vaga: "
        vaga.localVaga = System.in.newReader().readLine()

        def sqlUpdate = "UPDATE vaga SET nome = $vaga.nome, descricao = $vaga.descricao, localVaga = $vaga.localVaga WHERE ID = $id"

        try {
            sql.execute(sqlUpdate)
            sql.commit()
            println("Vaga atualizada")
        } catch(Exception ex) {
            sql.rollback()
            println("Erro ao atualizar vaga")
        }
        sql.close()
    }

    void deletaVaga() {

        listaVagas()
        println()

        print "Digite o ID da vaga que deseja remover: "
        def id = System.in.newReader().readLine()

        def sqlDelete = "DELETE FROM vaga WHERE ID = $id"

        try {
            sql.execute(sqlDelete)
            sql.commit()
            println("Vaga removida")
        } catch(Exception ex) {
            sql.rollback()
            println("Erro ao remover vaga")
        }
        sql.close()
    }

    void listaVagas() {

        println()
        println 'Lista de Vagas'
        
        sql.eachRow("SELECT * FROM vaga") { rs ->
            println "Nome: " + (rs.descricao)
            println "Descrição: " + (rs.descricao)
            println "Local da Vaga: " + (rs.localVaga)
            println()
        }
        sql.close()
    }
}
