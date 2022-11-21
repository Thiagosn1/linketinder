package controller

import model.Classes.Candidato
import model.DAO.CandidatoDAO

import javax.servlet.ServletException
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet("/candidatos")
class CandidatoController extends HttpServlet {

    void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Candidato candidato = new Candidato()
        candidato.setNome(request.getParameter("nome"))
        candidato.setSobrenome(request.getParameter("sobrenome"))
        candidato.setDt_nasc(request.getParameter("dt_nasc"))
        candidato.setEmail(request.getParameter("email"))
        candidato.setCpf(request.getParameter("cpf"))
        candidato.setPais(request.getParameter("pais"))
        candidato.setCep(request.getParameter("cep"))
        candidato.setDescricaoPessoal(request.getParameter("descricaoPessoal"))
        candidato.setSenha(request.getParameter("senha"))
    }

    void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter()
        CandidatoDAO dao = new CandidatoDAO()
        List<Candidato> candidatos = dao.listar()
        for (Candidato candidato : candidatos) {
            out.println("Nome: " + candidato.getNome() + " " + candidato.getSobrenome())
            out.println("Email: " + candidato.getEmail())
            out.println("País: " + candidato.getPais())
            out.println("Descrição Pessoal: " + candidato.getDescricaoPessoal())
            out.println("Competências: ")
            out.println()
        }
    }
}