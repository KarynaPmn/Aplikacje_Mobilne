package watki;

public class KontoRunnable implements Runnable {
    Konto k;

    public KontoRunnable(Konto k) {
        this.k = k;
    }

    public void run() {
        for (int i = 1; i <= 100 ; i++) {
            k.Dodaj();
        }
    }
}
