// Introduced in Chapter 14
/**
 * A nearly-perfect tree where nodes are <= their children.
 * Can be used as a priority queue or for heapsort.
 */
public class Heap<E extends Comparable<E>> {

  /** Contiguous representation of the tree. */
  private ArrayList<E> data;

  /** The tree is initially empty. */
  public Heap() {
    data = new ArrayList<E>();
  }

  /**
   * Copy the elements of unsortedData into the tree, then
   * rearrange them to make it a heap.
   */
  protected Heap(ArrayList<E> unsortedData) {
    data = new ArrayList<E>();
    for (E e : unsortedData) {
      data.add(e);
    }
    for (int i = (data.size() / 2) - 1; i >= 0; i--) {
      filterDown(i);
    }
  }

  /** Add a new element, maintaining the heap properties. */
  public void add(E target) {
    data.add(target);
    filterUp(data.size() - 1);
  }

    /** Move the element at index down to restore the heap properties. */
  protected void filterDown(int index) {
	  while(index < data.size()) {
		  int left=leftChildIndex(index);
		  int right=rightChildIndex(index);
		  int biggest=index;
		  if(left<data.size()&&data.get(left).compareTo(data.get(biggest))>0) {
			  biggest=left;
		  }
		  if(right<data.size()&&data.get(right).compareTo(data.get(biggest))>0) {
			  biggest=right;
		  }
		  if(biggest==index) {
			  return;
		  }
		  swap(biggest,index);
		  index=biggest;
	  }
  }
  
  protected void filterUp(int index) {
	  int parent=parentIndex(index);
	  while(parent>=0) {
		  if(data.get(parent).compareTo(data.get(index))>0) {
			  swap(parent,index);  
			  index=parent;
		      parent=parentIndex(index);
		  }
		  else{
			  return;
		  }
		
	  }
  }
  
  /** Sort data. */
  public static <E extends Comparable<E>> void
    heapsort(ArrayList<E> data) {
    Heap<E> heap = new Heap<E>(data);
    for (int i = 0; i < data.size(); i++) {
      data.set(i, heap.remove());
    }
  }

  /** Return true if this Heap is empty. */
  public boolean isEmpty() {
    return data.isEmpty();
  }

  /** Return the index of the left child of the node at index. */
  protected static int leftChildIndex(int index) {
    return (2 * index) + 1;
  }
  
  /** Return the index of the parent of the node at index. */
  protected static int parentIndex(int index) {
    return (index - 1) / 2;
  }

  /** Remove and return the biggest element in the Heap. */
  public E remove() {
    E result = data.get(0);
    E lastElement = data.remove(data.size() - 1);
    if (data.size() > 0) {
      data.set(0, lastElement);
    }
    filterDown(0);
    return result;
  }

  /** Return the index of the right child of the node at index. */
  protected static int rightChildIndex(int index) {
    return (2 * index) + 2;
  }

  /** Swap the elements at indices i and j. */
  protected void swap(int i, int j) {
    E temp = data.get(i);
    data.set(i, data.get(j));
    data.set(j, temp);
  }

  public static void main(String[] args) {
    ArrayList<Integer> arr = new ArrayList<Integer>();
    for (int i = 0; i < 10; i++) {
      arr.add((int)(Math.random() * 100));
    }
    System.out.println(arr);
    heapsort(arr);
    System.out.println(arr);
  }
  
}
