package Class;
import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;


public class Payment {
	String settlementTool;
	int finalPrice;
	int discountAmount;
	int price;
	PricePolicy pricePolicy;
	public static Coupon absolute = new Coupon(10000, "absolute");
	public static Coupon relative = new Coupon(0.1f,"relative");
	
	
	public static int calculatePrice(String carNum) throws SQLException {
		String queryString = Database.selectQuery("car_informations", carNum);
		HashMap<String, String> queryMap = Utils.parseData(queryString);
		LocalDateTime endOfTicket = null;
		LocalDateTime beginOfTicket = null;
		if(!queryMap.get("end_of_ticket").equals("null"))
			endOfTicket=LocalDateTime.parse(queryMap.get("end_of_ticket"),Time.formatter);
			LocalDateTime exitTime =LocalDateTime.now();
		if(!queryMap.get("begin_of_ticket").equals("null"))
			beginOfTicket = LocalDateTime.parse(queryMap.get("begin_of_ticket"),Time.formatter);
		LocalDateTime enterTime =LocalDateTime.parse(Database.selectEnterTime(carNum),Time.formatter);
		Duration duration =Duration.between(enterTime, exitTime);
		//ticket 유효성 확인
		if(endOfTicket != null && beginOfTicket != null) {
			if(endOfTicket.compareTo(exitTime)>=0
					&&beginOfTicket.compareTo(enterTime)<=0){
				System.out.println("조건문"+1);
				return 0;		
			}
			if(endOfTicket.compareTo(exitTime)<0
					&&beginOfTicket.compareTo(enterTime)<0
					&&endOfTicket.compareTo(enterTime)>0
					) {
				duration = Duration.between(endOfTicket,exitTime);
				System.out.println("조건문"+2);
			}
			if(endOfTicket.compareTo(exitTime)>=0
					&&beginOfTicket.compareTo(enterTime)>=0
					&&beginOfTicket.compareTo(exitTime)<0) {
				duration = Duration.between(enterTime, beginOfTicket);
				System.out.println("조건문"+3);
			}
			if(endOfTicket.compareTo(exitTime)<0
					&&beginOfTicket.compareTo(enterTime)>0){
				System.out.println("조건문"+4);
				duration = Duration.between(enterTime, beginOfTicket).plus(Duration.between(endOfTicket,exitTime));
			}
		}
		int minutes=(int) duration.toMinutes();
		
		//변동비 고정비 계산
		int timeExcess=minutes-PricePolicy.getbaseTime();
		if(timeExcess<=0)
			timeExcess=0;
		System.out.println("시간 초과분:"+timeExcess);
		int pricingUnit = timeExcess%PricePolicy.getperMinutes()==0?
				timeExcess/PricePolicy.getperMinutes() : timeExcess/PricePolicy.getperMinutes()+1;

		System.out.println("프라이싱단위:"+pricingUnit);
		return pricingUnit*PricePolicy.getvariablePrice()
				+PricePolicy.getFixedPrice();
	}
	
	//orvervide
	public static int calculatePrice(String carNum, String exitTim) throws SQLException {
		System.out.println("프라이싱 시장");
		String queryString = Database.selectQuery("car_informations", carNum);
		HashMap<String, String> queryMap = Utils.parseData(queryString);
		
		LocalDateTime endOfTicket = null;
		LocalDateTime beginOfTicket = null;
		if(!queryMap.get("end_of_ticket").equals("null"))
			endOfTicket=LocalDateTime.parse(queryMap.get("end_of_ticket"),Time.formatter);
		LocalDateTime exitTime =LocalDateTime.parse(exitTim,Time.formatter);
		if(!queryMap.get("begin_of_ticket").equals("null"))
			beginOfTicket = LocalDateTime.parse(queryMap.get("begin_of_ticket"),Time.formatter);
		LocalDateTime enterTime =LocalDateTime.parse(Database.selectEnterTime(carNum),Time.formatter);
		Duration duration =Duration.between(enterTime, exitTime);
		//ticket 유효성 확인
		if(endOfTicket != null && beginOfTicket != null) {
			if(endOfTicket.compareTo(exitTime)>=0
					&&beginOfTicket.compareTo(enterTime)<=0){
				System.out.println("조건문"+1);
				return 0;		
			}
			if(endOfTicket.compareTo(exitTime)<0
					&&beginOfTicket.compareTo(enterTime)<0
					&&endOfTicket.compareTo(enterTime)>0
					) {
				duration = Duration.between(endOfTicket,exitTime);
				System.out.println("조건문"+2);
			}
			if(endOfTicket.compareTo(exitTime)>=0
					&&beginOfTicket.compareTo(enterTime)>=0
					&&beginOfTicket.compareTo(exitTime)<0) {
				duration = Duration.between(enterTime, beginOfTicket);
				System.out.println("조건문"+3);
			}
			if(endOfTicket.compareTo(exitTime)<0
					&&beginOfTicket.compareTo(enterTime)>0){
				System.out.println("조건문"+4);
				duration = Duration.between(enterTime, beginOfTicket).plus(Duration.between(endOfTicket,exitTime));
			}
		}
		int minutes=(int) duration.toMinutes();
		
		//변동비 고정비 계산
		int timeExcess=minutes-PricePolicy.getbaseTime();
		if(timeExcess<=0)
			timeExcess=0;
		System.out.println("시간 초과분:"+timeExcess);
		int pricingUnit = timeExcess%PricePolicy.getperMinutes()==0?
				timeExcess/PricePolicy.getperMinutes() : timeExcess/PricePolicy.getperMinutes()+1;

		System.out.println("프라이싱단위:"+pricingUnit);
		return pricingUnit*PricePolicy.getvariablePrice()
				+PricePolicy.getFixedPrice();
		
		}
	

	public static int calculateDiscountAmount(int price, Coupon coupon) {
		if(coupon==null) 
			return 0;
		
		return coupon.applyCoupon(price)<0? 0 : coupon.applyCoupon(price);
	}
	
	public static int calculateFinalPrice(int price, int discountAmount) {
		if(price-discountAmount<0)
			return 0;
		return price-discountAmount;		
	}
	
	//계산해버리기 카드 계산
	public static int settlement(String carNum, int price, Coupon coupon) {
		System.out.println("결제시작");
		int discountAmount = calculateDiscountAmount(price, coupon);
		int finalPrice = calculateFinalPrice(price,discountAmount);
		if(Admin.checkPos()){
			System.out.println("카드결제 "+finalPrice+"아 완료 됬습니다.");
		Database.insertPaymentlog(price, 0, price, "card", carNum);
	return 1;}else {
		return -1;
	}
	}
	//현금 계산
	public static int settlement(String carNum, int price,Coupon coupon,  int cash) {
		System.out.println("결제시작");
		int discountAmount = calculateDiscountAmount(price, coupon);
		int finalPrice = calculateFinalPrice(price,discountAmount);
		if(Admin.checkChange()){
		
			int result = calculateChange(cash, finalPrice);
			if(result==-1) {
				return -1;
			}
			System.out.println("현금결제가 완료 됬습니다.");
		Database.insertPaymentlog(price, 0, price, "cash", carNum);
	return 1;}else {
		return -1;
	}
	}
	
	
	//검증하는거 다시 할것
	public static int settleTicket(String carNum, int price, String sortOfTicket, 
			String beginOfTicket, String endOfTicket) {
		
			if(Admin.checkPos()){
				System.out.println("카드결제가 완료 됬습니다.");
			Database.updateTicketInfo(sortOfTicket, beginOfTicket, endOfTicket, carNum);
			Database.insertPaymentlog(price, 0, price, "card", carNum);
		return 1;}else {
			return -1;
		}
	}
	public static int settleTicket(String carNum, int price, String sortOfTicket,
			String beginOfTicket, String endOfTicket, int cash) {
		if(Admin.checkChange()) {
			
			int result = calculateChange(cash, price);
			if(result==-1) {
				return -1;
			}
			System.out.println("현금결제가 완료 됬습니다.");
		Database.updateTicketInfo(sortOfTicket, beginOfTicket, endOfTicket, carNum);
		Database.insertPaymentlog(price, 0, price, "cash", carNum);
		return 1;
		}
	return -1;
	}
	
	public static int calculateChange(int cash, int cost) {
		System.out.println("잔돈계산시작");
		int finalPrice= cash-cost;
		System.out.println(finalPrice);
		int change5000 =0;
		int change1000 =0;
		int change500 =0;
		int change100 =0;
		if(finalPrice/5000>Admin. getChange5000Balance()) {
			System.out.println(1.1);
			change5000= Admin.getChange5000Balance();
			finalPrice -=Admin.getChange5000Balance()*5000;
		}else if(finalPrice/5000>0){
			System.out.println(1.2);
			change5000 = finalPrice/5000;
			finalPrice -= change5000*5000;
		}
		System.out.println("5000:"+change5000 );
		System.out.println(finalPrice);
		if(finalPrice/1000>Admin. getChange1000Balance()) {
			System.out.println(2.1);
			change1000= Admin.getChange1000Balance();
			finalPrice -=Admin.getChange1000Balance()*1000;
		}else if(finalPrice/1000>0){
			System.out.println(2.2);
			change1000 = finalPrice/1000;
			finalPrice -= change1000*1000;
		}
		System.out.println("1000:"+change1000 );
		System.out.println(finalPrice);
		if(finalPrice/500>Admin. getChange500Balance()) {
			System.out.println(3.1);
			change500= Admin.getChange500Balance();
			finalPrice -=Admin.getChange500Balance()*500;
		}else if(finalPrice/500>0){
			System.out.println(3.2);
			change500 = finalPrice/500;
			finalPrice -= change500*500;
		}
		System.out.println("500:"+change500 );
		System.out.println(finalPrice);
		if(finalPrice/100>Admin. getChange100Balance()) {
			System.out.println(4.1);
			change100= Admin.getChange100Balance();
			finalPrice -=Admin.getChange100Balance()*100;
		}else if(finalPrice/100>0){
			System.out.println(4.2);
			change100 = finalPrice/100;
			finalPrice -= change100*100;
		}
		System.out.println("100:"+change100 );
		System.out.println(finalPrice);
		if(finalPrice<0) {
			
			return-1;
		}
		
//		
//		int change1000 = finalPrice/1000;
//		finalPrice -= change1000*1000;
//		int change500 = finalPrice/500;
//		finalPrice -= finalPrice*500;
//		int change100 = finalPrice/100;
//		finalPrice -= finalPrice*100;
//		
		Admin.setChange5000Balance(-change5000);
		Admin.setChange1000Balance(-change1000);
		Admin.setChange500Balance(-change500);
		Admin.setChange100Balance(-change100);

		return 1;
	}
}




