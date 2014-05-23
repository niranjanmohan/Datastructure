package algorithm;

public class KMP {
	public static void main(String [] args){

		naiveAlgo("atcgcacattatacattattatacat","attataca");
	//	findWord("atcgcacattatacattattatacat","attataca");

	}




	//Practise

	public static void findWord(String P,String M){

		int lenm = M.length()-1;
		int lenp = P.length()-1;
		char [] pc = P.toCharArray();
		char [] mc = M.toCharArray();

		//calculate the overlap of the matcher string m
		int overlap[] = new int[lenm+1];
		overlap[0]=0;char c;int v;
		for(int k=0;k<lenm;k++){
			c=  mc[k+1];
			v = overlap[k];
			while(c != mc[v] && v != 0)
				v = overlap[v];
			if(c == mc[v])
				overlap[k+1] = v+1;
			else 
				overlap[k+1] = 0;
		}

		//traverse over the word using the overlap to avoid repetitive tasks
		int  i=0,j=0,k=0;

		while( lenp+1-k > lenm+1){
			while(j < lenm+1 && mc[j]==pc[i]){
				i++;j++;
			}
			if(j >= lenm )
				System.out.println("position :"+k);
			if(overlap[j-1] >0)
				k = i - overlap[j-1];
			else{
				if(i==k)
					i++;
				k =i;
			}
			if(j>1)
				j = overlap[j-1]+1;
		}
	}












	//runs in O(mn) time 
	public static void naiveAlgo(String p,String m){
		char[] pc = p.toCharArray();
		char[] mc = m.toCharArray();
		int j=0,k=0;
		for(int i=0;i<p.length();i++){
			k=i;
			while(j <=m.length()-1 && k<= p.length()-1 && pc[k] == mc[j]){
				j++;k++;
				if( j > m.length()-1){
					System.out.println(i);
				}
			}
			j=0;
		}
	}
}