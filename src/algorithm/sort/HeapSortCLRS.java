package algorithm.sort;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
public class HeapSortCLRS {

	public HeapSortCLRS() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String [] args){
		List<Integer>list =Arrays.asList( RandomGen.randArray(10));
		List<Integer> hlist= new ArrayList<Integer>();
		hlist.addAll(list);
		System.out.println(hlist.toString());
		//hlist = buildMaxHeap(hlist);
		//System.out.println("max heap-->"+hlist.toString());
		hlist =heapSort(hlist);
		 Collections.reverse(hlist);
		System.out.println("result--->>"+hlist.toString());
	}
	public static List<Integer> maxHeapify(List<Integer>hlist,int index,int end){
		System.out.println(hlist.size()+"***************");
		int left,right,largest,temp;left = -1;right =-1;
		largest = index;
		if( (index*2) <= end )
		left = hlist.get(2*index);
		if( (index*2+1) <= end)
		right = hlist.get(2*index + 1);
		System.out.println("values :"+hlist.get(index)+"left :"+left+"right :"+right);
		if(left > hlist.get(largest) && (index*2) <= end ){
			largest = 2*index;
		}
		if(right > hlist.get(largest) && (index*2+1) <= end)
			largest = 2*index+1;
		if(largest != index){
			System.out.println("swapping values");
			temp = hlist.get(index);
			hlist.set(index, hlist.get(largest));
			hlist.set(largest, temp);
			index = largest;
			hlist =maxHeapify(hlist,index,end);
		}
		return hlist;
	}
	public static List<Integer> buildMaxHeap(List<Integer>list){
		for(int i= list.size()/2;i>0;i--){
			//System.out.println("value of i is:"+i);
			list = maxHeapify(list, i-1,list.size()-1);
		}
		return list;
	}
	public static List<Integer> heapSort(List<Integer> hlist){
		hlist = buildMaxHeap(hlist);
		System.out.println("after max heap"+hlist.toString());
		int temp;
		List <Integer>result = new ArrayList<Integer>();
		System.out.println("calling heap sort");
		for(int i= hlist.size()-1;i>1;i--){
			//exchange a[1] with a[n]
			//hlist.set(1, hlist.get(hlist.size()-1));
			result.add( hlist.get(0));
			System.out.println("at size :"+(hlist.size())+"removing :"+hlist.toString());
			hlist.remove(0);
			System.out.println("after removing "+ hlist.toString());
			maxHeapify(hlist,0,i);
		}
		return result;
	}

}
