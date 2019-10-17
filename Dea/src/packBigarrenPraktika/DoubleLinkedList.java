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
		T lag=first.data;
		first=first.next;
		count--;
		return lag;
	}
	
	//Kostua konstante da lehenengo elementua bakarrik begiratzen delako

	public T removeLast() {
	// listako azken elementua kendu da
	// Aurrebaldintza: zerrenda ez da hutsa
		// KODEA OSATU ETA KOSTUA KALKULATU
		T lag=first.prev.data;
		first.prev=first.prev.prev;
		return lag;
    }
		//Kostua = konstantea, firstaren aurreko posizioa bakarrik kudeatzen duelako

	public T remove(T elem) {
	// Aurrebaldintza: zerrenda ez da hutsa
	// Balio hori listan baldin badago, bere lehen agerpena ezabatuko dut. Kendutako objektuaren erreferentzia 
        //  bueltatuko du (null ez baldin badago)
		// KODEA OSATU ETA KOSTUA KALKULATU
		Node<T> lag=null;
		boolean topatuta=false;
		T emaitza=null;
		if(first.data.equals(elem)){
			emaitza=first.data;
			removeFirst();
		}
		else {
			lag=first;
			while(lag!=null&&!topatuta) {
				topatuta=(lag.data.equals(elem));
			}
		}
		if(topatuta) {
			emaitza=lag.data;
			lag.next.prev=lag.prev;
			lag=lag.next;
			count--;
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
	// Egiazkoa bueltatuko du aurkituz gero, eta false bestela
	// KODEA OSATU ETA KOSTUA KALKULATU
		boolean badago=false;
		Node<T> lag;
		if(!isEmpty()) {
			badago=first.data.equals(elem);
			lag=first.next;
			while(lag!=null&&!badago) {
				badago=lag.data.equals(elem);
				lag=lag.next;
			}
		}
		return badago;
	}
	//Kostua = n da, kasurik txarrenean zerrenda osoa zeharkatu behar duelako	
	
	
	public T find(T elem) {
	// Elementua bueltatuko du aurkituz gero, eta null bestela
		// KODEA OSATU ETA KOSTUA KALKULATU
		boolean badago=false;
		Node<T> lag=null;
		T emaitza=null;
		if(!isEmpty()) {
			badago=first.data.equals(elem);
			lag=first.next;
			while(lag!=null&&!badago) {
				badago=lag.data.equals(elem);
				lag=lag.next;
			}
		}
		emaitza=lag.data;
		return emaitza;
	}
	
	//Kostua = n da, kasurik txarrenean zerrenda osoa zeharkatu behar duelako. n: Nodo kopurua


	public boolean isEmpty() 
	{ return first == null;};
	
	public int size() 
	{ return count;};
	
	/** Return an iterator to the stack that iterates through the items . */ 
	   public Iterator<T> iterator() { return new ListIterator(); } 

	   // an iterator, doesn't implement remove() since it's optional 
	   private class ListIterator implements Iterator<T> { 
		// KODEA OSATU 
		   private Node<T> current=first;
		   private int index=0;

	       public boolean hasNext(){ 
	    	   return index < count; 
	       }

	       public T next() {
	    	   T tmp=null;
	    	   if (!hasNext()){
	    		   throw new NoSuchElementException();
	    	   }
	    	   else {
	    		   tmp=current.data;
	    		   current = current.next;
	    		   index++;
	    	   }
	    	   return tmp;
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
