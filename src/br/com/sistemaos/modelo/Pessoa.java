package br.com.sistemaos.modelo;

public class Pessoa {

    private Long idPes;
    private String nomePes;
    private String cpfCnpjPes;
    private int referenciaTipoPessoaPes;
    
    public Long getIdPes() {
        return idPes;
    }

    public void setIdPes(Long idPes) {
        this.idPes = idPes;
    }

    public String getNomePes() {
        return nomePes;
    }

    public void setNomePes(String nomePes) {
        this.nomePes = nomePes;
    }

    public String getCpfCnpjPes() {
        return cpfCnpjPes;
    }

    public void setCpfCnpjPes(String cpfCnpjPes) {
        this.cpfCnpjPes = cpfCnpjPes;
    }

    public int getReferenciaTipoPessoaPes() {
        return referenciaTipoPessoaPes;
    }

    public void setReferenciaTipoPessoaPes(int referenciaTipoPessoaPes) {
        this.referenciaTipoPessoaPes = referenciaTipoPessoaPes;
    }
 
}
