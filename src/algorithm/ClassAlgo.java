/**
 * count the number of inversions in an array in O(nlogn) time
 * 
 * Select the i th element in O(n) time
 * 
 */


package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class ClassAlgo {
	public static void main(String [] args){


		//**********select the ith element in O(n) time
		Integer B[] = {3,4,10,20,33,65,12,91,88};
		List<Integer> list = Arrays.asList(B);
		System.out.println(list.toString());
		selectR(list,0,list.size()-1,5);
		Collections.sort(list);
		//System.out.println("sorted list :"+list.toString());
		//Find the number of inversions in a Matrix
		Integer Arr[] = { 0, 2, 1, 3, 5};
		list =Arrays.asList(Arr);
		int inv = splitInv(list, 0, Arr.length-1);
		System.out.println("the no of inversions are :"+inv);
		//System.out.println("sorted list :"+list.toString());

		//Three sum problem
		Integer arr[] ={0,1,2,3,4,5,6,7,8,9};
		ThreeSum(Arrays.asList(arr),9);


		//find median after insertion of n elements in fastest time
		findMedian(list);


		lcs("agcat","gac");


		//iterative method in O(n^2)
		//System.out.println("inversions :"+invCount(Arrays.asList(Arr)));

	}
	//Running time O(n) time 
	public static void  selectR(List<Integer>nlist,int low,int high,int I){
		int i = low, j = high;
		if(nlist.size() <= I){
			System.out.println("index is not in list");
			return;
		}
		int pindex = low + (high-low)/2;
		int pivot = nlist.get(low + (high-low)/2);
		//bigin partition subroutine
		while(i<=j){
			while(pivot > nlist.get(i))
				i++;
			while(nlist.get(j)> pivot)
				j--;
			if(i<=j){
				//swap
				int temp = nlist.get(i);
				nlist.set(i, nlist.get(j));
				nlist.set(j, temp);
				i++;
				j--;
			}
		}
		if(pindex == I)
			System.out.println("value at index :"+I+" :"+nlist.get(pindex));
		else if(pindex > I)
			selectR(nlist,low,pindex,I);
		else
			selectR(nlist,pindex,high,I);
	}


	//******************************************************************************************
	//********************to count the number of inversions in an array***********************

	public static Integer splitInv(List<Integer> nlist,int start,int end){
		if(start >=end){
			return 0;
		}
		int mid = (start+end)/2;
		//System.out.println("values of mid"+mid);
		int x = splitInv(nlist,start,mid);
		int y = splitInv(nlist,mid+1,end);
		int z = mergeInv(nlist,start,mid,end);
		return x+y+z;
	}
	public static Integer mergeInv(List<Integer> nlist,int low,int mid,int high){
		int inv =0;
		while(low<= mid+1){
			if(nlist.get(low) > nlist.get(mid+1)){
				//swap;
				int temp = nlist.get(low);
				nlist.set(low, nlist.get(mid+1));
				nlist.set(mid+1, temp);
				//push mid to the correct position
				int temp_mid = mid;
				inv+=1;
				//System.out.println("("+nlist.get(mid+1)+","+nlist.get(low)+")aaa");
				while(temp_mid+2<=high && (nlist.get(temp_mid+1) > nlist.get(temp_mid+2))){
					//swap
					inv+=1;
					//	System.out.println("----("+nlist.get(temp_mid+2)+","+nlist.get(low)+")----");
					temp = nlist.get(temp_mid+1);
					nlist.set(temp_mid+1, nlist.get(temp_mid+2));
					nlist.set(temp_mid+2, temp);
					temp_mid++;
					//System.out.println("after push :"+nlist.toString());
				}
			}
			low++;
		}
		return inv;
	}




	// iterative inversion count in o(n^2)
//	public static Integer invCount(List<Integer> nlist)	{
//		int inv =0;
//		for(int i=0;i<nlist.size();i++)
//			for (int j=i+1;j<nlist.size();j++){
//				//Integer temp;
//				if(nlist.get(i)>nlist.get(j)){
//					//swap
//					System.out.println("("+nlist.get(i)+","+nlist.get(j)+")");
//					inv++;
//				}
//			}
//		return inv;
//	}


	public static void ThreeSum (List<Integer> nlist,Integer B){

		for(int i=0;i<nlist.size()-3;i++){
			int f =i+1;
			int l = nlist.size()-1;
			while(f < l){
				int sum = nlist.get(i)+nlist.get(f)+nlist.get(l);
				if(sum ==B){
					System.out.println( nlist.get(i)+","+ nlist.get(f)+","+ nlist.get(l));
					break;
				}
				else if(sum >B){
					l--;
				}
				else
					f++;
			}
		}
	}


	public static void findMedian(List <Integer>ls){
		PriorityQueue<Integer> minQ = new PriorityQueue<Integer>();
		PriorityQueue<Integer> maxQ =new PriorityQueue<>(11, new Comparator<Integer>(){
			@Override
			public int compare(Integer no1, Integer no2) {
				// TODO Auto-generated method stub
				return no2.compareTo(no1);
			}
		});
		Collections.sort(ls);
		int mid = ls.size()/2;
		minQ.addAll(ls.subList(mid, ls.size()));
		maxQ.addAll(ls.subList(0, mid));
		printMedian(minQ, maxQ, 4,ls.size()+1);
		printMedian(minQ, maxQ, 7,ls.size()+1);
		printMedian(minQ, maxQ, 9,ls.size()+1);
		System.out.println(ls.toString());
	}
	public static void printMedian(Queue<Integer>minQ,Queue<Integer>maxQ,int no,int size){
		if(no > minQ.peek()){
			minQ.add(no);
		}else{
			maxQ.add(no);
		}
		if(minQ.size() > maxQ.size()+1){
			maxQ.add(minQ.poll());
		}
		else if(maxQ.size() > minQ.size()+1){
			minQ.add(maxQ.poll());
		}
		if(size%2==0){
			System.out.println((minQ.peek()+maxQ.peek())/2);
		}
		else
			System.out.println(minQ.peek());
		//	System.exit(0);

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



	//	public static Integer mergeInv(List<Integer> nlist,int start,int mid,int end){
	//		int inv= 0;
	//		int mid_c=mid+1;
	//	//	int bstart = start;
	//		System.out.println("start:"+start+"mid:"+mid+"end:"+end);
	//		while(start <=mid){
	//			System.out.println("inv"+inv+"start:"+start+"mid_c:"+mid_c+"end:"+end);
	//			if( mid_c > end ){
	//				inv+=mid+1-start;
	//				start++;
	//			}
	//			else if( nlist.get(start) > nlist.get(mid_c)){
	//				inv+=mid+1-start;
	//				mid_c++;
	//			}
	//			else{
	//				start++;
	//			}
	//		}
	//		//nlist =dlist;
	//		return inv;
	//	}
	
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