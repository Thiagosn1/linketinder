package model.DAO

import groovy.sql.Sql
import model.Classes.Candidato
import java.sql.SQLException

class CandidatoDAO {

    static void adicionaCandidato() {

        Candidato candidato = new Candidato()

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

        try {
            sql.execute(sqlInsert)
            println("Candidato adicionado")
        } catch (SQLException ex) {
            println("Erro ao adicionar candidato" + ex)
        }
        sql.close()
    }

    static void atualizaCandidato() {
        Candidato candidato = new Candidato()

        def sql = Sql.newInstance('jdbc:postgresql://localhost:5432/linketinder', 'thiago', '123456789', 'org.postgresql.Driver')

        print "Digite o nome do candidato que deseja atualizar: "
        def nome = System.in.newReader().readLine()

        print "Digite o novo email da candidato: "
        candidato.email = System.in.newReader().readLine()
        print "Digite a nova descrição do candidato: "
        candidato.descricaoPessoal = System.in.newReader().readLine()
        print "Digite a nova senha da candidato: "
        candidato.senha = System.in.newReader().readLine()

        def sqlUpdate = "UPDATE candidato SET email = $candidato.email, descricaoPessoal = $candidato.descricaoPessoal, senha = $candidato.senha  WHERE nome = $nome"

        try {
            sql.execute(sqlUpdate)
            println("Candidato atualizado")
        } catch (SQLException ex) {
            println("Erro ao atualizar candidato" + ex)
        }
        sql.close()
    }

    static void deletaCandidato() {

        def sql = Sql.newInstance('jdbc:postgresql://localhost:5432/linketinder', 'thiago', '123456789', 'org.postgresql.Driver')

        print "Digite o nome do candidato que deseja remover: "
        def nome = System.in.newReader().readLine()

        def sqlDelete = "DELETE FROM candidato WHERE nome = $nome"

        try {
            sql.execute(sqlDelete)
            println("Candidato removido")
        } catch (SQLException ex) {
            println("Erro ao remover candidato " + ex)
        }
        sql.close()
    }

    static void listaCandidatos() {


        println()
        println 'Lista de Candidatos'

        def sql = Sql.newInstance('jdbc:postgresql://localhost:5432/linketinder', 'thiago', '123456789', 'org.postgresql.Driver')

        sql.eachRow("SELECT * FROM candidato") { rs ->
            println "Nome: " + (rs.nome)
            println "Sobrenome: " + (rs.sobrenome)
            println "Descrição: " + (rs.descricaoPessoal)
            println "Email: " + (rs.email)
            println "País: " + (rs.pais)
            println "Competências: "
            println()
        }
        sql.close()
    }
}
