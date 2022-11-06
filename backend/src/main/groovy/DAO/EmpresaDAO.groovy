package DAO

import Classes.Empresa
import groovy.sql.Sql

class EmpresaDAO {

    def sql = Sql.newInstance('jdbc:postgresql://localhost:5432/linketinder', 'thiago', '123456789', 'org.postgresql.Driver')

    Empresa empresa = new Empresa()

    void adicionaEmpresa() {

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
            sql.commit()
            println("Empresa adicionada")
        } catch(Exception ex) {
            sql.rollback()
            println("Erro ao adicionar empresa")
        }
        sql.close()
    }

    void atualizaEmpresa() {

        listaEmpresas()
        println()

        print "Digite o ID da empresa que deseja atualizar: "
        def id = System.in.newReader().readLine()

        print "Digite o novo nome da empresa: "
        empresa.nome = System.in.newReader().readLine()
        print "Digite o novo email da empresa: "
        empresa.email = System.in.newReader().readLine()
        print "Digite a senha da empresa: "
        empresa.senha = System.in.newReader().readLine()

        def sqlUpdate = "UPDATE empresa SET nome= $empresa.nome, emailcorporativo = $empresa.email, senha = $empresa.senha WHERE ID = $id"

        try {
            sql.execute(sqlUpdate)
            sql.commit()
            println("Empresa atualizada")
        } catch(Exception ex) {
            sql.rollback()
            println("Erro ao atualizar empresa")
        }
        sql.close()
    }

    void deletaEmpresa() {

        listaEmpresas()
        println()

        print "Digite o ID da empresa que deseja remover: "
        def id = System.in.newReader().readLine()

        def sqlDelete = "DELETE FROM empresa WHERE ID = $id"

        try {
            sql.execute(sqlDelete)
            sql.commit()
            println("Empresa removida")
        } catch(Exception ex) {
            sql.rollback()
            println("Erro ao remover empresa")
        }
        sql.close()
    }

    void listaEmpresas() {

        println()
        println 'Lista de Empresas'

        sql.eachRow("SELECT * FROM empresa") { rs ->
            println "Nome: " + (rs.nome)
            println "Descrição: " + (rs.descricaoPessoal)
            println "País: " + (rs.pais)
            println("Competências: ")
            println()
        }
        sql.close()
    }
}
