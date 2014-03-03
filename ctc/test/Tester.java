package test;

public class Tester {
	
	
	public static void main(String [] args){
		recurseMe(2, 2);
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
