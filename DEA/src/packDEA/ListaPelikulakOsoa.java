package packDEA;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

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
	
	

}
