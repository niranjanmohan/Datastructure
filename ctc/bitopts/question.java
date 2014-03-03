package bitopts;

public class question {
	public static void main(String args[]){
		//doubleQ();
		
		String s = "010101010101";
		System.out.println(s);
		System.out.println(Integer.parseInt(s,2));
		
		
		//System.out.println(Integer.toBinaryString(i1));
		int a =21;
		int b=31;
//		System.out.println(Integer.toBinaryString(a));
//		System.out.println(Integer.toBinaryString(a&1));
		int count =0;
		
		//System.exit(0);
		
//		for(int c = a^b;c!=0;c= c >>1 ){
//			System.out.println(Integer.toBinaryString(c));
//			//System.out.println(c);
//			count +=c&1;
//			System.out.println(" ----"+Integer.toBinaryString(c&1));
//		}
		
		//System.out.println("count is "+count);
//		doubleQ();
//		mask();
		junk();
		
	}
	public static void doubleQ(){


		double no = .101;
		if(no >= 1 || 	no <= 0)
			System.out.println("error");
		StringBuilder bin = new StringBuilder(".");
		while (no > 0){
			if(bin.length() > 32){
				System.out.println("Error");
				break;
			}
			double r= no*2;
			System.out.println("value of r "+r);
			if(r >=1){
				bin.append(1);
				no = r-1;
			}
			else{
				bin.append(0);
				no = r;
			}
		}
		System.out.println(bin.toString());
	
	}


	public static void mask(){
		int allones = ~0;
		int j= 6;
		int i = 3;
		int number = 32;

		System.out.println(Integer.toBinaryString(allones));

		int lef = allones <<(j+1);
		int right = (1 <<i);
		System.out.println("right :"+Integer.toBinaryString(right));
		 right = (1 <<i)-1;
		
		System.out.println("right :"+Integer.toBinaryString(right));
		int mask = lef | right;
		//System.out.println("1 :"+Integer.toBinaryString(1));
		System.out.println(Integer.toBinaryString(lef));
		System.out.println(Integer.toBinaryString(mask));
	}
	public static void junk(){
		int n = 10;
		int c = n;
		int c0 =0;
		int c1 = 0;
		
		System.out.println("value :"+Integer.toBinaryString(c));
		System.out.println("value :"+Integer.toBinaryString(c&1));
		//c>>=1;
		
		while(((c&1) ==0) && (c !=0)){
			c0++;
			c >>= 1;
			//System.out.println("value :"+Integer.toBinaryString(c));
		}
		while((c&1)== 1){
			c0++;
			c>>=1;
		}
		
		while((c&1)==1){
			c1++;
			c >>=1;
		}
		if (c0 + c1 == 31 || c0 + c1 == 0) {
			System.out.println("eror");
			return ;
		}
			int p = c0 + c1; // position of rightmost non-trailing zero
			n |= (1 << p); // Flip rightmost non-trailing zero
			n &= ~((1 << p) - 1); // Clear all bits to the right of p
			n |= (1 << (c1 - 1)) - 1; // Insert (cl-1) ones on the right.
			System.out.println("answer in binary"+Integer.toBinaryString(n));
			System.out.println("answer "+n);
	}
	public static void dectobinIT(int n){
		int k =n;
		System.out.println();
		System.out.println("----------");
		for(int i=31;i>=0;i--){
			k = n>>i;
		if((k&1) ==1)
			System.out.print("1");
		else
			System.out.print("0");
		}
	}

}
