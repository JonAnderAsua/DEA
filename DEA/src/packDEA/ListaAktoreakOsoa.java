package packDEA;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
			Scanner entrada = new Scanner(new FileReader());      
			String linea;     
			while (entrada.hasNext()) {         
				linea = entrada.nextLine();         
				//	...      
			}
		entrada.close(); 
		}
		catch(IOException e) {e.printStackTrace();}
	}
	
	public void aktoreaGehitu(Aktorea pAktorea){ //Aktore bat listaAktore batean txertatzen du
		if(!this.lista.contains(pAktorea)) {
			this.lista.add(pAktorea);
		}
	}
}
