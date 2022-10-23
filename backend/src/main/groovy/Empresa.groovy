import groovy.sql.Sql

class Empresa {
    static void adicionaEmpresa() {
        def sql = Sql.newInstance('jdbc:postgresql://localhost:5432/linketinder', 'thiago', '123456789', 'org.postgresql.Driver')
        def sqlInsert = "INSERT INTO empresa(nome, cnpj, emailCorporativo, pais, cep, descricao, senha) VALUES ('Optimus Tecnologia', '11111111111111', 'optimustech@outlook.com', 'Brasil', '33330000', 'Consultoria Especializada em Tecnologia e Transformação Digital', 'optimus1')"

        sql.execute(sqlInsert)
        sql.close()

        println()
        println 'Empresa adicionada'
        println()
    }

    static void atualizaEmpresa() {
        def sql = Sql.newInstance('jdbc:postgresql://localhost:5432/linketinder', 'thiago', '123456789', 'org.postgresql.Driver')
        def sqlUpdate = "UPDATE empresa SET nome='Optimus Solutions', emailcorporativo='optimussolutions@gmail.com' WHERE ID = 7"

        sql.execute(sqlUpdate)
        sql.close()

        println()
        println 'Empresa atualizada'
        println()
    }

    static void deletaEmpresa() {
        def sql = Sql.newInstance('jdbc:postgresql://localhost:5432/linketinder', 'thiago', '123456789', 'org.postgresql.Driver')
        def sqlDelete = "DELETE FROM empresa WHERE ID = 7"

        sql.execute(sqlDelete)
        sql.close()

        println()
        println 'Empresa removida'
        println()
    }

    static void listaEmpresas() {

        println()
        println 'Lista de Empresas'

        def sql = Sql.newInstance('jdbc:postgresql://localhost:5432/linketinder', 'thiago', '123456789', 'org.postgresql.Driver')
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
