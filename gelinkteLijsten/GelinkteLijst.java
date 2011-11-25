package gelinkteLijsten;

public abstract class GelinkteLijst {
	private Node first, last;
	private int size;
	
	public GelinkteLijst(){}
	Node getFirst(){ return first; }
	Node getLast(){ return last; }	
	
	void insertFirst(Node nFirst){
		nFirst.next = first;
		first.previous = nFirst;
		first = nFirst;
		size++;
	}

	void insertLast(Node nLast){
		nLast.previous = last;
		last.next = nLast;
		last = nLast;
		size++;
	}
	
	void insertBefore(Node n){
		Node p = first;
		for (int i = 0; i < size; i++){
			if(p == n){
				//other stuff to do
				Node o = new Node();
				o.next = n;
				o.previous = n.previous;
				o.next.previous = o;
				o.previous.next = o;
				size++;
				break;
			}
			else {
				p = p.next;
			}
		}
	}
	
	void insertAfter(Node n){
		Node p = first;
		for (int i = 0; i < size; i++){
			if(p == n){
				Node o = new Node();
				o.previous = n;
				o.next = n.next;
				o.previous.next = o;
				o.next.previous = o;
				size++;
				break;
			}
			else {
				p = p.next;
			}
		}		
	}

	void remove(Object data){
		Node p = first;
		for(int i = 0; i < size; i++) {
			if(p.data == data) {
				p.previous.next = p.next;
				p.next.previous = p.previous;
				size--;
				break;
			}
		}
	}
	
	
	boolean isFirst(Node current){
		if(current == first){
			return true;
		}
		return false; //dummy
	}
	
	boolean isLast(Node current){
		if(current == last){
			return true;
		}
		return false; //dummy	
	}
	
	int getSize(){
		return size;
	}
	
	protected int setSize(){
		return size;
	}
}
