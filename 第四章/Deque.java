package ╣зкдуб;
public interface Deque<E>{
	/** Add target to the back of this Queue. */
	public void add(E target);
	
	/** Add target to the front of this Queue. */
	public void addFront(E target);
	
	/**
	   * Remove and return the front item from this Queue.
	   * @throws EmptyStructureException if the Queue is empty.
	   */
	public E remove();
	
	/**
	   * Remove and return the back item from this Queue.
	   * @throws EmptyStructureException if the Queue is empty.
	   */
	public E removerBack();
	/** Return true if this Queue is empty. */
	public boolean isEmpty();
	
}
