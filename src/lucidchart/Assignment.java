package lucidchart;

public class Assignment {
	public static void main(String[] args) { 
		int[][] grid = {{8, 2, 4}, 
				{0, 7, 1}, 
				{3, 7, 9}}; 
		System.out.println(longestSequence(grid)); 
	} 


	public static int longestSequence(int A[][]){
		int len = A.length;
		int dp [][] = new int [len][len];
		int max =0;
		for(int i=0;i<len;i++){
			for(int j=0;j<len;j++){
				int tempmax = fillDP(A,dp,i,j)+1;
				if(tempmax > max)
					max = tempmax;
			}
		}
		return max;

	}

	//fill in the memoized array 
	public static int fillDP(int [][]A,int[][]dp,int i,int j){
		int len = A.length;
		if(i <0 || j < 0 || i >= len || j >= len ){
			return 0;
		}
		if(dp[i][j] != 0)
			return dp[i][j];
		int left=0,right=0,topLeft=0,topRight=0,bottom=0,top=0,bottomLeft=0,bottomRight=0;
		if(j-1 >= 0&& A[i][j] < A[i][j-1])
			left = fillDP(A,dp,i,j-1);

		if(j+1<len && A[i][j] < A[i][j+1])
			right = fillDP(A,dp,i,j+1);

		if(i+1 <len && A[i][j] < A[i+1][j])
			bottom = fillDP(A,dp,i+1,j);

		if(i-1 >=0 && A[i][j] < A[i-1][j])
			top = fillDP(A,dp,i-1,j);

		if(i+1 < len && j-1 >=0 && A[i][j] < A[i+1][j-1])
			bottomLeft = fillDP(A,dp,i+1,j-1);

		if(i+1 >len && j+1 >len && A[i][j] < A[i+1][j+1])
			bottomRight = fillDP(A,dp,i+1,j+1);

		if(i-1 >=0 && j-1 >=0 && A[i][j] < A[i-1][j-1])
			topLeft = fillDP(A,dp,i-1,j-1);

		if(i-1 >=0 && j+1 <len && A[i][j] < A[i-1][j+1])
			topRight = fillDP(A,dp,i-1,j+1);

		dp[i][j]= Math.max(Math.max(Math.max(top,bottom),Math.max(right,left)),Math.max(Math.max(bottomRight,bottomLeft),Math.max(topLeft,topRight))) +1;
		return dp[i][j]; 

	}

}
