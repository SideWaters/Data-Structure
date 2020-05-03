// Introduced in Chapter 6
/** Iterator used by the LinkedList class. */
public class ListIterator<E> implements java.util.Iterator<E> {

  /** The Predecessor of node. */
  private Predecessor<E> prev;
  
  /**
   * The ListNode containing the last element returned, or the
   * LinkedList itself if no elements have yet been returned.
   */
  private Predecessor<E> node;

  /** The ListIterator starts at the beginning of the List. */
  public ListIterator(LinkedList<E> list) {
    prev = null;
    node = list;
  }

  public boolean hasNext() {
    return node.getNext() != null;
  }

  public E next() {
    prev = node;
    node = node.getNext();
    return ((ListNode<E>)node).getItem();
  }

  public void remove() {
    prev.setNext(node.getNext());
    node = prev;
  }

}
