package packLehenengoPraktika;

import packLehenengoPraktika.Node;

public class Node<Pelikula> {
		public Pelikula data; 			// dato del nodo
		public Node<Pelikula> next; 	// puntero al siguiente nodo de la lista
		public Node<Pelikula> prev; 	// puntero al anterior nodo de la lista
		// -------------------------------------------------------------

		public Node(Pelikula dd) 		// constructor
		{
			data = dd;
			next = null;
			prev = null;
		}
	}


