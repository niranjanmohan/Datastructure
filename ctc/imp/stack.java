package imp;

import java.util.HashSet;
import java.util.Set;

public class stack {
	 static int counter = 0;
	public static void main(String [] args){
		permutation("","cat");
	}
	
	

	private static void permutation(String prefix, String str) {
		
	    int n = str.length();
	    if (n == 0) System.out.println(prefix + counter++);
	    else {
	    	//if (n==1)
	    		System.out.println(prefix);
	        for (int i = 0; i < n; i++){
	       // System.out.println("prefix -->"+prefix+" chart at i :"+str.charAt(i)+"  str1 :"+str.substring(0, i)+" str2-->"+str.substring(i+1, n)+" value i->"+i+" N :"+n);
	        	permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
	        }
	    }
	}
	public static void somefunc(){
		
	}

}
