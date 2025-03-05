package activities;

public class Activity1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car carobj1 = new Car("Red","Manual",2020);
		Car carobj2 = new Car("White","Automatic",2022);
		
	carobj1.displayCharacteristics();
	carobj1.accelerate();
	carobj1.brake();

	}

}
