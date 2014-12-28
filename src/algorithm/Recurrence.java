package algorithm;

import java.util.BitSet;

public class Recurrence {
	public static void main(String []args){
		int ans;
		//permu("","abc");

		System.out.println();

		//power in O(log n) time 
		long ansl = pow (3l,5l);
		System.out.println(ansl);

		//power of any number using bit wise
		ans = powi(5, 5);
		System.out.println("power :"+ans);



		//power in O(n) time
		ans= powerBad(8);
		//System.out.println(ans);
		
		getPower2(6);
		
		int hexVal = 0Xaaaaaaaa;
		int hex2 = 0X55555555;
		System.out.println("hexval :"+hexVal+ "  hex2  :"+Integer.toBinaryString(hex2));
		System.out.println("integer of bin values :"+ Integer.parseInt("10101010101010101",2));
	}
	
	//power of 2
	public static void getPower2(int pow){
		int n =2;
		for(int i=0;i<pow-1;i++){
			n = n <<1;
		}
		System.out.println("2 to the power of :"+pow+" is :"+n);
	
	}
	
	public static long pow(long base, long exp){        
	    if(exp ==0){
	        return 1;
	    }
	    if(exp ==1){
	        return base;
	    }

	    if(exp % 2 == 0){
	        long half = pow(base, exp/2);
	        return half * half;
	    }else{
	        long half = pow(base, (exp -1)/2);
	        return base * half * half;
	    }       
	}


	public static void permu(String prefix,String str){
		int len = str.length();
		if(len == 0){
			System.out.print(" "+prefix+" ");
		}
		else{
			System.out.print(" "+str);
			for(int i=0;i<len;i++){
				permu(prefix+str.charAt(i),str.substring(0,i)+str.substring(i+1,len));
			}
		}
	}

	public static int powi(int base,int exp){
		int result =1;
		while(exp !=0){
			//System.out.println("count :"+count++);
			if((exp&1) != 0)
				result*=base;
			exp >>=1;
			//System.out.println(exp);
			base*=base;
		}
		return result;
	}








public static int powerBad(int n){
	if(n <=0)
		return 1;
	else
		return 2*powerBad(n-1);
}
}
