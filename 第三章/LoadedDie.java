
public class LoadedDie extends Die{
	public LoadedDie(){
		super();
	}
    @Override
	public void roll() {
    	this.setTopFace(6);
    }
    public static void main(String[] args) {
    	LoadedDie d = new LoadedDie();
        System.out.println("Before rolling: " + d);
        d.roll();
        System.out.println("After rolling: " + d);
      }
}
