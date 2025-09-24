package com.example.nwd;

public class Tools {
    public int NWD(int a, int b) {
        while (a != b){
            if (a > b) a -= b;
            else b -= a;
        }

        return a;
    }

    public int SumaCyfr(int n) {
        int suma = 0;

        while (n > 0) {
            suma += n % 10;
            n /= 10;
        }

        return suma;
    }
}
