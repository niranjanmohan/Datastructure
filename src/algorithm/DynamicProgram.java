package algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.lang.model.type.PrimitiveType;

public class DynamicProgram {

	public static void main(String [] args){
		int no = 2567;

		seivePrime(100);
		printPrimePair(24);
		System.out.println("sub palindrome  :"+subPalindrome("forgeeksskeegfor"));

		lcs("agcat","gac");

		int [] arr ={-2, -3, 4, -1, -2, 1, 5, -3};
		kandanes(arr);
	}




	//**********************Find if a number is prime or not given a range ***************************


	//sieve eratosthenes
	public static void seivePrime(int range){
		Boolean [] isPrime = new Boolean[range];
		for(int i=0;i<range;i++){
			isPrime[i] = true;
		}
		for(int i=2;i*i < range ;i++){
			if(isPrime[i]){
				for(int j=i;i*j< range ;j++){
					isPrime[j*i] = false;
				}
			}
		}
		//System.out.println(isPrime.length);
		for(int k=2;k<range;k++){
			if(isPrime[k])
				System.out.println(k);
		}
	}



	//modify the code above to Goldbach's conjecture	
	public static void printPrimePair(int no){
		//find all the primes eratosthenes algo
		Boolean [] isPrime = new Boolean[no+1];
		for(int i=0;i<no;i++){
			isPrime[i]= true;
		}
		Set<Integer> primeSet = new HashSet<Integer>();
		for(int i=2;i*i<no;i++){
			if(isPrime[i]){
				for(int j=i;j*i<no;j++){
					isPrime[j*i] = false;
				}
			}
		}
		for(int i=2;i<no;i++){
			if(isPrime[i])
				primeSet.add(i);
		}
		//get the goldbach's conjucture 
		for(Integer i:primeSet){
			if(primeSet.contains(no-i)){
				System.out.println("the pair :"+i+" "+(no-i));
				break;
			}
		}
	}


	public static void lcs(String s1,String s2){
		//intialize the 2D array to 0

		int len1 = s1.length();
		int len2 = s2.length();
		int length[][] = new int[len1+1][len2+1];
		for(int i=0;i<len1+1;i++)
			for(int j=0;j<len2+1;j++)
				length[i][j] =0;

		//code for the lcs
		for(int i=0;i<len1;i++)
			for(int j=0;j<len2;j++)
				if(s1.charAt(i) == s2.charAt(j))
					length[i+1][j+1] = 1+ length[i][j];
				else 
					length[i+1][j+1] = Math.max(length[i+1][j],length[i][j+1]);


		StringBuilder stb = new StringBuilder();		
		for(int x = len1, y= len2 ;x !=0 && y!=0;){
			if(length[x][y] == length[x-1][y])
				x--;
			else if(length[x][y] == length[x][y-1])
				y--;
			else{
				//assert(s1.charAt(x) == s2.charAt(y));
				stb.append(s1.charAt(x-1));
				x--;y--;
			}
		}
		stb.reverse();
		System.out.println("the Lcs is "+stb.toString());
	}



	public static String subPalindrome(String s){	
		int len = s.length();
		String result = null;
		char [] sarr = s.toCharArray();
		int arr[][] = new int[len][len];
		for(int i=0;i<len;i++){
			arr[i][i] = 1;
		}
		for(int i=0;i<len-1;i++){
			if(sarr[i] == sarr[i+1]){
				arr[i][i+1] = 1;
			}
			else{
				arr[i][i+1] =0;
			}
		}
		for(int i=2;i<len;i++)
			for(int j=0;j+i<len;j++){
				int k = i+j;
				if(sarr[j] == sarr[k] && arr[j+1][k-1] == 1){
					arr[j][k] = 1;
					result = s.substring(j,k+1);
				}
				else
					arr[j][k] =0;
			}
		return result;
	}






	// word break need test

	public static void wordBreak(String str,Set<String> dict){
		boolean[] flag = new boolean[str.length() +1];
		//initialize
		flag[0] = true; 
		int strlen = str.length();
		for(int i=0;i<strlen;i++){
			if(!flag[i])//already exists
				continue;
			for(String s:dict){
				int end = s.length()+i;
				if(end > strlen)
					continue;
				if(flag[end])
					continue;
				if(s.substring(i,end).equals(s))
					flag[end] = true;
			}
		}
	}





	//kandanes algorithm

	public static Integer kandanes(int [] arr){
		int local_max,global_max;
		int start=0,end=0,start_untilnow=0;
		local_max = global_max = arr[0];
		for(int i=0;i<arr.length;i++){
			local_max+= arr[i];
			if(local_max < arr[i]){
				local_max = arr[i];
				start_untilnow = i;
			}else{
				end = i;
			}
			if(global_max < local_max)
				global_max = local_max;
			start = start_untilnow;
		}
		System.out.println("Start :"+start+" End :"+end);
		return global_max;
	}
	//stepping number byn

}
