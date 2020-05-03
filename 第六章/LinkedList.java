// Introduced in Chapter 6
/** A linked list. */
public class LinkedList<E> implements List<E>, Predecessor<E> {

  /** The first node in the List. */
  private ListNode<E> front;

  /** A LinkedList is initially empty. */
  public LinkedList() {
    front = null;
  }

  public void add(E target) {
    Predecessor<E> last = this;
    while (last.getNext() != null) {
      last = last.getNext();
    }
    last.setNext(new ListNode<E>(target));
  }
  public void addFirst(E target) {
	  front =new ListNode<E>(target,front);
  }
  public boolean contains(E target) {
    for (ListNode<E> node = front;
         node != null;
         node = node.getNext()) {
      if (node.getItem().equals(target)) {
        return true;
      }
    }
    return false;
  }

  public E get(int index) {
    ListNode<E> node = front;
    for (int i = 0; i < index; i++) {
      node = node.getNext();
    }
    return node.getItem();
  }

  public ListNode<E> getNext() {
    return front;
  }
  
  public boolean isEmpty() {
    return front == null;
  }

  public java.util.Iterator<E> iterator() {
    return new ListIterator<E>(this);
  }
  
  public E remove(int index) {
    Predecessor<E> prev = this;
    ListNode<E> node = front;
    for (int i = 0; i < index; i++) {
      prev = node;
      node = node.getNext();
    }
    prev.setNext(node.getNext());
    return node.getItem();
  }

  public boolean remove(E target) {
    Predecessor<E> prev = this;
    ListNode<E> node = front;
    while (node != null) {
      if (node.getItem().equals(target)) {
        prev.setNext(node.getNext());
        return true;
      }
      prev = node;
      node = node.getNext();
    }
    return false;
  }

  public void set(int index, E target) {
    ListNode<E> node = front;
    for (int i = 0; i < index; i++) {
      node = node.getNext();
    }
    node.setItem(target);
  }
  
  public void setNext(ListNode<E> next) {
    front = next;
  }

  public int size() {
    int tally = 0;
    for (ListNode<E> node = front;
         node != null;
         node = node.getNext()) {
      tally++;
    }
    return tally;
  }

  public String toString() {
    String result = "( ";
    for (ListNode<E> node = front;
         node != null;
         node = node.getNext()) {
      result += node.getItem() + " ";
    }
    return result + ")";
  }

@Override
public boolean equals(Object obj) {
	if (this == obj) {
		return true;
	}
	if (obj == null) {
		return false;
	}
	if (getClass() != obj.getClass()) {
		return false;
	}
	LinkedList<E> that=(LinkedList<E>)obj;
	ListNode<E> next1 = this.getNext();
	ListNode<E> next2 = that.getNext();
	while(next1!=null&&next2!=null) {
		  if(!next1.getItem().equals(next2.getItem())) {//内容判断
		  	  return false;
		  }
		  next1=next1.getNext();
		  next2=next2.getNext();
    }
	if(next1==null&&next2==null) {
			return true;                                 //都为空
		}
			return false;                                //一为空一非空
		
}
/*找出list表中第一个target的值，如果没有则返回-1*/
  public int indexOf(E target) {
	  int i=0;
	  ListNode<E> node=front;
	  while(front!=null) {
	    if(front.getItem().equals(target)) {
		    return i;
	    }
	    	i++;
	    	node=node.getNext();
	  }
	  return -1;
  }
  /*移除所有相同元素*/
  public void removeAll(E target) {
	   Predecessor<E> prev = this;
	   ListNode<E> node = front;
	   while (node != null) {
	      if (node.getItem().equals(target)) {//相等时进行
	        prev.setNext(node.getNext());
	        node=node.getNext();
	        
	      }                                   
	      else{                               //不等时进行
	       prev = node;                         
	       node = node.getNext();
	      }
	  }
  }
/*使LinkedNode反转*/
  public void reverse() {
	ListNode<E>node=front;
	front=null;
	ListNode<E> succ=null;
	while(node!=null) {
		succ=node.getNext();
		node.setNext(front);
		front=node;
		node=succ;
	}
  }
  
  public static void main(String args[]) {
	  LinkedList a=new LinkedList();
	  a.add(1);
	  a.add(1);
	  System.out.println(a);
	  System.out.println(a.indexOf(1));
	  a.removeAll(1);
	  System.out.println(a);
	  a.add(1);
	  a.add(2);
	  a.reverse();
	  System.out.println(a);
  }
}  
