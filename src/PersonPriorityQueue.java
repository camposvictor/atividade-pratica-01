import java.util.ArrayList;
import java.util.List;

public class PersonPriorityQueue {
	private int inQueue;

	class Node {
		Person data;
		Node next;

		public Node(Person data) {
			this.data = data;
			this.next = null;
		}
	}

	Node head;
	Node tail;

	public PersonPriorityQueue() {
		inQueue = 0;
		head = null;
		tail = null;
	}

	public void add(Person data) {
		Node newNode = new Node(data);

		if (head == null) {
			head = newNode;
			tail = newNode;
			this.inQueue++;

			return;
		}

		if (!data.getHasPriority()) {
			tail.next = newNode;
			tail = newNode;
			this.inQueue++;

			return;
		}

		if (!head.data.getHasPriority() && data.getHasPriority()) {
			newNode.next = head;
			head = newNode;
			this.inQueue++;

			return;
		}

		Node current = head;

		while (current != tail && current.next.data.getHasPriority()) {
			current = current.next;
		}

		newNode.next = current.next;
		current.next = newNode;

		if (current == tail) {
			tail = newNode;
		}

		this.inQueue++;
	}

	public Person remove() {
		if (this.inQueue == 0)
			return null;

		Person data = head.data;
		head = head.next;

		if (head == null)
			tail = null;

		this.inQueue--;
		return data;

	}

	public boolean isEmpty() {
		return this.inQueue == 0;
	}

	public int size() {
		return this.inQueue;
	}

	public List<Person> findAll() {
		List<Person> list = new ArrayList<Person>();
		Node current = head;

		while (current != null) {
			list.add(current.data);
			current = current.next;
		}

		return list;
	}
}
