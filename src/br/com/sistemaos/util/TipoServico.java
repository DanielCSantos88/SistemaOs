
package br.com.sistemaos.util;

public enum TipoServico {
    
     ORCAMENTO(1), ORDEM_DE_SERVICO(2);

    private int valor;

    private TipoServico(int valor){
        this.valor = valor;
    }

    public int getValor(){
        return valor;
    } 
}
