
package br.com.sistemaos.util;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class LimitaCaracteres extends PlainDocument {
    
     // Enumerador, exibe o tipo de dado no switch case
    public enum TipoEntrada{
        CARACTERES_LETRAS, SOMENTE_NUMEROS
    };
  
    private final int qtdCaracteres;
    private final TipoEntrada tipoEntrada;
    
    // Construtor
    public LimitaCaracteres(int qtdCaracteres, TipoEntrada tipoEntrada) {
        this.qtdCaracteres = qtdCaracteres;
        this.tipoEntrada = tipoEntrada;
    }
    
    @Override
    public void insertString(int i, String string, AttributeSet as) throws BadLocationException {
        // Verificando se a quantidade de caracteres digitada é igual a confiurada, se for igual, sai do método, não deixando o usuário digitar mais caracteres
        if(string == null || getLength() == qtdCaracteres){
            return;
        }
        // Armazema o total de caracteres 
        int totalCaracteres = getLength() + string.length();
        //Filtro de caracteres
        String regex = "";
        switch(tipoEntrada){
            case CARACTERES_LETRAS: regex = "[^\\p{IsLatin}@.\\-_, ] [^0-9]";
                break;
            case SOMENTE_NUMEROS: regex = "[^0-9]";
            }
        
        //Fazendo a substituição
        string = string.replaceAll(regex, "");
        
        // Limitar o número de caracteres
        if(totalCaracteres <= qtdCaracteres){
            // Chama quando a string tiver formatada
            super.insertString(i, string, as); 
        } else{
            // Gera uma noma string
            String nova = string.substring(0, qtdCaracteres);
            // Chama quando a string tiver formatada
            super.insertString(i, nova, as);
        }
        
    }
}
