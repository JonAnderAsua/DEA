package packDEA;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
//import java.rmi.RemoteException;
//import java.util.logging.Level;
//import java.util.logging.Logger;

public class listaAktoreak {
	private ArrayList<Aktorea> lista;
	
	public listaAktoreak(){
		this.lista= new ArrayList<Aktorea>();
	}
	
	private Iterator<Aktorea> getIteradorea(){
		return this.lista.iterator();
	}
	
	public void cargarLista(String nomF){      
		try {
			Scanner entrada = new Scanner(new FileReader());      
			String linea;     
			while (entrada.hasNext()) {         
				linea = entrada.nextLine();         
				//	...      
			}
		entrada.close(); 
		}
		catch(IOException e) {e.printStackTrace();}
	}
	public void aktoreaKendu(Aktorea pAktorea){ //Aktore bat listaAktoretik kentzen du
		if(this.lista.contains(pAktorea)) {
			this.lista.remove(pAktorea);
		}
	}
	
	public void aktoreaGehitu(Aktorea pAktorea){ //Aktore bat listaAktore batean txertatzen du
		if(!this.lista.contains(pAktorea)) {
			this.lista.add(pAktorea);
		}
	}
	
	public listaFilmak aktorearenPelikulakBueltatu(Aktorea pAktorea) {  //Sartutako aktorearen pelikulak bueltatzen ditu
		return pAktorea.listaBueltatu();
	}
	
	public void zerrendaOrdenatu(T[]taula){ //listaAktoreak ordenatzen du
		quickSort(taula,0,taula.length-1);
	}
	
	private void quickSort(T[]taulaBat,int pHasiera, int pBukaera){
		if(pBukaera-pHasiera>0){
			int indizeaZatiketa=zatiketa(taulaBat,pHasiera,pBukaera);
			quickSort(taulaBat, pHasiera, indizeaZatiketa-1);
			quickSort(taulaBat,indizeaZatiketa+1,pBukaera);
		}
	}
	
	private int zatiketa(T[]taula,int pI,int pF){
		T lag=taula[pI];
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
	
	private void swap(T[] taula,int pOne, int pTwo) {
		T temp=taula[pOne];
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
				l.aktoreaGehitu(a);
			}
		}
		return l;
	}
	
	public void zerrendaFitxategianGorde() { //listaAktorea fitxategi batean gordetzen du
		//TODO
	}
}