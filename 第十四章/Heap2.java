// Introduced in Chapter 14
/**
 * A nearly-perfect tree where nodes are <= their children. Can be used as a
 * priority queue or for heapsort.
 */
//use insertSort and use array and data type is double and heapsort must can be used
public class Heap2 {

	/** Contiguous representation of the tree. */
	private double[] data;

	/** The tree is initially empty. */
	public Heap2() {
		data = new double[1];
	}

	/**
	 * Copy the elements of unsortedData into the tree, then rearrange them to make
	 * it a heap.
	 */
	protected Heap2(double[] unsortedData) {
		data = new double[unsortedData.length];
		for (int i = 0; i < data.length; i++) {
			data[i] = unsortedData[i];
		}
			for (int j =data.length/ 2 - 1; j >= 0; j--) {
				filterDown(data,j, data.length-1);
			}
	}

	/** Move the element at index down to restore the heap properties. */
	protected static void filterDown(double[] data,int index, int down) {
		while (index < down) {
			int left = leftChildIndex(index);
			int right = rightChildIndex(index);
			int biggest = index;
			if (left < down && data[left] > data[biggest]) {
				biggest = left;
			}
			if (right < down && data[right] > data[biggest]) {
				biggest = right;
			}
			if (biggest == index) {
				return;
			}
			swap(data,biggest, index);
			index = biggest;
		}
	}

	protected void filterUp(int index) {
		int parent = parentIndex(index);
		while (parent >= 0) {
			if (data[parent] > data[index]) {
				swap(data,parent, index);
				index = parent;
				parent = parentIndex(index);
			} else {
				return;
			}
		}
	}

	/** Sort data. */
	public static <E extends Comparable<E>> void heapsort(double[] data) {
		for (int i = data.length/2-1;i>=0; i--) {
		    filterDown(data, i, data.length);
		}
		for(int i=1;i<data.length;i++) {
			swap(data,0,data.length-i);
			filterDown(data, 0, data.length-i);
		}
	}

	/** Return the index of the left child of the node at index. */
	protected static int leftChildIndex(int index) {
		return (2 * index) + 1;
	}

	/** Return the index of the parent of the node at index. */
	protected static int parentIndex(int index) {
		return (index - 1) / 2;
	}

	/** Remove and return the smallest element in the Heap. */
  public double remove() {
    double result = data[0];
    double lastElement = data[data.length - 1];
    double[] data2=new double[data.length-1];
    for(int i=0;i<data2.length;i++) {
    	data2[i]=data[i];
    }
    data=data2;
    if (data.length > 0) {
      data[0]=lastElement;
    }
    filterDown(data,0,data.length);
    return result;
  }

	/** Return the index of the right child of the node at index. */
	protected static int rightChildIndex(int index) {
		return (2 * index) + 2;
	}

	/** Swap the elements at indices i and j. */
	protected static void swap(double[]data,int i, int j) {
		double temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}

	public static void main(String[] args) {
		double[] arr = new double[10];
		for (int i = 0; i < 10; i++) {
			arr[i] = (int)(Math.random() * 100);
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("%4.0f",arr[i]);
		}
		System.out.println();

		heapsort(arr);
//    System.out.println(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("%4.0f",arr[i]);
		}
	}

}
