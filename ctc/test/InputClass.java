package test;

import java.util.Scanner;

public class InputClass {
	public static void main(String [] args){
		String s =null;
		Scanner sc = new Scanner(System.in);
		System.out.println("input :::");
		while(sc.hasNext()){
			System.out.println("-->");
			s= sc.next();
			if(s.contains("break"))
				break;
			System.out.println("sdsdsdfsdf " + s);
		}
	}

}
