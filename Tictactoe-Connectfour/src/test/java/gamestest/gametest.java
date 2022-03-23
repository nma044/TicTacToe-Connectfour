package gamestest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import games.Game;

class gametest {
	/**
	 * Grunnet at flere av metodene i game bruker scanner for å få input i konsollen,
	 * og flere av metoden er void metoder som kaller andre metoder eller endrer
	 * på verdiene til feltvariablene i klassen, hadde jeg problemer med å lage tester
	 * til de fleste metodene i denne klassen.
	 */

	
	/**
	 * Sjekker changeplayer metoden
	 */
	@Test
	void changeplayertest() {
		Game test = new Game(true);
		String[] testlist = {"1", "2"};
		assertEquals("2", test.ChangePlayer(testlist, "1"));
		assertEquals("1", test.ChangePlayer(testlist, "2"));
	}

}
