package algorithm;

import java.util.Arrays;
import java.util.List;

public class Pytho {

	public static void main(String [] args){
		Integer [] a = { 1,2,3,4,5,6,7,8,9,10,11,12,13};
		List<Integer>list = Arrays.asList(a);

		for(int i=0;i<list.size();i++){
			list.set(i, list.get(i)*list.get(i));
		}
		

	}
}
