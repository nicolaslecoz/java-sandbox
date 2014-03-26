package date;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class JdkDateTest {
	
	private void printDate(Date d) {
		System.out.println(d.toString() + " in ms from 1970 = " + d.getTime());
	}
	
	@Test
	public void test01() {
		Date currentD = new Date();
		
		printDate(currentD);

		printDate(new Date(currentD.getTime() + TimeUnit.DAYS.toMillis(5)));
		
		printDate(new Date(currentD.getTime() + TimeUnit.DAYS.toMillis(20)));
		
		printDate(new Date(currentD.getTime() + TimeUnit.DAYS.toMillis(27)));
		
		printDate(new Date(currentD.getTime() - TimeUnit.DAYS.toMillis(365 * 30)));
		
		printDate(new Date(1295435354000L));
		
		printDate(new Date(currentD.getTime() + TimeUnit.DAYS.toMillis(365 + 20)));
	}
}
