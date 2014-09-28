package algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import algorithm.sort.misc.RandomGen;




public class SortArray {
	public static void main(String [] args){
		int n=20;
		final Integer A[] =RandomGen.randArray(n);
		final Integer R[] = RandomGen.reverseArray(n);
		List <Integer>rList = Arrays.asList(A);
		List<Integer>bkList = Arrays.asList(R);
		List <Integer>randList = new ArrayList<Integer>(rList);
		List<Integer>revList = new ArrayList<Integer>(bkList);
		long startTime,endTime;
		List<Integer> result = null;
		System.out.println("---Insertions,Selection Merge Sort,Quick Sort Heap Sort,In-Place Merge,In-Place Quick----");

		//#################Insertion sort#################
		startTime = System.nanoTime();
		result = SortArray.insertionSort(randList);
		endTime = System.nanoTime();
		System.out.println("Running Time :"+(endTime-startTime));
	//	SortArray.printOP(result);

		randList = new ArrayList<Integer>(rList);

		//#################selection sort#################
		startTime = System.nanoTime();
		result = SortArray.selectionSort(randList);
		endTime = System.nanoTime();
		System.out.println("Running Time :"+(endTime-startTime));
		//SortArray.printOP(result);

		randList = new ArrayList<Integer>(rList);

		//#################merge sort#################
		startTime = System.nanoTime();
		result = mergeSort(randList);
		endTime = System.nanoTime();
		System.out.println("Running Time :"+(endTime-startTime));
		//SortArray.printOP(result);

		randList = new ArrayList<Integer>(rList);

		//#################quicksort####################
		startTime = System.nanoTime();
		result = SortArray.quicksort(randList);
		endTime = System.nanoTime();
		System.out.println("Running Time :"+(endTime-startTime));
		//SortArray.printOP(result);

		randList = new ArrayList<Integer>(rList);
		//#################Heap Sort#####################
		startTime = System.nanoTime();
		heapSort(randList);
		endTime = System.nanoTime();
		System.out.println("Running Time :"+(endTime-startTime));
		//	SortArray.printOP(randList);


		randList = new LinkedList<Integer>(rList);
		//#################In-Place Merge Sort#####################
		startTime = System.nanoTime();
		result =sortInPlace(randList, 0, randList.size()-1);//(randList);
		endTime = System.nanoTime();
		System.out.println("Running Time :"+(endTime-startTime));
		//SortArray.printOP(result);


		
		randList = new ArrayList<Integer>(rList);
		//################In-Place Quick Sort#####################

		startTime = System.nanoTime();
		result =quickInPlace(randList, 0, randList.size()-1);//(randList);
		endTime = System.nanoTime();
		System.out.println("Running Time :"+(endTime-startTime));
		//SortArray.printOP(result);
		
		
		
		
		
		revList = new ArrayList<Integer>(bkList);
		
		



		//*********************************Reverse Array / Worst Case Running time1*************************************************
		System.out.println("\n Worst case : Insertion,Selection and merge sort");
		//Insertion Sort
		startTime = System.nanoTime();
		result = SortArray.insertionSort(revList);
		endTime = System.nanoTime();
		System.out.println("Worst Case Time:"+(endTime-startTime));
		//SortArray.printOP(result);

		revList = new ArrayList<Integer>(bkList);
		//selection sort
		startTime = System.nanoTime();
		result = SortArray.selectionSort(revList);
		endTime = System.nanoTime();
		System.out.println("Worst Case Time:"+(endTime-startTime));
		//SortArray.printOP(result);

		revList = new ArrayList<Integer>(bkList);

		//Merge sort
		//	SortArray.printOP(revList);
		startTime = System.nanoTime();
		result = SortArray.mergeSort(revList);
		endTime = System.nanoTime();
		System.out.println("Worst Case Time:"+(endTime-startTime));
		//SortArray.printOP(result);

		revList = new ArrayList<Integer>(bkList);

		//quicksort
		//SortArray.printOP(revList);
		startTime = System.nanoTime();
		result = SortArray.quicksort(randList);
		endTime = System.nanoTime();
		System.out.println("Worst Case Time:"+(endTime-startTime));
		//SortArray.printOP(result);


		revList = new ArrayList<Integer>(bkList);


		//need to code heap sort  here
		startTime = System.nanoTime();
		heapSort(revList);
		endTime = System.nanoTime();
		System.out.println("Worst Case Time:"+(endTime-startTime));
		//SortArray.printOP(revList);

		revList = new LinkedList<Integer>(bkList);

		startTime = System.nanoTime();
		result = sortInPlace(revList, 0, revList.size()-1);
		endTime = System.nanoTime();
		System.out.println("Worst Case Time in place :"+(endTime-startTime));
//		SortArray.printOP(result);
		
		revList = new ArrayList<Integer>(bkList);

		
		startTime = System.nanoTime();
		result =quickInPlace(randList, 0, randList.size()-1);//(randList);
		endTime = System.nanoTime();
		System.out.println("Worst Case Time in place :"+(endTime-startTime));
		SortArray.printOP(result);
		

	}





	/************
	 * 
	 * @param nlist
	 * @return
	 * 
	 * 
	 * 
	 * 
	 * Functions for the sorting algorithms defines below
	 * 
	 */

	//********************************Insertion Sort Begins******************************

	public static List<Integer> insertionSort(List<Integer>nlist){
		//System.out.println("\n Insertion Sort ");
		int i,j,key;
		for(j=1;j<nlist.size();j++){
			key = nlist.get(j);
			i = j-1;
			while(i > -1 && nlist.get(i) > key){
				nlist.set(i+1, nlist.get(i));
				i= i-1;
			}
			nlist.set(i+1, key);
		}
		//System.out.println("---n----"+n.toString());
		return nlist;
	}
	
	//********************************Insertion Sort Ends*********************************
	
	//********************************Selection Sort Begins*******************************
	public static List<Integer> selectionSort(List<Integer> nlist){
		//System.out.println("\n Selection Sort");
		int smallest,temp;
		for(int i=0;i<nlist.size();i++){
			smallest = i;
			for(int j=i+1;j<nlist.size();j++){
				if(nlist.get(j) < nlist.get(smallest)){
					smallest = j;
				}
			}
			//swap elements
			if(smallest != i){
				temp = nlist.get(i);
				nlist.set(i, nlist.get(smallest));
				nlist.set(smallest,temp);
			}
		}
		return nlist;
	}
	//********************************Selection Sort Ends***********************************

	//********************************In Place Merge Sort Begins******************************
	public static List<Integer> sortInPlace(List<Integer>nlist,int low,int high){
		if(low >= high)
			return null;
		else{
			int middle = (low+high)/2;
			sortInPlace(nlist,low,middle);
			sortInPlace(nlist,middle+1,high);
			List<Integer> result = mergeInPlace(nlist,low,middle,high);
			//System.out.println("In Place merge Sort"+result.toString());
			return result;
		}
	}

	public static List<Integer> mergeInPlace(List<Integer>nlist,int low,int mid,int high){
		while(low<= mid+1){
			if(nlist.get(low) > nlist.get(mid+1)){
				//swap;
				int temp = nlist.get(low);
				nlist.set(low, nlist.get(mid+1));
				nlist.set(mid+1, temp);
				//push mid to the correct position
				int temp_mid = mid;
				while(temp_mid+2<=high && (nlist.get(temp_mid+1) > nlist.get(temp_mid+2))){
					//swap
					temp = nlist.get(temp_mid+1);
					nlist.set(temp_mid+1, nlist.get(temp_mid+2));
					nlist.set(temp_mid+2, temp);
					temp_mid++;
					//System.out.println("after push :"+nlist.toString());
				}
			}
			low++;
		}
		return nlist;
	}
	
	//********************************In Place Merge Sort Ends********************************************

	//**************************************Merge Sort Begins**********************************************

	public static List<Integer> mergeSort(List <Integer> nlist){
		List<Integer>  left;
		List<Integer>  right;
		List<Integer> result;
		if(nlist.size() <= 1) return nlist;
		//System.out.println("lenght ----"+nlist.size());
		int middle = (nlist.size()/2);
		left = nlist.subList(0, middle);
		right = nlist.subList(middle, nlist.size());
		//System.out.println("lengths in sort->"+right.size()+"::"+left.size());
		left = mergeSort(left);
		right = mergeSort(right);
		//System.out.println("lengths in calls->"+right.size()+"::"+left.size());
		result =merge(left,right);
		return result;

	}

	public static List<Integer> merge(List <Integer> left, List <Integer> right){
		List<Integer> result = new ArrayList<Integer>();
		Iterator<Integer> itr = right.iterator();
		Iterator<Integer> itl = left.iterator();
		int l = itl.next();
		int r = itr.next();
		while(true){
			if(l > r){
				result.add(r);
				if(itr.hasNext())
					r = itr.next();
				else{
					result.add(l);
					while(itl.hasNext())
						result.add(itl.next());
					break;
				}
			} else {
				result.add(l);
				if(itl.hasNext())
					l = itl.next();
				else{
					result.add(r);
					while(itr.hasNext())
						result.add(itr.next());
					break;
				}
			}
		}
		return result;
	}
	//**************************************Merge Sort Ends**********************************************
	
	
	
	//**************************************Quick Sort Begins**********************************************
	public static List<Integer> quicksort(List<Integer> nlist){
		//Random pRand = new Random();
		//int index = pRand.nextInt(nlist.size());
		List<Integer> less = new ArrayList<Integer>();
		List<Integer> more = new ArrayList<Integer>();
		if(nlist.size() <1) return nlist;
		int pivot = nlist.get(0);
		//	System.out.println("the pivot is "+pivot);
		for(int i=1;i<nlist.size();i++){
			if(nlist.get(i) < pivot)
				less.add(nlist.get(i));
			else //(nlist.get(i) > pivot)
				more.add(nlist.get(i));
		}

		less = quicksort(less);
		more = quicksort(more);
		less.add(pivot);
		less.addAll(more);
		//System.out.println("less"+less.toString());
		return less;
	}
	//**************************************Quick Sort Ends**********************************************
	
	
	
	//**************************************In Place Quick Sort Begin**************************************
	
	public static List<Integer> quickInPlace(List<Integer> nlist,int low,int high){
		int i=low,j=high;
		int pivot = nlist.get((low+(high-low)/2));
		while (i<=j){
			while(nlist.get(i)<pivot){
				i++;
			}
			while(nlist.get(j) > pivot){
				j--;
			}
			if(i<=j){
				//swap
//				nlist.set(i, nlist.get(i)^nlist.get(j));
//				nlist.set(j, nlist.get(i)^nlist.get(j));
//				nlist.set(i, nlist.get(i)^nlist.get(j));
				int temp = nlist.get(i);
				nlist.set(i, nlist.get(j));
				nlist.set(j, temp);
				i++;
				j--;
				
			}
		}
		if(low <j){
			quickInPlace(nlist, low, j);
		}
		if(i < high){
			quickInPlace(nlist, i, high);
		}
		return nlist;
	}
	//*************************************In Place Quick sort End*****************************************

	//*********************************code for Heap Sort Begins here***************************************** 

	public static void heapSort(List <Integer>nlist){
		int length = nlist.size();
		buildMaxHeap(nlist);
		//System.out.println(nlist.toString());
		int end = length -1;int tmp;
		while(end > 0){
			tmp =nlist.get(end);
			nlist.set(end,nlist.get(0));
			nlist.set(0,tmp);
			heapify(nlist, 0, end);
			end--;
		}
	}
	public static void buildMaxHeap(List <Integer> nlist){
		int count = (nlist.size() -2)/2;
		while(count >=0){
			heapify(nlist, count, nlist.size()-1);
			count --;
		}
	}
	public static void heapify(List <Integer>nlist,int start,int end){
		int root = start,child,temp;
		while (root*2 +1 <end){
			child = root*2+1;
			if(child+1 < end && nlist.get(child+1)> nlist.get(child)){
				child = child+1;
			}
			if (nlist.get(root) < nlist.get(child)){
				temp = nlist.get(root);
				nlist.set(root, nlist.get(child));
				nlist.set(child, temp);
				root =child;
			}
			else
				return;
		}
	}
	//*********************************code for Heap Sort Ends here*****************************************
	
	
	
	
	//Helper method for printing the java.util.List
	//can use toString method to display instead 

	public static void printOP(List <Integer> list ){
		for( int i =0 ;i<list.size();i++){
			System.out.print(list.get(i)+" ");
		}
	}


}
