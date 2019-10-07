package packDEA;

public class Aktorea {
	private String izenAbizena;
	private listaFilmak lista;
	
	
	public Aktorea(String pIzenAbizena){
		this.izenAbizena=pIzenAbizena;
		this.lista=this.pelikulenLista();
	}
	
	public listaFilmak pelikulenLista(){ //Aktorearen pelikulen lista bueltatzen du
		return this.lista;
	}
	
	public boolean izenBerdina(String pIzena) {  //Sartutako Stringa eta aktorearen izena berdinak diren konparatzen du
		return (this.izenAbizena.equals(pIzena));
	}
	
	public boolean pelikulanParteHartu(Pelikula pPelikula) { //Aktorea sartutako pelikulan parte hartu duen ala ez adierazten du
		return this.lista.badago(pPelikula);
	}
	
	public String getIzena() {
		return this.izenAbizena;
	}
	
	public void gehituPelikula(Pelikula pPelikula) {
		this.lista.pelikulaGehitu(pPelikula);
	}
}