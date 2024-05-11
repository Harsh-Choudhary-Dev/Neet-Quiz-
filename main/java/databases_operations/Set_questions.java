package databases_operations;

import java.sql.SQLException;
import java.util.ArrayList;

public class Set_questions {
	
	Table_oprations to= new Table_oprations();
	ArrayList<String> d_options;

	Ques_ans_setter_getter qasg;
	public Set_questions(Ques_ans_setter_getter qasg) {
		
		this.qasg = qasg;
	}

	
	ArrayList<Integer> ques_no=new ArrayList<Integer>();
	static String [] all_chapters_ids={"ch_1", "ch_10", "ch_11", "ch_12", "ch_13", "ch_14", "ch_15", "ch_16", "ch_17", "ch_18","ch_19", "ch_2", "ch_20", "ch_21", "ch_22", "ch_23", "ch_24", "ch_25", "ch_26", "ch_27","ch_29", "ch_3", "ch_30", "ch_31", "ch_32", "ch_4", "ch_5", "ch_7", "ch_9"};

	public  int[] calc_questions(String session_id) throws ClassNotFoundException, SQLException {
//		String session_id="d8379fecaedf95b1e87e55a3f79471af";
		int[] ques_values =new int[3];
		
		int w_ch=d_options.size();
		int c_ch=29-w_ch;
		int w_ch_ques=30;
		int c_ch_ques=50-w_ch_ques;
		double w_ques= Math.ceil((double)w_ch_ques/w_ch);
		double c_ques= Math.ceil((double)c_ch_ques/c_ch);
		double total_ques=(w_ques*w_ch)+(c_ch*c_ques);
		ques_values[0]=(int) total_ques;
		ques_values[1]=(int) w_ques;
		ques_values[2]=(int) c_ques;

		System.out.println(ques_values[0]);
		return ques_values;
	
	}
	
	   boolean check(String toCheckValue)
	    {
		  System.out.println(d_options);
	        boolean test = false;
	        for (String element : d_options) {
	        	System.out.println(element+"\t\t\t"+toCheckValue);
	            if (element.equals(toCheckValue.toUpperCase())) {
	                test = true;
	                System.out.println(test);
	                break;
	            }
	        }
	        return test;
	    }
		public  int  get_random_number(int min,int max) {
			int range = max - min + 1;
			int rand = (int)(Math.random() * range) + min;
			while (ques_no.contains(rand)){
				 rand = (int)(Math.random() * range) + min;	
			}
			ques_no.add(rand);
			return rand;
		}

	public  void create_custom_test_paper() throws ClassNotFoundException, SQLException {
		String user_ids = qasg.getUserId()+"_question_table";
		int ques_values[]=new int[3];
		d_options = qasg.getChapter_ids();
		String db_name="neet_mcq_questions";
		ques_values=calc_questions(user_ids);
//		System.out.println(ques_values[0]+"\t\t"+ques_values[1]+"\t\t"+ques_values[2]);
		for (String element : all_chapters_ids) {
			int max=to.count_total_questions(element,db_name,"question");
			if(check(element)) {
				ques_no.clear();
				for (int j=1;j<=ques_values[1];j++) {
					int rand = get_random_number(1,max);
					String question_id = element+"_"+rand;
					System.out.println(j+"\t"+question_id);
					to.set_question_ids(user_ids,question_id,"user_profile");
					System.out.println("done from the if part");
				}
				
			}
			else {
				ques_no.clear();
				for (int n=1;n<=ques_values[2];n++) {
					int rand = get_random_number(1,max);
					String question_id = element+"_"+rand;
//					System.out.println(n+"\t"+question_id);
					to.set_question_ids(user_ids,question_id,"user_profile");
					System.out.println("done from else part ");
			}
				
			
			}
			System.out.println("all done sir ");
		}
//		String table_name=String.format("%s_question_table", user_ids);
		System.out.println(user_ids);
//		System.out.println(to.count_total_questions(user_ids,"user_profile"));
	}

	
	public void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		create_custom_test_paper();
	}

}
