// Introduced in Chapter 5
/** An array-based List. */
public class ArrayList<E> implements List<E> {

  /** Array of elements in this List. */
  private E[] data;

  /** Number of elements currently in this List. */
  private int size;

  /** The List is initially empty. */
  public ArrayList() {
    data = (E[])(new Object[1]); // This causes a compiler warning
    size = 0;
  }

  public void add(E target) {
    if (isFull()) {
      stretch();
    }
    data[size] = target;
    size++;
  }
  
  public boolean contains(E target) {
    for (int i = 0; i < size; i++) {
      if (data[i].equals(target)) {
        return true;
      }
    }
    return false;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  /** Return true if data is full. */
  protected boolean isFull() {
    return size == data.length;
  }

  public java.util.Iterator<E> iterator() {
    return new ArrayIterator<E>(this);
  }

  public E get(int index) {
    return data[index];
  }

  public E remove(int index) {
    E result = data[index];
    for (int i = index + 1; i < size; i++) {
      data[i - 1] = data[i];
    }
    size--;
    return result;
  }

  public boolean remove(E target) {
    for (int i = 0; i < size; i++) {
      if (data[i].equals(target)) {
        for (int j = i; j < size - 1; j++) {
          data[j] = data[j + 1];
        }
        size--;
        return true; 
      }
    }
    return false;
  }

  public void set(int index, E target) {
    data[index] = target;
  }
  
  public int size() {
    return size;
  }

  /** Double the length of data. */
  protected void stretch() {
    E[] newData = (E[])(new Object[data.length * 2]); // Warning
    for (int i = 0; i < data.length; i++) {
      newData[i] = data[i];
    }
    data = newData;
  }

  public String toString() {
    String result = "[ ";
    for (int i = 0; i < size; i++) {
      result += data[i] + " ";
    }
    return result + "]";
  }
public static void main (String args[]) {
	ArrayList a=new ArrayList();
	a.add(new Integer(1));
	a.add(new Double (2)); 
	System.out.println(a.get(1).getClass());
	System.out.println(a.get(0).getClass());
}
}
