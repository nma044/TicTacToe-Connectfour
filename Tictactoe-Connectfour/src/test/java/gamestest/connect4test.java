package gamestest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import games.Connect4;

class connect4test {

	/**
	 * Sjekker om sjekkrad returnerer false dersom oppgitt rad er full
	 * change metoden må fungere for at denne testen skal virke
	 */
	@Test
	void sjekkradtest() {
		Connect4 test = new Connect4();
		for(int i = 0; i<=6; i++) {
			test.change(1, 1);
		}
		boolean resultat = test.sjekkrad(1);
		assertEquals(false, resultat);
	}
	
	/**
	 * tester at change returnerer riktig posisjon
	 */
	@Test
	void changetest() {
		Connect4 test = new Connect4();
		int[] resultat1 = test.change(5, 1);
		int[] resultat2 = test.change(5, 2);
		assertEquals(12, resultat1[0]);
		assertEquals(9, resultat1[1]);
		assertEquals(10, resultat2[0]);
		assertEquals(9, resultat2[1]);
	}
	
	/**
	 * Sjekker at isFull returner riktig verdi om brettet er fullt eller ikke
	 */
	@Test
	void isFulltest() {
		Connect4 test = new Connect4();
		assertEquals(false, test.isFull());
		for(int i=0;i<=6;i++) {
			for(int u=0;u<=5;u++) {
				test.change(i+1, 1);
			}
		}
		boolean resultat = test.isFull();
		assertEquals(true, resultat);
	}
	
	/**
	 * Sjekker om sjekkvinner returnerer true dersom en spiller har 4 på rad
	 * enten vertikalt, horisontalt eller diagonalt
	 */
	@Test
	void sjekkvinnertest() {
		Connect4 test = new Connect4();
		Connect4 test2 = new Connect4();
		Connect4 test3 = new Connect4();
		Connect4 test4 = new Connect4();
		assertEquals(false, test.sjekkVinner(1));
		//Sjekker 4 på rad vertikalt
		for(int i=0;i<=3;i++) {
			test.change(1, 1);
		}
		assertEquals(true, test.sjekkVinner(1));
		//Sjekker horisontalt
		for(int i=0;i<=3;i++) {
			test2.change(i+1, 1);
		}
		assertEquals(true, test2.sjekkVinner(1));
		//Sjekker diagonalt oppover
		test3.change(2, 2);
		test3.change(3, 2);
		test3.change(3, 2);
		test3.change(4, 2);
		test3.change(4, 2);
		test3.change(4, 2);
		for(int i=0;i<=3;i++) {
			test3.change(i+1, 1);
		}
		assertEquals(true, test3.sjekkVinner(1));
		test3.change(3, 2);
		test3.change(2, 2);
		test3.change(2, 2);
		test3.change(1, 2);
		test3.change(1, 2);
		test3.change(1, 2);
		for(int i=0;i<=3;i++) {
			test4.change(i+1, 1);
		}
		assertEquals(true, test4.sjekkVinner(1));
	}

}
