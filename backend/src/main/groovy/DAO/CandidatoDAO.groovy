package DAO

import groovy.sql.Sql
import Classes.Candidato
class CandidatoDAO {

    Candidato candidato = new Candidato()

    void adicionaCandidato() {
        def sql = Sql.newInstance('jdbc:postgresql://localhost:5432/linketinder', 'thiago', '123456789', 'org.postgresql.Driver')

        print "Digite o nome do candidato: "
        candidato.nome = System.in.newReader().readLine()
        print "Digite o sobrenome do candidato: "
        candidato.sobrenome = System.in.newReader().readLine()
        print "Digite a data de nascimento do candidato: "
        candidato.dt_nasc = System.in.newReader().readLine()
        print "Digite o email do candidato: "
        candidato.email = System.in.newReader().readLine()
        print "Digite o CPF do candidato: "
        candidato.cpf = System.in.newReader().readLine()
        print "Digite o país do candidato: "
        candidato.pais = System.in.newReader().readLine()
        print "Digite o CEP do candidato: "
        candidato.cep = System.in.newReader().readLine()
        print "Digite a descrição do candidato: "
        candidato.descricaoPessoal = System.in.newReader().readLine()
        print "Digite a senha do candidato: "
        candidato.senha = System.in.newReader().readLine()

        def sqlInsert = "INSERT INTO candidato(nome, sobrenome, dt_nasc, email, cpf, pais, cep, descricaoPessoal, senha) VALUES ($candidato.nome, $candidato.sobrenome, $candidato.dt_nasc, '$candidato.email, $candidato.cpf, $candidato.pais, $candidato.cep, $candidato.descricaoPessoal, $candidato.senha)"

        sql.execute(sqlInsert)
        sql.close()

        println()
        println 'Candidato adicionado'
        println()
    }

    void atualizaCandidato() {
        def sql = Sql.newInstance('jdbc:postgresql://localhost:5432/linketinder', 'thiago', '123456789', 'org.postgresql.Driver')

        listaCandidatos()
        println()

        print "Digite o ID do candidato que deseja atualizar: "
        def id = System.in.newReader().readLine()

        print "Digite o novo email da candidato: "
        candidato.email = System.in.newReader().readLine()
        print "Digite a nova descrição do candidato: "
        candidato.descricaoPessoal = System.in.newReader().readLine()
        print "Digite a nova senha da candidato: "
        candidato.senha = System.in.newReader().readLine()

        def sqlUpdate = "UPDATE candidato SET email = $candidato.email, descricaoPessoal = $candidato.descricaoPessoal, senha = $candidato.senha  WHERE ID = $id"

        sql.execute(sqlUpdate)
        sql.close()

        println()
        println 'Candidato atualizado'
        println()
    }

    void deletaCandidato() {
        def sql = Sql.newInstance('jdbc:postgresql://localhost:5432/linketinder', 'thiago', '123456789', 'org.postgresql.Driver')

        print "Digite o ID do candidato que deseja atualizar: "
        def id = System.in.newReader().readLine()

        def sqlDelete = "DELETE FROM candidato WHERE ID = $id"

        sql.execute(sqlDelete)
        sql.close()

        println()
        println 'Candidato removido'
        println()
    }

    void listaCandidatos() {

        println()
        println 'Lista de Candidatos'

        def sql = Sql.newInstance('jdbc:postgresql://localhost:5432/linketinder', 'thiago', '123456789', 'org.postgresql.Driver')
        sql.eachRow("SELECT * FROM candidato") { rs ->
            println "Nome: " + (rs.nome)
            println "Descrição: " + (rs.descricaoPessoal)
            println "Email: " + (rs.email)
            println "País: " + (rs.pais)
            println("Competências: ")
            println()
        }
        sql.close()
    }
}
