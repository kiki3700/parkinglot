package Class;

public class Admin {
	private static int change5000Balance = 40000;
	private final int min5000amount = 2000;
	private static int change1000Balance = 500000;
	private final int min1000amount = 3000;
	private static int change500Balance = 60000;
	private final int min500amount = 6000;
	private static int change100Balance = 80000;
	private final int min100amount = 6000;
	
	public static boolean checkChange() {
		if(change5000Balance<change5000Balance)
			refillChange(5000,1000);
		if(change1000Balance<change1000Balance)
			refillChange(1000,3000);
		if(change500Balance<change500Balance)
			refillChange(500,8000);
		if(change100Balance<change100Balance)
			refillChange(100,9000);
		return true;
		
	}
	
	public static void refillChange(int quote, int amount) {
		switch(quote) {
		case 5000 : setChange5000Balance(amount);
		break;
		case 1000 : setChange1000Balance(amount);
		break;
		case 500 : setChange500Balance(amount);
		break;
		case 100 : setChange100Balance(amount);
		break;
		}
	}
	
	
	public static int getChange5000Balance() {		
		return change5000Balance;
		
	}
	public static int setChange5000Balance(long change5000) {
		change5000Balance += change5000;
		return 1;
	}
	public static int getChange1000Balance() {
		return change1000Balance;
	}
	public static void setChange1000Balance(long change1000) {
		change1000Balance += change1000;
	}
	public static int getChange500Balance() {
		return change500Balance;
	}
	public static void setChange500Balance(long change500) {
		change500Balance += change500;
	}
	public static int getChange100Balance() {
		return change100Balance;
	}
	public static void setChange100Balance(long change100) {
		change100Balance += change100;
	}
	
	private static boolean posWork=true;
	private static boolean controller=true;
	
	public static void changePosWork() {
		posWork = !posWork;
	}
	
	public void changeController() {
		controller = !controller;
	}
	
	public static boolean checkPos() {
		if(posWork)
			return true;
		return false;
	}

	public static String callAdmin() {
		String log = null;
		if(posWork==false)
			log = "error in pos!!";
		if(controller==false)
			log ="error in controller!!";
		return log;
	}
}
