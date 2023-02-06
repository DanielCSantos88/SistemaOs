
package br.com.sistemaos.modelo;

public class Endereco {
    
    private Long idEnd;
    private String cepEnd;
    private String ruaEnd;
    private String numEnd;
    private String complementoEnd;
    private String bairroEnd;
    private String cidadeEnd;
    private String ufEnd;
    private Long idPessoaFkEnd; 

    public Long getIdEnd() {
        return idEnd;
    }

    public void setIdEnd(Long idEnd) {
        this.idEnd = idEnd;
    }
    
    public String getCepEnd() {
        return cepEnd;
    }

    public void setCepEnd(String cepEnd) {
        this.cepEnd = cepEnd;
    }

    public String getRuaEnd() {
        return ruaEnd;
    }

    public void setRuaEnd(String ruaEnd) {
        this.ruaEnd = ruaEnd;
    }

    public String getNumEnd() {
        return numEnd;
    }

    public void setNumEnd(String numEnd) {
        this.numEnd = numEnd;
    }

    public String getComplementoEnd() {
        return complementoEnd;
    }

    public void setComplementoEnd(String complementoEnd) {
        this.complementoEnd = complementoEnd;
    }

    public String getBairroEnd() {
        return bairroEnd;
    }

    public void setBairroEnd(String bairroEnd) {
        this.bairroEnd = bairroEnd;
    }

    public String getCidadeEnd() {
        return cidadeEnd;
    }

    public void setCidadeEnd(String cidadeEnd) {
        this.cidadeEnd = cidadeEnd;
    }

    public String getUfEnd() {
        return ufEnd;
    }

    public void setUfEnd(String ufEnd) {
        this.ufEnd = ufEnd;
    }

    public Long getIdPessoaFkEnd() {
        return idPessoaFkEnd;
    }

    public void setIdPessoaFkEnd(Long idPessoaFkEnd) {
        this.idPessoaFkEnd = idPessoaFkEnd;
    }
   
}
