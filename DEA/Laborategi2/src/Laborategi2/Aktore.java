package Laborategi2;

import java.util.ArrayList;
import java.util.Iterator;

public class Aktore {
	private String izena;
	private String abizena;
	private ArrayList<Pelikula>listaPelikulak = new ArrayList<Pelikula>();
	
	
	//Eraikitzailea
	public Aktore(String pIzena,String pAbizena) {
		this.izena = pIzena;
		this.abizena = pAbizena;
	}
	
	private Iterator<Pelikula> getIteradorea(){
		return this.listaPelikulak.iterator();
	}
	//Getter metodoak.
	public ArrayList<Pelikula> getPelikulak() {
		return this.listaPelikulak;
	}
	public String getIzena() {
		return this.izena;
	}
	public String getAbizena() {
		return this.abizena;
	}
	//Metodoak
	public void gehituPelikula (Pelikula pPelikula) {
		listaPelikulak.add(pPelikula);
	}
	public void kenduPelikula(Pelikula pPelikula) {
		listaPelikulak.remove(pPelikula);
	}
	public int  zenbatPelikula() {
		return listaPelikulak.size();
	}
	public boolean badagoPelikula(String pPeli) {
		boolean badago = false;
		Iterator<Pelikula> itr = this.getIteradorea();
		Pelikula p;
		while (itr.hasNext() && badago == false){
			p = itr.next();
			if (p.getIzena() == pPeli) {
				badago = true;
			}
		}
		return badago;
	}
	public ArrayList<Pelikula> itzuliPelikulak() {
		return this.listaPelikulak;
	}
	
	public void ikusiPelikulak() {
		Pelikula p =null;
		Iterator<Pelikula> itr = this.getIteradorea();
		if(itr.hasNext()) {
			while(itr.hasNext()) {
				p=itr.next();
				System.out.println(p.getIzena());
			}
		}
	}
	
	 @Override
	    public boolean equals(Object o) {
	        Aktore person = (Aktore) o;
	        if (o instanceof Aktore && this.getAbizena() == person.getAbizena()&& this.getIzena()== person.getIzena()) {
	        	return true;
	        }else  	return false;
	  
	 }

	
}
