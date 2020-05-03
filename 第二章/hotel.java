package 第二章;

public class hotel {
	public static final java.util.Scanner INPUT
    = new java.util.Scanner(System.in);
    private String[]name;
    private boolean[]num;
    
    public hotel() {
    	name=new String[10];
    	num=new boolean[10];
    	
    }
    public void chickIn(int b,String a) {
    	name[b]=a;
    	num[b]=true;
    	
    }
    public void chickOut(int b) {
    	name [b]=null;
    	num[b]=false;
    }
    public void play() {
    	while(!(this.isFull())){
    	System.out.println("住房请按1，退房请按2");
    	int type=INPUT.nextInt();
    	if(type==1) {
    	System.out.println("房间的居住情况为(true房间已经有人入住了，false房间未有人入住)");
    		for(int a=0;a<10;a++) {
    			System.out.print("房间"+a+" ");
    			System.out.print(num[a]);
    		}
    		System.out.println("您想入住哪一间？");
    		int room=INPUT.nextInt();
    		/**断言*/
    		assert num[room]==false:"这里已经有人入住了";
    		System.out.println("请输入您的姓名");
        	String a=INPUT.next();
    		this.chickIn(room,a);
    		
    	}
    	else if(type==2) {
    		System.out.println("请问您要退哪间房，输入您的房间号");
    		int c=INPUT.nextInt();
    		this.chickOut(c);
    	}
    	}
    }
    public boolean isFull() {
    	int i=0;
    	for(boolean a:num) {
    		if (a==true) {
    			i++;
    		}
    	}
    	if(i==10) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
	public static void main(String[] args) {
	hotel a=new hotel();
	a.play();

	}

}
