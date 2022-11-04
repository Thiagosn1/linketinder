package DAO

import groovy.sql.Sql
import Classes.Vaga

class VagaDAO {

    Vaga vaga = new Vaga()

    void adicionaVaga() {

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

        sql.execute(sqlInsert)
        sql.close()

        println()
        println 'Vaga adicionada'
        println()
    }

    void atualizaVaga() {
        def sql = Sql.newInstance('jdbc:postgresql://localhost:5432/linketinder', 'thiago', '123456789', 'org.postgresql.Driver')

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

        sql.execute(sqlUpdate)
        sql.close()

        println()
        println 'Vaga atualizada'
        println()
    }

    static void deletaVaga() {
        def sql = Sql.newInstance('jdbc:postgresql://localhost:5432/linketinder', 'thiago', '123456789', 'org.postgresql.Driver')

        listaVagas()
        println()

        print "Digite o ID da vaga que deseja remover: "
        def id = System.in.newReader().readLine()

        def sqlDelete = "DELETE FROM vaga WHERE ID = $id"

        sql.execute(sqlDelete)
        sql.close()

        println()
        println 'Vaga removida'
        println()
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
