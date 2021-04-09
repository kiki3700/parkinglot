import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;



public class Time {
	int diff;
	LocalDateTime time;
	public final static DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	
	public static LocalDate stringToDate(String str) {
		return LocalDate.parse(str);
	}
	
	public static LocalDateTime dateTodateTime(LocalDate date) {
		
		return LocalDateTime.of(date,LocalTime.of(0,0));
	}
	
	
	
	public String toString() {
		return time.getDayOfYear()+"-"+time.getMonth()+"-"+time.getDayOfMonth()+" "+time.getHour()+":"
	+time.getMinute()+":"+time.getSecond();
	}
	
	

}

