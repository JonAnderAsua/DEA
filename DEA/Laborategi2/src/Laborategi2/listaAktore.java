package Laborategi2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class listaAktore {
	private static listaAktore i;
	private HashMap<String,Aktore> lista = null;
	
	public static synchronized listaAktore getLista() {
		if (listaAktore.i == null) {
			listaAktore.i = new listaAktore();
		}
		return i;
	}
// Eraikitzaile pribatua
	private listaAktore() {
		lista = new HashMap<String,Aktore>();
	}

	public void gehituAktorea(Aktore pAktore) {
			this.lista.put(pAktore.getIzena()+ " "+pAktore.getAbizena(), pAktore);
	}

	public int listaLuzeera() {
		return this.lista.size();
	}
	public void clear() {
		this.lista.clear();
	}
	public Aktore bilatuAktorea(String pIzena, String pAbizena) {
		return this.lista.get(pIzena + " "+pAbizena);
	}
	public boolean aktoreaDago(String pIzena, String pAbizena) {
		return lista.containsKey(pIzena+ " "+pAbizena);
	}
	public ArrayList<String> aktoreOrdenatuak() {
		List<String> listaordenatua = new ArrayList<>(lista.keySet());
		Collections.sort(listaordenatua);
//		Iterator<String> itr =listaordenatua.iterator();
////		while(itr.hasNext()) {
////			System.out.println(itr.next());
////		}
		return (ArrayList<String>) listaordenatua;
	}
	
}
