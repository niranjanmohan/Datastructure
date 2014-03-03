import java.util.Arrays;

/***********************************
 * @author niranjan
 * 
 **************** functions to implement**************
 *pop()
 *push(E value)
 *peek()
 *search(Object o)
 * 
 */


public class MyStack <E>{
	private int size;
	private final int default_size = 10;
	private Object element[];
	MyStack(){
		 element = new Object[default_size];
		 size =0;
	}
	
	@SuppressWarnings("unchecked")
	public E pop(){
		if(size == 0){
			E value = (E) element[size];
			element[size]=null;
			return value;
		}
		E e =(E)element[--size];
		element[size]=null;
		return e;
	}
	public void push(E value){
		if(size == element.length){
			incrSize();
		}
		element[size++]=value;
	}
	@SuppressWarnings("unchecked")
	public E peek(){
		return (E) element[size];
	}
	public int size(){
		return size;
	}
	private void incrSize(){
		size = size*2;
		Arrays.copyOf(element, size);
	}


}
