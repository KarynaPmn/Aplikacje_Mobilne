package zadanieWatki;

public class TablicaRunnableEnd implements Runnable{
    Tablica T;

    public TablicaRunnableEnd(Tablica t){
        this.T = t;
    }

    public void run() {
        for (int i = 99; i >= 50; i--) T.Wstaw(i, 2);
    }
}
