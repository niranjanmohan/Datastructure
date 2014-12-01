package datastructureimpl;
import java.util.Arrays;

/***************************************************
 *************functions in a list****************
get(index)
set(index,value)
add(value)
remove(index)
contains()
size()
iterator ->hasnext,next
 ******************************************************/

public class MyList<T> {
	private int size;
	private  final  int DEFAULT_CAPACITY =10;
	private Object element[];

	public MyList(){
		element = new Object[DEFAULT_CAPACITY];
		size=0;
	}
	public void add(T e){
		if(size == element.length){
			incrSize();
		}
		element[size]= e;
		size++;
	}
	private void checkRange(int index){
		if (index >size || index <0){
			throw new IndexOutOfBoundsException("index out of bound :"+index+"size of list:"+size);
		}
	}
	private void incrSize(){
		int newSize = element.length * 2;
		Arrays.copyOf(element, newSize);
	}
	@SuppressWarnings("unchecked")
	public T get(int index){
		checkRange(index);
		return (T)element[index];
	}
	public void set(int index,T value){
		checkRange(index);
		element[index] = value;
	}
	public void remove(int index){
		checkRange(index);
		for(int i=index;i<size-1;i++){
			element[i]= element[i+1];
		}
		size--;
	}
	public int size(){
		return size;
	}

}
