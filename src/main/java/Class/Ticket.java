package Class;

public class Ticket {
		private static int onedayTicket = 10000;
		private static int oneMonthTicket = 100000;
		private static int twoMonthsTicket = 180000;
		private static int sixMonthsTicket = 500000;
		private static int oneYearTicket = 800000;
		
		public static int getTicketPrice(int period) {
			switch (period) {
			case 1:
				return onedayTicket;
			case 30:
				return oneMonthTicket;
			case 60:
				return twoMonthsTicket;
			case 180:
				return sixMonthsTicket;
			case 365:
				return oneYearTicket;
			default :
					return -1;
			}
		}//게터 끝
		
		public static String getTicketName(int period) {
			switch (period) {
			case 1:
				return "당일권";
			case 30:
				return "1개월권";
			case 60:
				return "2개월권";
			case 180:
				return "육개월권";
			case 365:
				return "1년권";
			default :
					return "선택하지 않음";
			}
		}
		
		public static void setTicketPrice(String ticketName,int price) {
			switch (ticketName) {
			case "onedayTicket":
				onedayTicket=price;
			case "oneMonthTicket":
				oneMonthTicket=price;
			case "twoMonthTicket":
				twoMonthsTicket=price;
			case "sixMothsTicket" :
				sixMonthsTicket=price;
			case "oneYearTicket" :
				oneYearTicket=price;
			default :
				System.out.println("error");
			}
		}//세터 끝
	}// ticket 클래스 끝

