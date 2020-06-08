package com.company;


import java.util.Scanner;

public class GerenciarLivros {
	public static final int T = 20;
	public Livro[] livros = new Livro[T];
	public Cliente[] cli = new Cliente[T];
	Venda vendas = new Venda();
	int indice = 0;
	int i = 0;
	public static void main(String[] args) {
		GerenciarLivros gerenciar = new GerenciarLivros();
		Scanner sc = new Scanner(System.in);
		int op = 0;
		do{
			System.out.println("Digite a opção desejada: ");
			System.out.println("1 ---- Cadastrar Livro");
			System.out.println("2 ---- Cadastrar Cliente");
			System.out.println("3 ---- Verificar Estoque");
			System.out.println("4 ---- Consultar Livro");
			System.out.println("5 ---- Vender Livro");
			System.out.println("6 ---- Comprar Livro");
			System.out.println("7 ---- Listar Clientes");
			System.out.println("8 ---- Listar Livros");
			System.out.println("9 ---- Sair");
			op = Integer.parseInt(sc.nextLine());
			switch (op){
				case 1:
					gerenciar.cadLivros();
					break;
				case 2:
                    gerenciar.cadClientes();
					break;
				case 3:
                    gerenciar.verEstoque();
					break;
				case 4:
					gerenciar.consultar();
					break;
				case 5:
					gerenciar.venderLivros();
					break;
				case 6:
                    gerenciar.comprarLivros();
					break;
				case 7:
                    gerenciar.imprimirClientes();
					break;
				case 8:
                    gerenciar.imprimirLivros();
					break;
				case 9:
					System.out.println("Você encerrou o programa!");
					break;
				default:
					System.out.println("Opção inválida!");
			}
		}while(op !=9);
	}
	public void cadLivros(){
		Scanner sc = new Scanner(System.in);
		if(indice < T){
			livros[indice] = new Livro();
			System.out.println("Digite o código do livro: ");
			livros[indice].codigo=Integer.parseInt(sc.nextLine());
			System.out.println("Digite o título do livro: ");
			livros[indice].titulo=sc.nextLine();
			System.out.println("Digite o gênero do livro: ");
			livros[indice].genero = sc.nextLine();
            System.out.println("Digite o valor do livro: ");
            livros[indice].custo = Double.parseDouble(sc.nextLine());
            System.out.println("Digite a quantidade em estoque: ");
            livros[indice].estoque = Integer.parseInt(sc.nextLine());
            System.out.println("Defina o valor do estoque minimo: ");
            livros[indice].estoqueMin = Integer.parseInt(sc.nextLine());
			livros[indice].status = true;
			indice++;
			System.out.println("Livro cadastrado com sucesso!");
		}else{
			System.out.println("Não há mais espaço para cadastrar livro");
		}
	}
    public void cadClientes(){
	    Scanner sc = new Scanner(System.in);
	    if (indice < T){
	        cli[i] = new Cliente();
            System.out.println("Digite o código do cliente: ");
            cli[i].setCod(Integer.parseInt(sc.nextLine()));
            System.out.println("Digite o nome do cliente: ");
            cli[i].setNome(sc.nextLine());
            System.out.println("Digite o endereço do cliente: ");
            cli[i].setEndereco(sc.nextLine());
            System.out.println("Digite a idade do cliente: ");
            cli[i].setIdade(Integer.parseInt(sc.nextLine()));
            cli[i].setQtdCompras(0);
            cli[i].setDesconto(0);
            i++;
        }else{
            System.out.println("Não há mais espaço para cadastrar cliente!");
        }
    }
    public void verEstoque(){
	    Scanner sc = new Scanner(System.in);
	    int cod;
        System.out.println("Digite o código do produto que você deseja verificar o estoque: ");
        cod = Integer.parseInt(sc.nextLine());
        for (Livro l: livros) { //procurando nos livros
            if(l != null){ //vendo se tem algo cadastrado ou não
                if(cod == l.codigo){
                    l.verificarEstoque();
                    return;
                }
            }else{
                System.out.println("Livro não encontrado");
            }
        }
    }
	public void consultar(){
		Scanner sc = new Scanner(System.in);
		if (indice ==0){
			System.out.println("Não há livros cadastrados");
			return;
		}
		int cod;
		System.out.println("Digite o código do livro que deseja consultar: ");
		cod= Integer.parseInt(sc.nextLine());
		for (Livro l: livros) { //procurando nos livros
			if(l != null){ //vendo se tem algo cadastrado ou não
				if(cod == l.codigo){
					if(l.status){ //verificando disponibilidade
						System.out.println("Livro está disponivel!");
						return;
					}else{
                        System.out.println("Livro indisponivel");
                        return;
                    }
				}
			}else{
				System.out.println("Livro não encontrado!");
				return;
			}

		}
	}
	public void venderLivros(){
	    Scanner sc = new Scanner(System.in);
	    if(indice==0){
			System.out.println("Não ha produtos para realizar venda");
		}
	    if(indice != 0){
	        int cod;
            System.out.println("Digite o código do produto que deseja vender");
            cod = Integer.parseInt(sc.nextLine());
            for (Livro l : livros) {
                if(l != null){
                    if(cod == l.codigo){
                        int qtd;
                        System.out.println("Digite a quantidade vendida: ");
                        qtd = Integer.parseInt(sc.nextLine());
						vendas.custo = l.custo;//pegar o custo do livro
						double venda;
						venda = 0.0; //receberá o preço do produto
						int codCli;
						System.out.println("Digite código do cliente para realizar a venda: ");
						codCli= Integer.parseInt(sc.nextLine());
						for (Cliente c: cli) {
							if (c != null) {
								if (codCli == c.getCod()) {
                                    boolean resp= l.diminuirEstoque(qtd);
                                    if(!(resp)){
                                        return;
                                    }
								    int comp = 0; //variavel para pegar qtd de compras
								    comp = c.getQtdCompras() + 1;
									c.setQtdCompras(comp);//adicionar a compra no cliente
									vendas.calcValorUnit();//calcular valor unitário
									vendas.calcPreco(qtd);//calcular o preço
									venda = vendas.preco; //recebe o preço da venda
									boolean desc = c.calcDesconto(venda); /*Verifica se o cliente
									                                        *  tem direito a desconto
									                                        * qual é o valor do desconto*/

									if (desc) {//se tiver direito a desconto, vai calcular quanto cliente deve pagar
										double preco;
										preco = venda - c.getDesconto();
                                        System.out.println("Venda realizada com sucesso!");
										System.out.printf("O preço que o cliente deve pagar é: %.2f%n", (preco));
										return;
									} else {
                                        System.out.println("Venda realizada com sucesso!");
										System.out.printf("O cliente deve pagar: %.2f %n", (venda));
										return;
									}
								}
							}
						}
						System.out.println("Não há clientes para realizar a venda");
						return;
                    }
                }

            }
        }
    }
    public void comprarLivros(){
        Scanner sc = new Scanner(System.in);
        /*Quando um livro já cadastrado for comprado
        * ele será adicionado ao estoque*/
        if( indice ==0){
			System.out.println("Para adicionar a compra de um produto é necessário cadastrar primeiro!");
		}
        if(indice != 0){
            int cod;
            System.out.println("Digite o código do produto comprado: ");
            cod = Integer.parseInt(sc.nextLine());
            for (Livro l: livros) { //procurando nos livros
                if(l != null){ //vendo se tem algo cadastrado ou não
                    if(cod == l.codigo){
                        int qtd = 0;
                        System.out.println("Digite a quantidade comprada");
                        qtd = Integer.parseInt(sc.nextLine());
                        l.acrescentarEstoque(qtd);
                        return;
                    }
                }else{
                    System.out.println("Livro não encontrado");
                }
            }

        }
    }
    public void imprimirClientes(){
		for (Cliente c: cli) {
			if(c != null){
				c.imprimir();
			}
		}
    }
	public void imprimirLivros(){
		for (Livro l: livros) {
			if( l != null){
				l.imprimir();
			}
		}
	}
}
