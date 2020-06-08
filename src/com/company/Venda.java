package com.company;

public class Venda {
    public double custo;
    public double valorUnit;
    public double preco;
    public static double perc = 1.30;

    public Venda(){
        this.custo = custo;
        this.valorUnit = valorUnit;
        this.preco = preco;
        this.perc = perc;
    }

    public void calcValorUnit(){
        /*Calcular o valor unitário do produto, o valor
        * que está cadastrado com o produto é valor pelo
        * qual foi comprado, aqui será feito o valor
        * adicionando 30% de lucro, por isso multplica
        * pelo valor fixo de 1.30*/
        valorUnit = custo * perc;
    }
    public void calcPreco(int qtd){
        /*Calcular o valor da compra, multiplicar o valor
        * unitário do produto pela quantidade comprada*/
        preco = valorUnit * qtd;
    }
}
