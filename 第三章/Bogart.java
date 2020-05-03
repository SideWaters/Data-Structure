import java.util.ArrayList;

public class Bogart {
	ArrayList<Boolean> pot;
	ArrayList<Boolean> pot1;
	ArrayList<Boolean> pot2;
	public static final boolean PLAYER1 = false;
	public static final boolean PLAYER2 = true;
	PolyhedralDie die;
	public static final java.util.Scanner INPUT
    = new java.util.Scanner(System.in);
	
	public Bogart(){
		pot=new ArrayList<Boolean>();
		pot1=new ArrayList<Boolean>();
		pot2=new ArrayList<Boolean>();
		die=new PolyhedralDie(4);
	}
	
	//玩家管理者与数组管理者
	boolean player=PLAYER1;
	ArrayList <Boolean> potw;
    public void Play() {
    	
    	while(!gameOver()) {
    		if(player==PLAYER1) {
    			System.out.println("PLAYER1 to play now");
    			potw=pot1;
    			
    		}
    		else {
    			System.out.println("PLAYER2 to play now");
    			potw=pot2;
    		}
    		this.playGame();
    		player=!player;
    		
    	}
    	System.out.println("You win!!! ");
    }
    
	
	//骰子个数大于5
	public boolean gameOver() {
		if(pot1.size()>=30||pot2.size()>=30||dienum>=5) {
			return true;
		}
		else {
			return false;
		}
	}
	//用于记录骰子数
	private int dienum=0;
	/**用于掷骰子与骰子数增加*/
	public void playGame() {
		pot.add(true);
	    for(int i=1;i<6;i++) {
			//用于多次掷骰子
	    	if(!gameOver()) {
				for(int a=0;a<i;a++) {
					
					die.roll();
					System.out.print("you roll "+die.getTopFace()+" ");
					if(die.getTopFace()==1) {
						System.out.println("\nYou quit this turn ");
						System.out.println("bot have "+pot.size()+" chips");
						dienum=0;
						break;					
					}
						
				}
				dienum+=1;
				/**判断是否能够选择*/
				if(die.getTopFace()!=1) {	
					System.out.println("\nYou want quit or continue ");
					if(INPUT.nextLine().equals("quit")) {
						for(int i1=0;i1<pot.size();i1++) {
							potw.add(true);
						}
						pot.clear();
						System.out.println("bot have "+pot.size()+" chips");
						break;
					}
				}
				//掷到1换人玩骰子个数归零
				else {
					dienum=0;
					break;
				}
				pot.add(true);
				pot.add(true);
				System.out.println("bot have "+pot.size()+" chips");
			}
	    	else {
	    	    break;
	    	}
	    }
		
	}
	
	
	public static void main(String[] args) {
		Bogart game=new Bogart();
		game.Play();

	}
}
