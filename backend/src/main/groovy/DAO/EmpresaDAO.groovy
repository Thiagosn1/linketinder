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

        sql.execute(sqlInsert)
        sql.close()

        println()
        println 'Empresa adicionada'
        println()
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

        sql.execute(sqlUpdate)
        sql.close()

        println()
        println 'Empresa atualizada'
        println()
    }

    void deletaEmpresa() {

        listaEmpresas()
        println()

        print "Digite o ID da empresa que deseja remover: "
        def id = System.in.newReader().readLine()

        def sqlDelete = "DELETE FROM empresa WHERE ID = $id"

        sql.execute(sqlDelete)
        sql.close()

        println()
        println 'Empresa removida'
        println()
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
