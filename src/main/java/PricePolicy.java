
public class PricePolicy {
	private int fixedPrice= 3000;
	private int variablePrice=500; //per 30minutes
	public int getFixedPrice() {
		return this.fixedPrice;
	}
	public int getvariablePrice() {
		return this.variablePrice;
	}
	public void setFixedPrice(int price) {
		if(price>0)
		this.fixedPrice = price;
	}
	public void setVariablePrice(int price) {
		if(price>0)
			this.variablePrice=price;
	}
	
	class ticket{
		private int onedayTicket = 10000;
		private int oneMonthTicket = 100000;
		private int twoMonthsTicket = 180000;
		private int sixMonthsTicket = 500000;
		private int oneYearTicket = 800000;
		
		public int getTicketPrice(String ticketName) {
			switch (ticketName) {
			case "onedayTicket":
				return this.onedayTicket;
			case "oneMonthTicket":
				return this.oneMonthTicket;
			case "twoMonthTicket":
				return this.twoMonthsTicket;
			case "sixMothsTicket" :
				return this.sixMonthsTicket;
			case "oneYearTicket" :
				return this.oneYearTicket;
			default :
					return -1;
			}
		}//게터 끝
		public void setTicketPrice(String ticketName,int price) {
			switch (ticketName) {
			case "onedayTicket":
				this.onedayTicket=price;
			case "oneMonthTicket":
				this.oneMonthTicket=price;
			case "twoMonthTicket":
				this.twoMonthsTicket=price;
			case "sixMothsTicket" :
				this.sixMonthsTicket=price;
			case "oneYearTicket" :
				this.oneYearTicket=price;
			default :
				System.out.println("error");
			}
		}//세터 끝
	}// ticket 클래스 끝
	
	class coupon{
		int discountAmount;
		String wayTodiscount;
		coupon(int discountAmount, String wayTodiscount){
			this.discountAmount=discountAmount;
			this.wayTodiscount=wayTodiscount;
		}
		public int applyCoupon(int price) {
			if(this.wayTodiscount.equals("absolute")) {
				return this.discountAmount;
			}else {
				return price*discountAmount; 
			}
		}//쿠폰 적요 메서드 끝
	}
	
}
