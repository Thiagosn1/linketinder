import groovy.sql.Sql

class Candidato {
    static void adicionaCandidato() {
        def sql = Sql.newInstance('jdbc:postgresql://localhost:5432/linketinder', 'thiago', '123456789', 'org.postgresql.Driver')
        def sqlInsert = "INSERT INTO candidato(nome, sobrenome, dt_nasc, email, cpf, pais, cep, descricaoPessoal, senha) VALUES ('Thiago', 'Silva', '1999-10-15', 'thiago123@gmail.com', '11111111111', 'Brasil', '71110000', 'Desenvolvedor Web', 'thiago11')"

        sql.execute(sqlInsert)
        sql.close()

        println()
        println 'Candidato adicionado'
        println()
    }

    static void atualizaCandidato() {
        def sql = Sql.newInstance('jdbc:postgresql://localhost:5432/linketinder', 'thiago', '123456789', 'org.postgresql.Driver')
        def sqlUpdate = "UPDATE candidato SET sobrenome='Nascimento', descricaoPessoal='Engenheiro de Software' WHERE ID = 10"

        sql.execute(sqlUpdate)
        sql.close()

        println()
        println 'Candidato atualizado'
        println()
    }

    static void deletaCandidato() {
        def sql = Sql.newInstance('jdbc:postgresql://localhost:5432/linketinder', 'thiago', '123456789', 'org.postgresql.Driver')
        def sqlDelete = "DELETE FROM candidato WHERE ID = 10"

        sql.execute(sqlDelete)
        sql.close()

        println()
        println 'Candidato removido'
        println()
    }

    static void listaCandidatos() {

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
