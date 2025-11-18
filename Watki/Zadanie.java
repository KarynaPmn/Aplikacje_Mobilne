package org.example;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static ArrayList<Runnable> runnableArrayList = new ArrayList<>();
    static ArrayList<Thread> threadArrayList = new ArrayList<>();
    static Random rand = new Random();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Podaj liczbę: ");
        Integer n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int finalI = i;
            runnableArrayList.add(() -> Task(finalI));

            threadArrayList.add(new Thread(() -> Task(finalI)));
        }

        start();
    }

    private static void Task(Integer p) {

        Integer prio = rand.nextInt(4, 9);
        Integer degit = rand.nextInt(0, 10);

        Integer number = (100 * prio) + (10 * p) + degit;

        if (ifPrim(number))
            System.out.println(number + " - YES");
        else
            System.out.println(number + " - NO");

    }

    public static boolean ifPrim(Integer a) {
        for (int i = 2; i < (a / 2) + 1; i++) {
            if (a % i == 0)
                return false;
        }

        return true;
    }

    private static void start() {
        System.out.println("\n=== RUNNABLE ===");
        for (Runnable r : runnableArrayList)
            r.run();

        System.out.println("\n=== THREADS ===");
        for (Thread t : threadArrayList)
            t.start();
    }
}
