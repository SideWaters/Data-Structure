package µÚËÄÕÂ;
public class Calc {
	public static final java.util.Scanner INPUT = new java.util.Scanner(System.in);
    
    private ArrayStack<Double>i;
    
    public Calc() {
    	i=new ArrayStack<Double>();
    }
	
    public void run() {
    	String a;
    	double c=0;
    	double num1;
    	double num2;
    	String standard="+-*/";
    	System.out.print(":");
    	a=INPUT.next();
    	while(!a.equals("quit")){
    		if(!(standard.indexOf(a)==-1)) {
    			num1=i.pop();
    			num2=i.pop();
    			if(a.equals("+")) {
    			c=num2+num1;
    			}
    			else if(a.equals("-")) {
    				c=num2-num1;
    			}
    			else if(a.equals("*")) {
    				c=num2*num1;
    				
    			}
    			else {
    				c=num2/num1;
    			}
    			i.push(c);
    			System.out.print(c);
    			System.out.print(":");
    			c=0;
    		}
    		else {
    			i.push(Double.parseDouble(a));
    			System.out.print(a);
    			System.out.print(":");
    		}
    		a=INPUT.next();	
    	}
    }
	public static void main(String[] args) {
	    Calc a=new Calc();
	    a.run();

	}

}
