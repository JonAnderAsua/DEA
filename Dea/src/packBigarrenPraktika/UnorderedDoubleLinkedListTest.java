package packBigarrenPraktika;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UnorderedDoubleLinkedListTest {
	
	UnorderedDoubleLinkedList<Pertsona> lista1;
	Pertsona p1,p2,p3;

	@Before
	public void setUp() throws Exception {
		lista1=new UnorderedDoubleLinkedList<Pertsona>();
		p1=new Pertsona("Pertsona1","1");
		p2=new Pertsona("Pertsona2","2");
		p3=new Pertsona("Pertsona3","3");
	}

	@After
	public void tearDown() throws Exception {
		while(lista1.isEmpty()) { //erreseteatzeko
			lista1.removeFirst();
		}
	}

	@Test
	public void testAddToFront() {
		lista1.addToFront(p1);
		assertEquals(lista1.first(),p1);
		lista1.addToFront(p2);
		assertEquals(lista1.first(),p2);
		lista1.addToFront(p3);
		assertEquals(lista1.first(),p3);
	}

	@Test
	public void testAddToRear() {
		lista1.addToRear(p1);
		assertEquals(lista1.first(),p1);
		assertEquals(lista1.last(),p1);
		lista1.addToRear(p2);
		assertEquals(lista1.first(),p1);
		assertEquals(lista1.last(),p2);
		lista1.addToRear(p3);
		assertEquals(lista1.first(),p1);
		assertEquals(lista1.last(),p3);
	}

	@Test
	public void testAddAfter() {
		
		lista1.addToFront(p1);
		lista1.addAfter(p2, p1);
		assertEquals(lista1.posizioanLortu(2),p2);
		lista1.addAfter(p3, p1);
		assertEquals(lista1.posizioanLortu(2),p3);
		assertEquals(lista1.posizioanLortu(3),p2);
	}

}
