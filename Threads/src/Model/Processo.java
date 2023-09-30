package Model;

public class Processo extends Thread {
    private final String nome;
    public Processo(String nome){
        super();
        this.nome = nome;
    }
    public void run(){
        for (int i =0; i<10; i++){
            System.out.println("Thread " + nome +": "+ i);
            System.out.println("Thread " + nome + " concluída!");
        }
    }
}
