
package br.com.sistemaos.modelo;

public class DadosCliente {
    
    private Long idDcl;
    private String observacoesDcl;
    private Long idClienteFkDcl;

    public Long getIdDcl() {
        return idDcl;
    }

    public void setIdDcl(Long idDcl) {
        this.idDcl = idDcl;
    }

    public String getObservacoesDcl() {
        return observacoesDcl;
    }

    public void setObservacoesDcl(String observacoesDcl) {
        this.observacoesDcl = observacoesDcl;
    }

    public Long getIdClienteFkDcl() {
        return idClienteFkDcl;
    }

    public void setIdClienteFkDcl(Long idClienteFkDcl) {
        this.idClienteFkDcl = idClienteFkDcl;
    }
   
}
