package packBigarrenPraktika;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OrderedDoubleLinkedListTest {
	OrderedDoubleLinkedList<Pertsona> l1,l2,l3,l4;
	Pertsona p1,p2,p3,p4,p5;

	@Before
	public void setUp() throws Exception {
		l1=new OrderedDoubleLinkedList<Pertsona>();
		l2=new OrderedDoubleLinkedList<Pertsona>();
		
		p1=new Pertsona("Pertsona1","1");
		p2=new Pertsona("Pertsona2","2");
		p3=new Pertsona("Pertsona3","3");
		p4=new Pertsona("Pertsona4","4");
		p5=new Pertsona("Pertsona5","5");
		
		l1.add(p1);
		l1.add(p2);
		l1.add(p3);
		
		l3.add(p1);
		l3.add(p2);
		l3.add(p3);
		l3.add(p4);
		l3.add(p5);
		
		l4.add(p1);
		l4.add(p3);
		l4.add(p4);
		l4.add(p5);
	}

	@After
	public void tearDown() throws Exception {
		l2.removeFirst();
		l2.removeFirst();
		l2.removeFirst();
	}

	@Test
	public void testAdd() {
		
		l2.add(p2);
		l2.add(p3);
		l2.add(p1);
		assertEquals(l1.first(),l2.first());
		assertEquals(l1.posizioanLortu(2),l2.posizioanLortu(2));
		assertEquals(l1.last(),l2.last());
	}

	@Test
	public void testMerge() {
		
		//Bata bestearen atzean dagoenean
		l2.add(p4);
		l2.add(p5);
		
		l1.merge(l2);
		
		assertEquals(l1.first(),l3.first());
		assertEquals(l1.posizioanLortu(2),l3.posizioanLortu(2));
		assertEquals(l1.posizioanLortu(3),l3.posizioanLortu(3));
		assertEquals(l1.posizioanLortu(4),l3.posizioanLortu(4));
		assertEquals(l1.last(),l3.last());
		
		//Bata bestearen barnean dagoenean
		
		l1.removeFirst();
		l1.removeLast();
		
		//Momentu honetan l1 p2 bakarrik du
		
		l1.merge(l4);
		assertEquals(l1.first(),l3.first());
		assertEquals(l1.posizioanLortu(2),l3.posizioanLortu(2));
		assertEquals(l1.posizioanLortu(3),l3.posizioanLortu(3));
		assertEquals(l1.posizioanLortu(4),l3.posizioanLortu(4));
		assertEquals(l1.last(),l3.last());
	}

}
