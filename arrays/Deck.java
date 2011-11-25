package arrays;

import java.util.Random;

public class Deck {

	private Card[] cards;

	public Deck() {
		fillDeck();
		System.out.println(toString());
		shuffle();
		System.out.println(toString());
		sort();
		System.out.println(toString());
	}

	public int binarySearch(Card card) {
		int lo = 0;
		int hi = this.cards.length;

		while (lo < hi) {
			int i = (lo + hi) / 2;
			System.out.println(i);
			if (this.cards[i].getSuitNr() == card.getSuitNr()) {
				if (this.cards[i].getSeqNr() == card.getSeqNr()) {
					return i;
				} else if (this.cards[i].getSeqNr() < card.getSeqNr()) {
					lo = i;
				} else {
					hi = i;
				}
			} else if (this.cards[i].getSuitNr() < card.getSuitNr()) {
				lo = i;
			} else {
				hi = i;
			}
		}
		return -1;
	}

	public void delete(int index) {
		int n = this.cards.length - 1;
		Card[] c = new Card[n];

		for (int i = 0; i < this.cards.length; i++) {
			if (index == i) {
				continue;
			} else if (i < index) {
				c[i] = this.cards[i];
			} else {
				c[i - 1] = this.cards[i];
			}

		}

		this.cards = c;
	}

	public void fillDeck() {
		this.cards = new Card[52];
		int h = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 13; j++) {
				this.cards[h++] = new Card(i, j);
			}
		}
	}

	public void insertAt(Card card, int index) {
		int n = this.cards.length + 1;
		Card[] c = new Card[n];

		for (int i = 0; i < n; i++) {
			if (i < index) {
				c[i] = this.cards[i];
			} else if (i == index) {
				c[i] = card;
			} else {
				c[i] = this.cards[i - 1];
			}
		}
		this.cards = c;
	}

	public int sequentialSearch(Card card) {
		for (int i = 0; i < this.cards.length; i++) {
			if (card.getSeqNr() == this.cards[i].getSeqNr()
					&& card.getSuitNr() == this.cards[i].getSuitNr()) {
				return i;
			}
		}
		return -1;
	}

	public void shuffle() {
		Card[] d = new Card[this.cards.length]; // array met nieuwe volgorde
		int[] a = new int[this.cards.length]; // array met reeds gekozen waarden
		Random r = new Random();
		int n;
		boolean found, duplicate;

		for (int i = 0; i < this.cards.length; i++) {
			found = false;
			while (found == false) {
				n = r.nextInt(this.cards.length);
				duplicate = false;
				for (int j = 0; j < i; j++) {
					if (a[j] == n) {
						duplicate = true;
						break;
					}
				}
				if (!duplicate) {
					found = true;
					d[i] = this.cards[n];
					a[i] = n;
				}
			}
		}
		this.cards = d;
	}

	public void sort() {
		int i, j;
		Card temp;
		for (j = 0; j < this.cards.length; j++) {
			for (i = 1; i < this.cards.length - j; i++) {
				if (this.cards[i - 1].getSuitNr() > this.cards[i].getSuitNr()
						|| this.cards[i - 1].getSuitNr() == this.cards[i]
								.getSuitNr()
						&& this.cards[i - 1].getSeqNr() > this.cards[i]
								.getSeqNr()) {
					temp = this.cards[i];
					this.cards[i] = this.cards[i - 1];
					this.cards[i - 1] = temp;
				}
			}
		}
	}

	@Override
	public String toString() {
		String r = "";
		for (int i = 0; i < this.cards.length; i++) {
			r += this.cards[i].toString() + "\n";
		}
		return r;
	}

}
