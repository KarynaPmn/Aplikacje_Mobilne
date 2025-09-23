package kino;

public class Sala {
	private int[][] Seats = new int [5][5];
	private String Name;
	
	public Sala(String Name) {
		this.Name = Name;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				Seats[i][j] = 0;
			}
		}
	}

	public boolean ifEvaileble(int i, int j) {
		return (Seats[i][j] == 0);
	}
	

	public void book(int i, int j) {
		Seats[i - 1][j - 1] = 1;
	}
	

	public void declineBook(int i, int j) {
		Seats[i][j] = 0;
	}
	
	public int countAvailableSeats() {
		int suma = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (Seats[i][j] == 1) suma++;
			}
		}
		return suma;
	}
	
	public void displayNameSale() {
		System.out.println(Name);
	}

	public void displaySeats() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (Seats[i][j] == 1) System.out.print("X");
				else System.out.print("O");
			}
			System.out.println();
		}
	}
}
