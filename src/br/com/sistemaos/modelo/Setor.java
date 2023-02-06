
package br.com.sistemaos.modelo;

public class Setor {
    
    private Long idSet;
    private String nomeSet;
    private Long idFuncionarioFkSet; 

    public Long getIdSet() {
        return idSet;
    }

    public void setIdSet(Long idSet) {
        this.idSet = idSet;
    }

    public String getNomeSet() {
        return nomeSet;
    }

    public void setNomeSet(String nomeSet) {
        this.nomeSet = nomeSet;
    }

    public Long getIdFuncionarioFkSet() {
        return idFuncionarioFkSet;
    }

    public void setIdFuncionarioFkSet(Long idFuncionarioFkSet) {
        this.idFuncionarioFkSet = idFuncionarioFkSet;
    }

    @Override
    public String toString() {
        return getNomeSet(); 
    }
  
}
