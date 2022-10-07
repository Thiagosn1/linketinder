int opcao
boolean rodar = true

while (rodar) {

    println "-----------------------------"
    println "         LINKETINDER         "
    println "1 - ADICIONAR EMPRESAS"
    println "2 - ADICIONAR CANDIDATOS"
    println "3 - LISTAR EMPRESAS"
    println "4 - LISTAR CANDIDATOS"
    println "5 - ADICIONAR NOVA EMPRESA"
    println "6 - ADICIONAR NOVO CANDIDATO"
    println "7 - SAIR"
    println "-----------------------------"
    println()

    print "Digite a opção desejada: "
    opcao = System.in.newReader().readLine().toInteger()

    switch (opcao) {
        case 1:
            Empresa.adicionaEmpresas()
            println()
            println "Empresas adicionadas"
            println()
            break
        case 2:
            Candidato.adicionaCandidatos()
            println()
            println "Candidatos adicionados"
            println()
            break
        case 3:
            Empresa.listaEmpresas()
            break
        case 4:
            Candidato.listaCandidatos()
            break
        case 5:
            Empresa.adicionaNovaEmpresa()
            println()
            println "Nova empresa adicionada"
            println()
            break
        case 6:
            Candidato.adicionaNovoCandidato()
            println()
            println "Novo candidato adicionado"
            println()
            break
        case 7:
            rodar = false
            println "SAINDO..."
            break
    }
}
