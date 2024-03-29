package packBigarrenPraktika;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoubleLinkedList<T> implements ListADT<T> {

	// Atributuak
	protected Node<T> first; // lehenengoaren erreferentzia
	protected String deskr;  // deskribapena
	protected int count;

	public DoubleLinkedList() {
		first = null;
		deskr = "";
		count = 0;
	}
	
	public void setDeskr(String ize) {
	  deskr = ize;
	}

	public String getDeskr() {
	  return deskr;
	}

	public T removeFirst() {
	// listako lehen elementua kendu da
	// Aurrebaldintza: zerrenda ez da hutsa
		// KODEA OSATU ETA KOSTUA KALKULATU
		T lag=null;
		if(!isEmpty()) { //Nahiz eta aurrebaldintzan kasu hau agertuko ez dela esan tratatuko dugu
			lag=first.data;
			if(first.equals(first.next)) {
				first=null;
			}
			else {
				first.prev.next=first.next;
				first.next.prev=first.prev;
				first=first.next;
			}
			count--;
		}
		return lag;
	}
	
	//Kostua konstante da lehenengo elementua bakarrik begiratzen delako

	public T removeLast() {
	// listako azken elementua kendu da
	// Aurrebaldintza: zerrenda ez da hutsa
		// KODEA OSATU ETA KOSTUA KALKULATU
		T emaitza=null;
		if(!isEmpty()) { //Nahiz eta aurrebaldintzan kasu hau agertuko ez dela esan tratatuko dugu
			if(first.prev.equals(first)) {
				emaitza=first.data;
				removeFirst();
			}
			else {
				first.prev=first.prev.prev;
				first.prev.next=first;
			}
			count--;
		}
		return emaitza;
    }
		//Kostua = konstantea, firstaren aurreko posizioa bakarrik kudeatzen duelako

	public T remove(T elem) {
	// Aurrebaldintza: zerrenda ez da hutsa
	// Balio hori listan baldin badago, bere lehen agerpena ezabatuko dut. Kendutako objektuaren erreferentzia 
        //  bueltatuko du (null ez baldin badago)
		// KODEA OSATU ETA KOSTUA KALKULATU
		Node<T> lag;
		boolean topatuta=false;
		T emaitza=null;
		if(!isEmpty()){//Nahiz eta aurrebaldintzan kasu hau agertuko ez dela esan tratatuko dugu
			if(first.data.equals(elem)){//Elementua lehenengoa da
				emaitza=first.data;
				removeFirst();
			}
			else {
				lag=first.next;
				while(lag!=first && !topatuta) {
					lag=lag.next;
					topatuta=lag.data.equals(elem);
				}
				if(topatuta) {
					emaitza=lag.data;
					lag.prev.prev.next=lag;
					lag.prev=lag.prev.prev;
					count --;	
				}
			}
		}
		return emaitza;
	}
     

	//Kostua = n da, kasurik txarrenean zerrenda osoa zeharkatu behar duelako	
	
	public T first() {
	// listako lehen elementua ematen du
	      if (isEmpty())
	          return null;
	      else return first.data;
	}

	public T last() {
	// listako azken elementua ematen du
	      if (isEmpty())
	          return null;
	      else return first.prev.data;
	}

	public boolean contains(T elem) {
	//Aurre: 
	//Post: Egiazkoa bueltatuko du aurkituz gero, eta false bestela
	// KODEA OSATU ETA KOSTUA KALKULATU
		boolean badago=false;
		Node<T> lag;
		if(!isEmpty()) {
			badago=first.data.equals(elem);
			lag=first.next;
			while(lag!=first&&!badago) {
				lag=lag.next;
				badago=lag.data.equals(elem);
			}
		}
		return badago;
	}
	//Kostua = n da, kasurik txarrenean zerrenda osoa zeharkatu behar duelako	
	
	
	public T find(T elem) {
	// Elementua bueltatuko du aurkituz gero, eta null bestela
		// KODEA OSATU ETA KOSTUA KALKULATU
		boolean badago=false;
		Node<T> lag;
		T emaitza;
		if(!isEmpty()){
			badago=first.data.equals(elem);
			lag=first.next;
			while(lag!=first &&!badago) {
				lag=lag.next;
				badago=lag.data.equals(elem);
			}
			if(!badago) {return null;}
			else {
				emaitza=lag.data;
				return emaitza;
			
			}
		}
		else {
			return null;
		}
	}
	
	//Kostua = n da, kasurik txarrenean zerrenda osoa zeharkatu behar duelako. n: Nodo kopurua


	public boolean isEmpty() 
	{ return first == null;};
	
	public int size() { 
		Node<T>lag;
		int emaitza=0;
		if(!isEmpty()) {
			lag=first;
			while(lag.next!=first) {
				lag=lag.next;
				emaitza++;
			}
		}
		System.out.println(emaitza);
		return emaitza;
	}
	
	public Node<T> posizioanLortu(Integer pPosizioa){
		Node<T> emaitza=null;
		int i=pPosizioa-1;
		if(!isEmpty()) {
			emaitza=first;
			while(i>0&&emaitza.next!=first){
				emaitza=emaitza.next;
				i--;
			}
			if(emaitza.next==first) {
				emaitza=null;
			}
		}
		return emaitza;
	}
	
	public void gehituAmaieran(Node<T> pNodoa) {
	//Aurre:
	//Post: Nodoa zerrendan ez badago amaieran gehitzen du
		if(!isEmpty()) {
			if(!contains(pNodoa.data)) {
				pNodoa.prev=first.prev;
				pNodoa.next=first;
				first.prev.next=pNodoa;
				first.prev=pNodoa;
			}
		}
		else {
			first=pNodoa;
			first.prev=first.next=first;
		}
	}
	
	/** Return an iterator to the stack that iterates through the items . */ 
	   public Iterator<T> iterator() { return new ListIterator(); } 

	   // an iterator, doesn't implement remove() since it's optional 
	   private class ListIterator implements Iterator<T> { 
		// KODEA OSATU 
		   private Node<T> oraingoa=first;
		   private int indizea=0;

	       public boolean hasNext(){ 
	    	   System.out.println(size());
	    	   return indizea < size(); 
	       }

	       public T next() {
	    	   T emaitza=null;
	    	   if (!hasNext()){
	    		   throw new NoSuchElementException();
	    	   }
	    	   else {
	    		  emaitza=oraingoa.data;
	    		  oraingoa=oraingoa.next;
	    		  indizea++;
	    	   }
	    	   return emaitza;
	        }

	   } // private class
		
		
		public void adabegiakInprimatu() {
			System.out.println(this.toString());
		}

		
		@Override
		public String toString() {
			String result = new String();
			Iterator<T> it = iterator();
			while (it.hasNext()) {
				T elem = it.next();
				result = result + "[" + elem.toString() + "] \n";
			}	
			return "SimpleLinkedList " + result + "]";
		}

		
}
