package algorithm;

import java.util.HashSet;
import java.util.Set;

public class PermuteR {
	static int counter = 0;
	public static void main(String [] args){
		permutation("","cat");

		System.out.println("*************************************************************");

		allLexicographicRecur("", "sky");
	}



	private static void permutation(String prefix, String str) {

		int n = str.length();
		if (n == 0) System.out.println(prefix );
		else {
			//if (n==1)
			//	System.out.println(prefix);
			for (int i = 0; i < n; i++){
				//   System.out.println("prefix -->"+prefix+" chart at i :"+str.charAt(i)+"  str1 :"+str.substring(0, i)+" str2 :"+str.substring(i+1, n)+" value i->"+i+" N :"+n);
				permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
			}
		}
	}
	static void allLexicographicRecur(String prefix, String str)
	{
		if(prefix.length()==str.length())
		{ System.out.println(prefix); return; }

		for(int i=0; i<str.length(); i++)
			allLexicographicRecur(prefix+str.charAt(i),str);
	}

}
