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
    println "9 - ADICIONAR VAGA"
    println "10 - ATUALIZAR VAGA"
    println "11 - DELETAR VAGA"
    println "12 - LISTAR VAGAS"
    println "13 - SAIR"
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
            Conexao.adicionaVaga()
            break
        case 10:
            Conexao.atualizaVaga()
            break
        case 11:
            Conexao.deletaVaga()
            break
        case 12:
            Conexao.listaVagas()
            break
        case 13:
            rodar = false
            println "SAINDO..."
            break
    }
}

