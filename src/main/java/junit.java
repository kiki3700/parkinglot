import static org.junit.Assert.*;


import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Map;

import org.junit.Test;

import Class.Coupon;
import Class.Database;
import Class.InAndOut;
import Class.Payment;
import Class.Time;
import Class.Utils;
import Class.Coupon;
public class junit {

	@Test
	public void test() throws SQLException {
//		assertEquals(Database.updateExitcar("2021-12-02 01:00:00","6655"),1);
//		assertEquals("2020-12-12 00:00:00",Time.addTimeFormmat("2020-12-12"));
//		System.out.println(Database.selectEnterTime("3700"));
//		System.out.println(Payment.calculateDiscountAmount(1000, null));
//		InAndOut.enter("9879","small");
//		InAndOut.enter("1234","small");
//		InAndOut.enter("4567","small");
//		assertEquals(InAndOut.enter("1234","small"),-1);

		System.out.println(Payment.calculateChange(2600,0));



}
}
