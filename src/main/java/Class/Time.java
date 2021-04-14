package Class;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Locale;



public class Time {
	int diff;
	LocalDateTime time;
	public final static DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	public final static DateTimeFormatter formatterForDate=DateTimeFormatter.ofPattern("yyyy-MM-dd");
	public static LocalDate stringToDate(String str) {
		return LocalDate.parse(str,formatter);
	}
	public static LocalDateTime dateTodateTime(LocalDate date) {
		
		return LocalDateTime.of(date,LocalTime.of(0,0));
	}
	public static String formDateTime(String date, String time) {
		time = time+":00";
		return date+" "+time;
	}
	
	
	public static String dateTimetoString(LocalDateTime time) {
		return time.getDayOfYear()+"-"+time.getMonth()+"-"+time.getDayOfMonth()+" "+time.getHour()+":"
	+time.getMinute()+":"+time.getSecond();
	}
	
	public static String addTimeFormmat(String date) {
		return date+" 00:00:00";
	}
	public static LocalDateTime stringToDataTime(String str) {
		return LocalDateTime.parse(str, Time.formatter);		
	}
	
	public static String addPeriod(String beginOfTicket, int peri) {
		Period period = Period.ofDays(peri);
		LocalDateTime endOfTicket = stringToDate(beginOfTicket).plus(period).atStartOfDay();
		return endOfTicket.format(formatter); 
	}
}

