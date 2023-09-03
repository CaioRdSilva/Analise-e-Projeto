import java.util.Scanner;

import Module.Pilha;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe o tamanho da pilha: ");
        int tamanho = scanner.nextInt();
        Pilha lista = new Pilha(tamanho);
        try {
            while(lista.getSize() <= tamanho) {
                System.out.print("Aperte 0 para um novo item, 1 para remover o último item: ");
                int opcao = scanner.nextInt();
                if(opcao == 0 && lista.getSize() < tamanho) {
                    System.out.print("Digite o valor a ser inserido: ");
                    int valor = scanner.nextInt();
                    lista.setItem(valor);
                } else if (opcao == 0 && lista.getSize() == tamanho) {
                    throw new PilhaCheia("A Pilha já está cheia");
                } else if (opcao == 1 && lista.getSize() > 0) {
                    lista.popItem();
                } else if (opcao == 1 && lista.getSize() <= 0) {
                    throw new PilhaVazia("A pilha já está vazia");
                }
            }
        } catch (PilhaCheia | PilhaVazia e) {
            System.out.print(e.getMessage());
        }
    }
}
class PilhaCheia extends Exception {
    public PilhaCheia(String msg) {
        super(msg);
    }
}
class PilhaVazia extends Exception{
    public PilhaVazia(String msg){
        super(msg);
    }
}

