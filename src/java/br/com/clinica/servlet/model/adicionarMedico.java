package br.com.clinica.servlet.model;

public class adicionarMedico {
    private String nome;
    private String telefone;
    private String crm;
    private String especialidade;

    public adicionarMedico(String nome, String telefone, String crm, String especialidade) {
        this.nome = nome;
        this.telefone = telefone;
        this.crm = crm;
        this.especialidade = especialidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
}