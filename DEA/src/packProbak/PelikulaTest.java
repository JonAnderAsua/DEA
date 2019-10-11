package packProbak;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import packDEA.Pelikula;

public class PelikulaTest {
	Pelikula p1,p2,p3;

	@Before
	public void setUp() throws Exception {
		p1=new Pelikula("Reservoir Dogs");
		p2=new Pelikula("Blade Runner");
		p3=new Pelikula("Senderos De Gloria");
	}

	@After
	public void tearDown() throws Exception {
		p1=null;
		p2=null;
		p3=null;
	}

	@Test
	public void testPelikula() {
		assertNotNull(p1);
		assertNotNull(p2);
		assertNotNull(p3);
	}

	@Test
	public void testSetDirua() {
		p1.setDirua(100);
		assertEquals(p1.getDirua(),100);
		assertNotEquals(p1.getDirua(),50);
		
		p2.setDirua(150);
		assertEquals(p2.getDirua(),150);
		assertNotEquals(p2.getDirua(),50);
		
		p3.setDirua(196);
		assertEquals(p3.getDirua(),196);
		assertNotEquals(p3.getDirua(),50);
	}

}
