package View;

import model.Produto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciarEstoque {
    private List<Produto> produtos;
    private Scanner scanner;

    public GerenciarEstoque() {
        produtos = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        GerenciarEstoque gerenciarEstoque = new GerenciarEstoque();
        gerenciarEstoque.menu();
    }

    public void menu() {
        int opcao = 0;
        do {
            System.out.println("\nGerenciamento de Estoque");
            System.out.println("1. Cadastrar produto");
            System.out.println("2. Alterar dados do produto");
            System.out.println("3. Excluir produto");
            System.out.println("4. Entrada no estoque");
            System.out.println("5. Saída no estoque");
            System.out.println("6. Saldo atual no estoque");
            System.out.println("7. Listar produtos");
            System.out.println("8. Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida! Digite um número.");
                continue;
            }

            switch (opcao) {
                case 1:
                    cadastrarProduto();
                    break;
                case 2:
                    alterarProduto();
                    break;
                case 3:
                    excluirProduto();
                    break;
                case 4:
                    entradaEstoque();
                    break;
                case 5:
                    saidaEstoque();
                    break;
                case 6:
                    saldoAtualEstoque();
                    break;
                case 7:
                    listarProdutos();
                    break;
                case 8:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 8);
    }

    private void cadastrarProduto() {
        System.out.print("Nome do produto: ");
        String nome = scanner.nextLine();

        int quantidade = 0;
        while (true) {
            System.out.print("Quantidade: ");
            try {
                quantidade = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Quantidade inválida! Digite um número inteiro.");
            }
        }

        double preco = 0.0;
        while (true) {
            System.out.print("Preço: ");
            try {
                preco = Double.parseDouble(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Preço inválido! Digite um número decimal.");
            }
        }

        Produto produto = new Produto(nome, quantidade, preco);
        produtos.add(produto);
        System.out.println("Produto cadastrado com sucesso.");
    }

    private void alterarProduto() {
        System.out.print("Nome do produto a alterar: ");
        String nome = scanner.nextLine();

        for (Produto produto : produtos) {
            if (produto.getNome().equalsIgnoreCase(nome)) {
                int quantidade = 0;
                while (true) {
                    System.out.print("Nova quantidade: ");
                    try {
                        quantidade = Integer.parseInt(scanner.nextLine());
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Quantidade inválida! Digite um número inteiro.");
                    }
                }

                double preco = 0.0;
                while (true) {
                    System.out.print("Novo preço: ");
                    try {
                        preco = Double.parseDouble(scanner.nextLine());
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Preço inválido! Digite um número decimal.");
                    }
                }

                produto.setQuantidade(quantidade);
                produto.setPreco(preco);
                System.out.println("Produto alterado com sucesso.");
                return;
            }
        }
        System.out.println("Produto não encontrado.");
    }

    private void excluirProduto() {
        System.out.print("Nome do produto a excluir: ");
        String nome = scanner.nextLine();

        for (Produto produto : produtos) {
            if (produto.getNome().equalsIgnoreCase(nome)) {
                produtos.remove(produto);
                System.out.println("Produto excluído com sucesso.");
                return;
            }
        }
        System.out.println("Produto não encontrado.");
    }

    private void entradaEstoque() {
        System.out.print("Nome do produto: ");
        String nome = scanner.nextLine();

        for (Produto produto : produtos) {
            if (produto.getNome().equalsIgnoreCase(nome)) {
                int quantidade = 0;
                while (true) {
                    System.out.print("Quantidade a adicionar: ");
                    try {
                        quantidade = Integer.parseInt(scanner.nextLine());
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Quantidade inválida! Digite um número inteiro.");
                    }
                }

                produto.setQuantidade(produto.getQuantidade() + quantidade);
                System.out.println("Estoque atualizado com sucesso.");
                return;
            }
        }
        System.out.println("Produto não encontrado.");
    }

    private void saidaEstoque() {
        System.out.print("Nome do produto: ");
        String nome = scanner.nextLine();

        for (Produto produto : produtos) {
            if (produto.getNome().equalsIgnoreCase(nome)) {
                int quantidade = 0;
                while (true) {
                    System.out.print("Quantidade a remover: ");
                    try {
                        quantidade = Integer.parseInt(scanner.nextLine());
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Quantidade inválida! Digite um número inteiro.");
                    }
                }

                if (produto.getQuantidade() >= quantidade) {
                    produto.setQuantidade(produto.getQuantidade() - quantidade);
                    System.out.println("Estoque atualizado com sucesso.");
                } else {
                    System.out.println("Quantidade insuficiente em estoque.");
                }
                return;
            }
        }
        System.out.println("Produto não encontrado.");
    }

    private void saldoAtualEstoque() {
        System.out.print("Nome do produto: ");
        String nome = scanner.nextLine();

        for (Produto produto : produtos) {
            if (produto.getNome().equalsIgnoreCase(nome)) {
                System.out.println("Saldo atual de " + nome + ": " + produto.getQuantidade());
                return;
            }
        }
        System.out.println("Produto não encontrado.");
    }

    private void listarProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
        } else {
            System.out.println("Produtos cadastrados:");
            for (Produto produto : produtos) {
                System.out.println(produto);
            }
        }
    }
}