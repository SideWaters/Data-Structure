package µÚÊ®ÕÂ;

public class Odd_Even {

	public void isWhat(int num) {
		System.out.println(isOdd(num)?"Odd":"Even");
	}
	
	public boolean isOdd(int n) {
		return isEven(n-1)&&n!=0;
	}
	
	public boolean isEven(int n) {
		return n==0||isOdd(n-1);
	}
	public static void main (String args[]) {
		Odd_Even a=new Odd_Even();
		a.isWhat(5);
	}
}
