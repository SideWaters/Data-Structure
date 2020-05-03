// Introduced in Chapter 8
/** An array-based List of Comparables. */
public class SortableArrayList<E extends Comparable<E>> extends ArrayList<E> {

	public boolean contains(E target) {
		insertionSort();
		int bottom = 0;
		int top = size() - 1;
		while (bottom <= top) {
			int midpoint = (top + bottom) / 2;
			int comparison = target.compareTo(get(midpoint));
			if (comparison < 0) {
				top = midpoint - 1;
			} else if (comparison == 0) {
				return true;
			} else {
				bottom = midpoint + 1;
			}
		}
		return false;
	}

	/** Arrange the elements in this List from smallest to largest. */
	public void insertionSort() {
		for (int i = 1; i < size(); i++) {
			E target = get(i);
			int j;
			for (j = i - 1; (j >= 0) && (get(j).compareTo(target) > 0); j--) {
				set(j + 1, get(j));
			}
			set(j + 1, target);
		}
	}

//------------------------9.4-------------------------------------------------------
	public boolean binarySearch(E target) {
		return binarySearchHelper(0, size() - 1, target);
	}

	protected boolean binarySearchHelper(int bottom, int top, E target) {
		if (bottom > top) {// 全都没有, 递归出口
			return false;
		}
		int mid = (top + bottom) / 2;
		int com = get(mid).compareTo(target);
		if (com == 0) {// 找到的情况,递归出口
			return true;
		}
		if (com > 0) {
			return binarySearchHelper(bottom, mid - 1, target);
		}
		return binarySearchHelper(mid + 1, top, target);
	}

//-------------------------------9.10---------------------------------------------------------
	public void mergeSort() {
		SortableArrayList<E> target = mergeSortHelper(0, size() - 1);
		for (int i = 0; i < target.size(); i++) {
			this.set(i, target.get(i));
		}
	}

	protected SortableArrayList<E> mergeSortHelper(int bottom, int top) {
		if (bottom == top) {
			SortableArrayList<E> target = new SortableArrayList<E>();
			target.add(get(bottom));
			return target;
		} else {
			int midpoint = (top + bottom) / 2;
			return merge(mergeSortHelper(bottom, midpoint), mergeSortHelper(midpoint + 1, top));
		}
	}

	protected SortableArrayList<E> merge(SortableArrayList<E> a, SortableArrayList<E> b) {
		SortableArrayList<E> result = new SortableArrayList<E>();
		int i = 0;
		int j = 0;
		for (int k = 0; k < a.size() + b.size(); k++) {
			if ((j == b.size()) || ((i < a.size()) && (a.get(i).compareTo(b.get(j)) <= 0))) {
				result.add(a.get(i));
				i++;
			} else {
				result.add(b.get(j));
				j++;
			}
		}
		return result;
	}

//-----------------9.14----------------------------------------------------------------------
	public void quicksort() {
		quicksortHelper(0, this.size() - 1);
	}

	protected void quicksortHelper(int bottom, int top) {
		if (bottom < top) {
			int midpoint = partition(bottom, top);
			quicksortHelper(bottom, midpoint - 1);
			quicksortHelper(midpoint + 1, top);
		}
	}

	protected int partition(int bottom, int top) {
		E pivot = this.get(top);
		int firstAfterSmall = bottom;
		for (int i = bottom; i < top; i++) {
			if (this.get(i).compareTo(pivot) <= 0) {
				swap(firstAfterSmall, i);
				firstAfterSmall++;
			}
		}
		swap(firstAfterSmall, top);
		return firstAfterSmall;
	}

	/** swap the elements of data at indice i and j in "this" */
	protected void swap(int i, int j) {
		E temp = this.get(i);
		this.set(i, this.get(j));
		this.set(j, temp);
	}

//-----------------------------9.18------------------------------------
	public static void quicksortHelper(int[] data, int bottom, int top) {
		while (bottom < top) {
			int midpoint = partition(data, bottom, top);
			quicksortHelper(data, bottom, midpoint - 1);
			bottom = midpoint + 1;
		}
	}

	protected static int partition(int[] data, int bottom, int top) {
		int pivot = data[top];
		int firstAfterSmall = bottom;
		for (int i = bottom; i < top; i++) {
			if (data[i] <= pivot) {
				swap(data, firstAfterSmall, i);
				firstAfterSmall++;
			}
		}
		swap(data, firstAfterSmall, top);
		return firstAfterSmall;
	}

	protected static void swap(int[] data, int i, int j) {
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}

	public static void main(String args[]) {
		SortableArrayList<Integer> a = new SortableArrayList<Integer>();
		a.add(2);
		a.add(3);
		a.add(1);
		a.mergeSort();
		System.out.println(a);
	}
}
