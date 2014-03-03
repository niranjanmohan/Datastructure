package recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SimpleFunction {
	public static void main(String args[]){

		String s= "malllam";
		test(5);
		System.out.println("\n -->"+pal(s,0,s.length()-1));
		pal(s);
		fib(10);
		//System.out.println("recursive-->"+fibR(5));
		System.out.println();
		fibR(10);
		System.out.println(" \n decimal to binary");
		dectobin(10);
		dectobinIT(10);
		System.out.println("in List :"+dectobin(101,new ArrayList<Integer>()));
		System.out.println();
		System.out.println(factorial(5));
		factorialD(5);

	}

	//function prac1
	public static void test(int n){
		if(n>0){
			System.out.print(n+" ");
			test(n-1);
			System.out.print(n+" ");
		}
		else return;
	}
	//palindrome recursive
	public static boolean pal(String s,int i,int f){
		if(i < f){
			if(s.charAt(i) == s.charAt(f))
				return pal(s,i+1,f-1);
			else
				return false;
		}
		else 
			return true;
	}
	//palindrome iterative
	public static void pal(String s){
		int j = s.length()-1;
		boolean flag = false;
		for(int i=0;i<=s.length()/2-1;i++){
			j = j-i;
			if(s.charAt(i) == s.charAt(j))
				flag = true;
			else
				flag = false;
		}
		System.out.println("fib test :"+flag);
	}

	//fibonacci
	public static void fib(int n){
		int f1=0,f2=0,fn=1;
		f1=0;
		System.out.println("fibonnaci for the number :");
		while(f2 <= n){
			System.out.print(f2+" ");
			f1 = f2;
			f2 = fn;
			fn = f1+f2;
		}
	}
	//fibonacci recursive
	public static void fibR(int n,int f1,int f2){
		if(n-f1 <= 0)
			return ;
		else{
			 System.out.print(f1+" ");
			 fibR(n,f2,f2+f1);
		}
	}
	public static void fibR(int n){
		fibR(n,0,1);
	}
	public static void dectobin(int n){
		if(n >0){
			dectobin(n/2);
			System.out.print(n%2+" ");
		}
	}
	public static void dectobinIT(int n){
		int k =n;
		System.out.println();
		System.out.println("----------");
		for(int i=31;i>=0;i--){
			k = n>>i;
		if((k&1) ==1)
			System.out.print("1");
		else
			System.out.print("0");
		}
	}
	public static List<Integer> dectobin(int n,List<Integer> nlist){
		if(n >0){
			dectobin(n/2,nlist);
			nlist.add(n%2);
		}
		return nlist;
	}
	public static int factorialD(int n){
		if(n == 0)
			return 1;
	else{
			int result = factorialD(n-1);
			int fact = n*result;
			System.out.print(" \n factorial of "+n+"is :"+fact+ " intermediate value is :"+result);
			return fact;
		}
	}
	public static int factorial(int n){
		if(n <=1)
			return 1;
		else
			return n*factorial(n-1);
	}



}
