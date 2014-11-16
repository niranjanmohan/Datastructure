package algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Set;

public class OnlineProb {

	public static void main(String [] args){

//		int [] A ={7,-1,-5,-2, 4, -3,0};
//		int r = equi(A);
//		System.out.println(" The value is :"+ r);
//		int [] A1= {1,2,2,3,5,5,7,8,9,9,9,9,9};
//		System.out.println("Index :"+ searchBin(A1, 0, A.length-1, 9, -1));



		System.out.println("sub palindrome  :"+subPalindrome("forgeeksskeegfor"));

	}



	// Equilibrium problem 
	public static int equi( int[] A ) {
		long sum = 0;
		long leftSum = 0;
		
		

		for (int i=0;i<A.length;i++){
			leftSum += A[i];
		}
		for (int i=0;i<A.length;i++){
			if (sum==leftSum-A[i]) return i;
			sum+=A[i];
			leftSum-=A[i];
		}
		return -1;

	}



	//Disc intersection problem
	public int number_of_disc_intersections ( int[] A ) {
		int overlaps = 0;
		if (A.length<2) return 0;
		PriorityQueue<Integer> leftEdges = new PriorityQueue<Integer>();
		PriorityQueue<Long> rightEdges = new PriorityQueue<Long>();
		for (int i=0; i<A.length; i++){
			leftEdges.add(i-A[i]);
			rightEdges.add((long)i+(long)(A[i]));
		}
		int otherCirclesAtThisEdgeNum = 0;
		while ( !rightEdges.isEmpty()) {
			try {
				if (leftEdges.element() <= rightEdges.peek() ) {
					overlaps += otherCirclesAtThisEdgeNum++;
					if (overlaps > 10000000) return -1;
					leftEdges.poll();
				} else {
					otherCirclesAtThisEdgeNum--;
					rightEdges.poll();
				}
			}catch (NoSuchElementException e){
				break;
			}
		}
		return overlaps;
	}


	//colorful number
	public static boolean checkColorful(int no){
		String num = String.valueOf(no);
		if(num.contains("0") || num.contains("1"))
			return false;

		char[] arr = num.toCharArray();

		//check for duplicates
		Set<Byte> setB = new HashSet<Byte>();
		List<Integer> alist = new ArrayList<Integer>();
		for(char c: arr)
			if(!setB.add((byte)c))
				return false;
			else
				alist.add(Integer.parseInt(String.valueOf(c)));
		setB= null;int val;
		Set<Integer> setI = new HashSet<Integer>();
		for(int f=0;f<alist.size();f++){
			for(int l=f;l<alist.size();l++){
				val =1;
				for(int j=f;j<=l;j++){
					val+= alist.get(j);
					//System.out.println("value of j"+j);
				}
				System.out.println(" value is :"+val);
				if(!setI.add(val)) return false;
			}
		}
		return true;
	}


	//Given sorted array and a number find the max index of the number in the array

	public static int searchBin(int []A,int start,int last,int no,int found){
		if(start > last ){
			System.out.println("reached here");
			return found;
		}
		else{
			int mid = (start+last)/2;
			if(A[mid] == no){
				if(mid > found)
					found = mid;
				return searchBin(A,mid+1,last,no,found);
			}
			else if( A[mid] > no){
				return searchBin(A,start,mid-1,no,found);
			}
			else{
				return searchBin(A,mid+1,last,no,found);
			}
		}
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
	
	
	
	
	
	
	
	
	
	
	
	
}
