package activities;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Activity13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		ArrayList <Integer> al = new ArrayList<Integer>();
		Random Rm = new Random();
		
		System.out.println("Enter integer please ");
		System.out.println("(EOF or non-integer to terminate): ");
		
		while(sc.hasNextInt()) {
			al.add(sc.nextInt());
			
		}
		
		Integer nums[] = al.toArray(new Integer[0]);
		int index = Rm.nextInt(nums.length);
		
		System.out.println("index value generated: " + index);
		System.out.println("value is array at generated index: " + nums[index]);

		sc.close();
	}

}
