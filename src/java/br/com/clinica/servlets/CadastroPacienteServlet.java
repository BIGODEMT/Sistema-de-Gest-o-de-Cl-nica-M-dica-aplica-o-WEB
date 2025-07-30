package br.com.clinica.servlets;

import br.com.clinica.servlet.connection.conexãoFactory;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.clinica.servlet.dao.contatoPaciente;
import br.com.clinica.servlet.model.adicionarPaciente;
import static java.lang.System.out;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/cadastroPacienteServlet")
public class CadastroPacienteServlet extends HttpServlet {

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String telefone = request.getParameter("telefone");
        String cpf = request.getParameter("cpf");
        String dataNascimento = request.getParameter("data_nascimento");
        
        conexãoFactory CF = new conexãoFactory();
        
        adicionarPaciente paciente = new adicionarPaciente(nome, telefone, cpf, dataNascimento);
        
        paciente.setNome(nome);
        paciente.setTelefone(telefone);
        paciente.setCpf(cpf);
        paciente.setDataNascimento(dataNascimento);
        
        contatoPaciente dao;
        try {
            dao = new contatoPaciente(CF.getConnection());
            dao.cadastrarPaciente(paciente);
        } catch (SQLException ex) {
            Logger.getLogger(CadastroPacienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        // imprime o nome do contato que foi adicionado
        request.setCharacterEncoding("UTF-8");

        out.println("<html>");
        out.println("<body>");
        out.println("Registro " + paciente.getNome() + " adicionado com sucesso!");
        out.println("</body>");
        out.println("</html>");
    
    }
}