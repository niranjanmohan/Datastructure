package hashtable;
import java.util.Arrays;


public class MyHashTable {
	private String [] sysArray;
	private int size;
	private int itemsinArray =0;
	
	
	public void hashFunc(String[] dataArray){
		for(int i=0;i< dataArray.length;i++){
			String newElement = dataArray[i];
			sysArray[Integer.parseInt(newElement)] = newElement;
		}
	}
	MyHashTable(int size){
		this.size = size;
		sysArray = new String[size];
		Arrays.fill(sysArray, "-1");
	}
	public void hashFunction(String [] dataArray){
		for(int i=0;i< dataArray.length;i++){
			String newElement = dataArray[i];
			int index = Integer.parseInt(newElement)%31;
			int stepIndex = 7 - Integer.parseInt(newElement)%7;
			System.out.println("index"+index+"value"+dataArray[i]);int count =0;
			while(! sysArray[index].equals("-1") && count <= sysArray.length ){
				index+=stepIndex;
				System.out.println("collision"+index);
				index %= size;
				count++;
			}
			sysArray[index] = newElement;
		}
	}
	
	
	public String findKey(String key){
		int keyhashindex = Integer.parseInt(key)%31;
		while(!sysArray[keyhashindex].equals("-1")){
			if(sysArray[keyhashindex].equals(key)){
				System.out.println("Key found at index"+keyhashindex);
				return String.valueOf(keyhashindex);
			}
		}
		return null;
	}
	public void displayContent(){
		for(int i=0;i<sysArray.length;i++){
			System.out.println("index :"+i+"value :"+sysArray[i]);
		}
	}
	
	

}
