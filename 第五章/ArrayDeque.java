
public class ArrayDeque<E> implements Deque<E>{
	 /** Array of items in this Queue. */
	  private E[] data;

	  /** Index of the frontmost element in this Queue. */
	  private int front;

	  /** Number of items currently in this Queue. */
	  private int size;
	  
	  public ArrayDeque(){
		  data = (E[])(new Object[1]); // This causes a compiler warning
		  size = 0;
		  front = 0;
	  }

	@Override
	public void add(E target) {
		if (isFull()) {
		      stretch();
		    }
		    data[(front + size) % data.length] = target;
		    size++;
	}

	@Override
	public void addFront(E target) {
		if (isFull()) {
		      stretch();
		    }
		    front=(front+data.length-1)%data.length;
		    data[front]=target;
		    
		    
		    size++;
	
		
	}

	@Override
	public E remove() {
		if (isEmpty()) {
		      throw new EmptyStructureException();
		    }
		    E result = data[front];
		    front = (front + 1) % data.length;
		    size--;
		    return result;
	}

	@Override
	public E removeBack() {
		if (isEmpty()) {
		      throw new EmptyStructureException();
		    }
		    E result = data[(front+size-1)%data.length];
		    size--;
		    return result;
	}

	@Override
	public boolean isEmpty() {
		 return size == 0;
	}
	
	/** Return true if data is full. */
	  protected boolean isFull() {
	    return size == data.length;
	  }
	  
	 /** Double the length of data. */
	  protected void stretch() {
	    E[] newData = (E[])(new Object[data.length * 2]); // Warning
	    for (int i = 0; i < data.length; i++) {
	      newData[i] = data[(front + i) % data.length];
	    }
	    data = newData;
	    front = 0;
	  }
	  
	  
 
	public static void main(String args[]) {
    	ArrayDeque<Integer> a=new ArrayDeque<Integer>();
    	
    	a.add(1);
    	a.addFront(2);
    	System.out.println(a.removeBack());
    	System.out.println(a.removeBack());
    	a.add(1);
 
    	System.out.println(a.remove());
    }
}
