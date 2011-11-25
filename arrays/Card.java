package arrays;

public class Card {

	private int seqNr;		//Ace = 0; Jack = 10; Queen = 11; King = 12;
	private int suitNr;
	private String name;	//Ace, 1, 2, 3, 4, 5, .., Jack, Queen, King
	private String suit;	//Spades (0); Hearts (1); Diamonds (2); Clubs (3);
	
	public Card(int suitNr, int seqNr) {
		this.seqNr = seqNr;
		this.suitNr = suitNr;
		switch(seqNr) {
			case 0: this.name = "Ace"; break;
			case 10: this.name = "Jack"; break;
			case 11: this.name = "Queen"; break;
			case 12: this.name = "King"; break;
			default: this.name = "" + seqNr; break;
		}
		switch(suitNr) {
			case 0: this.suit = "Spades"; break;
			case 1: this.suit = "Heart"; break;
			case 2: this.suit = "Diamonds"; break;
			case 3: this.suit = "Clubs"; break;
		}
	}
	
	@Override
	public String toString() {
		return name + " of " + suit;
	}
	
	public int getSeqNr() { return this.seqNr; }
	public int getSuitNr() { return this.suitNr; }
	
}
