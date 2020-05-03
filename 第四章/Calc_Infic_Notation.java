package 第四章;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Calc_Infic_Notation {
	/**定义优先级*/
	public static final Map<Character,Integer> basic =new HashMap<Character,Integer>();
	static {
		basic.put('-', 1);
		basic.put('+', 1);
		basic.put('*', 2);
		basic.put('/', 2);
		basic.put('(', 0); 
		
	}
	
//	public String toSuffix(String infix) {
//		List<String>queue = new ArrayList<String>();//定义队列用来储存数字以及最后的运算式
//		List<Character>stack=new ArrayList<Character>();//定义栈用于储存运算符最后栈中会清空
//		
//		char[] charArr=infix.trim().toCharArray();//字符数组用于拆分数字或符号
//		String standard="+-*/";//判断标准，表达式中会出现的运算符
//		char ch='&';//循环中用于保存当前循环变量
//	    int len=0;//用于记录数组长度
//	    for(int i=0;i<charArr.length;i++) {
//	    	ch=charArr[i];
//	    	if(Character.isDigit(ch)) {
//	    		len++;
//	    	}
//	    	else if(Character.isLetter(ch)) {
//	    		len++;
//	    	}
//	    	else if(Character.isSpaceChar(ch)) {
//	    		if(len>=0) {
//	    			queue.add(String.valueOf(Arrays.copyOfRange(charArr,i-len,i)));
//	    			len=0;
//	    		}
//	    		continue;
//	    	}
//	    	else if(standard.indexOf(ch)!=-1) {
//	    		if(len>0) {
//	    			queue.add(String.valueOf(Arrays.copyOfRange(charArr,i-len,i)));
//	    			len=0;
//	    		}
//	    		if(ch=='(') {
//	    			stack.add(ch);
//	    		}
//	    		if(!stack.isEmpty()) {
//	    			int size = stack.size()-1;
//	    			boolean flags=false;
//	    			if(size>=0&&ch==')'&&stack.get(size)!='(') {
//	    				queue.add(String.valueOf(stack.remove(size)));
//	    				size--;
//	    			}
//	    		}
//	    		if(ch !=')')
//	    			stack.add(ch);
//	    	}
//	    		
//	    		
//	    		
//	    		
	    		
	    		
//	    }
//	}
}
