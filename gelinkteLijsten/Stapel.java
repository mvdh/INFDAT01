package gelinkteLijsten;

/**
 * De stapel, of eigenlijk 'Stack', is ook een klassieke datastructuur. In
 * [Hubbard, Hoofdstuk 5] wordt de Stack besproken. Niet te veel spieken, daar
 * leert u immers minder van.
 * 
 * In deze klasse implementeer je zelf een Stack, door alleen maar gebruik te
 * maken van de opslag methode die de klasse GelinkteLijst je biedt. De Node
 * komt in deze klasse niet voor.
 */
public class Stapel {

	public GelinkteLijst lijst;

	public Stapel() {
		lijst = new GelinkteLijst();
	}

	/**
	 * Zet een object boven op de stapel
	 * 
	 * @param object
	 */
	void push(Object object) {
		lijst.insertFirst(object);
	}

	/**
	 * Haalt het bovenste object van de stapel LIFO: Last-in, First-out
	 * 
	 * @return het bovenste object
	 */
	Object pop() {
		if(lijst.getFirst() != null){
			Object o = lijst.getData(lijst.getFirst());
			lijst.remove(lijst.getData(lijst.getFirst()));
			return o;
		}
		return null;

	}

	/**
	 * Geeft het bovenste object terug, maar laat het op de stapel staan.
	 * 
	 * @return
	 */
	Object front() {
		return lijst.getData(lijst.getFirst());
	}

	/**
	 * Geeft 'true' als er niks op de stapel ligt.
	 * 
	 * @return
	 */
	boolean isEmpty() {
		if(lijst.getSize() == 0){
			return true;
		}
		return false;
	}
}
