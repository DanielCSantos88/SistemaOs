
package br.com.sistemaos.util;

public enum TipoPessoa {
    
    CLIENTE(1), FORNECEDOR(2), FUNCIONARIO(3);

    private int valor;

    private TipoPessoa(int valor){
        this.valor = valor;
    }

    public int getValor(){
        return valor;
    } 
}
