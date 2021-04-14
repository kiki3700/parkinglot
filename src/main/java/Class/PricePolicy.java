package Class;

public class PricePolicy {
	private static int fixedPrice= 5000;
	private static int baseTime=30;
	private static int variablePrice=500; //per 30minutes
	private static int perMinutes=30;
	public static int getFixedPrice() {
		return fixedPrice;
	}
	public static int getperMinutes() {
		return perMinutes;
	}
	public static int getbaseTime() {
		return baseTime;
	}
	public static int getvariablePrice() {
		return variablePrice;
	}
	public void setFixedPrice(int price) {
		if(price>0)
			fixedPrice = price;
	}
	public static void setperMinutes(int time) {
		perMinutes=time;
	}
	public void setVariablePrice(int price) {
		if(price>0)
			variablePrice=price;
	}
	
	
}


