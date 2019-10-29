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
			berria.prev=berria.next=berria;
		}
		else {
			if(!this.contains(elem)) {
				lag=first;
				while(konp.compareTo(lag.data)<0&&lag.next!=first) {
					lag=lag.next;
				}
				berria.prev=lag;
				berria.next=lag.next;
				lag.next.prev=berria;
				lag.next=berria;
			}
		}
		count++;
	}	
	
	//Kostua = n, kasurik txarrenean lista osoa errekorritu behar duzulako 

	public void merge(DoubleLinkedList<T> zerrenda){
		// KODEA OSATU ETA KOSTUA KALKULATU
		Node<T>berria;
		Comparable<T>azkena=(Comparable<T>)last();
		if(isEmpty()) {
			for(int i=0;i<=zerrenda.size();i++){
				berria=zerrenda.posizioanLortu(i);
				this.gehituAmaieran(berria);
			}	
		}
		else {
			if(!zerrenda.isEmpty()) {
				if(azkena.compareTo(zerrenda.first())<1){ //Sartutako listaren datuak dauden datuak baino handiago badira
					for(int i=0;i<=zerrenda.size();i++) {
						berria=zerrenda.posizioanLortu(i);
						gehituAmaieran(berria);
					}
				}
				else {
					for(int i=0;i<=zerrenda.size();i++) {
						berria=zerrenda.posizioanLortu(i);
						add(berria.data);
					}
				}
			}
		}
		count=count+zerrenda.size();
	}
}
