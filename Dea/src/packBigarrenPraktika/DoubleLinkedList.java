package packBigarrenPraktika;

public class DoubleLinkedList {
	private LinearNode first;
	private LinearNode last;
	private int count;
	private String deskribapena;
	
	
	public DoubleLinkedList() {
		first=null;
		last=null;
		count=size();
	}
	
	public void setDesk(String pDeskribapena){
		//Aurre:
		//Post: Sartutako Stringa deskribapena bihurtzen du
		this.deskribapena=pDeskribapena;
	}
	
	public String getDesk(){
		//Aurre:
		//Post: Linked listaren deskribapena bueltatzen du
		return this.deskribapena;
	}
	
	public Ikaslea removeFirst(){
		//Aurre:
		//Post: Lehenengo linear nodea ezabatzen du
		Ikaslea ik=null;
		if(!isEmpty()) {
			ik=first.data;
			first=first.next;
		}
		return ik;
	}
	
	private boolean isEmpty() {
		//Aurre:
		//Post: Lista hutsa dagoen ala ez adierazten du, hutsa bada True bueltako du, bestela false
		return first==null;
	}
	
	public Ikaslea removeLast() {
		//Aurre:
		//Post: Lisha Hutsa ez bada azkenengo Linear Nodea ezabatzen du eta ezabatutakoa bueltatzen du
		LinearNode lag=new LinearNode();
		if(!isEmpty()) {
			lag=first;
			while(last.next!=null) {
				last=lag.next;
			}
			lag=last;
			last=null;
		}
		return lag.data;
	}
	
	public Ikaslea removeElem(Ikaslea pIkaslea){
		//Aurre:
		//Post: Sartutako elementua listan badago ezabatzen eta bueltatzen du
		boolean topatua=false;
		if(!isEmpty()) {
			LinearNode lag = new LinearNode();
			LinearNode lag2 = new LinearNode();
			lag=first;
			lag2=first.next;
			topatua=lag.data.konparatu(pIkaslea);
			lag=first.next;
			while(lag!=null&&!topatua) {
				lag=lag.next;
				lag2=lag2.next;
				topatua=lag.data.konparatu(pIkaslea);
			}
			if(topatua) {
				lag2=lag2.next.next;
			}
			return lag.data;
		}
	}
	
	public Ikaslea first() {
		//Aurre:
		//Post: Zerrendaren lehenengo elementua bueltatzen du
		Ikaslea lag=null;
		if(!isEmpty()) {
			lag=first.data;
		}
		return lag;
	}
	
	public Ikaslea last(){
		//Aurre:
		//Post: Zerrendaren azkenengo elementua bueltatzen du
		LinearNode lag=new LinearNode();
		if(!isEmpty()) {
			lag=first;
			while(lag.next!=null){
				lag=lag.next;
			}
		}
		return lag.data;
	}
	
	public boolean contains(Ikaslea pIkaslea) {
		//Aurre:
		//Post:Elementua listan dagoen ala ez adierazten du, badago true bueltatuko du, bestela false
		LinearNode lag=new LinearNode();
		boolean topatua=false;
		if(!isEmpty()) {
			lag=first;
			while(lag!=null&&!topatua) {
				topatua=lag.data.konparatu(pIkaslea);
				lag=lag.next;
			}
		}
		return topatua;
	}
	
	public Ikaslea find(Ikaslea pIkaslea) {
		//Aurre:
		//Post: Elemetua zerrendan bilatzen du, badago elementu hori bueltatuko du, bestela null
		Ikaslea ik=null;
		if(contains(pIkaslea)) {
			ik=pIkaslea;
		}
		return ik;
	}
	
	public int size() {
		//Aurre:
		//Post: Listaren tamaina bueltatzen du
		int kont=0;
		LinearNode lag=new LinearNode();
		if(!isEmpty()) {
			lag=first;
			while(lag!=null) {
				lag=lag.next;
				kont++;
			}
		}
		return kont;
	}
	
	
	
}
