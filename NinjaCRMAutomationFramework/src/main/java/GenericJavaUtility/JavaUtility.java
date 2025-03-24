package GenericJavaUtility;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.apache.poi.ss.formula.functions.Days360;

public class JavaUtility {

	public int getRandomNum(int limit) {

		Random ran= new Random();
		int randomNum = ran.nextInt(limit);
		return randomNum;

	}
	
	public String  getSystemDate() {
		Date dateObj = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		String date = dateFormat.format(dateObj);
		return date;
		
	}
	
	public String getRequiredDate(int days) {
		Date dateObj = new Date();
		SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");
		String date = dFormat.format(dateObj);
			
		Calendar calendarDate = dFormat.getCalendar();
		calendarDate.add(Calendar.DAY_OF_MONTH,days);
		String requiredDate = dFormat.format(calendarDate.getTime());
		return requiredDate;
				
	}

}
