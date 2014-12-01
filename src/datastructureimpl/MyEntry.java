package datastructureimpl;
/***
 * 
 * @author niranjan
 ************Functions *************************
 *
 *getKey(Key)
 *getValue(Value)
 *
 * @param <K>
 * @param <V>
 */
public class MyEntry<K,V> {
	private K key;
	private V value;
	MyEntry(K k,V v){
		this.key = k;
		this.value = v;
	}
	public V getValue(){
		return this.value;
	}
	public K getKey(){
		return this.key;
	}
	public void setValue(V value){
		this.value = value;
	}
	
}
