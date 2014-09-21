package algorithm.sort.misc;
import java.util.ArrayList;
import java.util.List;


public class Test {
public static void main(String [] args){
	List<Integer>ls = new ArrayList<Integer>();
	List<Integer>right = null;
	List<Integer> left = null;
	for(int i=0;i<2;i++){
		ls.add(i);
	}
	System.out.println(ls.size());
	//System.out.println(ls.get(9));
	left =ls.subList(0, ls.size()/2);
	right = ls.subList(ls.size()/2, ls.size());
	System.out.println("left::"+left.toString()+"right::"+right.toString());
	
	
	System.out.println("testing function calls");
	List <Integer> lis = new ArrayList<Integer>();
	for(int i=0;i<10;i++){
		lis.add(0);
	}
	updateLis(lis);
	for(int i=0;i<10;i++){
		System.out.print(" "+lis.get(i));
	}
	
	
	
}
public  static void updateLis(List<Integer> nlist){
	for(int i=0;i<10;i=i+2)
	nlist.set(i, 999);
}

}
