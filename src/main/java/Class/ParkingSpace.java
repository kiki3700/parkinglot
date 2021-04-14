package Class;

public class ParkingSpace {
	private int availableSpace;
	
	public static ParkingSpace big = new ParkingSpace(30);
	public static ParkingSpace small = new ParkingSpace(30);
	
	
	ParkingSpace(int availableSpace){
		this.availableSpace=availableSpace;
	}
	public int getAvailableSpace() {
		return availableSpace;
	}
	public void setAvailableSpace(int number) {
		this.availableSpace+=number;
		if(this.availableSpace<=0) {
			this.availableSpace=0;
		}
	}
}
