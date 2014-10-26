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
		System.out.println("longest palindrome :"+ longestPalindrome2(s));
		
	}
	
	
	
	public static String longestPalindrome2(String s) {
		if (s == null)
			return null;
	 
		if(s.length() <=1)
			return s;
	 
		int maxLen = 0;
		String longestStr = null;
	 
		int length = s.length();
	 
		int[][] table = new int[length][length];
	 
		//every single letter is palindrome
		for (int i = 0; i < length; i++) {
			table[i][i] = 1;
		}
		//printTable(table);
	 
		//e.g. bcba
		//two consecutive same letters are palindrome
		for (int i = 0; i <= length - 2; i++) {
			if (s.charAt(i) == s.charAt(i + 1)){
				table[i][i + 1] = 1;
				longestStr = s.substring(i, i + 2);
			}	
		}
		//printTable(table);
		//condition for calculate whole table
		for (int l = 3; l <= length; l++) {
			for (int i = 0; i <= length-l; i++) {
				int j = i + l - 1;
				
				if (s.charAt(i) == s.charAt(j)) {
					System.out.println("value of j"+j+"    "+i);
					table[i][j] = table[i + 1][j - 1];
					if (table[i][j] == 1 && l > maxLen){
						System.out.println("entered ");
						longestStr = s.substring(i, j + 1);
					}
				} else {
					table[i][j] = 0;
				}
			//	printTable(table);
			}
		}
	 
		return longestStr;
	}

//*******************Seems Wrong ******************************

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

