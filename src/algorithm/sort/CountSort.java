package algorithm.sort;
import java.util.List;
import java.util.ArrayList;

public class CountSort {
	public static void main(String [] args){
		List <Integer>test = new ArrayList<Integer>();
		for(int i=0;i<100;i++)
			test.add(i%9);
		countingSort(test);
		System.out.println("\n"+test.size());
		
		
	}
	
	public static void countingSort(List<Integer> ls){
		//find the min and the max
		int min=0,max=0;
		List<Integer> ar = new ArrayList<Integer>();
		for (Integer number : ls){
			if(number <min)
				min = number;
			if(number >max)
				max =number;
		}
		//initialize all elements to zero
		for(int i =min; i<=max;i++)
			ar.add(0);
		for(int i=0; i<ls.size();i++){
			ar.set(ls.get(i), ar.get(ls.get(i))+1);
		}
		List<Integer> flist = new ArrayList<Integer>();
		for(int i=min;i<=max;i++)
			while(ar.get(i-min)> 0){
				flist.add(i);
				ar.set(i-min, ar.get(i-min) -1);
			}
		int count =0;
		for(Integer nu :flist){
			System.out.print(nu+" ");
			count++;
		}
		System.out.println("\n"+count);
	}
	
	
	
	
	
	
	
	
	
	//downloaded code
	public static void countingSort(int[] array, int min, int max){
		int[] count= new int[max - min + 1];
		for(int number : array){
			count[number - min]++;
		}
		int z= 0;
		for(int i= min;i <= max;i++){
			while(count[i - min] > 0){
				array[z]= i;
				z++;
				count[i - min]--;
			}
		}
	}
	
	

}
