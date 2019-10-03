package packDEA;
import java.util.HashMap;

public class ListaPelikulakOsoa {
	private HashMap<String,Pelikula> map=null;
	private int giltza=0;
	private static ListaPelikulakOsoa nireListaPelikulakOsoa=null;
	
	private ListaPelikulakOsoa() {
		this.map=new HashMap<String,Pelikula>();
	}
	
	public static ListaPelikulakOsoa getNireListaPelikulakOsoa() {
		if(nireListaPelikulakOsoa==null) {
			nireListaPelikulakOsoa=new ListaPelikulakOsoa();
		}
		
		return nireListaPelikulakOsoa;
	}
	public Pelikula gehituPelikula(String pString) {
		Pelikula p=new Pelikula(pString);
		if (!this.map.containsKey(p)){ //galdetu
			this.map.put(pString,p);
		}
		return p;
	}
	
	public Pelikula pelikulaBilatu(Pelikula pPelikula) {
		Pelikula emaitza=null;
		if(map.containsKey(pPelikula)) {
			emaitza=pPelikula;
		}
		return emaitza;
	}
}