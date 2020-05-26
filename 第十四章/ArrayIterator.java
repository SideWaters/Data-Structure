package 第十四章;

// Introduced in Chapter 5
/** Iterator associated with an ArrayList. */
public class ArrayIterator<E> implements java.util.Iterator<E> {

  /** List being traversed. */
  private ArrayList<E> list;

  /** Index of the last element returned by next(). */
  private int previous;

  /** The Iterator begins ready to visit element 0. */
  public ArrayIterator(ArrayList<E> list) {
    this.list = list;
    previous = -1;
  }

  public boolean hasNext() {
    return (previous + 1) < list.size();
  }

  public E next() {
    previous++;
    return list.get(previous);
  }

  public void remove() {
    list.remove(previous);
    previous--;
  }

}
