package packProbak;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AktoreaTest {
	Aktorea a1,a2,a3,a4,a5,a6,a7,a8;
	ListaFilmak lf1;
	Pelikula p1,p2;

	@Before
	public void setUp() throws Exception {
		a1 = new Aktorea("Alec Guinness");
		a2 = new Aktorea("Peter Cushing");
		a3 = new Aktorea("Carrie Fisher");
		a4 = new Aktorea("Mark Hamill");
		
		//Izen berdina duten aktoreak
		a5 = new Aktorea("Alec Guinness");
		a6 = new Aktorea("Peter Cushing");
		a7 = new Aktorea("Carrie Fisher");
		a8 = new Aktorea("Mark Hamill");
		
		//ListaFilmak
		lf1 = new ListaFilmak();
		
		//Pelikulak ListaFilman sartzeko
		p1 = new Pelikula("Un cadaver a los postres",20);
		p2 = new Pelikula("Pulp Fiction",10);
		
	}

	@After
	public void tearDown() throws Exception {
		a1 = null;
		a2 = null;
		a3 = null;
		a4 = null;
		a5 = null;
		a6 = null;
		a7 = null;
		a8 = null;
    
	}

	@Test
	public void testAktorea() {
		assertNotNull(a1);
		