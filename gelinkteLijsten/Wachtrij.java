package gelinkteLijsten;

/**
 * Een wachtrij (queue) werkt via het 
 * first-in first-out principe; elementen worden toegevoegd 
 * aan de achterkant en worden verwijderd aan de voorkant.
 * 
 * In deze klasse implementeer je een Queue door alleen 
 * maar gebruik te maken van de opslag methode die de 
 * klasse GelinkteLijst je biedt. De Node komt niet voor in deze klasse!
 * 
 * In [Hubbard, hoofdstuk 6] wordt de Queue besproken.
 * 
 * @author Youri 
 *
 */
public class Wachtrij{
	
	GelinkteLijst lijst;
	
	public Wachtrij(){
		lijst = new GelinkteLijst();
	}
	
	/**
	 * Zet iets in de wachtrij
	 * aan de achterkant: FIFO
	 */
	void enqueue(Object o){
		lijst.insertLast(o);	
	}
	
	/**
	 * Haal iets van de wachtrij
	 * Aan de voorkant: FIFO
	 */
	void dequeue(){
		if(lijst.getFirst() != null) {
			lijst.remove(lijst.getData(lijst.getFirst()));
		}
	}
	
	/**
	 * Het aantal elementen in de wachtrij
	 * @return
	 */
	int size(){
		return lijst.getSize();
	}
	
	/**
	 * Is de lijst leeg?
	 * @return
	 */
	boolean isEmpty(){
		if(size() == 0){
			return true;
		}
		return false;
	}
	
	/**
	 * Bekijk het eerste element in de wachtrij, 
	 * maar haalt het niet er vanaf. 
	 * Note: het eerste element is als eerste toegevoegd.
	 * @return
	 */	
	Object front(){
		return lijst.getData(lijst.getFirst());
	}
}
