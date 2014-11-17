
public class TestString {
	public static void main(String [] args){
		String s = "hello";
		String s2 = "hello";
		String s3 = "hello".intern();
		System.out.println("s and s3"+(s == s3));
		System.out.println("s and s2"+(s2 == s));
	}

}
