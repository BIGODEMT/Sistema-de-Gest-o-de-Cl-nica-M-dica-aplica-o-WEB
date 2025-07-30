package br.com.clinica.servlet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.annotation.Resource;
import br.com.clinica.servlet.model.adicionarMedico;
import br.com.clinica.servlet.connection.conexãoFactory;

public class contatoMedico {
    @Resource(name="jdbc/clinicamedica")
    private final Connection connection;

        public contatoMedico() throws SQLException {
            conexãoFactory CF = new conexãoFactory();
            this.connection = CF.getConnection();
	}

	public contatoMedico(Connection connection) {
            this.connection = connection;
	}
    public void cadastrarMedico(adicionarMedico Medico) {
        try {
            String sql = "INSERT INTO medico (nome, telefone, crm, especialidade) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql); 
            stmt.setString(1, Medico.getNome());
            stmt.setString(2, Medico.getTelefone());
            stmt.setString(3, Medico.getCrm());
            stmt.setString(4, Medico.getEspecialidade());
            stmt.executeUpdate();
            stmt.close();
        }

        catch (SQLException e) {
            throw new RuntimeException(e);  
           
       }
    }
}    