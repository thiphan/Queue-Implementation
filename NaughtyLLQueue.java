package homeWork7;

public class NaughtyLLQueue<E> implements Queue<E> {
	private static class Node<E> {	// "static" means that Node does *not* have access to the instance variables of LinkedList
		private E data;
		private Node<E> next;

		// Constructor (generated automatically through Eclipse)
		public Node(E data, Node<E> next) {
			super();
			this.data = data;
			this.next = next;
		}
	}
	private Node<E> head;
	private int size;
	
	
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public E peek() {
		if (!isEmpty()) {
			Node<E> temp = head;
			while(temp.next!=null) {
				temp = temp.next;
			}
			return temp.data;
		}
		else
			return null;
	}

	// Enqueue: add a new node before the head Node
	@Override
	public void enqueue(E newItem) {
		if (!isEmpty()) {
			Node<E> temp = new Node<>(newItem, head);
			head = temp;	
		} else	// Special case of adding to an empty queue - both head and tail should be pointing to the same node after adding
			head = new Node<>(newItem, null);
		size++;
	}

	// Dequeue: make a traversal and remove the tail Node
	@Override
	public E dequeue() {
		if (!isEmpty()) {
			E toReturn = head.data;
			if(head.next!=null) {
				Node<E> temp = head;
				while(temp.next.next!=null) {
					temp = temp.next;
				}
				toReturn = temp.next.data;
				temp.next =null;
			}
			else {
				toReturn = head.data;
				head = null;
			}							
			size--;
			return toReturn;
		}
		else
			return null;
	}

	
	public String toString() {
		String r = "LLQueue object (size = " + size + "), containing (front to back): ";
		for (Node<E> temp =  head; temp != null; temp = temp.next)
			r += temp.data + "; ";
		return r;
	}
	public static void main(String[] args) {
		Queue<String> q = new NaughtyLLQueue<>();
		System.out.println(q.dequeue());
		q.enqueue("dark chocolate");
		System.out.println(q);
		q.enqueue("darker chocolate");
		System.out.println(q);
		q.enqueue("even darker chocolate");
		System.out.println(q);
		q.enqueue("the darkest chocolate");
		System.out.println(q);
		q.enqueue("inferior (milk) chocolate");
		System.out.println(q);
		q.enqueue("more dark chocolate");
		System.out.println(q);
				
		while (!q.isEmpty()) {
			System.out.println("remove " + q.dequeue());
			System.out.println(q);
		}
	}
}
