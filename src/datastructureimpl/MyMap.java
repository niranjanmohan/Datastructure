package datastructureimpl;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/***
 * 
 * @author niranjan
 *********************Functions for MAP********************
 *put(Key,value)
 *get(key) -> should return value
 *size()
 *remove()
 *keySet()
 *
 * @param <K>
 * @param <V>
 */
public class MyMap<K,V> {
	private int size;
	private static final int DEFAULT_SIZE = 10;
	@SuppressWarnings("unchecked")
	private MyEntry<K,V>[] map = new MyEntry[DEFAULT_SIZE];

	public V get(K key){
		for(int i=0;i<size;i++){
			if (map[i].getKey().equals(key))
				return map[i].getValue();
		}
		return null;
	}

	public void put(K key,V value){
		boolean insert = true;
		for (int i=0 ;i <size;i++){
			if(map[i].getKey().equals(key))
				insert = false;
		}
		if(insert){
			incrSize();
			map[size++] = new MyEntry<K,V>(key, value);
			System.out.println("added value:"+value+"key:"+key+"at index:"+size);
		}
	}

	private void incrSize(){
		if(map.length == size){
			int newsize = map.length*2;
			Arrays.copyOf(map, newsize);
		}
	}
	public Set<K> getKeySet(){
		Set <K>s = new HashSet<K>();
		for(int i=0;i<size;i++){
			//System.out.println("getting key:"+map[i].getKey()+"Index :"+i);
			s.add(map[i].getKey());
		}
		return s;
			
	}
	
	public boolean remove(K key){
		boolean isRemoved = false;
		for(int i=0;i< size;i++){
			if(map[i].getKey().equals(key)){
				resizeArr(i);
				isRemoved = true;
				size--;
			}
		}
		return isRemoved;
	}
	private void resizeArr(int start){
		map[start]=null;
		for(int i=start;i<size;i++){
			map[i]=map[i+1];
		}
	}
}
