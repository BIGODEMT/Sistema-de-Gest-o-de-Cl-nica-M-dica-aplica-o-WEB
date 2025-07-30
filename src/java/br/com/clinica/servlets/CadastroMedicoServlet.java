package br.com.clinica.servlets;

import br.com.clinica.servlet.connection.conexãoFactory;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.clinica.servlet.dao.contatoMedico;
import br.com.clinica.servlet.model.adicionarMedico;
import static java.lang.System.out;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.tomcat.dbcp.dbcp2.ConnectionFactory;

@WebServlet("/cadastroMedicoServlet")
public class CadastroMedicoServlet extends HttpServlet {

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
        String crm = request.getParameter("crm");
        String especialidade = request.getParameter("especialidade");
        
        conexãoFactory CF = new conexãoFactory() {};
        
        adicionarMedico medico = new adicionarMedico(nome, telefone, crm, especialidade);
        
        medico.setNome(nome);
        medico.setTelefone(telefone);
        medico.setCrm(crm);
        medico.setEspecialidade(especialidade);
        
        contatoMedico dao;
        try {
            dao = new contatoMedico(CF.getConnection());
            dao.cadastrarMedico(medico);
        } catch (SQLException ex) {
            Logger.getLogger(CadastroMedicoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        // imprime o nome do contato que foi adicionado
        request.setCharacterEncoding("UTF-8");

        out.println("<html>");
        out.println("<body>");
        out.println("Registro " + medico.getNome() + " adicionado com sucesso!");
        out.println("</body>");
        out.println("</html>");
    }
}

