package packLehenengoPraktika;

import static org.junit.Assert.*;
import packDEA.Pelikula;
import packDEA.listaAktoreak;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import packDEA.Aktorea;
import packDEA.ListaAktoreakOsoa;

public class ListaAktoreakOsoaTest {
	Aktorea a1,a2,a3;

	@Before
	public void setUp() throws Exception {
		a1=new Aktorea("Pitt Brad");
		a2=new Aktorea("Stone Emma");
		a3=new Aktorea("Grier Pam");
		ListaAktoreakOsoa.getNireListaAktoreakOsoa().aktoreaGehitu(a1.getIzena());
		ListaAktoreakOsoa.getNireListaAktoreakOsoa().aktoreaGehitu(a2.getIzena());
		ListaAktoreakOsoa.getNireListaAktoreakOsoa().aktoreaGehitu(a3.getIzena());
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetNireListaAktoreakOsoa() {
		assertNotNull(ListaAktoreakOsoa.getNireListaAktoreakOsoa());
	}

	@Test
	public void testAktoreaGehitu() {
		assertEquals(ListaAktoreakOsoa.getNireListaAktoreakOsoa().luzera(),3);
		ListaAktoreakOsoa.getNireListaAktoreakOsoa().aktoreaGehitu("Hanks Tom");
		assertEquals(ListaAktoreakOsoa.getNireListaAktoreakOsoa().luzera(),4);
		ListaAktoreakOsoa.getNireListaAktoreakOsoa().aktoreaGehitu("Hanks Tom");
		
		//Errepikatzen bada ez du berriro sartuko
		assertEquals(ListaAktoreakOsoa.getNireListaAktoreakOsoa().luzera(),4);
		
		//Beste aktore berri bat sartu
		ListaAktoreakOsoa.getNireListaAktoreakOsoa().aktoreaGehitu("Paul Aron");
		assertEquals(ListaAktoreakOsoa.getNireListaAktoreakOsoa().luzera(),5);
	}

	@Test
	public void testAktoreaBilatu() {
		assertEquals(ListaAktoreakOsoa.getNireListaAktoreakOsoa().aktoreaBilatu(a1),a1);
		assertEquals(ListaAktoreakOsoa.getNireListaAktoreakOsoa().aktoreaBilatu(a2),a2);
		assertEquals(ListaAktoreakOsoa.getNireListaAktoreakOsoa().aktoreaBilatu(a3),a3);
		assertNotEquals(ListaAktoreakOsoa.getNireListaAktoreakOsoa().aktoreaBilatu(a3),a1);
		assertNotEquals(ListaAktoreakOsoa.getNireListaAktoreakOsoa().aktoreaBilatu(a3),a2);
	}

	@Test
	public void testOrdenatu() {
		fail("Not yet implemented");
	}

	@Test
	public void testPelikularenAktoreak() {
		Pelikula p=new Pelikula("Senderos De Gloria");
		listaAktoreak l=new listaAktoreak();
		listaAktoreak l2=new listaAktoreak();
		l.aktoreaGehitu(a1.getIzena());
		l.aktoreaGehitu(a2.getIzena());
		a1.gehituPelikula(p);
		a2.gehituPelikula(p);
		assertEquals(l,ListaAktoreakOsoa.getNireListaAktoreakOsoa().pelikularenAktoreak(p));
		assertNotEquals(l2,ListaAktoreakOsoa.getNireListaAktoreakOsoa().pelikularenAktoreak(p));
	}
}
