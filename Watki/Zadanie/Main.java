import watki.Konto;
import watki.KontoRunnable;
import zadanieWatki.Tablica;
import zadanieWatki.TablicaRunnableEnd;
import zadanieWatki.TablicaRunnableStart;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Tablica t = new Tablica();

        Thread tStart = new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                t.Wstaw(i, 1);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread tEnd = new Thread(() -> {
            for (int i = 99; i >= 50; i--) {
                t.Wstaw(i, 2);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread show = new Thread(() -> {
            for (int i = 0; i < t.getTablica().length; i++) {
                t.Wyswietl();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        });
        tStart.start();
        tEnd.start();
        show.start();
    }
}