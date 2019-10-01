package packDEA;
import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;


public class ListaAktoreakOsoa {
	private HashMap<Integer,Aktorea> map=null;
	private int giltza=0;
	private static ListaAktoreakOsoa nireListaAktoreakOsoa;
	
	private ListaAktoreakOsoa() {
		this.map=new HashMap<Integer,Aktorea>();
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
				ListaPelikulakOsoa.getNireListaPelikulakOsoa().gehituPelikula(a[1]);
				ListaAktoreakOsoa.getNireListaAktoreakOsoa().aktoreaGehitu(aktoreak[1]);
			}
		entrada.close(); 
		}
		catch(IOException e) {e.printStackTrace();}
	}
	
	public void aktoreaGehitu(String pAktorea){ //Aktore bat listaAktore batean txertatzen du
		Aktorea a=new Aktorea(pAktorea);
		if (!this.map.containsKey(a)){
			this.map.put(this.giltza,a);
		}
		this.giltza++;
	}
	
	public void listaAktoreakSortu(){  //Pelikulen eta aktoreen fitxategia irakurtzen du
		this.cargarLista("FilmActors20162017.txt");
	}
}
