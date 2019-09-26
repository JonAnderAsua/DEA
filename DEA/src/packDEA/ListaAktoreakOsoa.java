package packDEA;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

public class ListaAktoreakOsoa {
	private ArrayList<Aktorea> lista;
	private static ListaAktoreakOsoa nireListaAktoreakOsoa;
	
	private ListaAktoreakOsoa() {
		this.lista=new ArrayList<Aktorea>();
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
				ListaPelikulakOsoa.getNireListaPelikulakOsoa().gehituPelikula("a");
				ListaAktoreakOsoa.getNireListaAktoreakOsoa().aktoreaGehitu(aktoreak);
			}
		entrada.close(); 
		}
		catch(IOException e) {e.printStackTrace();}
	}
	
	public void aktoreaGehitu(String[] pAktorea){ //Aktore bat listaAktore batean txertatzen du
		Aktorea a=new Aktorea(pAktorea);
		this.lista.add(a);
	}
	
	public void listaAktoreakSortu(){
		this.cargarLista("FilmActors20162017.txt");
	}
}
