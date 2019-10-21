package packBigarrenPraktika;

public class OrderedDoubleLinkedList<T> extends DoubleLinkedList<T> implements OrderedListADT<T> {
	
	public void add(T elem){
		//Aurre:
		//Post: Zerrendan emandako elementua bere posizioan txertatzen du
		// KODEA OSATU ETA KOSTUA KALKULATU
		Node lag=new Node(elem);
		if(isEmpty()) {
			lag=first;
			lag.prev=lag.next=null;
		}
		else {
			
		}


	}

	public void merge(DoubleLinkedList<T> zerrenda){
		// KODEA OSATU ETA KOSTUA KALKULATU
		while(zerrenda.first()==null) {
			this.add(zerrenda.first());
			zerrenda.removeFirst();
		}


	}


}
