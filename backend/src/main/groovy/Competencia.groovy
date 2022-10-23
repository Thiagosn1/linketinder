import groovy.sql.Sql

class Competencia {
    static void adicionaCompetencia() {
        def sql = Sql.newInstance('jdbc:postgresql://localhost:5432/linketinder', 'thiago', '123456789', 'org.postgresql.Driver')
        def sqlInsert = "INSERT INTO competencia(descricao) VALUES ('GIT')"

        sql.execute(sqlInsert)
        sql.close()

        println()
        println 'Competência adicionada'
        println()
    }

    static void atualizaCompetencia() {
        def sql = Sql.newInstance('jdbc:postgresql://localhost:5432/linketinder', 'thiago', '123456789', 'org.postgresql.Driver')
        def sqlUpdate = "UPDATE competencia SET descricao='Gitflow' WHERE ID = 9"

        sql.execute(sqlUpdate)
        sql.close()

        println()
        println 'Competência atualizada'
        println()
    }

    static void deletaCompetencia() {
        def sql = Sql.newInstance('jdbc:postgresql://localhost:5432/linketinder', 'thiago', '123456789', 'org.postgresql.Driver')
        def sqlDelete = "DELETE FROM competencia WHERE ID = 9"

        sql.execute(sqlDelete)
        sql.close()

        println()
        println 'Competência removida'
        println()
    }

    static void listaCompetencias() {

        println()
        println 'Lista de Competencias'

        def sql = Sql.newInstance('jdbc:postgresql://localhost:5432/linketinder', 'thiago', '123456789', 'org.postgresql.Driver')
        sql.eachRow("SELECT * FROM competencia") { rs ->
            println "Descrição: " + (rs.descricao)
            println()
        }
        sql.close()
    }
}
