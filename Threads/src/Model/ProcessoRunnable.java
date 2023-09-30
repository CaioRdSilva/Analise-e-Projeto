package Model;

public class ProcessoRunnable implements Runnable {
    private final String nome;
    private final int inicio;
    private final int fim;

    public ProcessoRunnable(String nome, int inicio, int fim) {
        super();
        this.nome = nome;
        this.inicio = inicio;
        this.fim = fim;
    }


    @Override
    public void run() {
        synchronized (this) {
            for (int i = inicio; i <= fim; i++) {
                if (i % 3 == 0 && i % 5 == 0 ) {
                    System.out.println("Thread " + nome + ": " + i);
                    System.out.println("Thread " + nome + " concluída!");
                }

            }
            notify();
        }
    }
}