package Laborategi2;

import java.util.ArrayList;
import java.util.Iterator;

public class listaPelikula {
		private static listaPelikula i = null;
		private ArrayList<Pelikula> lista;
		
		//eraikitzailea
		private listaPelikula() {
			this.lista = new ArrayList<Pelikula>();
	}

		
		public static synchronized listaPelikula getLista() {
			if ( listaPelikula.i == null) {
				listaPelikula.i = new listaPelikula();
			}
			return i;
		}
		public void gehituPelikula(Pelikula pPelikula) {
			lista.add(pPelikula);
		}
		private Iterator<Pelikula> getIteradorea() {
			return this.lista.iterator();
		}
		public void kenduPelikula(Pelikula pPelikula) {
			lista.remove(pPelikula);
		}
		public int listaLuzeera() {
			return lista.size();
		}
		public void ezabatu() {
			lista.clear();
		}
		public boolean badagoPelikula (Pelikula pPelikula) { 
				Iterator<Pelikula> itr = this.getIteradorea();
				Pelikula p1=null;
				while (itr.hasNext() ) {
//					System.out.println(a++);
					p1 = itr.next();
					if (p1.getIzena().equals(pPelikula.getIzena())) {
					return true;
		}
				}
				return false;
		}
		public Pelikula itZuliPelikula(String pIzena) { //return !instanceof Pelikula por algun motivo, null?
			Iterator<Pelikula> itr = this.getIteradorea();
			Pelikula p1=null;
			boolean aurkitua = false;
			while (itr.hasNext() ) {
//				System.out.println(a++);
				p1 = itr.next();
				if (p1.getIzena().equals(pIzena)) {
					aurkitua=true;
				}
			}
			if(!aurkitua) {
				return null;
			}else { 
				return p1;
		}
}
}
