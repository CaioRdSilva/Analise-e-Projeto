//import Model.Processo;
import Model.ProcessoRunnable;

public class Main {
    public static void main(String[] args) {
        //new Processo("1").start();
        //new Processo("2").start();


        Runnable run1 = new ProcessoRunnable("1", 100, 300);
        Runnable run2 = new ProcessoRunnable("2", 301, 500);
        Runnable run3 = new ProcessoRunnable("3", 501, 700);

        Thread t1 = new Thread(run1);
        Thread t2 = new Thread(run2);
        Thread t3 = new Thread(run3);


        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        t2.start();
        try {
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        t3.start();


    }
}