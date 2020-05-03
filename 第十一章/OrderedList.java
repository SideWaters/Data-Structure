// Introduced in Chapter 11
/** A linked list of Comparable items, in increasing order. */
public class OrderedList<E extends Comparable<E>> implements Set<E>, Predecessor<E> {

	/** The first node in the list. */
	private ListNode<E> front;

	/** An OrderedList is initially empty. */
	public OrderedList() {
		front = null;
	}

	public void add(E target) {
		Predecessor<E> prev = this;
		ListNode<E> node = front;
		while (node != null) {
			int comparison = target.compareTo(node.getItem());
			if (comparison < 0) {
				prev.setNext(new ListNode<E>(target, node));
				return;
			}
			if (comparison == 0) {
				return;
			}
			prev = node;
			node = node.getNext();
		}
		prev.setNext(new ListNode<E>(target));
	}

	public boolean contains(E target) {
		ListNode<E> node = front;
		while (node != null) {
			int comparison = target.compareTo(node.getItem());
			if (comparison < 0) {
				return false;
			}
			if (comparison == 0) {
				return true;
			}
			node = node.getNext();
		}
		return false;
	}

	public ListNode<E> getNext() {
		return front;
	}

	public void remove(E target) {
		Predecessor<E> prev = this;
		ListNode<E> node = front;
		while (node != null) {
			int comparison = target.compareTo(node.getItem());
			if (comparison == 0) {
				prev.setNext(node.getNext());
				return;
			}
			if (comparison < 0) {
				return;
			}
			prev = node;
			node = node.getNext();
		}
	}

	public void setNext(ListNode<E> next) {
		front = next;
	}

	public int size() {
		int tally = 0;
		for (ListNode<E> node = front; node != null; node = node.getNext()) {
			tally++;
		}
		return tally;
	}

	public String toString() {
		String result = "( ";
		for (ListNode<E> node = front; node != null; node = node.getNext()) {
			result += node.getItem() + " ";
		}
		return result + ")";
	}

	public void addAll(Set<E> target) {
		OrderedList<E> o = (OrderedList<E>) target;
		ListNode<E> node = o.front;
		while (node != null) {
			this.add(node.getItem());
			node = node.getNext();
		}
	}

	public void retainAll(Set<E> target) {
		OrderedList<E> ol = (OrderedList<E>) target;
		ListNode<E> node = front;
		while (node != null) {
			if (!ol.contains(node.getItem())) {
				this.remove(node.getItem());
			}
			node = node.getNext();
		}
	}
}
