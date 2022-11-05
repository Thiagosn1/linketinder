package DAO


import groovy.sql.Sql
import Classes.Candidato
class CandidatoDAO {

    def sql = Sql.newInstance('jdbc:postgresql://localhost:5432/linketinder', 'thiago', '123456789', 'org.postgresql.Driver')

    Candidato candidato = new Candidato()

    void adicionaCandidato() {

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
            sql.commit()
            println("Candidato adicionado")
        } catch(Exception ex) {
            sql.rollback()
            println("Erro ao adicionar candidato")
        }
        sql.close()
    }

    void atualizaCandidato() {

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

        try {
            sql.execute(sqlUpdate)
            sql.commit()
            println("Candidato atualizado")
        } catch(Exception ex) {
            sql.rollback()
            println("Erro ao atualizar candidato")
        }
        sql.close()
    }

    void deletaCandidato() {

        print "Digite o ID do candidato que deseja atualizar: "
        def id = System.in.newReader().readLine()

        def sqlDelete = "DELETE FROM candidato WHERE ID = $id"

        try {
            sql.execute(sqlDelete)
            sql.commit()
            println("Candidato removido")
        } catch(Exception ex) {
            sql.rollback()
            println("Erro ao remover candidato")
        }
        sql.close()
    }

    void listaCandidatos() {

        println()
        println 'Lista de Candidatos'

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
