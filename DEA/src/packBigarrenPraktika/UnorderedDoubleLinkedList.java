package packBigarrenPraktika;

public class UnorderedDoubleLinkedList<T> extends DoubleLinkedList<T> implements UnorderedListADT<T> {
	
	public void addToFront(T elem) {
	// hasieran gehitu
		// KODEA OSATU ETA KOSTUA KALKULATU
		Node lag=new Node(elem);
		if(isEmpty()){ //Lista hutsa bada
			first=lag;
			first.prev=first.next=lag;
		}
		else {
			lag.next=first;
			lag.prev=first.prev;
			first.prev.next=lag;
			first.prev=lag;
			first=lag;
		}
		count++;
	}
	
	//Kostua = konstantea lehenengo posizioan jartzen duzulako elementu berria

	public void addToRear(T elem) {
	// bukaeran gehitu
		// KODEA OSATU ETA KOSTUA KALKULATU
		Node berria=new Node(elem);
		if(isEmpty()) {
			first=berria;
			first.prev=first.next=berria;
		}
		else {
			berria.prev=first.prev;
			berria.next=first;
			first.prev=berria;
			first.prev.next=berria;
		}
		
		count++;
	}
	
	//Kostua konstantea da, bakarrik first eta bere aurreko elementua atzitzen dituelako

	
	public void addAfter(T elem, T target) {
		// KODEA OSATU ETA KOSTUA KALKULATU (AUKERAZKOA)
		if(!contains(target)) {
			System.out.println("Sartutako target-a ez dago zerrendan");
		}
		else {
			Node berria=new Node(elem);
			Node lag;
			if(!isEmpty()) {
				lag=first;
				while(lag.next!=null&&!lag.data.equals(target)) {
					lag=lag.next;
				}	
				berria.prev=lag;
				berria.next=lag.next;
				lag.next.prev=berria;
				lag.next=berria;
			}
		}
	}
	//Kostua n (elementu kopurua) da kasurik txarrenean zerrendako nodo guztiak zeharkatu behar direlako
}
