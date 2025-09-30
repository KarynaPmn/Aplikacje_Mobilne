package zadanieWatki;

public class Tablica {
    private int[] T;

    public Tablica() {
        this.T = new int[100];
    }

    public int[] getTablica() {
        return T;
    }

    public synchronized void Wstaw(int position, int e) {
        T[position] = e;
    }

    public void Wyswietl() {
        for (int i = 0; i < T.length; i++) {
            System.out.print(T[i] + " ");
        }
        System.out.println();
    }
}
