package packBigarrenPraktika;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sun.jndi.ldap.BerDecoder;

class DoubleLinkedListTest {
	DoubleLinkedList<Pertsona> lista,lista2,lista3,lista4;
	Pertsona p1,p2,p3,p4,p5;
	Node n1,n2,n3,n4,n5;
	
	@BeforeEach
	void setUp() throws Exception {
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

	@AfterEach
	void tearDown() throws Exception {
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
	void testDoubleLinkedList() {
		assertNotNull(lista);
	}

	@Test
	void testSetDeskr() {
		lista.setDeskr("Proba1");
		assertEquals(lista.getDeskr(),"Proba1");
		lista.setDeskr("Proba2");
		assertEquals(lista.getDeskr(),"Proba2");
		lista.setDeskr("Proba3");
		assertEquals(lista.getDeskr(),"Proba3");
	}

	@Test
	void testGetDeskr() {
		assertNotEquals(lista,lista2);
		lista.removeFirst();
		assertEquals(lista.toString(),lista2.toString());
		lista2.removeFirst();
		assertNotEquals(lista,lista2);
		lista.removeFirst();
		assertEquals(lista.toString(),lista2.toString());
	}

	@Test
	void testRemoveFirst() {
		assertNotEquals(lista,lista3);
		lista.removeLast();
		assertEquals(lista.toString(),lista3.toString());
	}

	@Test
	void testRemoveLast() {
		assertNotNull(lista.find(p1));
		lista.remove(p1);
		assertNull(lista.find(p1));
	}

	@Test
	void testRemove() {
		assertNotNull(lista.find(p1));
		lista.remove(p1);
		assertNull(lista.find(p1));
	}

	@Test
	void testFirst() {
		assertEquals(lista.first(),n1);
		assertEquals(lista2.first(),n2);
		assertEquals(lista3.first(),n1);
	}

	@Test
	void testLast() {
		assertEquals(lista.last(),n4);
		assertEquals(lista.last(),n4);
		assertEquals(lista.last(),n3);
	}

	@Test
	void testContains() {

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
	void testFind() {

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
	void testIsEmpty() {
		assertTrue(lista4.isEmpty());
		assertFalse(lista.isEmpty());
		assertFalse(lista2.isEmpty());
		assertFalse(lista3.isEmpty());
	}
	
	@Test
	void testSize() {

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
	void testPosizioanLortu() {
		lista.gehituAmaieran(n1);
		lista.gehituAmaieran(n2);
		lista.gehituAmaieran(n3);
		
		lista.gehituAmaieran(n4);
		//Lehenengo lista
		assertTrue(lista.posizioanLortu(0).equals(n1));
		assertTrue(lista.posizioanLortu(1).equals(n2));
		assertTrue(lista.posizioanLortu(2).equals(n3));
		assertTrue(lista.posizioanLortu(3).equals(n4));
		
		
		//Bigarren lista
		assertTrue(lista2.posizioanLortu(0).equals(n2));
		assertTrue(lista2.posizioanLortu(1).equals(n3));
		assertTrue(lista2.posizioanLortu(2).equals(n4));
		
		
		//Hirugarren lista
		assertTrue(lista3.posizioanLortu(0).equals(n1));
		assertTrue(lista3.posizioanLortu(1).equals(n2));
		assertTrue(lista3.posizioanLortu(2).equals(n3));
	}

	@Test
	void testGehituAmaieran() {

		//Lehenengo lista
		assertEquals(lista.last(),n4);
		lista.gehituAmaieran(n5);
		assertEquals(lista.last(),n5);
		lista.gehituAmaieran(n1);
		assertEquals(lista.last(),n5);
		lista.gehituAmaieran(n2);
		assertEquals(lista.last(),n5);
		lista.gehituAmaieran(n3);
		assertEquals(lista.last(),n5);
		lista.gehituAmaieran(n4);
		assertEquals(lista.last(),n5);
		
		//Bigarren lista
		assertEquals(lista2.last(),n4);
		lista2.gehituAmaieran(n1);
		assertEquals(lista2.last(),n1);
		lista.gehituAmaieran(n1);
		assertEquals(lista.last(),n5);
		lista.gehituAmaieran(n2);
		assertEquals(lista.last(),n5);
		lista.gehituAmaieran(n3);
		assertEquals(lista.last(),n5);
		lista.gehituAmaieran(n4);
		assertEquals(lista.last(),n5);
		
		//Hirugarren lista
		assertEquals(lista3.last(),n3);
		lista3.gehituAmaieran(n4);
		assertEquals(lista3.last(),n4);
		lista3.gehituAmaieran(n5);
		assertEquals(lista3.last(),n5);
		lista3.gehituAmaieran(n1);
		assertEquals(lista3.last(),n5);
		lista3.gehituAmaieran(n2);
		assertEquals(lista3.last(),n5);
		lista3.gehituAmaieran(n3);
		assertEquals(lista3.last(),n5);
		
		//Laugarren lista
		assertNull(lista4.last());
		lista4.gehituAmaieran(n1);
		assertEquals(lista4.last(),n1);
		lista4.gehituAmaieran(n2);
		assertEquals(lista4.last(),n2);
		lista4.gehituAmaieran(n3);
		assertEquals(lista4.last(),n3);
		lista4.gehituAmaieran(n4);
		assertEquals(lista4.last(),n4);
		lista4.gehituAmaieran(n5);
		assertEquals(lista4.last(),n5);
		lista4.gehituAmaieran(n1);
		assertEquals(lista4.last(),n5);
		lista4.gehituAmaieran(n2);
		assertEquals(lista4.last(),n5);
		lista4.gehituAmaieran(n3);
		assertEquals(lista4.last(),n5);
		lista4.gehituAmaieran(n4);
		assertEquals(lista4.last(),n5);
		lista4.gehituAmaieran(n5);
		assertEquals(lista4.last(),n5);
	}

}
