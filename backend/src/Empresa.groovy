class Empresa {
    String nome
    String emailCorporativo
    String cnpj
    String pais
    String estado
    String cep
    String descricaoEmpresa
    List<String> competencias

    static ArrayList empresas = []

    static void adicionaEmpresas() {
        Empresa empresa1 = new Empresa(nome: "Tech Ventures", emailCorporativo: "techventures@outlook.com", cnpj: "74.534.334/0001-81", pais: "Estados Unidos", estado: "Califórnia", cep: "16350000", descricaoEmpresa: "Consultoria Especializada em Tecnologia e Transformação Digital", competencias: ["JAVA", "C#", "GIT", "SCRUM"])
        Empresa empresa2 = new Empresa(nome: "BlueWave Tecnologia", emailCorporativo: "bluewavetech@outlook.com", cnpj: "02.138.182/0001-97", pais: "Brasil", estado: "Rio de Janeiro", cep: "86320000", descricaoEmpresa: "Consultoria Especializada em Tecnologia e Transformação Digital", competencias: ["GIT", "SCRUM"])
        Empresa empresa3 = new Empresa(nome: "Twisted Soluções", emailCorporativo: "twistedsolucoes@outlook.com", cnpj: "62.722.371/0001-34", pais: "Brasil", estado: "Bahia", cep: "36330000", descricaoEmpresa: "Soluções em tecnologia", competencias: ["GIT", "PYTHON"])
        Empresa empresa4 = new Empresa(nome: "Harvest Informática", emailCorporativo: "harvestinfo@outlook.com", cnpj: "66.873.479/0001-89", pais: "Brasil", estado: "Goiás", cep: "76360000", descricaoEmpresa: "Equipamentos de Informática", competencias: ["JAVA"])
        Empresa empresa5 = new Empresa(nome: "Optimus Tecnologia", emailCorporativo: "optimustech@outlook.com", cnpj: "02.540.681/0001-06", pais: "Brasil", estado: "Santa Catarina", cep: "56340000", descricaoEmpresa: "Consultoria Especializada em Tecnologia e Transformação Digital", competencias: ["PHP"])
        empresas.add(empresa1)
        empresas.add(empresa2)
        empresas.add(empresa3)
        empresas.add(empresa4)
        empresas.add(empresa5)
    }

    static void listaEmpresas() {
        if (empresas.isEmpty()) {
            println()
            println "A lista está vazia"
            println()
        } else {
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
        }
    }

    static void adicionaNovaEmpresa() {
        Empresa empresa6 = new Empresa(nome: "Dev Hub", emailCorporativo: "devhub@outlook.com", cnpj: "68.214.345/0002-62", pais: "Canadá", estado: "Nova Escócia", cep: "23351000", descricaoEmpresa: "Consultoria Especializada em Tecnologia e Transformação Digital", competencias: ["JAVA", "C#", "GIT", "SCRUM", "Python", "Django"])
        empresas.add(empresa6)
    }
}
