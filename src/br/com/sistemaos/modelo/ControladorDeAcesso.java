
package br.com.sistemaos.modelo;


public class ControladorDeAcesso {
    
    private Long idCda;
    private String loginCda;
    private String senhaCda;
    private Long idPessoaFkcda;
    private String nomePessoaFkcda;

    public Long getIdCda() {
        return idCda;
    }

    public void setIdCda(Long idCda) {
        this.idCda = idCda;
    }
 
    public String getLoginCda() {
        return loginCda;
    }

    public void setLoginCda(String loginCda) {
        this.loginCda = loginCda;
    }

    public String getSenhaCda() {
        return senhaCda;
    }

    public void setSenhaCda(String senhaCda) {
        this.senhaCda = senhaCda;
    }
    
     public Long getIdPessoaFkCda() {
        return idPessoaFkcda;
    }

    public void setIdPessoaFkCda(Long idPessoaFkcda) {
        this.idPessoaFkcda = idPessoaFkcda;
    }

    public String getNomePessoaFkCda() {
        return nomePessoaFkcda;
    }

    public void setNomePessoaFkCda(String nomePessoaFkcda) {
        this.nomePessoaFkcda = nomePessoaFkcda;
    }
}
