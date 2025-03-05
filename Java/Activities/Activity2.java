package activities;

public class Activity2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Activity2 actobj = new Activity2();
		int[] inputarr = {10,77,10,54,-11,10};
		int searchNum = 10;
		int finalSum = 30;
		
		System.out.println("Does the sum equal to 30: "+actobj.result(inputarr, searchNum, finalSum));

	}
	
	public boolean result(int[] nums,int searchNum, int fixedSum) { 
		int tempSum = 0;
		
		for(int num:nums) {
			if(num ==searchNum) {
				tempSum += searchNum;
			}
			if(tempSum > fixedSum) {
				break;
			}
		}
		return tempSum == fixedSum;
	}

}
