package activities;

import java.util.HashSet;

public class Activity10 {

	public static void main(String[] args) {
		HashSet<String> hs = new HashSet<String>();
		hs.add("a");
		hs.add("e");
		hs.add("i");
		hs.add("o");
		hs.add("i");
		hs.add("u");
		hs.add(null);
		
		
		System.out.println("original hashset:" + hs);
		System.out.println("size of hashset :" + hs.size());
		System.out.println("removing i from hashset :" + hs.remove("i"));
		if(hs.remove("x")) {
			System.out.println("x removed from the set");
		}else {
			System.out.println("x is not present in the set");
		}
		System.out.println("checking a is present in set :" + hs.contains("a"));
		System.out.println("updated hashset :" +hs);
	}
		

}

