
package br.com.sistemaos.modelo;

public class Email {
    
    private Long idEma;
    private String emailEma;
    private String responsavelEma;
    private String dataAniversarioEma;
    private String departamentoEma;
    private Long idPessoaFkEma; 

    public String getDataAniversarioEma() {
        return dataAniversarioEma;
    }

    public void setDataAniversarioEma(String dataAniversarioEma) {
        this.dataAniversarioEma = dataAniversarioEma;
    }

    public Long getIdEma() {
        return idEma;
    }

    public void setIdEma(Long idCon) {
        this.idEma = idCon;
    }

    public String getResponsavelEma() {
        return responsavelEma;
    }

    public void setResponsavelEma(String responsavel) {
        this.responsavelEma = responsavel;
    }

    public String getEmailEma() {
        return emailEma;
    }

    public void setEmailEma(String emailCom) {
        this.emailEma = emailCom;
    }

    public String getDepartamentoEma() {
        return departamentoEma;
    }

    public void setDepartamentoEma(String departamentoEma) {
        this.departamentoEma = departamentoEma;
    }

    public Long getIdPessoaFkEma() {
        return idPessoaFkEma;
    }

    public void setIdPessoaFkEma(Long idPessoaFkEma) {
        this.idPessoaFkEma = idPessoaFkEma;
    }
}
