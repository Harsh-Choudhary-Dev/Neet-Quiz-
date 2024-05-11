package databases_operations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.UUID;

public class Table_oprations {
	
	Ques_ans_setter_getter qasg;
	public Table_oprations(Ques_ans_setter_getter qasg) {
		
		this.qasg = qasg;
	}

	public Table_oprations() {
		// TODO Auto-generated constructor stub
	}
	
	public int counter(String name,String table_name) throws SQLException, ClassNotFoundException {
		Connection con = Database_connections.connectDB("user_profile");
		String sql_query=String.format("SELECT COUNT(*) FROM %s WHERE ques_id LIKE '%%%s%%'"
				,table_name,name);
//		System.out.println(sql_query);
		PreparedStatement p = con.prepareStatement(sql_query);
		ResultSet rs=p.executeQuery();
		if (rs.next()) {
			return rs.getInt(1);
//			 System.out.println(count);
		}

        return 0;
    }

	public  int count_total_questions(String user_ids,String db_name,String row_name) throws ClassNotFoundException, SQLException {
		Connection con = Database_connections.connectDB(db_name);
		int count=0;
//		System.out.println("total questions loaded    "+user_ids);
		String sql_query=String.format("SELECT COUNT(%s) FROM %s",row_name, user_ids);
		PreparedStatement p = con.prepareStatement(sql_query);
		ResultSet rs=p.executeQuery();
//		System.out.println(sql_query);
		if (rs.next()) {
			 count = rs.getInt(1);
//			 System.out.println(count);
		}
		return count;
	}
	
	public void set_question_ids(String user_id,String ques_id,String db_name) throws SQLException, ClassNotFoundException {
//		System.out.println("user_id\t"+user_id);
		String sql_query=String.format("INSERT INTO %s(ques_id) VALUES(?)", user_id);
//		System.out.println(sql_query);
		Connection con = Database_connections.connectDB(db_name);
		PreparedStatement p = con.prepareStatement(sql_query);
		p.setString(1, ques_id);
		p.executeUpdate();
	}
	
	public void create_table(String session_id,String db_name) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		 session_id=session_id+"_question_table";
		 
		Connection con = Database_connections.connectDB(db_name);
		String sql_query=String.format("CREATE TABLE  IF NOT EXISTS %s (ques_no int  PRIMARY KEY AUTO_INCREMENT, ques_id varchar(25)); ", session_id);
		System.out.println(sql_query);
		PreparedStatement p = con.prepareStatement(sql_query);
		 p.executeUpdate();
//		System.out.println("table created");
		
	}
	
	public   String generate_userIds() {
		// TODO Auto-generated method stub
		String uniqueID = UUID.randomUUID().toString().replace("-","").substring(20);
//		System.out.println(uniqueID);
		return uniqueID;
	}
	
	
	public Ques_ans_setter_getter chapter_ids() throws ClassNotFoundException, SQLException {
		ArrayList<String> chapter_ids = new ArrayList<String>();
		 Connection con = Database_connections.connectDB("neet");
		 
		ArrayList<String> chapter_name = qasg.getChapter_name();
		 for (String name : chapter_name ) {
			 String sql_query=" select ch_id from chapter_id where ch_name=(?);";
				PreparedStatement p = con.prepareStatement(sql_query);
				p.setString(1, name);
				ResultSet rs = p.executeQuery();
				if(rs.next()) {

					chapter_ids.add(rs.getString("ch_id"));
//					System.out.println(chapter_ids);
				}
		 }
		 qasg.setChapter_ids(chapter_ids);
		 
		return qasg;
	
	}
	public void set_users_details() throws SQLException, ClassNotFoundException {
		
		String sql_query=("INSERT INTO login_details(FirstName,LastName, email,user_id) VALUES(?,?,?,?)");
		Connection con = Database_connections.connectDB("user_profile");
		PreparedStatement p = con.prepareStatement(sql_query);
		p.setString(1, qasg.getFname());
		p.setString(2, qasg.getLname());
		p.setString(3, qasg.getEmail());
		p.setString(4, qasg.getUserId());
		p.executeUpdate();
	}

	
	public  String get_user_id() throws ClassNotFoundException, SQLException {
		String sql_query=("select user_id from login_details where email=?");
		String user_id = null;
		Connection con = Database_connections.connectDB("user_profile");
		PreparedStatement p = con.prepareStatement(sql_query);
		p.setString(1, qasg.getEmail());
		ResultSet rs = p.executeQuery();
		if(rs.next()) {
			 user_id = rs.getString("user_id");
//			System.out.println(user_id);
					
		}
//		System.out.println("user_id"+user_id);
		return user_id;
		
	}

	public String get_user_name(String user_id) throws ClassNotFoundException, SQLException {
        String sql_query = ("select FirstName,LastName from login_details where user_id=?");

        Connection con = Database_connections.connectDB("user_profile");
        PreparedStatement p = con.prepareStatement(sql_query);
        p.setString(1, user_id);
        ResultSet rs = p.executeQuery();
        String user_fname = null;
        if (rs.next()) {
            user_fname = rs.getString("FirstName");

            return user_fname;
        }


        return user_fname;
    }
	
	public String get_question_ids(String table_name, String db_name) throws ClassNotFoundException, SQLException {
		String ques_id=null;
		int ques_id_no=qasg.getQues_id_no();
//		String table_name = get_user_id()+"_question_table";
		String sql_query=("select ques_id from "+ table_name+" where ques_no=?");
		Connection con = Database_connections.connectDB(db_name);
		PreparedStatement p = con.prepareStatement(sql_query);
		p.setInt(1,ques_id_no);
		ResultSet rs = p.executeQuery();
		if(rs.next()) {
			 ques_id = rs.getString("ques_id");
//			System.out.println(ques_id);
					
		}
//		System.out.println("ques_id"+ques_id);
		return ques_id;
	
	}	
	public String get_question_ids(String table_name, String db_name,int ques_id_no) throws ClassNotFoundException, SQLException {
		String ques_id=null;

//		String table_name = get_user_id()+"_question_table";
		String sql_query=("select ques_id from "+ table_name+" where ques_no=?");
		Connection con = Database_connections.connectDB(db_name);
		PreparedStatement p = con.prepareStatement(sql_query);
		p.setInt(1,ques_id_no);
		ResultSet rs = p.executeQuery();
		if(rs.next()) {
			 ques_id = rs.getString("ques_id");
//			System.out.println(ques_id);

		}
//		System.out.println("ques_id"+ques_id);
		return ques_id;

	}
	
	
	public Ques_ans_setter_getter get_questions(String ques_id) throws SQLException, ClassNotFoundException {
		String[] options;
		options = new String[4];
		String ques_no = ques_id.split("_")[2];
		String ch_name = "ch_"+ques_id.split("_")[1];
//		String table_name = qasg.getUserId()+"_question_table";
		String sql_query=String.format("select * from %s where id=?;",ch_name);  
		Connection con = Database_connections.connectDB("neet_mcq_questions");
		PreparedStatement p = con.prepareStatement(sql_query);
		p.setString(1,ques_no);
		ResultSet rs = p.executeQuery();
		if(rs.next()) {
			String question = rs.getString("question");
			 options[0] = rs.getString("option1");
			 options[1] = rs.getString("option2");
			 options[2]= rs.getString("option3");
			 options[3]= rs.getString("option4");
			String answere= rs.getString("answere");
//			System.out.print(question);
//			System.out.print(answere);
			qasg.setQuestion(question);
//			for(String opt: options) {
//				System.out.println(opt);
//			}
			
			qasg.setAns(answere);	
			qasg.setOptions(options);
			return qasg;
		}
		return null;
	}

	public Ques_ans_setter_getter get_questions(String ch_name,String ques_id) throws SQLException, ClassNotFoundException {
		String[] options;
		options = new String[4];
		String sql_query=String.format("select * from %s where id=?;",ch_name);  
		Connection con = Database_connections.connectDB("neet_mcq_questions");
        PreparedStatement p = con.prepareStatement(sql_query);
		p.setString(1,ques_id);
		ResultSet rs = p.executeQuery();
		if(rs.next()) {
			String question = rs.getString("question");
			 options[0] = rs.getString("option1");
			 options[1] = rs.getString("option2");
			 options[2]= rs.getString("option3");
			 options[3]= rs.getString("option4");
			String answere= rs.getString("answere");
//		System.out.print(question);
//			System.out.print(answere);
			qasg.setQuestion(question);
//			for(String opt: options) {
//				System.out.println(opt);
//			}
			
			qasg.setAns(answere);	
			qasg.setOptions(options);
			
		}
		return qasg;
	}
	
	public void store_history() throws ClassNotFoundException, SQLException {
		String sql_query = "INSERT INTO wrong_ans_history (user_id, datetime, total_questions,correct_answere,wrong_ans) VALUES (?,?,?,?,?);";
		Connection con = Database_connections.connectDB("wrong_user_answeres");
        assert con != null;
        PreparedStatement p = con.prepareStatement(sql_query);
		p.setString(1, qasg.getUserId());
		p.setString(2, qasg.getDatetime());
		p.setInt(3, qasg.getTotal_questions());
		p.setInt(4, qasg.getCorrect_answere());
		p.setInt(5, qasg.getWrong_ans());
		p.executeUpdate();
//		System.out.println("data loaded successfully");
	}

	public String get_time(){
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
//		System.out.println(dtf.format(now));
		return dtf.format(now);
	}

//	public static void main(String[]args) {
//		String ch = " ch_7_30";
//		System.out.println(ch.split("_")[2]);
//	}
}
