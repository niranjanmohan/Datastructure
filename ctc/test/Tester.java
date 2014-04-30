package test;

import java.util.ArrayList;
import java.util.List;

public class Tester {
	
	
	public static void main(String [] args){
		recurseMe(2, 2);
		List<Integer> ls = new ArrayList<Integer>(10);
		ls.add(2, 3);
		//System.out.println(ls.toString());
		
	}
	
	public static void recurseMe(int x,int n){
		
		if(n%2 ==0){
			System.out.println(n);
			recurseMe(x,n/2);
		}
		else
			System.out.println(n);
		
	}

}
