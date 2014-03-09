package algorithm.sort;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class RandomGen {

	public RandomGen() {
		// TODO Auto-generated constructor stub
	}
	public static Integer[] randArray(Integer n){
		int j;
		Integer A[];
		List<Integer> list = new ArrayList<Integer>();
		Random rand = new Random();
		list.add(rand.nextInt(n));
		while(list.size() < n){
			j = rand.nextInt(n);
			if(!list.contains(j))
				list.add(j);
		}
//		System.out.println("Initial Array");
//		for(i=0;i<list.size();i++){
//			System.out.print(list.get(i)+" ");
//		}
		A = new Integer[list.size()];
		A = list.toArray(A);
		return A;
	}
	public static Integer[] reverseArray(Integer n){
		Integer A[] = new Integer[n];
		for(int i=n;i>0;i--){
			A[n-i] = i;
		}
		return A;
	}
	public static Integer[] sortedList(Integer n){
		Random rand= new Random();
		Integer A[] = new Integer[n];int i,j;
		for( i=0,j=0;j<n;i=i+rand.nextInt(3),j++){
			//System.out.println("value of rand"+rand.nextInt(2));
			A[j] = i;
		}
		return A;
	}

}
