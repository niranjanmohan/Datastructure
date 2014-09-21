package algorithm.sort.misc;
import java.util.List;


public class TestSort {

	public static List<Integer> quickSort(List<Integer> nlist){
		//Default method
		quickSort(0,nlist.size()-1,nlist);
		return nlist;
	}
	public static List<Integer> quickSort(int p,int q,List<Integer> nlist){
		int pindex;
		if(p < q){
			pindex =partition(p,q,nlist);
			//is nlist updated here
			System.out.println("value of pindex"+pindex);
			quickSort(p,pindex-1,nlist);
			quickSort(pindex,q,nlist);
		}
		return nlist;
	} 
	public static Integer partition(int p,int q,List<Integer> nlist){
		int pivot,temp;
		pivot = nlist.get(q);
		int j =p-1;
		for(int i=p;i<q-1;i++){
			if(nlist.get(i) <= pivot){
				j=j+1;
				temp = nlist.get(i);
				nlist.set(i,nlist.get(j));
				nlist.set(j, temp);
			}
			//insert pivot
			temp = nlist.get(j+1);
			nlist.set(j+1, pivot);
			nlist.set(q, temp);
		}
		return j+1;
	}

}
