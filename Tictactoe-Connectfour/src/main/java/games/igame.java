package games;

import java.util.ArrayList;


public interface igame {
	
	/**
	* Returnerer spillbrettet som skal brukes til spillet
	  er i todimensjonal karakterliste slik at det fungerer i terminal
	*/
	public char[][] GetBoard();
	
	/**
	 * @return symbolet som representerer spiller 1
	 */
	public char getKarakter1();
	
	/**
	 * @return symbolet som representerer spiller 2
	 */
	public char getKarakter2();
	
	
	/**
	 * Gir alle gyldige inputs til spillet
	 * @return Arraylisten inputs, inkluderer alle gyldige inputs
	 */ 
	public ArrayList<Integer> getInputs();
	
	/**
	 * 
	 * @param spiller, hvilken spiller det skal sjekkes om har vunnet
	 * @return true dersom spiller har vunnet, false ellers
	 */
	public boolean sjekkVinner(int spiller);

	/**
	 * Sjekker om brettet er fullt, som ofte betyr uavgjort i spillet
	 * @return true dersom brettet er fullt, false ellers
	 */
	public boolean isFull();
	
	/**
	 * Gir posisjon til stedet spilleren ønsker å plassere brikke
	 * @param felt, nr på hvor spiller ønsker å plassere brikke
	 * @param bruker hvilken bruker som gjør trekket, 
	 * noen klasser trenger ikke denne informasjonen, så da settes det som 0.
	 * @return liste med int, første tall er rekke, andre tall rad.
	 */
	public int[] change(int felt, int bruker);
}
