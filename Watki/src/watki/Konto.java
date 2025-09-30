package watki;

public class Konto {
    private  int saldo;

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public synchronized void Dodaj() {
        saldo += 10;
        System.out.println(saldo);
    }
}

