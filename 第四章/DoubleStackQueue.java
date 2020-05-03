package 第四章;

public class DoubleStackQueue<E> implements Queue<E> {
    private ArrayStack<E>front;
    private ArrayStack<E>back;
    
    public DoubleStackQueue(){
    	front=new ArrayStack<E>();
    	back=new ArrayStack<E>();
    }
    /**用于添加元素*/
    public void add(E target) {
    	back.push(target);
    }
    /**用于移出元素*/
    public E remove() {
    	if (front.isEmpty()&&back.isEmpty()) {
    	     throw new EmptyStructureException();
    	}
    	if(front.isEmpty()) {
    	while (!back.isEmpty()) {
    		front.push(back.pop());
    	}
    	return front.pop();
    	}
    	return front.pop();
    }
    
    public boolean isEmpty() {
    	if(front.isEmpty()&&back.isEmpty()) {
    		return true;
    	}
    	return false;
    }
//代码多余，ArrayList中已经存在判断是否为空的方法    
//    /**用于判断back是否为空*/
//    public boolean bIsNull(){
//    	if(back.peek()==null) {
//    		return true;
//    	}
//    	return false;
//    }
//    /**用于判断front是否为空*/
//    public boolean fIsNull() {
//    	if(front.peek()==null) {
//    		return true;
//    	}
//    	return false;
//    }
    public static void main(String args []) {
    	DoubleStackQueue a=new DoubleStackQueue();
    	a.remove();
    }
}
