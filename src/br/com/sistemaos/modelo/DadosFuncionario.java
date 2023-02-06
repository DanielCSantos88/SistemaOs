
package br.com.sistemaos.modelo;

public class DadosFuncionario {
  
    private Long idDfu;
    private String salarioDfu;
    private Long idSetorFkDfu;
    private Long idFuncionarioFkDfu;

    public Long getIdDfu() {
        return idDfu;
    }

    public void setIdDfu(Long idDfu) {
        this.idDfu = idDfu;
    }
     
    public String getSalarioDfu() {
        return salarioDfu;
    }

    public void setSalarioDfu(String salario) {
        this.salarioDfu = salario;
    }

    public Long getIdSetorFkDfu() {
        return idSetorFkDfu;
    }

    public void setIdSetorFkDfu(Long idSetorFkDfu) {
        this.idSetorFkDfu = idSetorFkDfu;
    }
    
    public Long getIdFuncionarioFkDfu() {
        return idFuncionarioFkDfu;
    }

    public void setIdFuncionarioFkDfu(Long idFuncionarioFkDfu) {
        this.idFuncionarioFkDfu = idFuncionarioFkDfu;
    }
  
}
