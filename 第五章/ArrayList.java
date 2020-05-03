import java.util.Iterator;

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

  public void add(E target) {//由后至前插入，由前至后则会覆盖
    if (isFull()) {
      stretch();
    }
    data[size] = target;
    size++;
  }
    public void addFirst(E target) {
	  if(isFull()) {
		  stretch();
	  }
	  
	  for(int i=size-1;i>0;i--) {
		 data[i]=data[i-1];
	  }
	  data[0]=target;
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
/**5.23*/
  public String toString() {
    String result = "[ ";
    Iterator<E> iterator= iterator();
    for (E a:this) {
      result += a + " ";
    }
    return result + "]";
  }

  /**5.19*/
  @Override
  public boolean equals(Object obj) {
	  if(obj==null) {                                                        //与空比较
	  	  return false;
	  }
	  if(this==obj) {                                                    //完全相同返回true
		  return true;
	  }
	  if(obj.getClass()!=this.getClass()) {                             //类型不同返回false
		  return false;
	  }
	  @SuppressWarnings("unchecked")
	  ArrayList<E> t=(ArrayList<E>)obj;
	  if(size !=t.size) {
		  return false;
	  }
	  for(int i=0;i<size;i++) {
		  if(!data[i].equals(t.data[i])) {
			  return false;
		  }
	  }
	  return true;                                                           

  }
  /**5.21*///可修改为一次for循环
  public void removeAll(E target) {//不用remove方法，因为调用方法会消耗更多资源
	  int a=0;
	  for (int i = 0; i < size; i++) {
	      if (!data[i].equals(target)) {
	    	data[a++]=data[i];
	      }
	    }
	  size=a;
  }
  
  public int count(E target) {
	  int num=0;
	  for (int i = 0; i < size; i++) {
	      if (data[i].equals(target)) {
	        num++;
	      }
	    }
	  return num;
  }
  public static void main (String args[]) {
	  ArrayList a=new ArrayList();
	  a.add(1);
	  a.add("w");
	  Double d=new Double(1.0);
	  System.out.println(a.contains(2));
	  System.out.println(a.count(1));
	  a.add(d);
	  a.add(d);
	  System.out.println(a.contains(d));
	  a.removeAll(d);
	  System.out.println(a.contains(d));
	  System.out.println(a.equals(3));
	  System.out.println(a.get(1));
	  System.out.println(a.remove(0));
	  System.out.println(a);
	  System.out.println(a.get(0));
	  a.set(0, d);
	  System.out.println(a.size());
	  System.out.println(a);
  }
}
