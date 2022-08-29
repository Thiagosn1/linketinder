int opcao
boolean rodar = true

while (rodar) {

    println "-----------------------------"
    println "         LINKETINDER         "
    println "1 - LISTAR EMPRESAS"
    println "2 - LISTAR CANDIDATOS"
    println "3 - SAIR"
    println "-----------------------------"
    println()

    print "Digite a opção desejada: "
    opcao = System.in.newReader().readLine().toInteger()

    switch (opcao) {
        case 1:
            def empresas = [new Empresa([nome: "Tech Ventures", emailCorporativo: "techventures@outlook.com", cnpj: "74.534.334/0001-81", pais: "Estados Unidos", estado: "Califórnia", cep: "16350000", descricaoEmpresa: "Consultoria Especializada em Tecnologia e Transformação Digital", competencias: ["JAVA", "C#", "GIT", "SCRUM"]]),
                            new Empresa([nome: "BlueWave Tecnologia", emailCorporativo: "bluewavetech@outlook.com", cnpj: "02.138.182/0001-97", pais: "Brasil", estado: "Rio de Janeiro", cep: "86320000", descricaoEmpresa: "Consultoria Especializada em Tecnologia e Transformação Digital", competencias: ["GIT", "SCRUM"]]),
                            new Empresa([nome: "Twisted Soluções", emailCorporativo: "twistedsolucoes@outlook.com", cnpj: "62.722.371/0001-34", pais: "Brasil", estado: "Bahia", cep: "36330000", descricaoEmpresa: "Soluções em tecnologia", competencias: ["GIT", "PYTHON"]]),
                            new Empresa([nome: "Harvest Informática", emailCorporativo: "harvestinfo@outlook.com", cnpj: "66.873.479/0001-89", pais: "Brasil", estado: "Goiás", cep: "76360000", descricaoEmpresa: "Equipamentos de Informática", competencias: ["JAVA"]]),
                            new Empresa([nome: "Optimus Tecnologia", emailCorporativo: "optimustech@outlook.com", cnpj: "02.540.681/0001-06", pais: "Brasil", estado: "Santa Catarina", cep: "56340000", descricaoEmpresa: "Consultoria Especializada em Tecnologia e Transformação Digital", competencias: ["PHP"]])]
            println()
            println "LISTA DE EMPRESAS"
            println()
            for (Empresa empresa : empresas) {
                println "Nome: " + empresa.nome + "\n"
                println "Descrição: " + empresa.descricaoEmpresa + "\n"
                println "Email: " + empresa.emailCorporativo + "\n"
                println "País: " + empresa.pais + "\n"
                println "Estado: " + empresa.estado + "\n"
                println "Competências exigidas: " + empresa.competencias
                println()
                println()
            }
            break
        case 2:
            def candidatos = [new Candidato([nome: "Thiago", email: "thiago123@gmail.com", cpf: "05860698798", idade: 22, estado: "Goiás", cep: "76360000", descricaoPessoal: "Técnico em Informática", competencias: ["HTML", "CSS", "JS"]]),
                              new Candidato([nome: "João", email: "joaoc@gmail.com", cpf: "84165022772", idade: 18, estado: "São Paulo", cep: "16350000", descricaoPessoal: "Estudante", competencias: ["JS", "PYTHON"]]),
                              new Candidato([nome: "Mariana", email: "mari123@gmail.com", cpf: "03286737739", idade: 25, estado: "Acre", cep: "56340000", descricaoPessoal: "Desenvolvedora Web Junior", competencias: ["HTML", "CSS", "JS"]]),
                              new Candidato([nome: "Isabela", email: "bella123@gmail.com", cpf: "74713682411", idade: 28, estado: "Alagoas", cep: "36330000", descricaoPessoal: "Formado em Direito. Em busca de uma recolocação no mercado de trabalho", competencias: ["PHP"]]),
                              new Candidato([nome: "Carlos Eduardo", email: "cadu123@gmail.com", cpf: "73861184575", idade: 21, estado: "Rio de Janeiro", cep: "86320000", descricaoPessoal: "Estagiária de Desenvolvimento", competencias: ["JAVA", "C#"]])]
            println()
            println "LISTA DE CANDIDATOS"
            println()
            for (Candidato candidato : candidatos) {
                println "Nome: " + candidato.nome + "\n"
                println "Idade: " + candidato.idade + "\n"
                println "Email: " + candidato.email + "\n"
                println "Estado: " + candidato.estado + "\n"
                println "Descrição: " + candidato.descricaoPessoal + "\n"
                println "Competências: " + candidato.competencias
                println()
                println()
            }
            break
        case 3:
            rodar = false
            println "SAINDO..."
            break
    }
}