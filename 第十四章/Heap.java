package µÚÊ®ËÄÕÂ;

public class Heap <E extends Comparable<E>>{
     private ArrayList<E>data;
     
     public Heap() {
    	 data=new ArrayList<E>();
     }
     
     public boolean isEmpty() {
    	 return data.isEmpty();
     }
     protected static int leftChildIndex(int index) {
    	 return (2*index)+1;
     }
     
     protected static int rightChildindex(int index) {
    	 return (2*index)+2;
     }
     
     protected static int parentIndex(int index) {
    	 return (index-1)/2;
     }
     
   public void add(E target) {
	   data.add(target);
	   filterUp(data.size()-1);
   }
   
   public void filterUp(int index) {
	   while(index>0) {
		   if(data.get(index).compareTo(data.get(parentIndex(index)))>=0) {
			   swap(index,parentIndex(index));
			   index=parentIndex(index);
		   }else {
			   return ;
		   }
		   
	   }
   }
   
   public void swap(int i,int j) {
	   E target=data.get(i);
	   data.set(i,data.get(j));
	   data.set(j, target);
   }
   //only can remove the biggest number in the heap???
   public E remove() {
	   E result=data.get(0);
	   E lastElement=data.remove(data.size()-1);
	   if(data.size()>0) {
		   data.set(0, lastElement);
	   }
	   filterDown(0);
	   return result;
   }
   
   public void filterDown(int index) {
	   while(index<data.size()) {
		   int left=leftChildIndex(index);
		   int right=rightChildindex(index);
		   int smallest=index;
		   if(left<data.size()) {
			   if(data.get(smallest).compareTo(data.get(left))>0) {
				   smallest=left;
			   }
			   if(right<data.size()) {
				   if(data.get(smallest).compareTo(data.get(right))>0) {
					   smallest=right;
				   }
			   }
			   if(index==smallest) {
				   return;
			   }
			   swap(smallest,index);
			   index=smallest;
		   }
	   }
   }
}
