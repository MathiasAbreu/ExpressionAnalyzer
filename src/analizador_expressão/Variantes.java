package analizador_expressão;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class Variantes{
    
    static ArrayList variaveis = new ArrayList();
      
    static ArrayList<Character> alfabeto = new ArrayList<>();
    static Map<String,Numeros> variaveisDicionario = new HashMap<>();
     
    private boolean entenderExpressao(ArrayList lista) {
        for (int x = 0;x<lista.size();x++) {
            if (variaveisDicionario.containsKey((String) lista.get(x))) {
                double numero = variaveisDicionario.get((String) lista.get(x)).GetVariavel();
                lista.set(x, numero);                
            }
        }
        return true;
    }
    
    private char caractere(String simbolo) {
        try {
            char retorno = simbolo.charAt(0);
            return retorno;
        } catch (Exception e) {
            return ' ';
        }
    }
    
    private void alfabetoArray() {
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            alfabeto.add(ch);
        }
        for (char ch = 'a'; ch <= 'z';ch++) {
            alfabeto.add(ch);
        }
    }
    
    private boolean verificarCaractere(char caracter) {
        for (int x = 0;x<alfabeto.size();x++) {
            if (alfabeto.get(x).equals(caracter)) {
                return true;
            }
        }
        return false;
    }
    
    private boolean verificarDeclaração(ArrayList lista) {
        alfabetoArray();
        if (lista.size() == 3) {
            Caracteres caracter = new Caracteres();
            if (caracter.verificarCaractere((String) lista.get(0))) {
                if (lista.get(1).equals("=")) {
                    try {
                        double testar = Double.parseDouble((String) lista.get(2));
                        variaveis.add(lista);
                        Numeros numero = new Numeros();
                        numero.SetVariavel(testar);
                        variaveisDicionario.put( lista.get(0).toString(),numero);
                        return true;
                    } catch (Exception e) {
                        return false;
                    }
                }
            }
        }
        else {
            return false;
        }
        return false;
    }
    
    public boolean expressao(ArrayList lista) {
        if (verificarDeclaração(lista)) {
            return false;
        }
        else {
            if (entenderExpressao(lista)) {
                return true;
            }
        }
        return false;
    }
    
}
