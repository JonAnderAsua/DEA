package packDEA;

public class Aktorea {
	private String izenAbizena;
	private listaFilmak lista;
	
	
	public Aktorea(String pIzenAbizena){
		this.izenAbizena=pIzenAbizena;
		this.lista=this.pelikulenLista();
	}
	
	private listaFilmak pelikulenLista(){ //Aktorearen pelikulen lista bueltatzen du
		return this.lista;
	}
	
	public boolean izenBerdina(String pIzena) {  //Sartutako Stringa eta aktorearen izena berdinak diren konparatzen du
		return (this.izenAbizena==pIzena);
	}
	
	public listaFilmak listaBueltatu() { //Aktorearen filmak (listaFilmak) bueltatzen du
		return this.lista;
	}
	
	public boolean pelikulanParteHartu(Pelikula pPelikula) { //Aktorea sartutako pelikulan parte hartu duen ala ez adierazten du
		return this.lista.badago(pPelikula);
	}
}
