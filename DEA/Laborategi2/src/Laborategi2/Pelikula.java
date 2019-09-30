package Laborategi2;

import java.util.ArrayList;

public class Pelikula {
	private String izena;
	private ArrayList<Aktore> listaAktoreak = new ArrayList<Aktore>();
	private int dirua;
	
	public Pelikula(String pIzena, int pDirua) {
		this.izena = pIzena;
		this.listaAktoreak =null;
		this.dirua = pDirua;
	}
	public String getIzena() {
		return this.izena;
	}
	public ArrayList<Aktore> getListaAktore(){
		return this.listaAktoreak;
	}
	public int getDirua() {
		return this.dirua;
	}
	public void diruaGehitu(int pDirua) {
		this.dirua = this.dirua + pDirua;
	}
	public void gehituAktore (Aktore pAktore) {
		if(this.listaAktoreak==(null)) {
			this.listaAktoreak=new ArrayList<Aktore>();
		}
		this.listaAktoreak.add(pAktore);
	}
	public void kenduAktore(Aktore pAktore) {
		listaAktoreak.remove(pAktore);
	}
	public int getAktoreKopurua() {
		return this.listaAktoreak.size();
	}
}