package algorithm;

public class CalcPermutation {
	static int count =0;
	public static void main(String [] args){
		
		String input ="cat";
		for(int i=0;i<input.length();i++){
			for(int j=0;j<=i;j++){
				insertCharAt(i,j,input);
			}
		}
	}
	public static void insertCharAt(int shiftchar ,int newpos ,String str){
		//remove char at position i and place it at jth index
		StringBuffer br = new StringBuffer(str);
		char m =br.charAt(shiftchar);
		br.deleteCharAt(shiftchar);
		System.out.println("newpos"+newpos+" i :"+m);
		br.insert(newpos, m);
		System.out.println(br.toString()+" "+count++);
		
		//int r=Integer.MIN_VALUE;
	}

}
