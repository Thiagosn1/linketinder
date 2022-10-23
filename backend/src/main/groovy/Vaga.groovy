import groovy.sql.Sql

class Vaga {
    static void adicionaVaga() {
        def sql = Sql.newInstance('jdbc:postgresql://localhost:5432/linketinder', 'thiago', '123456789', 'org.postgresql.Driver')
        def sqlInsert = "INSERT INTO vaga(descricao, localvaga, idempresa) VALUES ('Desenvolvedor Pleno', 'São Paulo', 1)"

        sql.execute(sqlInsert)
        sql.close()

        println()
        println 'Vaga adicionada'
        println()
    }

    static void atualizaVaga() {
        def sql = Sql.newInstance('jdbc:postgresql://localhost:5432/linketinder', 'thiago', '123456789', 'org.postgresql.Driver')
        def sqlUpdate = "UPDATE vaga SET descricao='Desenvolvedor Pleno/Senior' WHERE ID = 2"

        sql.execute(sqlUpdate)
        sql.close()

        println()
        println 'Vaga atualizada'
        println()
    }

    static void deletaVaga() {
        def sql = Sql.newInstance('jdbc:postgresql://localhost:5432/linketinder', 'thiago', '123456789', 'org.postgresql.Driver')
        def sqlDelete = "DELETE FROM vaga WHERE ID = 2"

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
            println "Descrição: " + (rs.descricao)
            println "Local: " + (rs.localvaga)
            println()
        }
        sql.close()
    }
}
