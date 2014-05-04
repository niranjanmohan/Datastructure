import java.util.Arrays;


public class PalindromeNo {
	
	public static void main(String [] args){
		int length =0;
		String s= "acivicla";
		int strlen = s.length();
		int [][] dy = new int[strlen][strlen];
		for(int i=0;i<strlen;i++)
			for(int j=0;j<strlen;j++)
				dy[i][j]=0;
		//System.out.println(dy.toString());
		System.out.println("max pal is :"+findPalindrome(s, 0, s.length()-1, length,dy));
		
		
	}



//dynamic prog
	public static int findPalindrome(String s, int i, int j, int length,int [][] dy){
		if(dy[i][j] !=0 )
			return dy[i][j];
		if(i == j){
			dy[i][j] =1;
			return 1;
		}
		if(j == i + 1){
			if(s.charAt(i) == s.charAt(j)){
				dy[i][j] =2;
				return 2;
			}
		}
		if(s.charAt(i) == s.charAt(j)){
			length = 2 + findPalindrome(s, i+1 , j-1, length,dy);
			dy[i][j] =length;
		}else{
			length = Math.max(findPalindrome(s, i+1 , j , length,dy), findPalindrome(s, i , j-1 , length,dy));
			dy[i][j] =length;
		}	
		return length;
	}
}

