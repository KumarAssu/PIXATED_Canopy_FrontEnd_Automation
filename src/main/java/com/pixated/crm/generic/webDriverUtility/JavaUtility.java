package com.pixated.crm.generic.webDriverUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
   public int getRandomNumber() {
	   Random r=new Random();
	   int randomNumber=r.nextInt(4000);
	   return randomNumber;
	   }
   public String getSystemDateYYYYDDMM() {
	   Calendar cal=Calendar.getInstance();
	   Date d=cal.getTime();
	   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	   String todayDate=sdf.format(d);
	   return todayDate;
	   /*Another Way*/
	   /* 
	   Date dateObj=new Date();
	   SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	   String date =sdf.format(dateObj);
	   return date;
	   */
   }
   public String getSystemDateYYYYDDMM(int days) {
	   Calendar calendar = Calendar.getInstance();
       calendar.add(Calendar.DAY_OF_YEAR, days);
       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
       String futureDate = sdf.format(calendar.getTime());
	   return futureDate;
   }
}
