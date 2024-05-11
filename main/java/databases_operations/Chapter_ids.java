package databases_operations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Chapter_ids {

	Ques_ans_setter_getter qasg;
	Connection con = null;
	PreparedStatement p = null;
	ResultSet rs = null;
	public Chapter_ids(Ques_ans_setter_getter qasg) {
		
		this.qasg = qasg;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public Ques_ans_setter_getter chapter_ids() throws ClassNotFoundException, SQLException {
		ArrayList<String> chapter_ids = new ArrayList<String>();
		 con = Database_connections.connectDB("neet");
		 ArrayList<String> chapter_name = qasg.getChapter_name();
		 for (String name : chapter_name ) {
			 String sql_query=" select ch_id from chapter_id where ch_name=(?);";
				p = con.prepareStatement(sql_query);
				p.setString(1, name);
				rs = p.executeQuery();
				if(rs.next()) {

					chapter_ids.add(rs.getString("ch_id"));
					System.out.println(chapter_ids);					
				}
		 }
		 qasg.setChapter_ids(chapter_ids);
		 return qasg;
		
	}

}
