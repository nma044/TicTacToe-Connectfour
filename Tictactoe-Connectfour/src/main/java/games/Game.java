package games;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {
	
	private boolean Multiplayer = false;
	private char[] karakterer = {' ',' '};
	private char karakter = ' ';
	private boolean Play = false;
	public String[] spillere = {"",""};
	private char[][] Board;
	private ArrayList<Integer> inputs = new ArrayList<Integer>();
	private boolean tictactoe;
	private Connect4 connect;
	private Tictactoe tic;
	

	public Game(boolean i) {
		if(i) {
			Tictactoe spill = new Tictactoe();
			this.karakterer[0] = spill.getKarakter1();
			this.karakterer[1] = spill.getKarakter2();
			this.Board = spill.GetBoard();
			this.inputs = spill.getInputs();
			this.tic = spill;
			this.tictactoe = true;
		}
		else {
			Connect4 spill = new Connect4();
			this.karakterer[0] = spill.getKarakter1();
			this.karakterer[1] = spill.getKarakter2();
			this.Board = spill.GetBoard();
			this.inputs = spill.getInputs();
			this.connect = spill;
			
		}
		
	};
	
	/**
	 * Implementerer alle metodene for å få et funksjonelt spill
	 */
	public static void playGame() {
	
	Game Spill = new Game(sjekkspill());

	Spill.Flerspiller();
	if(Spill.Multiplayer) {
		System.out.println("Spiller 1 navn: ");
		Spill.spillere[0] = Spill.navninput();
		System.out.println("Spiller 2 navn: ");
		Spill.spillere[1] = Spill.navninput();
	}
	else {
		System.out.println("Spillernavn: ");
		Spill.spillere[0] = Spill.navninput();
		Spill.spillere[1] = "Datamaskin";
	}
	String Currentplayer = Spill.spillere[0];
	Spill.Play = true;
	while(Spill.Play==true) {
	Spill.gameinput(Currentplayer);
	Spill.ferdig();
	Currentplayer = Spill.ChangePlayer(Spill.spillere, Currentplayer);
	}
	}
	
	/**
	 * Sjekker om spilleren vil spille mot datamaskin eller annen spiller
	 * gjør this.Multiplayer om til true om det ønskes to spillere
	 * this.Multiplayer = false om det ønskes å spille mot datamaskin
	 */
	public void Flerspiller() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Vil du spille med to spillere? (j/n)");
		String svar = scan.next();
		if(svar.startsWith("j") || svar.startsWith("J")) {
			Multiplayer = true;
		}
		else if(svar.startsWith("n") || svar.startsWith("N")) {
			Multiplayer = false;
		}
		else {
			System.out.println("Skriv 'j' for flerspiller og 'n' for enkeltspiller");
			Flerspiller();
		}
	}
	/**
	 * Returnerer String gitt i konsollen, for å sette navn på spiller
	 */
	public String navninput() {
		Scanner scan = new Scanner(System.in);
		String navn = scan.next();
		return navn;
	}
	/**
	 * Sender videre til AIinput dersom spiller er datamaskin
	 * Ber om hvilken posisjon spiller ønsker å gjøre trekket, 
	 * sjekker om gitt posisjon er gyldig for spillet og brettet
	 * sender posisjon videre til changeboard dersom det er gyldig input
	 * 
	 * @param spiller Navnet til spilleren som gjør turen
	 */
	public void gameinput(String spiller) {
		
		ArrayList<Integer>ledigfelt = new ArrayList<Integer>();
		ArrayList<Integer>feltliste = null;
	if(tictactoe) {

		ledigfelt.addAll(tic.spiller1felt);
		ledigfelt.addAll(tic.spiller2felt);
	if(spiller.equals(spillere[0])) {
		karakter = karakterer[0];
		feltliste = tic.spiller1felt;
	} else if(spiller.equals(spillere[1])) {
		karakter = karakterer[1];
		feltliste = tic.spiller2felt;
	}
	}
	if(spiller.equals(spillere[0])) 
		karakter = karakterer[0];
	else if(spiller.equals(spillere[1])) 
		karakter = karakterer[1];
	if(spiller.equals("Datamaskin")) {
		aiinput();
		return;
	}
	
	Scanner scan = new Scanner(System.in);
	System.out.println(spiller +": Plasser " + karakter + " på et ledig felt (1-"+inputs.size()+")");
	this.printMap();
	while(!scan.hasNextInt()) scan.next();
	int felt = scan.nextInt();
	if(tictactoe) {
		ledigfelt.addAll(tic.spiller1felt);
		ledigfelt.addAll(tic.spiller2felt);
	if(inputs.contains(felt) && !ledigfelt.contains(felt)) {
		feltliste.add(felt);
		ChangeBoard(felt, spiller);	
	}
	else {
		System.out.println("Skriv inn et ledig felt");
		gameinput(spiller);
	}}
	else {
	if(inputs.contains(felt) && connect.sjekkrad(felt)) {
		ChangeBoard(felt, spiller);	
	}
	else {
		System.out.println("Skriv inn en ledig rad");
		gameinput(spiller);
	}
	}
	}
	/**
	 * Metode for datamaskins plassering i spillet, random så ingen AI.
	 */
	public void aiinput() {
		Random rand = new Random();
		int felt = rand.nextInt(inputs.size()) + 1;
		if(tictactoe) {
		if(!tic.spiller1felt.contains(felt) && !tic.spiller2felt.contains(felt)) {
			tic.spiller2felt.add(felt);
			ChangeBoard(felt, "Datamaskin");	
		}
		else
			aiinput();
		}
		else {
			if(connect.sjekkrad(felt)) {
				ChangeBoard(felt, "Datamaskin");	
			}
			else
				aiinput();
			
		}
		
	}
	/**
	 * Endrer midlertidig spiller, så spillet vet hvem sin tur det er
	 * @param spillere, liste over alle spillere i spillet
	 * @param currentplayer, gjeldende spiller før metoden er gjort
	 * @return Spiller i listen spillere som ikke er currentplayer
	 */
	public String ChangePlayer(String[] spillere, String currentplayer) {
		if(spillere[0].equals(currentplayer))
			return spillere[1];
		else
			return spillere[0];
			
	}
	/**
	 * Plasserer brikke på Board i posisjon som er gitt
	 * @param felt feltet hvor spilleren ønsker å plassere brikke
	 * @param spiller gjeldende spiller som gjør trekket
	 */
	public void ChangeBoard(int felt, String spiller) {
		
		int brukernr = 0;
		
	if(spiller.equals(spillere[0])) {
		karakter = karakterer[0];
		brukernr = 1;
	} else if(spiller.equals(spillere[1])) {
		karakter = karakterer[1];
		brukernr = 2;
	}
	if(tictactoe) {
		int[] byttefelt = tic.change(felt, 0);
		Board[byttefelt[0]][byttefelt[1]] = karakter;
	}
	else {
		int[] byttefelt = connect.change(felt, brukernr);
		Board[byttefelt[0]][byttefelt[1]] = karakter;
		
	}
}
	/**
	 * Sjekker hvilket spill som ønskes å spille
	 * @return true om det ønskes å spille tic tac toe
	 * false om connect 4 ønskes
	 */
	public static boolean sjekkspill() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Hvilket spill vil du spille? skriv inn 1 for Tripp trapp tresko, og 2 for fire på rad: ");
		while(!scan.hasNextInt()) scan.next();
		int svar = scan.nextInt();
		if(svar==1) {
			return true;
		}
		if(svar==2) {
			return false;
		}
		return sjekkspill();
	}
	public void printMap() {
		for(char[] rad : Board) {
		for(char i : rad) {
			System.out.print(i);
		}
		System.out.println();
	}
	}
	/**
	 * Sjekker om spillet er ferdig, 
	 * sjekker først om en av spillerne har vunnet
	 * Etterpå om spillet av uavgjort
	 * gjør this.Play til false dersom spillet er ferdig,
	 * gjør ingenting om spillet ikke er ferdig
	 */
	public void ferdig() {
		if(tictactoe) {
			if(tic.sjekkVinner(1)) {
				printMap();
				System.out.println(this.spillere[0] +" vant!");
				this.Play = false;
				return;
			}
			if(tic.sjekkVinner(2)) {
				printMap();
				System.out.println(this.spillere[1] +" vant!");
				this.Play = false;
				return;
			}
		if(tic.isFull()) {
			printMap();
			System.out.println("Uavgjort!");
			this.Play = false;
		}}
		else {
			if(connect.sjekkVinner(1)) {
				printMap();
				System.out.println(this.spillere[0] +" vant!");
				this.Play = false;
			}
			if(connect.sjekkVinner(2)) {
				printMap();
				System.out.println(this.spillere[1] +" vant!");
				this.Play = false;
			}
			if(connect.isFull()) {
				printMap();
				System.out.println("Uavgjort!");
				this.Play = false;
			}
		}
			
		}
	}

