// Introduced in Chapter 6
/**
 * Something that has a next ListNode.
 */
public interface Predecessor<E> {

  /** Get the next ListNode. */
  public ListNode<E> getNext();
  
  /** Set the next ListNode. */
  public void setNext(ListNode<E> next);

}
