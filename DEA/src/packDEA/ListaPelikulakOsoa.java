package packDEA;
import java.util.ArrayList;

public class ListaPelikulakOsoa {
	private ArrayList<Pelikula> lista;
	private static ListaPelikulakOsoa nireListaPelikulakOsoa=null;
	
	private ListaPelikulakOsoa() {
		this.lista=new ArrayList<Pelikula>();
	}
	
	public static ListaPelikulakOsoa getNireListaPelikulakOsoa() {
		if(nireListaPelikulakOsoa==null) {
			nireListaPelikulakOsoa=new ListaPelikulakOsoa();
		}
		
		return nireListaPelikulakOsoa;
	}
	public void gehituPelikula(String pString) {
		Pelikula p= new Pelikula("pString");
		if(!this.lista.contains(p)){
			this.lista.add(p);
		}
	}
	

}
