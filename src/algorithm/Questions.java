package algorithm;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class Questions {
	public static void main(String [] args){
		Integer arr[]= {-2,-5,6,-2,-3,7,-5,-6,8};
		List <Integer>nlist= Arrays.asList(arr);
		//findMaxSlow(nlist);
		findMaxFast(nlist);
		Integer a2[]= {0,1,9,0,0,8,4,0,0,2,7,0,6,0};
		zeroToend(Arrays.asList(a2));
		zeroToBegin(Arrays.asList(a2));
		sum("12","12");multiply("99999","99");

		System.out.println("anagra check");
		System.out.println(isAnagram("llamalm", "malamll"));
	}



	//should be done using Karatsuba's Algorithm
	//need to implement it 
	public static void multiply(String sno1,String sno2){
		List<Integer> no1 = new ArrayList<Integer>();
		List<Integer> no2 = new ArrayList<Integer>();
		List<Integer> result = new ArrayList<Integer>();
		for(int i =0;i<sno1.length();i++){
			Integer n = (int)sno1.charAt(i)-48;
			no1.add(n);
		}
		for(int i =0;i<sno2.length();i++){
			Integer n = (int)sno2.charAt(i) -48;
			System.out.println(n);
			no2.add(n);
		}
		Collections.reverse(no1);
		Collections.reverse(no2);
		for(int i=0;i<(no1.size()+no2.size());i++)
			result.add(0);
		int prod =1;

		for(int i=0;i<no1.size();i++){
			int carry =0;
			for(int j=0;j<no2.size();j++){
				prod = no2.get(j)*no1.get(i)+carry+result.get(i+j);
				if(prod >=10){
					carry = prod/10;
					result.set(i+j,prod%10);
				}
				else{
					carry =0;
					result.set(i+j, prod);
				}
			}
			if(carry !=0){
				result.set(no2.size()+i, carry);
			}
		}
		Collections.reverse(result);
		System.out.println("Product is --->"+result.toString());
	}

	public static void sum(String sno1,String sno2){
		List<Integer> no1 = new ArrayList<Integer>();
		List<Integer> no2 = new ArrayList<Integer>();
		for(int i =0;i<sno1.length();i++){
			Integer n = (int)sno1.charAt(i)-48;
			no1.add(n);
		}
		for(int i =0;i<sno2.length();i++){
			Integer n = (int)sno2.charAt(i) -48;
			System.out.println(n);
			no2.add(n);
		}
		//multiply both the numbers
		int size1 = no1.size();
		int size2 = no2.size();
		int max = size1 > size2 ? size1:size2;
		int less = size1 > size2 ? size2:size1;
		int carry =0;int sum =0;
		Collections.reverse(no1);
		Collections.reverse(no2);
		List <Integer>result = new ArrayList<Integer>();
		//code to find sum
		for(int i=0;i<less;i++){
			sum = no1.get(i)+no2.get(i)+carry;
			//System.out.println("prod"+sum);
			if(sum >= 10){
				carry = 1;
				sum = sum%10;
			}
			else
				carry =0;
			result.add(sum);
		}
		if(max > less)
			for(int i=less;i<max;i++){
				int rest = size1 >size2 ? no1.get(i) : no2.get(i);
				rest+=carry;
				if(rest >10){
					carry =1;
					rest = rest%10;
				}
				else{
					carry =0;
				}
				result.add(rest);
			}
		if(carry !=0)
			result.add(carry);
		//	System.out.println("the reverse prod is "+result.toString());
		Collections.reverse(result);
		System.out.println("real sum is"+result.toString());
	}



	//Kadanes algorithm
	public static void findMaxFast(List<Integer>nlist){
		int global_max=-9999,u=0,v=0;
		int cur_max=nlist.get(0),q=0;
		for(int i=1;i<nlist.size()-1;i++){
			if(cur_max >= 0){
				cur_max = cur_max + nlist.get(i);
			}
			else{
				cur_max =nlist.get(i);
				q=i;
			}
			if(cur_max >= global_max){
				global_max = cur_max;
				u =q;
				v=i;
			}
		}
		System.out.println("Maximum Sub-Seq :"+global_max+"Indexes :"+u+","+v);
	}



	public static void zeroToend(List<Integer> nlist){
		int count =nlist.size() -1;
		for(int i= nlist.size()-1;i>=0 ;i--){
			if(nlist.get(i) == 0){
				nlist.set(i, nlist.get(count));
				nlist.set(count, 0);
				count --;
			}
		}
		System.out.println(nlist.toString());
	}
	public static void zeroToBegin(List<Integer> nlist){
		int count =0;
		for(int i=0;i<nlist.size();i++){
			if(nlist.get(i) == 0){
				nlist.set(i, nlist.get(count));
				nlist.set(count, 0);
				count++;
			}
		}
		System.out.println(nlist.toString());
	}



	//find if 2 String are anagrams
	public static boolean isAnagram(String s1,String s2){
		Map<Character,Integer> cMap = new HashMap<Character,Integer>();
		if (s1.length() != s2.length())
			return false;
		else {
			for(Character c:s1.toCharArray()){
				if(! cMap.containsKey(c))
					cMap.put(c, 1);
				else{
					cMap.put(c,( cMap.get(c)+1));
				}
			}
			for(Character c:s2.toCharArray()){
				if(! cMap.containsKey(c))
					return false;
				else{
					if(cMap.get(c) >1)
						cMap.put(c, cMap.get(c)-1);
					else
						cMap.remove(c);
				}
			}
			if(cMap.size()!=0)
				return false;
			else
				return true;
		}
	}



	public static int rotated_binary_search(Integer A[], int N, int key) {
		int L = 0;
		int R = N - 1;

		while (L <= R) {
			// Avoid overflow, same as M=(L+R)/2
			int M = L + ((R - L) / 2);
			if (A[M] == key) return M;

			// the bottom half is sorted
			if (A[L] <= A[M]) {
				if (A[L] <= key && key < A[M])
					R = M - 1;
				else
					L = M + 1;
			}
			// the upper half is sorted
			else {
				if (A[M] < key && key <= A[R])
					L = M + 1;
				else 
					R = M - 1;
			}
		}
		return -1;
	}
}



//naive method with o(n^2) time need to implement  faster algo which runs in o(n) time
//DONT USE THIS XXXXXXXXXXXXXXXXXXXXXXXXXX
//public static void findMaxSlow(List<Integer> nlist){
//	int global_max =-9999;
//	int local_max=-9999;int last_index=0;
//	int start_index=0,global_last =0;
//	//Don not implement this inefficent algo
//	for(int i =0;i<nlist.size();i++){
//		//int local_last = 0;
//		int sum = 0;
//		for(int j=i;j<nlist.size();j++){
//			sum = nlist.get(j)+ sum;
//			if(sum > local_max){
//				local_max = sum;
//				last_index = j;
//			}
//		}
//		if(local_max > global_max){
//			global_max = local_max;
//			start_index =i;
//			global_last = last_index;
//		}
//	}
//	System.out.println("Maximum Sub-Seq :"+global_max+"indexes :"+start_index+","+global_last);
//}
//faster algo for finding max subsequence 
