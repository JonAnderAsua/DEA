package packBigarrenPraktika;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DoubleLinkedListTest {
	DoubleLinkedList<Pertsona> lista,lista2,lista3,lista4;
	Pertsona p1,p2,p3,p4,p5;
	Node n1,n2,n3,n4,n5;

	@Before
	public void setUp() throws Exception {
		lista=new DoubleLinkedList<Pertsona>();
		lista2=new DoubleLinkedList<Pertsona>();
		lista3=new DoubleLinkedList<Pertsona>();
		lista4=new DoubleLinkedList<Pertsona>();
		p1=new Pertsona("Pertsona1","1");
		p2=new Pertsona("Pertsona2","2");
		p3=new Pertsona("Pertsona3","3");
		p4=new Pertsona("Pertsona4","4");
		p5=new Pertsona("Pertsona5","5");
		n1=new Node(p1);
		lista.gehituAmaieran(n1);
		n2=new Node(p2);
		lista.gehituAmaieran(n2);
		n3=new Node(p3);
		lista.gehituAmaieran(n3);
		n4=new Node(p4);
		lista.gehituAmaieran(n4);
		n5=new Node(p5);
		lista2.gehituAmaieran(n2);
		lista2.gehituAmaieran(n3);
		lista2.gehituAmaieran(n4);
		lista3.gehituAmaieran(n1);
		lista3.gehituAmaieran(n2);
		lista3.gehituAmaieran(n3);
	}

	@After
	public void tearDown() throws Exception {
		lista.gehituAmaieran(n1);
		lista.gehituAmaieran(n2);
		lista.gehituAmaieran(n3);
		lista.gehituAmaieran(n4);
		lista2.gehituAmaieran(n2);
		lista2.gehituAmaieran(n3);
		lista2.gehituAmaieran(n4);
		lista3.gehituAmaieran(n1);
		lista3.gehituAmaieran(n2);
		lista3.gehituAmaieran(n3);
	}

	@Test
	public void testDoubleLinkedList() {
		assertNotNull(lista);
	}

	@Test
	public void testSetDeskr() {
		lista.setDeskr("Proba1");
		assertEquals(lista.getDeskr(),"Proba1");
		lista.setDeskr("Proba2");
		assertEquals(lista.getDeskr(),"Proba2");
		lista.setDeskr("Proba3");
		assertEquals(lista.getDeskr(),"Proba3");
	}

	@Test
	public void testRemoveFirst() {
		assertNotEquals(lista,lista2);
		lista.removeFirst();
		assertEquals(lista,lista2);
		lista2.removeFirst();
		assertNotEquals(lista,lista2);
		lista.removeFirst();
		assertEquals(lista,lista2);
	}

	@Test
	public void testRemoveLast() {
		assertNotEquals(lista,lista3);
		lista.removeLast();
		assertEquals(lista,lista3);
	}

	@Test
	public void testRemove() {
		assertNotNull(lista.find(p1));
		lista.remove(p1);
		assertNull(lista.find(p1));
	}

	@Test
	public void testFirst() {
		assertEquals(lista.first(),n1);
		assertEquals(lista2.first(),n2);
		assertEquals(lista3.first(),n1);
	}

	@Test
	public void testLast() {
		assertEquals(lista.last(),n4);
		assertEquals(lista.last(),n4);
		assertEquals(lista.last(),n3);
	}

	@Test
	public void testContains() {
		
		//Lehenengo lista
		assertTrue(lista.contains(p1));
		assertTrue(lista.contains(p2));
		assertTrue(lista.contains(p3));
		assertTrue(lista.contains(p4));
		assertFalse(lista.contains(p5));
		
		//Bigarren lista
		assertTrue(lista2.contains(p2));
		assertTrue(lista2.contains(p3));
		assertTrue(lista2.contains(p4));
		assertFalse(lista2.contains(p5));
		assertFalse(lista2.contains(p1));
		
		//Hirugarren lista
		assertTrue(lista3.contains(p1));
		assertTrue(lista3.contains(p2));
		assertTrue(lista3.contains(p3));
		assertFalse(lista3.contains(p4));
		assertFalse(lista3.contains(p5));
		
	}

	@Test
	public void testFind() {
		
		//Lehenengo lista
		assertEquals(lista.find(p1),p1);
		assertEquals(lista.find(p2),p2);
		assertEquals(lista.find(p3),p3);
		assertEquals(lista.find(p4),p4);
		assertNotEquals(lista.find(p5),p5); 
		
		//Bigarren lista
		assertEquals(lista2.find(p2),p2);
		assertEquals(lista2.find(p3),p3);
		assertEquals(lista2.find(p4),p4);
		assertNotEquals(lista2.find(p1),p1);
		assertNotEquals(lista2.find(p5),p5);
		
		//Hirugarren lista
		assertEquals(lista3.find(p1),p1);
		assertEquals(lista3.find(p2),p2);
		assertEquals(lista3.find(p3),p3);
		assertNotEquals(lista3.find(p4),p4);
		assertNotEquals(lista3.find(p5),p5);
	}

	@Test
	public void testIsEmpty() {
		assertTrue(lista4.isEmpty());
		assertFalse(lista.isEmpty());
		assertFalse(lista2.isEmpty());
		assertFalse(lista3.isEmpty());
	}

	@Test
	public void testSize() {
		
		//Lehenengo lista
		assertEquals(lista.size(),4);
		lista.gehituAmaieran(n5);
		assertNotEquals(lista.size(),4);
		assertEquals(lista.size(),5);
		lista.gehituAmaieran(n5);
		assertEquals(lista.size(),5);
		
		//Bigarren lista
		assertEquals(lista2.size(),3);
		lista2.gehituAmaieran(n4);
		assertEquals(lista2.size(),4);
		lista2.gehituAmaieran(n5);
		assertEquals(lista2.size(),5);
		lista2.gehituAmaieran(n5);
		assertEquals(lista2.size(),5);
		
		//Hirugarren lista
		assertEquals(lista2.size(),3);
		lista2.gehituAmaieran(n1);
		assertEquals(lista2.size(),4);
		lista2.gehituAmaieran(n5);
		assertEquals(lista2.size(),5);
		lista2.gehituAmaieran(n5);
		assertEquals(lista2.size(),5);
	}

	@Test
	public void testPosizioanLortu() {
		fail("Not yet implemented");
	}

	@Test
	public void testGehituAmaieran() {
		fail("Not yet implemented");
	}

	@Test
	public void testIterator() {
		fail("Not yet implemented");
	}

	@Test
	public void testAdabegiakInprimatu() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

}
