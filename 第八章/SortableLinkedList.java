// Introduced in Chapter 8
/** A linked List of Comparables. */
public class SortableLinkedList<E extends Comparable<E>> extends LinkedList<E> implements Comparable<LinkedList> {

	/** Add target in order, assuming this List is currently sorted. */
	protected void addInOrder(E target) {
		Predecessor<E> prev = this;
		ListNode<E> node = getNext();
		while ((node != null) && (node.getItem().compareTo(target) < 0)) {
			prev = node;
			node = node.getNext();
		}
		prev.setNext(new ListNode<E>(target, node));
	}

	/** Arrange the elements in this List from smallest to largest. */
	public void insertionSort() {
		SortableLinkedList<E> newList = new SortableLinkedList<E>();
		for (E e : this) {
			newList.addInOrder(e);
		}
		setNext(newList.getNext());
	}

	@Override
	public int compareTo(LinkedList that) {
		if(this==that) {
			return 0;
		}
		for(int i=0;i<size()&&i<that.size();i++) {
			E a=get(i);
			E b=(E)that.get(i);
			int c=a.compareTo(b);
			if(c!=0) {
				return c;
			}
		}
		return size()-that.size();
		
	}

	public static void main(String[] args) {
		SortableLinkedList<Integer> a = new SortableLinkedList<Integer>();
		SortableLinkedList<Integer> b = new SortableLinkedList<Integer>();
		a.add(1);
		a.add(2);
		b.add(3);
		System.out.println(a);
		System.out.println(b);
		System.out.println(b.compareTo(a));
	}

}
