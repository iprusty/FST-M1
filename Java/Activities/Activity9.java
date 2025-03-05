package activities;

import java.util.ArrayList;
import java.util.List;

public class Activity9 {

	public static void main(String[] args) {
	List<String> myList = new ArrayList<>();
	myList.add("apple");
	myList.add("orange");
	myList.add("banana");
	myList.add(1,"mango");
	myList.add(3, "pineapple");
	
System.out.println(myList);
for(String name :myList) {
	System.out.println(name);
}
System.out.println("Third element:" + myList.get(2));
System.out.println("is pineapple in the list " + myList.contains("pineapple"));
	myList.remove(1);
	myList.remove("mango");
	
	System.out.println("No of elements are: " + myList.size());
	System.out.println();

	}

}

