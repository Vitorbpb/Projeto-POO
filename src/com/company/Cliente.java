package com.company;

public class Cliente {
    private String nome;
    private String endereco;
    private int cod;
    private int idade;
    private int qtdCompras;
    private double desconto;

    public Cliente(){
        this.nome = nome;
        this.cod = cod;
        this.idade =idade;
        this.endereco = endereco;
        this.qtdCompras = qtdCompras;
        this.desconto = desconto;

    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getQtdCompras() {
        return qtdCompras;
    }

    public void setQtdCompras(int qtdCompras) {
        this.qtdCompras = qtdCompras;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public void imprimir(){
        System.out.println("----- Cliente -----");
        System.out.println("Código: " + this.getCod());
        System.out.println("Nome: " + this.getNome());
        System.out.println("Endereço:  " + this.getEndereco());
        System.out.println("Idade: " + this.getIdade());
        System.out.println("Quantidade de compras feitas:  " + this.getQtdCompras());
        System.out.println("-----------------------------");
    }
    public boolean calcDesconto(double valor){
        /*Os descontos serão calculados de acordo
        * com a quantidade de compra realizada pelo cliente,
        * só receberá desconto aquele que tiver realizado mais
        * de 5 compras*/
       if(qtdCompras >=5){
           desconto = valor *0.10;
           System.out.printf("O valor do desconto é: %.2f%n", (desconto));
           return true;
       }else if(qtdCompras >=10){
           desconto = valor * 0.20;
           System.out.printf("O valor do desconto é: %.2f%n", (desconto));
           return true;
       } else{
           System.out.println("O cliente não tem direito a desconto");
           return false;
       }
    }
}
