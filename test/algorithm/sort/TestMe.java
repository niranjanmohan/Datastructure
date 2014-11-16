package algorithm.sort;

import java.util.*;
import java.util.HashSet;
import java.util.LinkedList;

public class TestMe {
	public static void main(String [] args){
		//		int A[] = {1,2,2,3,5,5,7,8,9,9,9,9,9};
		//		System.out.println("Basic input"+ searchBin(A, 0, A.length-1, 9, -1));
		//
		
		
		
		Long l = 34l;
		Long l1 = 45l;
		l = l+11;
		System.out.println("is long equal "+ (l==l1));
		Long l3 = new Long(45);
		Long l4= new Long("45");
		
		System.out.println("is long equal "+ (l3==l4));
	
		Double d = -2.9;
		System.out.println(Math.round(d)+"    "+Math.ceil(d));
		
		
		TreeMap tmap = new TreeMap();

		//		int [][]rot = new int[4][4];
		//		rot[0] = new int[]{0,1,2,3};
		//		rot[1] = new int[]{10,11,12,13};
		//		rot[2] = new int[]{20,21,22,23};
		//		rot[3] = new int[]{30,31,32,33};
		//		int [][] rot1 = rot.clone();
		//		rotateArray(rot, 1, "clockwise");
		//		rotateArray(rot1, 1);

		//		Node hnode = new Node('a');
		//		Node node ;
		//		node = new Node('b');
		//		hnode.insertAfter(node);
		//		node = new Node('c');
		//		hnode.insertAfter(node);
		//		node = new Node('b');
		//		hnode.insertAfter(node);
		//		node = new Node('a');
		//		hnode.insertAfter(node);
		//		hnode.printAll();
		//		bittest();
		//permuteAll("", "sky");

	}



	public static void bittest(){
		int bitmask = 0x000F;
		int val = 0x2222;
		System.out.println("val :"+val + "   bitmask :"+bitmask);
		// prints "2"
		System.out.println(val & bitmask);
		int i = -10348;
		System.out.println("i shift :"+Integer.toBinaryString(i>>4));
		System.out.println("i shift :"+Integer.toBinaryString(i>>>4));


	}

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


	// Array rotation in O(n^2) time and O(1) space
	public static void rotateArray(int A[][],int spin,String direction){
		int last,first;
		printArray(A);
		for(int i=0;i<A.length/2;i++){
			first = i;
			last = A.length-1-i;
			for(int j=first;j<last;j++){
				int offset = j-first;
				int temp = A[first][j];
				A[first][j] = A[last-offset][first];
				A[last-offset][first] = A[last][last-offset];
				A[last][last-offset] = A[j][last];
				A[j][last] = temp;
			}
		}
		System.out.println("*******************************************");
		printArray(A);
	}


	public static void rotateArray(int input[][],int spin){
		System.out.println();
		printArray(input);
		System.out.println();
		int n =input.length;
		int m = input[0].length;
		int [][] output = new int [m][n];

		for (int i=0; i<n; i++)
			for (int j=0;j<m; j++)
				output [j][n-1-i] = input[i][j];
		printArray(output);
	}



	private static void printArray(int[][] a) {
		for(int i=0;i<a.length;i++){
			System.out.println();
			for(int j=0;j<a.length;j++)
				System.out.print(a[i][j]+" ");
		}
	}







	public static void permute(String prefix,String str){
		int len = str.length();
		if(len == 0){
			System.out.println(prefix);
		}
		else
			for(int i=0;i<len;i++){
				permute(str.charAt(i)+prefix,str.substring(0,i)+str.substring(i+1,len));
			}
	}

	public static void permuteAll(String prefix,String str){
		int len = str.length();
		if(prefix.length() == len)
			System.out.println(prefix);
		else
			for(int i=0;i<len;i++){
				permuteAll(str.charAt(i)+prefix,str);
			}
	}



	public int ladderLength(String start, String end, HashSet<String> dict) {

		if (dict.size() == 0)  
			return 0; 

		LinkedList<String> wordQueue = new LinkedList<String>();
		LinkedList<Integer> distanceQueue = new LinkedList<Integer>();

		wordQueue.add(start);
		distanceQueue.add(1);


		while(!wordQueue.isEmpty()){
			String currWord = wordQueue.pop();
			Integer currDistance = distanceQueue.pop();

			if(currWord.equals(end)){
				return currDistance;
			}

			for(int i=0; i<currWord.length(); i++){
				char[] currCharArr = currWord.toCharArray();
				for(char c='a'; c<='z'; c++){
					currCharArr[i] = c;

					String newWord = new String(currCharArr);
					if(dict.contains(newWord)){
						wordQueue.add(newWord);
						distanceQueue.add(currDistance+1);
						dict.remove(newWord);
					}
				}
			}
		}

		return 0;
	}




















}
