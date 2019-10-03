package analizador_expressão;
import java.util.ArrayList;
public class Metodos {
    
    // Estrutura de Classe Refatorada
    private double variavel_1;
    private double variavel_2;
    private double somar() {
        return (this.variavel_1 + this.variavel_2);
    }
    private double diminuir() {
        return (this.variavel_1 - this.variavel_2);
    }
    private double multiplicar() {
        return (this.variavel_1 * this.variavel_2);
    }
    private double dividir() {
        return (this.variavel_1 / this.variavel_2);
    }
    private double potenciar() {
        double variando = this.variavel_1;
        while (true) {
            if (this.variavel_2 > 1) {
                this.variavel_1 *= variando;
                this.variavel_2 -=1;
            }
            else {
                return this.variavel_1;
            }
        }
    }
    public double setPotenciar() {
        return potenciar();
    }
    public void setVariavel1(double variavel_1) {
        this.variavel_1 = variavel_1;
    }
    public void setVariavel2(double variavel_2) {
        this.variavel_2 = variavel_2;
    }
    ///////////////////////////////////////
    
    // Métodos Refatorados
    private void realizarMultiplicacao(ArrayList lista,int indice) {
        Metodos operação = new Metodos();
        double numero1 = (double) lista.get(indice - 1);
        double numero2 = (double) lista.get(indice + 1);
        operação.variavel_1 = numero1;
        operação.variavel_2 = numero2;
        double retorno = operação.multiplicar();
        lista.remove(indice);
        lista.add(indice,((double) retorno));
        lista.remove(indice + 1);
        lista.remove(indice - 1);
    }
    private void realizarDivisao(ArrayList lista,int indice) {
        Metodos operação = new Metodos();
        double numero1 = (double) lista.get(indice - 1);
        double numero2 = (double) lista.get(indice + 1);
        operação.variavel_1 = numero1;
        operação.variavel_2 = numero2;
        double retorno = operação.dividir();
        lista.remove(indice);
        lista.add(indice,((double)retorno));
        lista.remove(indice + 1);
        lista.remove(indice - 1);
    }
    private void realizarSoma(ArrayList lista,int indice) {
        Metodos operação = new Metodos();
        double numero1 = (double) lista.get(indice - 1);
        double numero2 = (double) lista.get(indice + 1);
        operação.variavel_1 = numero1;
        operação.variavel_2 = numero2;
        double retorno = operação.somar();
        lista.remove(indice);
        lista.add(indice,((double)retorno));
        lista.remove(indice + 1);
        lista.remove(indice - 1);
    }
    private void realizarDiminuicao(ArrayList lista,int indice) {
        Metodos operação = new Metodos();
        double numero1 = (double) lista.get(indice - 1);
        double numero2 = (double) lista.get(indice + 1);
        operação.variavel_1 = numero1;
        operação.variavel_2 = numero2;
        double retorno = operação.diminuir();
        lista.remove(indice);
        lista.add(indice,((double)retorno));
        lista.remove(indice + 1);
        lista.remove(indice - 1);
    }
    private void realizarPotenciacao(ArrayList lista,int indice) {
        Metodos operação = new Metodos();
        double numero1 = (double) lista.get(indice - 1);
        double numero2 = (double) lista.get(indice + 1);
        operação.variavel_1 = numero1;
        operação.variavel_2 = numero2;
        double retorno = operação.potenciar();
        lista.remove(indice);
        lista.add(indice,(double)retorno);
        lista.remove(indice + 1);
        lista.remove(indice - 1);
    }
    public void identificadorSimbolo(ArrayList lista) {
        jogoSinais(lista);
        for (int x = 0; x < lista.size();x++) {
            if (lista.get(x).equals("^")) {
                realizarPotenciacao(lista, x);
            }
        }
        for (int x = 0;x < lista.size();x++) {
            if (lista.get(x).equals("*")) {
                realizarMultiplicacao(lista, x);
            }
        }
        for (int x = 0;x < lista.size();x++) {
            if (lista.get(x).equals("/")) {
                realizarDivisao(lista, x);
            }
        }
        for (int x = 0;x < lista.size();x++) {
            if (lista.get(x).equals("+")) {
                realizarSoma(lista, x);
            }
        }
        for (int x = 0;x < lista.size();x++) {
            if (lista.get(x).equals("-")) {
                realizarDiminuicao(lista, x);
            }
        }
    }
    /////////////////////////////////////////////
    
    // Método em analise
    private void jogoSinais(ArrayList lista) {
        for (int x = 0;x<lista.size();x++) {
            try {
                String simbolo = ((String) lista.get(x));
                double numero1 = (double) lista.get(x - 1);
                double numero2 = (double) lista.get(x + 1);
                if (numero2 < 0 && simbolo.equals("+")) {
                    lista.remove(x);
                    lista.add(x,"-");
                    numero2 = numero2 * (-1);
                    lista.remove(x + 1);
                    lista.add(x + 1,numero2);
                }
                if (numero2 < 0 && simbolo.equals("-")) {
                    lista.remove(x);
                    lista.add(x,"+");
                    numero2 = numero2 * (-1);
                    lista.remove(x + 1);
                    lista.add(x + 1,numero2);
                }
            } catch (Exception e) {

            }
        }
    }
    
    //Metodo Refatorado
    public void mostrarExpressão(ArrayList lista) {
        System.out.print(" | ");
        for (int x = 0;x < lista.size();x++) {
            if (x < (lista.size() - 1)) {
                System.out.print(lista.get(x)+" ");
            }
            else {
                System.out.println(lista.get(x));
            }
        }
    }
}
