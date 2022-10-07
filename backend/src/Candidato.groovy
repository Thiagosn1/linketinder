class Candidato {
    String nome
    String email
    String cpf
    int idade
    String estado
    String cep
    String descricaoPessoal
    List<String> competencias

    static ArrayList<Candidato> candidatos = []

    static void adicionaCandidatos() {
        Candidato candidato1 = new Candidato(nome: "Thiago", email: "thiago123@gmail.com", cpf: "05860698798", idade: 22, estado: "Goiás", cep: "76360000", descricaoPessoal: "Técnico em Informática", competencias: ["HTML", "CSS", "JS"])
        Candidato candidato2 = new Candidato(nome: "João", email: "joaoc@gmail.com", cpf: "84165022772", idade: 18, estado: "São Paulo", cep: "16350000", descricaoPessoal: "Estudante", competencias: ["JS", "PYTHON"])
        Candidato candidato3 = new Candidato(nome: "Mariana", email: "mari123@gmail.com", cpf: "03286737739", idade: 25, estado: "Acre", cep: "56340000", descricaoPessoal: "Desenvolvedora Web Junior", competencias: ["HTML", "CSS", "JS"])
        Candidato candidato4 = new Candidato(nome: "Isabela", email: "bella123@gmail.com", cpf: "74713682411", idade: 28, estado: "Alagoas", cep: "36330000", descricaoPessoal: "Formado em Direito. Em busca de uma recolocação no mercado de trabalho", competencias: ["PHP"])
        Candidato candidato5 = new Candidato(nome: "Carlos Eduardo", email: "cadu123@gmail.com", cpf: "73861184575", idade: 21, estado: "Rio de Janeiro", cep: "86320000", descricaoPessoal: "Estagiária de Desenvolvimento", competencias: ["JAVA", "C#"])
        candidatos.add(candidato1)
        candidatos.add(candidato2)
        candidatos.add(candidato3)
        candidatos.add(candidato4)
        candidatos.add(candidato5)
    }

    static void listaCandidatos() {
        if (candidatos.isEmpty()) {
            println()
            println "A lista está vazia."
            println()
        } else {
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
        }
    }

    static void adicionaNovoCandidato() {
        Candidato candidato6 = new Candidato(nome: "Amanda", email: "amanda123@gmail.com", cpf: "12860698639", idade: 25, estado: "Rio de Janeiro", cep: "12340000", descricaoPessoal: "Graduanda em Engenharia de Software", competencias: ["HTML", "CSS", "JS", "JAVA", "Banco de Dados"])
        candidatos.add(candidato6)
    }
}
