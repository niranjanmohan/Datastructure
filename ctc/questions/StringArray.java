package questions;

import java.rmi.server.UnicastRemoteObject;
import java.util.Arrays;

public class StringArray {
	public static void main (String [] args){
		//code to convert the number to base 10		
		try{
			System.out.println(Integer.parseInt("A",16));
		}
		catch(NumberFormatException nfe){
			nfe.printStackTrace();
		}

		//code to check the String has got all unique digits

		String un = "trusee";
		for(int i=0;i<un.length();i++)
		{
			if(un.indexOf(un.charAt(i)) != (un.lastIndexOf(un.charAt(i)))){
				System.out.println("duplicate");
				break;
			}	
		}

		//given 2 string write a function to see if one is the permutation of the other
		String anagram1 ="created";
		String anagram2 ="reactd";		
		if(anagram1.length() == anagram2.length())
			if(sorted(anagram1).equals(sorted(anagram2)))
				System.out.println("Anagram");

		if(checkAnagram(anagram1, anagram2))
			System.out.println("char anagram");


		//replace all spaces in a String with "%20"
		System.out.println(replaceSpace("abc def "));

		//using String for my own curiosity
		String rep = "abc def ";
		String newstr = rep.replaceAll(" ", "20%");
		System.out.println(newstr);

		//if string is in for aaaabbcc output should be a3b2c2 
		compresString("aaabbcc");


		//Rotate a matrix by 90 
		int mat[][] = new int [4][4];
		//create a matrix
		for(int i=0;i<4;i++)
			for(int j=0;j<4;j++)
				mat[i][j]=j+1;

		//print matrix
		for(int i=0;i<4;i++){
			System.out.println();
			for(int j=0;j<4;j++){
				System.out.print(mat[i][j]+" ");
			}
		}
		
		
		rotateMatrix(mat);		


	}

	public static String sorted(String s){
		char ar[] = s.toCharArray();
		Arrays.sort(ar);
		//System.out.println(String.valueOf(ar));
		return String.valueOf(ar);
	}
	public static boolean checkAnagram(String s1,String s2){
		//need to check using character array
		boolean ar[]= new boolean[256];
		for(int i=0;i<s1.length();i++){
			int asci =s1.charAt(i);
			ar[asci]= true;
		}
		for(int i=0;i<s2.length();i++){
			int asci = s2.charAt(i);
			if(! ar[asci])
				return false;
		}
		return true;
	}
	public static String replaceSpace(String s){
		char ar[]= s.toCharArray();
		int count=0;
		int oldlen = ar.length;
		for(int i=0;i<ar.length;i++){
			if (ar[i] ==' ')
				count++;
		}
		System.out.println(count);
		int newlen = count*2+ar.length;
		//System.out.println("size before :"+ar.length);
		ar =Arrays.copyOf(ar, newlen);
		System.out.println("size"+ar.length);
		for(int i=oldlen-1;i>=0;i--){
			if(ar[i]==' '){
				ar[newlen -1] = '%';
				ar[newlen -2] = '0';
				ar[newlen -3] = '2';
				newlen-=3;
			}
			else{
				ar[newlen-1] = ar[i];
				newlen --;
			}
		}
		return String.valueOf(ar);
	}



	//compress string aaabbcc -> a3b2c2
	public static void compresString(String s){
		StringBuffer bf = new StringBuffer(s);
		StringBuffer f_bf = new StringBuffer();
		char ch = bf.charAt(0);
		f_bf.append(ch);
		int count =1;
		for(int i=1;i<bf.length();i++){
			if(ch == bf.charAt(i)){
				count ++;
			}else{
				f_bf.append(count);
				ch = bf.charAt(i);
				f_bf.append(ch);
				count =1;
			}	
		}
		f_bf.append(count);
		if(f_bf.length() < bf.length())
			System.out.println(f_bf.toString());
		else
			System.out.println(bf);
	}
	public static void rotateMatrix(int [][] mat){
		System.out.println();
		int size = mat.length;int top;
		for(int layer =0;layer< size/2;++layer){
			int first = layer;
			int last = size-1-layer;
			for(int i=first;i<size;++i){

				System.out.println("first :"+first+" i :"+i+ "last :"+last);
				//load the top to temp
				top = mat[first][i];
				int offset = i-first;
				//load the left to top
				mat[first][i] = mat[last-offset][first];
				
				//load the bottom to left 
				mat[last-offset][first] = mat[last][last-offset];
		
				//load the right to bottom
				mat[last][last-offset]=mat[i][last];
			
				//load the temp to right
				mat[i][last] = top;
				
				/*
				 *  layer :0 i :0last :3
					layer :0 i :1last :3
					layer :0 i :2last :3
					layer :0 i :3last :3
					layer :1 i :1last :3
					layer :1 i :2last :3
					layer :1 i :3last :3
				 * 
				 * 
				 * 
				 * 
				 * 
				 */
				
				
				
				
			}
		}
		//print matrix
		for(int i=0;i<4;i++){
			System.out.println();
			for(int j=0;j<4;j++){
				System.out.print(mat[i][j]+" ");
			}
		}
		
	}
}
