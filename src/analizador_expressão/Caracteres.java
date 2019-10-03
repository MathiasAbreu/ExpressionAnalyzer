package analizador_expressão;

import java.util.ArrayList;

public class Caracteres {
    private ArrayList<Character> alfabeto = new ArrayList<>();
    Caracteres() {
        alfabetoArray(alfabeto);
    }
    
    // Função responsável por Atribui todas as letras ao ArrayList //
    private void alfabetoArray(ArrayList lista) {
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            alfabeto.add(ch);
        }
        for (char ch = 'a'; ch <= 'z';ch++) {
            alfabeto.add(ch);
        }
    }
    
    // Função responsável por Verificar se determinado elemento é ou não do Alfabeto //
    public boolean verificarCaractere(String string) {
        for (int x = 0;x<alfabeto.size();x++) {
            char letra = caractere(string);
            if (alfabeto.get(x).equals(letra)) {
                return true;
            }
        }
        return false;
    }
    
    // Função responsável por Transformar String em char //
    private char caractere(String simbolo) {
        try {
            char retorno = simbolo.charAt(0);
            return retorno;
        } catch (Exception e) {
            return ' ';
        }
    }
}
