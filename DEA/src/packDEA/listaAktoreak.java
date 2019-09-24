package packlab1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
		if(bilatuAktorea(pAktorea)) {
			this.lista.remove(pAktorea);
		}
	}
	
	public void aktoreaGehitu(Aktorea pAktorea){ //Aktore bat listaAktore batean txertatzen du
		if(!bilatuAktorea(pAktorea)) {
			this.lista.add(pAktorea);
		}
	}
	public boolean bilatuAktorea(Aktorea pAktorea){ //Aktore bat sartuta aktore hori listaAktorean dagoen ala ez adierazten du
		Iterator<Aktorea>itr=this.getIteradorea();
		Boolean topatuta=false;
		Aktorea a=null;
		while(itr.hasNext()&&!topatuta){
			a=itr.next();
			topatuta=(a.equals(pAktorea));
		}
		return topatuta;
	}
	
	public listaFilmak aktorearenPelikulakBueltatu(Aktorea pAktorea) {  //Sartutako aktorearen pelikulak bueltatzen ditu
		return pAktorea.listaBueltatu();
	}
	
	private void zerrendaOrdenatu(){ //listaAktoreak ordenatzen du
		//TODO
	}
	
	public listaAktoreak aktoreenZerrendaOrdenatua() { //Ordenatuta dagoen listaAktorea bueltatzen du 
		this.lista.zerrendaOrdenatu();
		return this.lista;
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