package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.lang.model.type.PrimitiveType;
import javax.swing.tree.ExpandVetoException;

public class DynamicProgram {

	public static void main(String [] args){
		int no = 2567;

		seivePrime(100);
		printPrimePair(24);
		String s = "forbrod";
		System.out.println("sub palindrome  :"+subPalindrome(s));
		System.out.println("Longest palindrome :"+LPS(s));
		lcs("agcat","gac");

		int [] arr ={3,2,6,4,5,1,9,6,7};
		getLIS(arr);

		System.out.println("get the LIS in grid");
		int[][] grid = {{8, 2, 4}, 
				{0, 7, 1}, 
				{3, 7, 9}}; 
		System.out.println(findGridLIS(grid));


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

	public static String expandAround(String s, int start,int end){
		int b =start;int l =end;int n = s.length();
		System.out.println("String :"+s+ "  "+b+"  "+l);
		b++;
		while(b<n-1 && l >0 && s.charAt(b) == s.charAt(l)){
			b++;l--;
		}
		//		if(l==1 && b== 0)
		//			System.out.println("   ::"+b+"  ::"+l);
		return s.substring(l,b);
	}

	public static String LPS(String s){
		int len = s.length();
		if(len ==0 )
			return null;
		String maxlen = s.substring(0,1);
		//even plaindrome
		for(int i=0;i<len;i++){
			String s1 = expandAround(s,i,i);
			if(s1.length() > maxlen.length()){
				maxlen = s1;
			}
		}
		//odd palindrome
		for(int i=0;i<len;i++){
			String s1 = expandAround(s,i,i+1);
			if(s1.length() > maxlen.length()){
				maxlen = s1;
				System.out.println("got here");
			}
		}
		return maxlen.substring(1);

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


	//find the longest increasing sub-sequence
	public static void getLIS(int A[]){
		int len = A.length;
		int memo[] = new int[len];
		int dp[] = new int[len];
		int end =0;
		int maxlen =1;
		memo[0] = -1;
		dp[0] =1;
		for(int i=1;i<len;i++){
			memo[i] = -1;
			dp[i] = 1;
			for(int j=i-1;j>=0;j--){
				if(dp[i] < dp[j]+1 && A[i] > A[j]){
					dp[i] = dp[j]+1;
					memo[i] = j;//this is the start point;
				}
				if(maxlen < dp[i]){
					maxlen = dp[i];
					end = i ;
				}
			}
		}
		//print the LIS
		System.out.println("length of MIS "+ maxlen+ "-----");
		System.out.println();
		List<Integer> list = new ArrayList<Integer>();
		list.add(A[end]);
		//System.out.print(A[end]+" ");
		while(memo[end] !=-1 ){
			list.add(A[memo[end]]);
			end = memo[end];
		}
		Collections.reverse(list);
		System.out.println(list.toString());
	}




	//Find the LIS in a grid 


	/* 
	 * 8	2	4
	 * 0	7	1
	 * 3	7	9
	 */



	public static int findGridLIS(int A[][]){
		int len = A.length;
		int dp [][] = new int [len][len];
		int max =0;
		//intialize memoizing array with all ones

		for(int i=0;i<len;i++){
			for(int j=0;j<len;j++){
				int tempmax = fillDP(A,dp,i,j)+1;
				if(tempmax > max)
					max = tempmax;
			}
		}
		return max;

	}

	public static int fillDP(int [][]A,int[][]dp,int i,int j){
		int len = A.length;
		if(i <0 || j < 0 || i >= len || j >= len ){
			return 0;
		}
		if(dp[i][j] != 0)
			return dp[i][j];
		int left=0,right=0,topLeft=0,topRight=0,bottom=0,top=0,bottomLeft=0,bottomRight=0;
		if(j-1 >= 0&& A[i][j] < A[i][j-1])
			left = fillDP(A,dp,i,j-1);

		if(j+1<len && A[i][j] < A[i][j+1])
			right = fillDP(A,dp,i,j+1);

		if(i+1 <len && A[i][j] < A[i+1][j])
			bottom = fillDP(A,dp,i+1,j);

		if(i-1 >=0 && A[i][j] < A[i-1][j])
			top = fillDP(A,dp,i-1,j);

		if(i+1 < len && j-1 >=0 && A[i][j] < A[i+1][j-1])
			bottomLeft = fillDP(A,dp,i+1,j-1);

		if(i+1 >len && j+1 >len && A[i][j] < A[i+1][j+1])
			bottomRight = fillDP(A,dp,i+1,j+1);

		if(i-1 >=0 && j-1 >=0 && A[i][j] < A[i-1][j-1])
			topLeft = fillDP(A,dp,i-1,j-1);

		if(i-1 >=0 && j+1 <len && A[i][j] < A[i-1][j+1])
			topRight = fillDP(A,dp,i-1,j+1);

		dp[i][j]= Math.max(Math.max(Math.max(top,bottom),Math.max(right,left)),Math.max(Math.max(bottomRight,bottomLeft),Math.max(topLeft,topRight))) +1;
		return dp[i][j]; 

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

}
