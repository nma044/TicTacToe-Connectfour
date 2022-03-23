package games;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tictactoe implements igame {
	
	private char[][] Board = {{' ', '|', ' ', '|', ' '}, 
			{'-', '+', '-', '+', '-'}, 
			{' ', '|', ' ', '|', ' '},
			{'-', '+', '-', '+', '-'},
			{' ', '|', ' ', '|', ' '}};
	
	private List<List> vinnliste = vinneliste();
	
	private char karakter1 = 'X';
	private char karakter2 = 'O';
	private ArrayList<Integer> inputs = new ArrayList<Integer>();
	public ArrayList<Integer> spiller1felt = new ArrayList<Integer>();
	public ArrayList<Integer> spiller2felt = new ArrayList<Integer>();
	
	public Tictactoe() {
		
	}
	
	public List<List> vinneliste() {
		List rad1 = Arrays.asList(1, 2, 3);
		List rad2 = Arrays.asList(4, 5, 6);
		List rad3 = Arrays.asList(7, 8, 9);
		List kol1 = Arrays.asList(1, 4, 7);
		List kol2 = Arrays.asList(2, 5, 8);
		List kol3 = Arrays.asList(3, 6, 9);
		List kryss1 = Arrays.asList(1, 5, 9);
		List kryss2 = Arrays.asList(3, 5, 7);
		
		List<List> vinnliste = new ArrayList<List>();
		vinnliste.add(rad1);
		vinnliste.add(rad2);
		vinnliste.add(rad3);
		vinnliste.add(kol1);
		vinnliste.add(kol2);
		vinnliste.add(kol3);
		vinnliste.add(kryss1);
		vinnliste.add(kryss2);

		return vinnliste;
		
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
		inputs.add(8);
		inputs.add(9);
		
		return this.inputs;
	}
	public boolean sjekkVinner(int spiller) {
		
		if(spiller==1) {
		for(List i : vinnliste) {
			if(spiller1felt.containsAll(i)) {
				return true;
			}}}
		if(spiller==2) {
			for(List u : vinnliste) {
				if(spiller2felt.containsAll(u)) {
						return true;
				}
				
			}}
		return false;
	}
	
	public boolean isFull() {
		return (spiller1felt.size() + spiller2felt.size() >= 9);
	}
	
	//Bruker alltid bruker = 0 for tictactoe, 
	//dette paramteret har ingen effekt men er med for å støtte interface 
	public int[] change(int felt, int bruker) {
		int[] posisjon = {0, 0};
		switch(felt) {
		case 1:
			posisjon[0] = 0;
			posisjon[1] = 0;
			return posisjon;
		case 2:
			posisjon[0] = 0;
			posisjon[1] = 2;
			return posisjon;
		case 3:
			posisjon[0] = 0;
			posisjon[1] = 4;
			return posisjon;
		case 4:
			posisjon[0] = 2;
			posisjon[1] = 0;
			return posisjon;
		case 5:
			posisjon[0] = 2;
			posisjon[1] = 2;
			return posisjon;
		case 6:
			posisjon[0] = 2;
			posisjon[1] = 4;
			return posisjon;
		case 7:
			posisjon[0] = 4;
			posisjon[1] = 0;
			return posisjon;
		case 8:
			posisjon[0] = 4;
			posisjon[1] = 2;
			return posisjon;
		case 9:
			posisjon[0] = 4;
			posisjon[1] = 4;
			return posisjon;
	}
		return null;
	}
	
}
