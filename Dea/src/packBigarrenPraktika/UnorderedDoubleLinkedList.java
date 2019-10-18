package packBigarrenPraktika;

public class UnorderedDoubleLinkedList<T> extends DoubleLinkedList<T> implements UnorderedListADT<T> {
	
	public void addToFront(T elem) {
	// hasieran gehitu
		// KODEA OSATU ETA KOSTUA KALKULATU
		Node lag=new Node(elem);
		if(isEmpty()){
			first=lag;
			first.prev=first.next=first;
		}
		else {
			lag.next=first;
			lag.prev=first.prev;
			first.prev.next=lag;
			first.prev=lag;
			first=lag;
		}
	}
	
	//Kostua = konstantea lehenengo posizioan jartzen duzulako elementu berria

	public void addToRear(T elem) {
	// bukaeran gehitu
		// KODEA OSATU ETA KOSTUA KALKULATU
		Node berria=new Node(elem);
		if(isEmpty()) {
			first=berria;
			first.prev=first.next=null;
		}
		else {
			first.prev.next=berria;
			berria.prev=first.prev;
			first.prev=berria;
			berria.next=first;
			
		}
	}
	
	//Zerrendako elementu guztiak zeharkatu behar dituenez, kostua = n da, n elementu kopurua 
	
	public void addAfter(T elem, T target) {
		// KODEA OSATU ETA KOSTUA KALKULATU (AUKERAZKOA)
		if(!contains(target)) {
			System.out.println("Sartutako target-a ez dago zerrendan");
		}
		else {
			Node lag=new Node(find(target));
			Node berria=new Node(elem);
			berria.next=lag.next;
			berria.prev=lag;
			lag.next.prev=berria;
			lag.next=berria;
		}
	}
	
	//Kostua n (elementu kopurua) da kasurik txarrenean zerrendako nodo guztiak zeharkatu behar direlako

}
