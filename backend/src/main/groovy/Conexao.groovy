import groovy.sql.Sql

class Conexao {
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
