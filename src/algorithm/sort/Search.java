package algorithm.sort;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Search {

	public Search() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String []args){
		Integer list[]  = RandomGen.sortedList(100);
		System.out.println(binSearch(list, 101));
		List<Integer> alist =  Arrays.asList(list);
		System.out.println(alist.contains(101));
		for(int i=0;i<alist.size();i++){
			System.out.print(alist.get(i)+" ");
		}
		
	}
	public static boolean binSearch(Integer [] list,int item){
		int bottom = 0;
		int top = (list.length) -1;
		int middle;
		int location =-1;
		boolean found = false;
		while (bottom <= top && ! found){
			middle =(bottom+top)/2;
		//	System.out.println(middle+" value"+list[middle]);
			if (item == list[middle]){
				found =true;
				location =middle;
			}
			else if(list[middle] <= item){
				bottom = middle+1;
			}
			else{
				top = middle -1;
			}
		}
		return found;
	}
	

}
