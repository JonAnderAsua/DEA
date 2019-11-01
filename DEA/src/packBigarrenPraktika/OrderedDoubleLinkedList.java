package packBigarrenPraktika;

public class OrderedDoubleLinkedList<T> extends DoubleLinkedList<T> implements OrderedListADT<T> {
	
	public void add(T elem){
		//Aurre:
		//Post: Zerrendan emandako elementua bere posizioan txertatzen du
		Node<T> lag;
		Node<T> berria=new Node(elem);
		Comparable<T>konp=(Comparable<T>)elem;
		if(isEmpty()) {
			first=berria;
			first.prev=first.next=first;
		}
		else {
			lag=first;
			while(konp.compareTo(lag.data)>=0&&lag.next!=first) {
				lag=lag.next;
			}
			berria.prev=lag;
			berria.next=lag.next;
			lag.next.prev=berria;
			lag.next=berria;
		}
	}
	
	//Kostua = n, kasurik txarrenean lista osoa errekorritu behar duzulako 

	public void merge(DoubleLinkedList<T> zerrenda){
		// KODEA OSATU ETA KOSTUA KALKULATU
		Node<T>lag;
		Comparable<T>lehenengoa=(Comparable<T>)first;
		if(!zerrenda.isEmpty()) {
			if(lehenengoa.compareTo(zerrenda.first())<1||isEmpty()){ 
				for(int i=0;i<zerrenda.size();i++) {
					gehituAmaieran(zerrenda.posizioanLortu(i-1));
				}
			}
			for(int i=0;i<zerrenda.size();i++) {
				Node<T> berria=zerrenda.posizioanLortu(i-1);
				lag=first.next;
				Comparable<T> berriaKomp=(Comparable<T>)berria;
				while(berriaKomp.compareTo(lag.data)>0 && lag!=first) {
					lag=lag.next;
				}
				berria.prev=lag.prev;
				berria.next=lag;
				lag.prev.next=berria;
				lag.prev=berria;
			}
		}
	}
}
