package µÚÊ®ËÄÕÂ;

// Introduced in Chapter 5
/** A list of elements. */
public interface List<E> extends Iterable<E> {

  /** Add target to the back of this List. */
  public void add(E target);

  /** Return true if some item in this List equals() target. */
  public boolean contains(E target);

  /** Return the indexth element of this List. */
  public E get(int index);

  /** Return true if this List is empty. */
  public boolean isEmpty();

  /**
   * Remove and return the indexth element from this List, shifting
   * all later items one place left.
   */
  public E remove(int index);

  /**
   * Remove the first occurrence of target from this List, shifting
   * all later items one place left.  Return true if this List
   * contained the specified element.
   */
  public boolean remove(E target);

  /** Replace the indexth element of this List with target. */
  public void set(int index, E target);
  
  /** Return the number of elements in this List. */
  public int size();

}
