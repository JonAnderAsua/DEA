package packBigarrenPraktika;

public class Ikaslea {
	private String izena;
	private int nan;
	
	public Ikaslea(String pIzena,int pNan) {
		this.izena=pIzena;
		this.nan=pNan;
	}
	
	public int getNan() {
		return this.nan;
	}
	
	public boolean konparatu(Ikaslea pIkaslea) {
		return (this.nan==pIkaslea.getNan());
	}

}
