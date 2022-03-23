package games;

import java.util.ArrayList;
import java.util.List;

public class Connect4 implements igame {

	private char[][] Board = {{' ', '1', '|', '2', '|', '3','|', '4', '|', '5', '|', '6','|', '7', ' ',},
			{' ', ' ', ' ', ' ', ' ', ' ',' ', ' ', ' ', ' ', ' ', ' ',' ', ' ', ' ',},
			{'|', ' ', '|', ' ', '|', ' ','|', ' ', '|', ' ', '|', ' ','|', ' ', '|',},
			{'|', '-', '+', '-', '+', '-','+', '-', '+', '-', '+', '-','+', '-', '|',},
			{'|', ' ', '|', ' ', '|', ' ','|', ' ', '|', ' ', '|', ' ','|', ' ', '|',},
			{'|', '-', '+', '-', '+', '-','+', '-', '+', '-', '+', '-','+', '-', '|',},
			{'|', ' ', '|', ' ', '|', ' ','|', ' ', '|', ' ', '|', ' ','|', ' ', '|',},
			{'|', '-', '+', '-', '+', '-','+', '-', '+', '-', '+', '-','+', '-', '|',},
			{'|', ' ', '|', ' ', '|', ' ','|', ' ', '|', ' ', '|', ' ','|', ' ', '|',},
			{'|', '-', '+', '-', '+', '-','+', '-', '+', '-', '+', '-','+', '-', '|',},
			{'|', ' ', '|', ' ', '|', ' ','|', ' ', '|', ' ', '|', ' ','|', ' ', '|',},
			{'|', '-', '+', '-', '+', '-','+', '-', '+', '-', '+', '-','+', '-', '|',},
			{'|', ' ', '|', ' ', '|', ' ','|', ' ', '|', ' ', '|', ' ','|', ' ', '|',},
			{'-', '-', '-', '-', '-', '-','-', '-', '-', '-', '-', '-','-', '-', '-',}};
	
	private char karakter1 = 'o';
	private char karakter2 = '•';
	private ArrayList<Integer> inputs = new ArrayList<Integer>();
	private int[][] rader = {{0, 0, 0, 0, 0, 0}, 
			{0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0}};
	
	/**
	 * Sjekker om gitt rad er full, eller om det kan plasseres brike der
	 * @param felt, raden som skal sjekkes
	 * @return true dersom raden ikke er full, 
	 * og brikke kan plasseres, false dersom raden er full
	 */
	public boolean sjekkrad(int felt) {
		if(rader[felt-1][5] != 0) {
			return false;
		}
		else
			return true;
	}

	
	public char[][] GetBoard(){
		return this.Board;
	}
	
	public char getKarakter1() {
		return this.karakter1;
	}
	public char getKarakter2() {
		return this.karakter2;
	}
	
	public ArrayList<Integer> getInputs() {
		inputs.add(1);
		inputs.add(2);
		inputs.add(3);
		inputs.add(4);
		inputs.add(5);
		inputs.add(6);
		inputs.add(7);
		
		return this.inputs;
	}
	public int[] change(int felt, int bruker) {
		int[] posisjon = {0, 0};
		int kol = 0;
		for(int i : rader[felt-1]) {
			if(i == 0) {
				rader[felt-1][kol] = bruker;
				break;
			}
			kol += 1;	
		}
		posisjon[1] = felt*2-1;
		switch(kol) {
		case 0:
			posisjon[0] = 12;
			return posisjon;
		case 1:
			posisjon[0] = 10;
			return posisjon;
		case 2:
			posisjon[0] = 8;
			return posisjon;
		case 3:
			posisjon[0] = 6;
			return posisjon;
		case 4:
			posisjon[0] = 4;
			return posisjon;
		case 5:
			posisjon[0] = 2;
			return posisjon;
	}
		return posisjon;
}
	public boolean isFull() {
		for(int[] i : rader) {
			for(int j : i) {
				if(j == 0)
					return false;
			}
		}
		return true;
	}
	
	public boolean sjekkVinner(int spiller) {
		int antall = 0;
		//Sjekker om spiller har 4 på rad vertikalt
		for(int[] rad : rader) {
			for(int i : rad) {
				if(i==spiller) {
					antall++;
					if(antall>=4) {
						return true;}
				}
				else
					antall=0;
			}
			antall=0;	
		}

		int kryss = 0;
	for(int radteller = 0;radteller<6;radteller++) {
		//Sjekker om spiller har 4 på rad horisontalt
			for(int[]siderad : rader) {
				if(siderad[radteller] == spiller) {
				antall++;
				if(antall>=4) {
					return true;
				}
				}
			else
				antall=0;
			}
			antall=0;
			//Sjekker om spiller har 4 på diagonalt nedover
			for(int[]u : rader) {
				if(radteller-kryss >= 0) {
				if(u[radteller-kryss] == spiller) {
					antall++;
					kryss++;	
					if(antall>=4) {
						return true;
					}
				}
				else {
					antall=0;
					kryss=0;
				}}
			}
			antall=0;
			kryss=0;
			//Sjekker om spiller har 4 på rad diagonalt oppover
			for(int[]o : rader) {
				if(radteller+kryss <= 5) {
				if(o[radteller+kryss] == spiller) {
					antall++;
					kryss++;	
					if(antall>=4) {
						return true;
					}
				}
				else {
					antall=0;
					kryss=0;
				}}
			}
		
	}
		return false;	
	}

}
