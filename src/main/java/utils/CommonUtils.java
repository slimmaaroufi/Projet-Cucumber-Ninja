package utils;


import java.util.Date;

	public class CommonUtils {
		
		//Constant
		public static final int IMPLICIT_WAIT_TIME=10;
		public static final int PAGE_LOAD_TIME=15;
		public static final int EXPLICIT_WAIT_BASIC_TIME=30;
		
		public String getEmailWithTimeStam() {
		
		Date date =new Date();
		return "amotoori"+date.toString().replace(" ", "_").replace(":", "_")+"@gmail.com";
		//return "slimtest1_"+date.toString().replace(" ", "_").replace(":", "_")+"@gmail.com";
		 
	}
		

		
		
	
		
}
