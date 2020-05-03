
public class PolyhedralDie extends Die{
	private int face;
    public PolyhedralDie(){
    	super();
    }
	public PolyhedralDie(int face) {
		this.face=face;
	}
	
	@Override
	public void roll() {
		this.setTopFace(((int)(Math.random() * face)) + 1);
	}
	
	public static void main(String args[]) {
		PolyhedralDie die=new PolyhedralDie(4);
		die.roll();
		System.out.println(die.getTopFace());
	}
}
