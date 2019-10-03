package packDEA;
import java.util.HashMap;

public class ListaPelikulakOsoa {
	private HashMap<Integer,Pelikula> map=null;
	private int giltza=0;
	private static ListaPelikulakOsoa nireListaPelikulakOsoa=null;
	
	private ListaPelikulakOsoa() {
		this.map=new HashMap<Integer,Pelikula>();
	}
	
	public static ListaPelikulakOsoa getNireListaPelikulakOsoa() {
		if(nireListaPelikulakOsoa==null) {
			nireListaPelikulakOsoa=new ListaPelikulakOsoa();
		}
		
		return nireListaPelikulakOsoa;
	}
	public void gehituPelikula(String pString) {
		Pelikula p=new Pelikula(pString);
		if (!this.map.containsKey(p)){ //galdetu
			this.map.put(this.giltza,p);
		}
		this.giltza++;
	}
	
	public Pelikula pelikulaBilatu(Pelikula pPelikula) {
		Pelikula emaitza=null;
		if(map.containsKey(pPelikula)) {
			emaitza=pPelikula;
		}
		return emaitza;
	}
}