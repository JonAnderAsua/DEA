package packDEA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
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
		return pAktorea.pelikulenLista();
	}
	
	public void zerrendaOrdenatu(){ //listaAktoreak ordenatzen du
		ArrayList<String> listaBerria = this.lista.Cast<String>().ToArray();
		Collections.sort(listaBerria);
		return (ArrayList<String>) listaBerria;
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
}