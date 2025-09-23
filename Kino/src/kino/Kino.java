package kino;

import java.util.ArrayList;

public class Kino {
	public ArrayList<Sala> Sale = new ArrayList<>();
    
    public Kino() {
        Sale.add(new Sala("Narwal"));
        Sale.add(new Sala("Biedronka"));
        Sale.add(new Sala("Koala"));
    }
    
    public int countAvailableSeats() {
        int total = 0;
        for (Sala sala : Sale){
            total += sala.countAvailableSeats();
        }
        return total;
    }
    
    public void displayAllSale() {
        for (Sala sala : Sale) {
            sala.displayNameSale();
        }
    }
    
    public void displayAllSeats() {
        for (Sala sala : Sale) {
            sala.displaySeats();
            System.out.println();
        }
    }
    
    public ArrayList<Sala> getListAllSeats() {
        return Sale;
    }
}
