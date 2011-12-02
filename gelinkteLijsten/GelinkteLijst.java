package gelinkteLijsten;

public class GelinkteLijst {

	/**
	 * Alleen de gelinkte lijst heeft toegang tot de node
	 */
	private class Node {
		// Dit is de data die je opslaat
		Object data;

		// referenties/pijlen naar de eerste en laatste nodes
		Node next, previous;
	}

	private Node first, last;
	private int size;

	public GelinkteLijst() {
	}

	Node getFirst() {
		return first;
	}

	Node getLast() {
		return last;
	}

	/**
	 * Voeg toe aan de voorkant
	 */
	void insertFirst(Object o) {
		Node n = new Node();
		n.data = o;
		if (first != null) {
			n.next = first;
			first.previous = n;
		} else {
			last = n;
		}
		first = n;
		size++;
	}

	/**
	 * Voeg toe aan de achterkant
	 */
	void insertLast(Object o) {
		Node n = new Node();
		n.data = o;
		if (last != null) {
			n.previous = last;
			last.next = n;
		} else {
			first = n;
		}
		last = n;
		size++;
	}

	/**
	 * Voeg toe voor een ander element
	 */
	void insertBefore(Object o, Object before) {
		Node s = first;
		while (s != null) {
			if (s.data.equals(before)) {
				Node n = new Node();
				n.data = o;
				n.next = s;
				n.next.previous = n;
				if(!isFirst(before)) {
					n.previous = s.previous;
					n.previous.next = n;					
				} else {
					first = n;
				}
				size++;
				break;
			} else {
				s = s.next;
			}
		}
	}

	/**
	 * Voeg toe na een ander element
	 */
	void insertAfter(Object o, Object after) {
		Node s = first;
		while (s != null) {
			if (s.data.equals(after)) {
				Node n = new Node();
				n.data = o;
				n.previous = s;
				n.previous.next = n;
				if(!isLast(after)){
					n.next = s.next;	
					n.next.previous = n;					
				} else {
					last = n;
				}
				size++;
				break;
			} else {
				s = s.next;
			}
		}
	}

	/**
	 * Verwijder een element
	 * 
	 * @param data
	 */
	void remove(Object data) {
		Node s = first;
		while (s != null) {
			if (s.data.equals(data)) {
				if (!isFirst(s.data) && !isLast(s.data)) {
					s.previous.next = s.next;
					s.next.previous = s.previous;
				} else if (getSize() == 1) {
					first = null;
					last = null;
				} else if (isFirst(s.data)) {
					first = s.next; 
					s.next.previous = null;
				} else if (isLast(s.data)) {
					last = s.previous;
					s.previous.next = null;
				}
				size--;
				break;
			} else {
				s = s.next;
			}
		}
	}

	/**
	 * 
	 * @param o
	 * @return
	 */
	boolean isFirst(Object o) {
		return first.data.equals(o);
	}

	/**
	 * 
	 * @param o
	 * @return
	 */
	boolean isLast(Object o) {
		return last.data.equals(o);
	}

	/**
	 * Het aantal elementen in de gelinkte lijst
	 * 
	 * @return
	 */
	int getSize() {
		return size;
	}

	Object getData(Node n) {
		return n.data;
	}

	@Override
	public String toString() {
		Node s = first;
		String r = "";
		int c = 1;
		while (s != null) {
			r += "Node " + c++ + ":" + s + "\n";
			s = s.next;
		}
		return r;
	}
}
