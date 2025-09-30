package zadanieWatki;

public class TablicaRunnableStart implements Runnable {
    Tablica T;

    public TablicaRunnableStart(Tablica t){
        this.T = t;
    }

    public void run() {
        for (int i = 0; i < 50; i++) T.Wstaw(i, 1);
    }
}
