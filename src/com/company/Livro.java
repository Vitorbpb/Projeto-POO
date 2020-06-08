package com.company;


public class Livro {
    public int codigo;
    public String titulo;
    public String genero;
    public boolean status; //saber se está disponivel para ser emprestado
    public double custo;
    public int estoque;
    public int estoqueMin;

    public Livro(){
        this.codigo = codigo;
        this.titulo = titulo;
        this.genero = genero;
        this.status = status;
        this.custo = custo;
        this.estoque = estoque;
        this.estoqueMin = estoqueMin;
    }

    public void imprimir(){
        System.out.println("----- Livro -----");
        System.out.println("Código: " + codigo);
        System.out.println("Título:" + titulo);
        System.out.println("Estoque: " + estoque);
        System.out.println("Estoque Minimo: " + estoqueMin);
        System.out.println("Custo: " + custo);
        if (status) {
            System.out.println("Livro disponivel!");
        }else{
            System.out.println("O livro indisponivel!");
        }
        System.out.println("-----------------------------");

    }
    public void verificarEstoque(){
        /*Verifica qual é o nivel do estoque, se
        * está abaixo ou acima do nivel de estoque minimo*/
        if(estoque < estoqueMin){
            System.out.println("Estoque abaixo do valor minimo. Faça uma nova compra!");
            System.out.println("Quantidade em estoque:  " + estoque);
        }else if (estoque == 0){
            status = false;
            System.out.println("Produto não está disponivel");
        }else{
            System.out.println("Estoque acima do valor minimo!");
            System.out.println("Quantidade em estoque:  " + estoque);
        }
    }
    public boolean diminuirEstoque(int qtd){
        //Retira quantidade do estoque quando ocorre uma venda
        if(qtd > estoque){
            System.out.println("O estoque não é suficiente!");
            return false;
        }else{
            estoque -=qtd;
            if(estoque == 0){
                status = false;
            }
            return true;
        }
    }
    public void acrescentarEstoque(int qtd){
        /*Adiciona quantidade ao estoque quando ocorre
        *compra de novos produtos que já estão cadastrados*/
       if(estoque == 0){
           estoque += qtd;
           status = true;
           System.out.println("Compra realizada com sucesso!");
       }else{
           estoque += qtd;
           System.out.println("Compra realizada com sucesso!");
       }

    }
}
