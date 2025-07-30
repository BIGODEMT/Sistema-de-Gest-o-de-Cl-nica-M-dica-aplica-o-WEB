package br.com.clinica.servlet.dao;

import br.com.clinica.servlet.connection.conexãoFactory;
import br.com.clinica.servlet.model.adicionarMedico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.annotation.Resource;
import javax.sql.DataSource;
import br.com.clinica.servlet.model.adicionarPaciente;

public class contatoPaciente {
    @Resource(name="jdbc/clinicamedica")
    private final Connection connection;

        public contatoPaciente() throws SQLException {
            conexãoFactory CF = new conexãoFactory();
            this.connection = CF.getConnection();
	}

	public contatoPaciente(Connection connection) {
            this.connection = connection;
	}
    public void cadastrarPaciente(adicionarPaciente Paciente) {
        try {
            String sql = "INSERT INTO paciente (nome, telefone, cpf, data_nascimento) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql); 
            stmt.setString(1, Paciente.getNome());
            stmt.setString(2, Paciente.getTelefone());
            stmt.setString(3, Paciente.getCpf());
            stmt.setString(4, Paciente.getDataNascimento());
            stmt.executeUpdate();
            stmt.close();
        }

        catch (SQLException e) {
            throw new RuntimeException(e);  
           
       }
    }
}    