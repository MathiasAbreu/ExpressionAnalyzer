package analizador_expressão;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class Analizador_Expressao {
    public static void main(String[] args) {
        while (true) {
        
            ArrayList lista = new ArrayList();
            Scanner input = new Scanner(System.in);

            Circunstancias analisar  = new Circunstancias(); // Calculo Geral // Números Negativos // Tranformador Double // Classe Simbolos //
            Metodos operações = new Metodos(); // Somar // Diminuir // Multiplicar // Dividir // Potenciar // Identificador Simbolos // Jogo Sinais //
            Excecoes erros = new Excecoes(); // Analizador Números // Verificar Geral //
            Variantes variaveis = new Variantes();
            Recursividade verificar = new Recursividade(); // Verificador Números // Verificador Casa Decimais // Removedor //

            System.out.print(" | Insira a expressão: ");
            String expressão = input.nextLine();
            System.out.print("");
            String remover = expressão.replaceAll("\\s", "");
            //System.out.println(remover);
            String[] saida = remover.split("");
            lista.addAll(Arrays.asList(saida));
            //System.out.println(lista);

            if (variaveis.expressao(lista)) {
                erros.verificarGeral(lista);
                //operações.mostrarExpressão(lista);
                analisar.transformadorDouble(lista);
                verificar.verificadorNumeros(lista);
                verificar.verificadorCasaDecimal(lista);
                erros.analizadorNumeros(lista);
                analisar.numerosNegativos(lista);
                //operações.mostrarExpressão(lista);
                while (lista.size()> 1) {
                    //try {
                        boolean verificador = false;
                        while (verificador != true) {
                            for (int x = 0;x<lista.size();x++) {
                                if (lista.get(x).equals("(") || lista.get(x).equals(")")) {
                                    verificar.removedor(lista,"(",")");
                                    operações.mostrarExpressão(lista);
                                }
                            }
                            for (int x = 0;x<lista.size();x++) {
                                if (lista.get(x).equals("[") || lista.get(x).equals("]")) {
                                    verificar.removedor(lista, "[", "]");
                                    operações.mostrarExpressão(lista);
                                }
                            }
                            for (int x = 0;x<lista.size();x++) {
                                if (lista.get(x).equals("{") || lista.get(x).equals("}")) {
                                    verificar.removedor(lista, "{", "}");
                                    operações.mostrarExpressão(lista);
                                }
                            }
                            operações.identificadorSimbolo(lista);
                            verificador = true;
                        }
                    /*} catch (Exception e) {
                        System.out.println(" \n |  Expressão Inválida! |\n | Erro: "+e+"\n");
                        break;
                    }*/
                }
                try {
                    if (lista.size() == 1) {
                        System.out.print("\n | Resultado da equação: "+lista.get(0)+"\n");
                        break;
                    }
                } catch (Exception e) {

                }
            }
            else {
                //System.out.println("\n | Declaração aceita! |");
            }
        }
    }
}
