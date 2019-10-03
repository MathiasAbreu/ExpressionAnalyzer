package analizador_expressão;
import java.util.ArrayList;
public class Excecoes {
    public void analizadorNumeros(ArrayList lista) {
        for (int x = 0;x<lista.size();x++) {
            try {
                double numero1 = ((double) lista.get(x));
                double numero2 = ((double) lista.get(x + 2));
                if (lista.get(x + 1).equals(" ")) {
                    System.out.printf("\n | Expressão inválida! |\n | Local: '%s%s%s' |\n | Erro: Operador não encontrado! |\n",(lista.get(x)),(lista.get(x + 1)),(lista.get(x + 2)));
                    lista.clear();
                }
            } catch (Exception e) {
                
            }
        }
    }
    public void verificarGeral(ArrayList listaOriginal) {
        ArrayList lista = new ArrayList();
        for (int x = 0;x<listaOriginal.size();x++) {
            lista.add(listaOriginal.get(x));
        }
        Circunstancias simbolo = new Circunstancias();
        for (int x = 0;x < lista.size();x++) {
            try {
                if (simbolo.verificarSimbolos((String) lista.get(x),false)) {
                    for (int y = (lista.size() - 1);y > x;y--) {
                        if (simbolo.verificarSimbolos((String) lista.get(y - 1), false)) {
                            lista.remove(y); lista.remove(x);
                            x = -1;
                            break;
                        }
                        if (y - 1 == x) {
                            System.out.printf("\n | Expressão Inválida! | Erro: O simbolo '%s' era esperado! |\n",(simbolo.setSimbolos((String) lista.get(x))));
                            listaOriginal.clear();
                        }
                    }
                }
                else {
                    lista.remove(x);
                    x = -1;
                }
            } catch (Exception e ) {
                
            }
        }
        if (lista.size() % 2 != 0) {
            System.out.println("\n | A expressão foi considerada inválida! |\n | Erro: Falta ou excesso de simbolos não operandos! |");
            listaOriginal.clear();
        }
    }
}
