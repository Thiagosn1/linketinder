package controller

import model.Classes.Vaga
import model.DAO.VagaDAO

import javax.servlet.ServletException
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet("/vagas")
class VagaController extends HttpServlet{
    void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Vaga vaga = new Vaga()
        vaga.setNome(request.getParameter("nome"))
        vaga.setDescricao(request.getParameter("descricao"))
        vaga.setLocalVaga(request.getParameter("localVaga"))
    }

    void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter()
        VagaDAO dao = new VagaDAO()
        List<Vaga> vagas = dao.listar()
        for (Vaga vaga : vagas) {
            out.println("Nome: " + vaga.getDescricao())
            out.println("Descrição: " + vaga.getDescricao())
            out.println("Local da Vaga: " + vaga.getLocalVaga())
            out.println()
        }
    }
}
