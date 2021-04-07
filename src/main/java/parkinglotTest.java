import static org.junit.Assert.*;
import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import org.junit.Test;


public class parkinglotTest {

	
	
//	@Test
//	public void insertNewCar() {
//		assertEquals(Database.newCarInfo("1234", "small"),1);
//	}
//	@Test
//	public void selectquery() throws SQLException {
////		assertEquals(Database.connect(),1);
//		String queryResult=Database.selectQuery("enter_logs", "1234");
//		HashMap<String,String> a=DbUtils.parseData(queryResult);
//		assertEquals(a.get("car_number"),"1234");
//	}
//}
	@Test
	public void timetest() {
		assertEquals(Database.selectEnterTime("3700"),"2021-04-07 04:21:24");
	}	
}