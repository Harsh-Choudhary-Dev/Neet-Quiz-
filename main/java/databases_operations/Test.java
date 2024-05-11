package databases_operations;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Test {
	
	
	  public static void main(String[] args) {    
//		  regex_exp() ;
		  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		  LocalDateTime now = LocalDateTime.now();
		  System.out.println(dtf.format(now));
	  }
		
	
	public static void regex_exp() {
		int w_ch=2;
		int c_ch=29-w_ch;
		int w_ch_ques=25;
		int c_ch_ques=45-w_ch_ques;
		double w_ques= Math.ceil((double)w_ch_ques/w_ch);
		double c_ques= Math.ceil((double)c_ch_ques/c_ch);
		double total_ques=(w_ques*w_ch)+(c_ch*c_ques);
		
		System.out.println(total_ques);
		System.out.println(w_ques);
		System.out.println(c_ques);
	
	  }
	
	 

//	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		regex_exp();
//	}

}
