package packDEA;

import java.util.ArrayList;
import java.util.Iterator;


public class listaFilmak {
	private ArrayList<Pelikula> lista;
	
	
	public listaFilmak(){
		this.lista=new ArrayList<Pelikula>();
	}
	
	
	public boolean badago(Pelikula pPelikula) {
		return this.lista.contains(pPelikula);
	}
	
	public void pelikulaGehitu(Pelikula pPelikula) {
		if(!this.lista.contains(pPelikula)) {
			lista.add(pPelikula);
		}
	}
}
