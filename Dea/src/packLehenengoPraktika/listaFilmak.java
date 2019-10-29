package packLehenengoPraktika;

import packBigarrenPraktika.Node;

public class listaFilmak {
	private Node<Pelikula> first;
	private int count=0;
	
	
	public listaFilmak(){
		this.first=null;
	}
	
	public void pelikulaGehitu(Pelikula pPelikula) {
		//Aurre:
		//Post: Pelikula ez badago zerrendan HASIERAN gehitzen du
		if(isEmpty()) {
			Node<Pelikula>berria=new Node(pPelikula);
			first=berria;
			berria.prev=berria.next=berria;
		}
		else{
			if(!contains(pPelikula)) {
				Node<Pelikula>berria=new Node(pPelikula);
				berria.next=first;
				berria.prev=first.prev;
				first.prev.next=berria;
				first.prev=berria;
				berria=first;
			}
		}
	}
	
	public boolean contains(Pelikula pPelikula) {
		boolean badago=false;
		Node<Pelikula> lag;
		int i=count;
		if(!isEmpty()) {
			badago=first.data.equals(pPelikula);
			lag=first.next;
			while(i>=0&&!badago) {
				lag=lag.next;
				badago=lag.data.equals(pPelikula);
			}
		}
		return badago;
	}
	
	public boolean isEmpty() {
		return this.first.equals(null);
	}
}
