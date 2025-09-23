package kino;

import java.util.ArrayList;
import java.util.Scanner;

public class ManagerKina {

	public static void main(String[] args) {
		Kino kino = new Kino();
		
		System.out.println("Wybirz salę: ");
		kino.displayAllSeats();
		
		ArrayList<Sala> wszystkieSale = kino.getListAllSeats();
		
		boolean live = true;
		while(true) {
			Scanner s = new Scanner(System.in);
			switch(s.nextLine()) {
				case "q" -> { live = false; }
				case "w" -> { kino.displayAllSale(); }
				case "d" -> {
					Scanner miejsca = new Scanner(System.in);
					String wejscie = miejsca.nextLine();
					char[] c = wejscie.toCharArray();
					int a = c[0] - '0';
					int b = c[2] - '0';
					if (kino.Sale.get(0).ifEvaileble(a, b)) {
						kino.Sale.get(0).book(a, b);
					} else {
						System.out.println("Miejsce zajęte");
					}
				}
			}
		}
	}

}
