package packDEA;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class ListaAktoreakOsoa {
	private HashMap<String,Aktorea> map=null;
	private static ListaAktoreakOsoa nireListaAktoreakOsoa;
	
	private ListaAktoreakOsoa() {
		this.map=new HashMap<String,Aktorea>();
	}
	
	public static ListaAktoreakOsoa getNireListaAktoreakOsoa() {
		if(nireListaAktoreakOsoa==null) {
			nireListaAktoreakOsoa=new ListaAktoreakOsoa();
		}
		return nireListaAktoreakOsoa;
	}
	
	public void cargarLista(String nomF){      
		try {
			Scanner entrada = new Scanner(new FileReader(nomF));      
			String linea;     
			while (entrada.hasNext()) {         
				linea = entrada.nextLine();         
				String[]a=linea.split("\\s--->\\s");
				String[]aktoreak=a[1].split("\\s&&&\\s");
				Pelikula peli=ListaPelikulakOsoa.getNireListaPelikulakOsoa().gehituPelikula(a[0]);
				for(int i=0;i<aktoreak.length;i++){
					Aktorea aktore=ListaAktoreakOsoa.getNireListaAktoreakOsoa().aktoreaGehitu(aktoreak[i]);
					aktore.gehituPelikula(peli);
				}
			}
		entrada.close(); 
		}
		catch(IOException e) {e.printStackTrace();}
	}
	
	public Aktorea aktoreaGehitu(String pAktorea){ //Aktore bat listaAktore batean txertatzen du
		Aktorea a=new Aktorea(pAktorea);
		if (!this.map.containsKey(a)){ //galdetu
			this.map.put(pAktorea,a);
		}
		return a;
	}
	
	public Aktorea aktoreaBilatu(Aktorea pAktorea){
		Aktorea emaitza=null;
		if(this.map.containsKey(pAktorea)){
			emaitza=pAktorea;
		}
		return emaitza;
	}
	
	public ArrayList<String> ordenatu() {
		List<String> listaordenatua = new ArrayList<>(map.keySet());
		Collections.sort(listaordenatua);
		return (ArrayList<String>) listaordenatua;
	}
	
	public listaAktoreak pelikularenAktoreak(Pelikula pPelikula) {
		listaAktoreak lista=new listaAktoreak();
		Iterator it = map.entrySet().iterator();
		while (it.hasNext()) {
		    Map.Entry e = (Map.Entry)it.next();
		    Aktorea a=e.getValue();
		    lista.aktoreaGehitu(a);
		}
		return lista;
	}
}
