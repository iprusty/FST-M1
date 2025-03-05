package activities;

import java.util.HashMap;

public class Activity11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap <Integer,String>hm = new HashMap<Integer, String> ();
		hm.put(1, "red");
		hm.put(2, "black");
		hm.put(3, "pink");
		hm.put(4, "green");
		hm.put(5, "white");
		
		System.out.println("The orginal map :" + hm);
		 hm.remove(3);
		 
		 System.out.println("after removing pink color:" + hm);
		 
		 if(hm.containsValue("green")) {
			 System.out.println("green exists in the map");
		 }else {
			 System.out.println("green doesnot exist in the map");
		 }
		 System.out.println("number of colors in the map: " +hm.size());
		 

	}

}
