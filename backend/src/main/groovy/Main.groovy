int opcao
boolean rodar = true

while (rodar) {

    println "-----------------------------"
    println "         LINKETINDER         "
    println "1 - ADICIONAR EMPRESA"
    println "2 - ATUALIZAR EMPRESA"
    println "3 - DELETAR EMPRESA"
    println "4 - LISTAR EMPRESAS"
    println "5 - ADICIONAR CANDIDATO"
    println "6 - ATUALIZAR CANDIDATO"
    println "7 - DELETAR CANDIDATO"
    println "8 - LISTAR CANDIDATOS"
    println "9 - ADICIONAR COMPETÊNCIA"
    println "10 - ATUALIZAR COMPETÊNCIA"
    println "11 - DELETAR COMPETÊNCIA"
    println "12 - LISTAR COMPETÊNCIAS"
    println "13 - ADICIONAR VAGA"
    println "14 - ATUALIZAR VAGA"
    println "15 - DELETAR VAGA"
    println "16 - LISTAR VAGAS"
    println "17 - SAIR"
    println "-----------------------------"
    println()

    print "Digite a opção desejada: "
    opcao = System.in.newReader().readLine().toInteger()

    switch (opcao) {
        case 1:
            Conexao.adicionaEmpresa()
            break
        case 2:
            Conexao.atualizaEmpresa()
            break
        case 3:
            Conexao.deletaEmpresa()
            break
        case 4:
            Conexao.listaEmpresas()
            break
        case 5:
            Conexao.adicionaCandidato()
            break
        case 6:
            Conexao.atualizaCandidato()
            break
        case 7:
            Conexao.deletaCandidato()
            break
        case 8:
            Conexao.listaCandidatos()
            break
        case 9:
            Conexao.adicionaCompetencia()
            break
        case 10:
            Conexao.atualizaCompetencia()
            break
        case 11:
            Conexao.deletaCompetencia()
            break
        case 12:
            Conexao.listaCompetencias()
            break
        case 13:
            Conexao.adicionaVaga()
            break
        case 14:
            Conexao.atualizaVaga()
            break
        case 15:
            Conexao.deletaVaga()
            break
        case 16:
            Conexao.listaVagas()
            break
        case 17:
            rodar = false
            println "SAINDO..."
            break
    }
}