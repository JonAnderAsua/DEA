package packBigarrenPraktika;

public class DoubleLinkedList {
	private LinearNode first;
	private LinearNode last;
	private int count;
	private String deskribapena;
	
	
	public DoubleLinkedList() {
		first=null;
		last=null;
		count=0;
	}
	
	public void setDesk(String pDeskribapena){
		//Aurre:
		//Post: Sartutako Stringa deskribapena bihurtzen du
		this.deskribapena=pDeskribapena;
	}
	
	public String getDesk(){
		return this.deskribapena;
	}
	
	public Ikaslea removeFirst() {
		Ikaslea ik=null;
		if(!isEmpty()) {
			ik=first.data;
		}
		return ik;
	}
	
	private boolean isEmpty() {
		return first==null;
	}
	
	
}
