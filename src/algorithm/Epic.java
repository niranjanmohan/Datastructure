package algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.lang.model.type.PrimitiveType;

public class Epic {

	public static void main(String [] args){
		int no = 2567;
		System.out.println(checkColorful(no));
		System.out.println(isMagicNumber(2396));

		System.out.println(checkMagic(181));

		printOct(891);

		seivePrime(100);
		printPrimePair(24);
		steppingNos(0, 1000);
		
		int [] arr ={-2, -3, 4, -1, -2, 1, 5, -3};
		kandanes(arr);
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





	//palindrome sub-sequence


	public static String subPalindrome(String str){
		int len = str.length();
		int maxlen =0;
		int [][] arr = new int[len][len];
		//a single alphabet is a palindrome
		for(int i=0;i<len;i++){
			arr[i][i] = 1;
		}
		//
		String longestStr=null;
		for(int i=0;i<len-1;i++){
			if(str.charAt(i) == str.charAt(i+1)){
				arr[i][i+1] = 1;
				longestStr = str.substring(i,i+2);
			}
		}
		for(int l=3;l<len;l++)
			for(int i=0;i<len-1;i++){
				int j = i+l-1;
				if(str.charAt(i) == str.charAt(j)){
					arr[i][j] = arr[i+1][j-1];
					if(arr[i][j] == 1 && l > maxlen){
						longestStr = str.substring(i, j + 1);
					} else {
						arr[i][j] = 0;
					}
				}
			}
		return longestStr;
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
