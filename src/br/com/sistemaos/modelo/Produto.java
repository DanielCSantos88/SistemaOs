
package br.com.sistemaos.modelo;


public class Produto {
    
    private Long idPro;
    private String nomePro;
    private Long idMarcaFkPro;

    public Long getIdPro() {
        return idPro;
    }

    public void setIdPro(Long idPro) {
        this.idPro = idPro;
    }

    public String getNomePro() {
        return nomePro;
    }

    public void setNomePro(String nomePro) {
        this.nomePro = nomePro;
    }

    public Long getIdMarcaFkPro() {
        return idMarcaFkPro;
    }

    public void setIdMarcaFkPro(Long idMarcaFkPro) {
        this.idMarcaFkPro = idMarcaFkPro;
    }
    
}
