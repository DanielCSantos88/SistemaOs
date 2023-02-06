
package br.com.sistemaos.modelo;

public class Telefone {
    
    private Long idTel;
    private String telefoneTel;
    private String responsavelTel;
    private String dataAniversarioTel;
    private String departamentoTel;
    private Long idPessoaFkTel; 

    public Long getIdTel() {
        return idTel;
    }

    public void setIdTel(Long idTel) {
        this.idTel = idTel;
    }

    public String getTelefoneTel() {
        return telefoneTel;
    }

    public void setTelefoneTel(String telefoneTel) {
        this.telefoneTel = telefoneTel;
    }

    public String getResponsavelTel() {
        return responsavelTel;
    }

    public void setResponsavelTel(String responsavelTel) {
        this.responsavelTel = responsavelTel;
    }

    public String getDataAniversarioTel() {
        return dataAniversarioTel;
    }

    public void setDataAniversarioTel(String dataAniversarioTel) {
        this.dataAniversarioTel = dataAniversarioTel;
    }

    public String getDepartamentoTel() {
        return departamentoTel;
    }

    public void setDepartamentoTel(String departamentoTel) {
        this.departamentoTel = departamentoTel;
    }

    public Long getIdPessoaFkTel() {
        return idPessoaFkTel;
    }

    public void setIdPessoaFkTel(Long idPessoaFkTel) {
        this.idPessoaFkTel = idPessoaFkTel;
    }

}
