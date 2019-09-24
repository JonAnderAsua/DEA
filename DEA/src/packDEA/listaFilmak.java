package packlab1;

import java.util.ArrayList;
import java.util.Iterator;


public class listaFilmak {
	private ArrayList<Pelikula> lista;
	
	public listaFilmak(){
		this.lista=new ArrayList<Pelikula>();
	}
	
	private Iterator<Pelikula> getIteradorea(){
		return this.lista.iterator();
	}
	
	public boolean pelikulaDago(Pelikula pPelikula) {  //Aktoreak parte hartu duen pelikuletan bilaketa egiten du, pelikula badago true bueltatzen du, bestela false
		Iterator<Pelikula>itr=this.getIteradorea();
		Pelikula p=null;
		boolean topatuta=false;
		while(itr.hasNext()&&!topatuta) {
			p=itr.next();
			topatuta=(p==pPelikula);
		}
		return topatuta;
	}
}
