package packDEA;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class listaAktoreak {
	private ArrayList<Aktorea> lista;
	
	public listaAktoreak(){
		this.lista= new ArrayList<Aktorea>();
	}
	
	private Iterator<Aktorea> getIteradorea(){
		return this.lista.iterator();
	}
	
	public void aktoreaKendu(Aktorea pAktorea){ //Aktore bat listaAktoretik kentzen du
		if(this.lista.contains(pAktorea)) {
			this.lista.remove(pAktorea);
		}
	}
	
	public void aktoreaGehitu(String pIzena){ //Aktore bat listaAktore batean txertatzen du
		Aktorea a=new Aktorea(pIzena);
		if(!this.lista.contains(a)) {
			this.lista.add(a);
		}
	}
	
	public listaFilmak aktorearenPelikulakBueltatu(Aktorea pAktorea) {  //Sartutako aktorearen pelikulak bueltatzen ditu
		return pAktorea.listaBueltatu();
	}
	
	public void zerrendaOrdenatu(listaAktoreak[] pLista){ //listaAktoreak ordenatzen du
		quickSort(pLista,0,pLista.luzera()-1);
	}
	
	private void quickSort(listaAktoreak taulaBat[],int pHasiera, int pBukaera){
		if(pBukaera-pHasiera>0){
			int indizeaZatiketa=zatiketa(taulaBat,pHasiera,pBukaera);
			quickSort(taulaBat, pHasiera, indizeaZatiketa-1);
			quickSort(taulaBat,indizeaZatiketa+1,pBukaera);
		}
	}
	
	private int zatiketa(listaAktoreak[] taula,int pI,int pF){
		Aktorea lag=taula[pI];
		int ezker=pI;
		int eskuin=pF;
		while(ezker<eskuin){
			while(taula[ezker].compareTo(lag)<=0 && ezker<eskuin) {
				ezker++;
			}
			while(taula[eskuin].compareTo(lag)>0){
				eskuin--;
			}
			if(ezker<eskuin) {
				swap(taula,ezker,eskuin);
			}
		}
		taula[pI]=taula[eskuin];
		taula[eskuin]=lag;
	}
	
	private void swap(listaAktoreak taula,int pOne, int pTwo) {
		Aktorea temp=taula[pOne];
		taula[pOne]=taula[pTwo];
		taula[pTwo]=temp;
	}
	
	public listaAktoreak pelikularenAktoreakBueltatu(Pelikula pPelikula) { //Pelikula bat sartuta han agertutako aktoreak bueltatzen ditu
		listaAktoreak l = new listaAktoreak();
		Aktorea a=null;
		Iterator<Aktorea>itr=this.getIteradorea();
		while(itr.hasNext()){
			a=itr.next();
			if(a.pelikulanParteHartu(pPelikula)){
				l.aktoreaGehitu(a.getIzena());
			}
		}
		return l;
	}
	
	public void zerrendaFitxategianGorde() { //listaAktorea fitxategi batean gordetzen du
		String ruta = "~/DEA/listaAktoreak.txt";
	    File f = new File(ruta);
	    FileWriter fw = new FileWriter(f);
	    BufferedWriter escritura = new BufferedWriter(fw);
	    for(int i=0;i<lista.size();i++){
	        escritura.write(lista.get(i));
	        escritura.newLine();

	    }
	    escritura.close();
	}
	
	private int luzera() {
		return this.lista.size();	}
}