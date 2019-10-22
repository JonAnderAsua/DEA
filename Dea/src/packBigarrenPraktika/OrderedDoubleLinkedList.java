package packBigarrenPraktika;

public class OrderedDoubleLinkedList<T> extends DoubleLinkedList<T> implements OrderedListADT<T> {
	
	public void add(T elem){
		//Aurre:
		//Post: Zerrendan emandako elementua bere posizioan txertatzen du
		// KODEA OSATU ETA KOSTUA KALKULATU
		Node<T> lag;
		Node<T> berria=new Node(elem);
		Comparable<T>konp=(Comparable<T>)elem;
		if(isEmpty()) {
			lag=first;
			lag.prev=lag.next=null;
		}
		else {
			lag=first;
			while(konp.compareTo(lag.data)<1&&lag.next!=null) {
				lag=lag.next;
			}
			berria.prev=lag;
			if(lag.next!=null) {
				berria.next=lag.prev;	
			}
			lag.next.prev=berria;
			lag.next=berria;
		}


	}

	public void merge(DoubleLinkedList<T> zerrenda){
		// KODEA OSATU ETA KOSTUA KALKULATU
		Node<T>berria;
		for(int i=0;i<=zerrenda.size();i++) {
			berria=zerrenda.posizioanLortu(i);
			add(berria.data);
		}
	}


}
