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
import java.util.List;

public class ClassAlgo {
	public static void main(String [] args){


		//**********select the ith element in O(n) time
		Integer B[] = {3,4,10,20,33,65,12,91,88};
		List<Integer> list = Arrays.asList(B);
		System.out.println(list.toString());
		selectR(list,0,list.size()-1,5);
		Collections.sort(list);
		System.out.println("sorted list :"+list.toString());
		//Find the number of inversions in a Matrix
		Integer Arr[] = {  4,2, 1, 3, 5};
		list =Arrays.asList(Arr);
		System.out.println(list.toString());
		int inv = splitInv(list, 0, Arr.length-1);
		System.out.println("the no of inversions are :"+inv);
		System.out.println("sorted"+list.toString());
		Integer arr[] = {  2,4, 1, 3, 5};
		//iterative method
		System.out.println("inversions :"+invCount(Arrays.asList(arr)));



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



// iterative inversion count in o(n^2)
	
	public static Integer invCount(List<Integer> nlist)	{
		int inv =0;
		for(int i=0;i<nlist.size();i++)
		for (int j=i+1;j<nlist.size();j++){
			Integer temp;
			if(nlist.get(i)>nlist.get(j)){
				//swap
				System.out.println("("+nlist.get(i)+","+nlist.get(j)+")");
				inv++;
			}
		}
		return inv;
	}

	public static Integer mergeInv(List<Integer> nlist,int low,int mid,int high){
		//List<Integer> dlist= new ArrayList<>();
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




}