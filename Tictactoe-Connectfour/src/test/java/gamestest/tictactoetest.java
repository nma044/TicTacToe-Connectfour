package gamestest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import games.Tictactoe;

class tictactoetest {

	/**
	 * Sjekker at sjekkvinner returnerer true dersom en spiller har 3 på rad
	 * og false ellers
	 */
	@Test
	void sjekkVinnertest() {
		Tictactoe test = new Tictactoe();
		test.spiller1felt.add(1);
		test.spiller1felt.add(2);
		test.spiller1felt.add(3);
		boolean resultat = test.sjekkVinner(1);
		assertEquals(true, resultat);
		test.spiller2felt.add(1);
		test.spiller2felt.add(5);
		test.spiller2felt.add(9);
		boolean resultat2 = test.sjekkVinner(2);
		assertEquals(true, resultat2);
		Tictactoe test2 = new Tictactoe();
		test2.spiller1felt.add(1);
		test2.spiller1felt.add(2);
		boolean resultat3 = test2.sjekkVinner(1);
		assertEquals(false, resultat3);
	}
	
	/**
	 * Sjekker at isFull returnerer true dersom brettet er fullt
	 */
	@Test
	void isFulltest() {
		Tictactoe test = new Tictactoe();
		for(int i=0;i<=9;i++) {
			test.spiller1felt.add(i);
		}
		boolean brett = test.isFull();
		assertEquals(true, brett);
	}
	
	/**
	 * Sjekker at change returnerer riktig posisjon
	 */
	@Test
	void changetest() {
		Tictactoe test = new Tictactoe();
		int[] pos = test.change(6, 0);

		assertEquals(2, pos[0]);
		assertEquals(4, pos[1]);
	}

}
