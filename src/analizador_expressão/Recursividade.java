package analizador_expressão;
import java.util.ArrayList;
import java.util.Arrays;
public class Recursividade {
    
    //Método Refatorado
    public void verificadorNumeros(ArrayList lista) {
        for (int indice = 0;indice < lista.size();indice++) {
            try {
                double teste1 = Double.parseDouble((String) lista.get(indice));
                double teste2 = Double.parseDouble((String) lista.get(indice + 1));
                double numeroFinal = (teste1 * 10 + teste2);
                lista.remove(indice);
                lista.add(indice, Double.toString((double)numeroFinal));
                lista.remove(indice + 1);
                try {
                    double teste3 = Integer.parseInt((String) lista.get(indice + 1));
                    verificadorNumeros(lista);
                } catch (Exception e) {

                }
            } catch (Exception e) {

            }
        }
    }
    
    //Método Refatorado
    public void verificadorCasaDecimal(ArrayList lista) {
        for (int x = 0;x<lista.size();x++) {
            try {
                if (lista.get(x).equals(".") || lista.get(x).equals(",")) {
                    try {
                        double conversão1 = ((double) lista.get(x - 1));
                        double conversão2 = ((double) lista.get(x + 1));
                        ArrayList numeros = new ArrayList();
                        String expressão = Integer.toString((int) conversão2);
                        String[] saida = expressão.split("");
                        numeros.addAll(Arrays.asList(saida));
                        Metodos operacao = new Metodos();
                        operacao.setVariavel1(10.0);
                        operacao.setVariavel2(numeros.size());
                        double resultado = ( conversão1 + (conversão2 / operacao.setPotenciar()));
                        lista.remove(x);
                        lista.add(x,((double)resultado));
                        lista.remove(x + 1);
                        lista.remove(x - 1);
                    } catch (Exception e) {
                        System.out.print("\n | A expressão foi considerada inválida! |\n");
                    }
                }
            } catch (Exception e) {

            }
        }
    }
    public void removedor(ArrayList lista,String simboloAbertura,String simboloFechadura) {
        for (int x = 0;x<lista.size();x++) {
            if (lista.get(x).equals(simboloAbertura)) {
                for (int y = x + 1;y < lista.size();y++) {
                    if (lista.get(y).equals(simboloAbertura)) {
                        break;
                    }
                    if (lista.get(y).equals(simboloFechadura)) {
                        ArrayList equação = new ArrayList();
                        for (int primeiro = x + 1;primeiro < y;primeiro++ ) {
                                equação.add(lista.get(primeiro));
                            }
                        if (percorrerLista(equação)) {
                            Circunstancias parentese = new Circunstancias();
                            ArrayList indices = new ArrayList();
                            int contador = x + 1;
                            while (true) {
                                if (lista.get(contador).equals(simboloFechadura)) {
                                    lista.remove(contador);
                                    break;
                                }
                                else {
                                    lista.remove(contador);
                                }
                            }
                            lista.remove(x);
                            double resultado = parentese.calculoGeral(equação);
                            lista.add(x,resultado);
                        }
                        else {
                            lista.remove(y);
                            lista.remove(x);
                            x = -1;
                            break;
                        }
                    }
                }
            }
        }
        for (int indice = 0;indice < lista.size();indice++) {
            if (lista.get(indice).equals(simboloAbertura) || lista.get(indice).equals(simboloFechadura)) {
                removedor(lista,simboloAbertura,simboloFechadura);
                break;
            }
        }
    }
    private boolean deletarNulo(int indiceAbertura,ArrayList lista, int indiceFechadura) {
        if (indiceAbertura + 1 == indiceFechadura) {
            lista.remove(indiceFechadura);
            lista.remove(indiceAbertura);
            return true;
        }
        return false;
    }
    private boolean classeOperacoes(String operando) {
        if (operando.equals("+")) { return true; }
        if (operando.equals("-")) { return true; }
        if (operando.equals("*")) { return true; }
        if (operando.equals("/")) { return true; }
        if (operando.equals("^")) { return true; }
        return false;
    }
    private boolean percorrerLista (ArrayList lista) {
        for (int x = 0;x<lista.size();x++) {
            try {
                if (classeOperacoes((String) lista.get(x))) {
                    return true;
                }
            } catch (Exception e) {
                
            }
        }
        return false;
    }
}
