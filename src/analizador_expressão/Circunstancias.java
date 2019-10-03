package analizador_expressão;
import java.util.ArrayList;
public class Circunstancias {
    
    
    
    // Classe Totalmente Refatorada
    
    
    
    // Alteração de classe 
    public double calculoGeral(ArrayList lista) {
        while (lista.size() != 1) {
            Metodos operação = new Metodos();
            Recursividade função = new Recursividade();
            função.verificadorNumeros(lista);
            operação.identificadorSimbolo(lista);
        }
        double resultado = (double) lista.get(0);
        return resultado;
    }
    
    // Método Refatorado
    public void numerosNegativos(ArrayList lista) {
        for (int x = 0;x < lista.size();x++) {
            try {
                if (lista.get(x).equals("-")) {
                    if (x == 0) {
                        try {
                            double numero = (double) lista.get(x + 1);
                            numero = numero * (-1);
                            lista.remove(x + 1);
                            lista.add(x + 1, numero);
                            lista.remove(x);
                        } catch (Exception e) {
                        }
                    }
                    else {
                        try {
                            double numero = (double) lista.get(x + 1);
                            if (classeSimbolos((String) lista.get(x - 1),true)) {
                                numero = numero * (-1);
                                lista.remove(x + 1);
                                lista.add(x + 1, numero);
                                lista.remove(x);
                            }
                            else {
                                double numero2 = (double) lista.get(x - 1);
                                numero = numero * (-1);
                                lista.remove(x + 1);
                                lista.add(x + 1, numero);
                                lista.remove(x);
                            }
                        } catch (Exception e) {
                            
                        }
                    }
                }
            } catch (Exception e) {
            
            }
        }
    }
    
    //Método Refatorado
    public void transformadorDouble(ArrayList lista) {
        double numero1;
        double numero2;
        Recursividade verificar = new Recursividade();
        verificar.verificadorNumeros(lista);
        for (int indice = 0; indice < lista.size();indice++) {
            try {
                double numero = Double.parseDouble((String) lista.get(indice));
                lista.remove(indice);
                lista.add(indice, numero);
            } catch (Exception e) {
                try {
                    if (verificarSimbolos((String) lista.get(indice),true)) {

                    }
                    else {
                        System.out.printf("\n | Expressão Inválida! |\n | Erro: '%s' Operador ou Simbolo inválido! |\n",((String) lista.get(indice)));
                        lista.clear();
                        break;
                    }
                } catch (Exception x ) {
                    
                }
                
            }
        }
    }
    
    //Alteração de Classe e Metodos Refatorados
    public String setSimbolos(String simbolo) {
        if (classeSimbolos(simbolo,false)) {
            if (simbolo.equals("(")) { return ")"; }
            if (simbolo.equals(")")) { return "("; }
            if (simbolo.equals("[")) { return "]"; }
            if (simbolo.equals("]")) { return "["; }
            if (simbolo.equals("{")) { return "}"; }
            if (simbolo.equals("}")) { return "{"; }
        }
        return "";
    }
    private boolean classeSimbolos(String simbolo,boolean valor) {
        Caracteres caracter = new Caracteres();
        if (valor == true) {
            if (simbolo.equals("+")) { return true; }
            if (simbolo.equals("-")) { return true; }
            if (simbolo.equals("*")) { return true; }
            if (simbolo.equals("/")) { return true; }
            if (simbolo.equals("^")) { return true; }
            if (simbolo.equals("=")) { return true; }
            if (simbolo.equals("{") || simbolo.equals("}")) { return true; }
            if (simbolo.equals("[") || simbolo.equals("]")) { return true; }
            if (simbolo.equals("(") || simbolo.equals(")")) { return true; }
            if (simbolo.equals(".") || simbolo.equals(",")) { return true; }
            else { return false; }
        }
        else {
            if (caracter.verificarCaractere(simbolo)) { return true; }
            if (simbolo.equals("{") || simbolo.equals("}")) { return true; }
            if (simbolo.equals("[") || simbolo.equals("]")) { return true; }
            if (simbolo.equals("(") || simbolo.equals(")")) { return true; } 
            else { return false; }
        }
    }
    public boolean verificarSimbolos(String simbolo, boolean valor) {
        return classeSimbolos(simbolo,valor);
    }
}
