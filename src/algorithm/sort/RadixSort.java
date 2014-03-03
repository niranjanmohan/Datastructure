package algorithm.sort;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;


public class RadixSort {
	public static void main(String [] args){
		
		Random rand = new Random();
		List <Integer>ls = new ArrayList<Integer>();
		for(int i=0;i<10;i++){
			ls.add(rand.nextInt(150));
		}
		System.out.println(ls.toString());
		ls = radixSort(ls);
		System.out.println(ls.toString());
}



	public static List<Integer> radixSort(List<Integer> ls){
		Queue<Integer> bucket[] = new Queue[10];
		for(int px=0;px < 3 ;px++){
			for(int i=0;i<ls.size();i++){
				int cval = ls.get(i);
				int digit = (int)(cval/Math.pow(10,px) %10);
				if(bucket[digit] == null){
					bucket[digit] = new LinkedList<Integer>();
				}
				bucket[digit].add(cval);
			}
			//copy the values into intermeidate array
			List<Integer> inter =new ArrayList<Integer>();
			for(int bi =0;bi <bucket.length;bi++){
				if(bucket[bi]!=null){
					while(! bucket[bi].isEmpty()){
						inter.add(bucket[bi].poll());
					}
				}
			}
			
			//copy this to ls
			ls = new ArrayList<Integer>(inter);
			
		}
		return ls;
	}
}
