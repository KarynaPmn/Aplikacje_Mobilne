package watki;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Konto k1 = new Konto();
        Thread w1 = new Thread(new KontoRunnable(k1));
        Thread w2 = new Thread(new KontoRunnable(k1));
        w1.start();
        w2.start();

        Thread.sleep(3000);

        System.out.println(k1.getSaldo());

//       Petla p = new Petla();
//       p.setName("Harry Hole");
//       p.start();


//        Thread t1 = new Thread(new IPetla());
//        t1.start();
//
//        for (int i = 0; i <= 20; i++) {
//            System.out.println("M" + i);
//        }

//        Thread t2 = new Thread(() -> {System.out.println("asd");});
//        t2.start();
    }
}