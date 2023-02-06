
package br.com.sistemaos.util;

public enum ValorTela {
    
    TELA_CADASTRA_ACESSO(1), TELA_CADASTRA_USABILIDADE(2);

    private int valor;

    private ValorTela(int valor){
        this.valor = valor;
    }

    public int getValor(){
        return valor;
    } 
    
}
