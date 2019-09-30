package Laborategi2;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;



public class Scannera {

public static void main(String[] args) throws Exception {
	Boolean kargatuta=false;
	listaAktore.getLista().clear();
	System.out.println("Pelikula eta aktoreak kargatzen daude, prozesu honek ez luke denbora luzerik hartu behar");
	while (!kargatuta) {
		kargatuta=listakKargatu();
	}
	new Scannera();
}

	public Scannera() throws Exception {
		
		System.out.println("Zer egin nahiko zenuke?");
		System.out.println("1. aukera: Aktore baten pelikula guztiak ikusi");
		System.out.println("2. aukera: Aktoreen lista ordenatua lortu");
		System.out.println("3. aukera: Aktore berri bat gehitu");
		System.out.println("4. aukera: Pelikula baten aktoreak itzuli");
		
		Scanner aukera = new Scanner(System.in);
		
		switch (aukera.nextInt()) 
		{
	
		case 1:
		    aukera.nextLine(); //D
		    this.aktorearenPelikulak();
		    amaitu();
		    break; //para que despues de preguntar amaitu acabe
		    case 2:
		    this.listaOrdenatua();
		    amaitu();
		    aukera.close();
		    break; //para que despues de preguntar amaitu acabe
	  
		    case 3:
		    amaitu(); 
		    aukera.close();
		    break; //para que despues de preguntar amaitu acabe
		    
		    case 4:
		    aukera.nextLine();
		    System.out.println("Idatzi pelikularen izena (Ipini espazio bat amaieran)");
			this.pelikularenAktoreak();
			amaitu(); 
			aukera.close();
		  	break;
		
		    case 5:
		    amaitu(); 
		    aukera.close();
		    break;
		    
		    case 6:
		    System.out.println ( "6 aukera, aktore baten ezabaketa" ); //No tengo en cuenta la opcion de que la pelicula no este.
		   	System.out.println("Idatzi ezabatu nahi den aktorearen izena");
		   	amaitu(); 
		    aukera.close();
		    break;
		    
		    default:
		    System.err.println ( "Ez dago horrelako aukerarik" );
		    break;
		}
		aukera.close();
	}

	public void amaitu() throws Exception {
		System.out.println("Saioa amaitu nahi duzu?");
		System.out.println("Horrela baldin bada, sartu 9");
		System.out.println("Bestela, sartu 0");
		Scanner irten = new Scanner(System.in);
	       
		switch (irten.nextInt()) 
		{
		    case 9:
		    System.out.println ("Saio amaituko da.");
		    break;
	  
		    case 0:
		    new Scannera();
		    irten.close();
		    break;
		    
		    default:
		    System.err.println ( "Ez dago horrelako aukerarik" );
		    irten.close();
		    break;
		}
		irten.close();
	}

	
	public static Boolean listakKargatu() throws Exception{
	  
		long startTime = System.nanoTime();
		String[] unekoAktore=null;
		String[] linea = null;
	    File file = new File("C:\\Users\\elsan\\Desktop\\FilmsActors20162017.txt"); 
	    Scanner sc = new Scanner(file); 
	    TimeUnit.SECONDS.sleep(1);
	    while (sc.hasNextLine()) {
		    linea = sc.nextLine().replace(" &&& ", "<").replace("> ", ">").split("[<>]+"); //la primera linea
		    String pelikulaIzena=linea[0].replace("-","");
		    Pelikula Pelikula1 =new Pelikula(pelikulaIzena,0);
	    	for(int i=1;i<linea.length;i++) { //pongo i=1 porque el primer dato del array es el nombre de la peli y no un actor
	    		unekoAktore=linea[i].replace(", ",",").split(",");
	    		if(unekoAktore.length==1) { //por algun motivo hay actores que no tienen apellido (o estan mal formateados, yo que se) en la lista 
	    			String izena = unekoAktore[0];
	    			Aktore Aktore1 = new Aktore(izena, "");
	    			if(listaAktore.getLista().aktoreaDago(izena, "")){
	    				Pelikula1.gehituAktore(listaAktore.getLista().bilatuAktorea(izena, ""));
	    				listaAktore.getLista().bilatuAktorea(izena, "").gehituPelikula(Pelikula1);
	    			}else {
		    			Pelikula1.gehituAktore(Aktore1);
		    			Aktore1.gehituPelikula(Pelikula1);
		    			listaAktore.getLista().gehituAktorea(Aktore1);	    
	    			}			
	    		}else{
	    			String abizena = unekoAktore[0]; //el apellido
	    			String izena = unekoAktore[1]; //el nombre 
	    			Aktore Aktore1 = new Aktore(izena, abizena);
	    			if(listaAktore.getLista().aktoreaDago(izena, abizena)){
	    				Pelikula1.gehituAktore(listaAktore.getLista().bilatuAktorea(izena,abizena));
	    				listaAktore.getLista().bilatuAktorea(izena, abizena).gehituPelikula(Pelikula1);
	    			}else {
		    			Pelikula1.gehituAktore(Aktore1);
		    			Aktore1.gehituPelikula(Pelikula1);
		    			listaAktore.getLista().gehituAktorea(Aktore1);	    
	    			}	
	    		}
	    	}
	    	listaPelikula.getLista().gehituPelikula(Pelikula1);
	    }
	    System.out.println(listaAktore.getLista().listaLuzeera() + " aktore ezberdin daude.");
	    System.out.println(listaPelikula.getLista().listaLuzeera() + " pelikula daude.");
	    long endTime = System.nanoTime();

		long timeElapsed = endTime - startTime;

		System.out.println(timeElapsed / 1000000000 + " segundu behar izan dira. " );
		sc.close();
		return true;
	  }
	
	
	public String idatziString() {
		 Scanner s = new Scanner(System.in);
		 String gureString =null;
		 gureString=s.nextLine();
		 return gureString;
	}
	public ArrayList<Aktore> pelikularenAktoreak(){
		String ad = this.idatziString();
//		System.out.println(listaPelikula.getLista().itZuliPelikula(ad) instanceof Pelikula);
		ArrayList<Aktore> aktoreak = listaPelikula.getLista().itZuliPelikula(ad).getListaAktore();
		System.out.println(aktoreak.size() + " aktore ditu pelikula honek");
		return aktoreak;
	}
	public void aktorearenPelikulak(){
		System.out.println("Idatzi aktorearen izena"); 
		String iZ=this.idatziString();//usaremos este metodo apartir de ahora
		System.out.println("Idatzi aktorearen abizena");
		String iA= this.idatziString();
		System.out.println(listaAktore.getLista().bilatuAktorea(iZ, iA).zenbatPelikula());
//		return listaAktore.getLista().bilatuAktorea(iZ, iA).getPelikulak();
		
	}
	public ArrayList<String> listaOrdenatua(){
		return listaAktore.getLista().aktoreOrdenatuak();
		
	}
}
