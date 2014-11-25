package algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Set;

public class OnlineProb {

	public static void main(String [] args){

		int [] A ={7,-1,-5,-2, 4, -3,0};
		int r = equi(A);
		System.out.println(" The value is :"+ r);
		int [] A1= {1,2,2,3,5,5,7,8,9,9,9,9,9};
		System.out.println("Index :"+ searchBin(A1, 0, A.length-1, 9, -1));
		int no = 2567;
		System.out.println(checkColorful(no));
		System.out.println(isMagicNumber(2396));
		System.out.println(checkMagic(181));
		printOct(891);
		steppingNos(0, 1000);
		System.out.println("*************************");
		getIndexProd(132);


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
	public static boolean checkColorful2(int no){
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
					val*= alist.get(j);
					//System.out.println("value of j"+j);
				}
				//				System.out.println(" value is :"+val);
				if(!setI.add(val)) return false;
			}
		}
		return true;
	}

	///*******************************code to find if a number is magic or not**************************************************

	//magic number
	public static boolean isMagicNumber(int number){
		List<Integer> list = copyIntToArray(number);
		if(list.contains(0))
			return false;
		int value ;
		do {
			value =0;
			for(Integer i: list){
				value += i;
			}
			System.out.println("value : "+value);
			list =  copyIntToArray(value);
		} while(value > 9);
		if(value ==1) return true;
		else return false;
	}

	private static List<Integer> copyIntToArray(int number){
		char [] arr = String.valueOf(number).toCharArray();
		List<Integer> list = new ArrayList<Integer>();

		for(int i=0;i<arr.length;i++){
			list.add(Integer.parseInt(String.valueOf(arr[i])));
		}
		return list;
	}


	//****************************************end magic color******************************************************************

	//**************************************better code magic number **********************************************************
	//magic number short

	public static int magic (int no){
		if(no < 9)
			return no;
		else
			return no%10 + magic(no/10);
	}



	public static boolean checkMagic (int  no){
		int j;
		while((j =magic(no))/10 !=0){
			System.out.println(" j :"+j);
			no =j;
		}
		if(j ==1)
			return true;
		else
			return false;
	}


	//*************************************************end magic number *******************************************************



	//****************************Deci to Oct sample code *************************************


	public static  void deciToOct(int no,List<Integer> list){
		if (no > 8)
			deciToOct(no/8,list);
		list.add(no%8);
	}

	public static void printOct(int no){
		List<Integer> list = new ArrayList<Integer>();
		deciToOct(no,list);
		System.out.println(list.toString());
	}


	//******************************************end deci to oct******************************


	// is stepping number 


	public static void steppingNos(int s,int e){
		if(e < s)
			System.out.println("error");
		else{
			while(s <= e ){
				if(isStepping(s))
					System.out.print(s+" ");
				s++;
			}
		}
	}

	public static boolean isStepping(int no){
		while ( no > 10){
			if(Math.abs((no%10) - ((no/10)%10)) == 1)
				no = no/10;
			else
				return false;
		}
		return true;
	}

	public static void getIndexProd(int number){
		int no = number;
		int newNo=0;
		long prod = 1l;
		while(no > 0){
			prod *= no%10;
			no = no/10;
		}
		//form the number
		no = number;
		for(int i=0;no >0 ; no=no/10,i++){
			int digit = no %10;
			newNo += (prod/digit)*Math.pow(10,i);
			if((prod/digit) >9)
				i++;
		}
		System.out.println("new no is :"+newNo);
	}
}

