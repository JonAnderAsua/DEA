package packBigarrenPraktika;

public class UnorderedDoubleLinkedList<T> extends DoubleLinkedList<T> implements UnorderedListADT<T> {
	
	public void addToFront(T elem) {
	// hasieran gehitu
		// KODEA OSATU ETA KOSTUA KALKULATU
		Node lag=new Node(elem);
		lag.next=first;
		first=lag;
	}
	
	//Kostua = konstantea lehenengo posizioan jartzen duzulako elementu berria

	public void addToRear(T elem) {
	// bukaeran gehitu
		// KODEA OSATU ETA KOSTUA KALKULATU
		Node lag;
		if(isEmpty()) {
			first=new Node(elem);
			first.prev=first.next=null;
		}
		else {
			lag=first;
			while(lag.next!=null) {
				lag=lag.next;
			}
			lag.next=new Node(elem);
			lag.next.prev=lag;
			lag.next.next=null;
		}
	}
	
	//Zerrendako elementu guztiak zeharkatu behar dituenez, kostua = n da
	
	public void addAfter(T elem, T target) {
		// KODEA OSATU ETA KOSTUA KALKULATU (AUKERAZKOA)
		
	}

}
