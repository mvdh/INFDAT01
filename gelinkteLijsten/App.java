package gelinkteLijsten;

/**
 * In deze opdracht verken je het generieke karakter van de gelinkte datastructuur.
 * Daarvoor programmeer je eerst de klasse 'GelinkteLijst'. Deze klasse is abstract.
 * De Klasses Stapel en Wachtrij implementeren de GelinkteLijst. 
 * 
 * - Zorg dat je criteria opstelt (zoals we in les 2 gedaan hebben) en beschrijf 
 *   dit in de javadoc bij elke methode.
 * - Aan de hand van de criteria controleer je of de opdracht correct werkt.
 * - Implementeer tot slot de klasse App. Deze is bedoeld om de werking van 
 *   verschillende klassses te demonstreren.
 * 
 * @author youritjang
 *
 */

public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Wachtrij w = new Wachtrij();
		for(int i = 0; i < 10; i++){
			w.enqueue(new Object());
		}
		System.out.println(w.lijst.toString());	
		for(int i = 0; i < 20; i++){
			w.dequeue();
			System.out.println(w.lijst.toString());	
		}
		
		
		System.out.println("STAPEL");
		
		
		Stapel s = new Stapel();
		for(int i = 0; i < 10; i++){
			s.push(new Object());
		}
		System.out.println(s.lijst.toString());
		System.out.println("Front: " + s.front());
		for(int i = 0; i < 20; i++){
			s.pop();
			System.out.println(s.lijst.toString());	
		}
	}
}
