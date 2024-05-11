

import databases_operations.Ques_ans_setter_getter;
import databases_operations.Table_oprations;
import org.json.JSONObject;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/test_servlet_3")
public class test_servlet_3 extends HttpServlet {
	Set<String> chapter_names = new HashSet<String>();
	Ques_ans_setter_getter qasg = new Ques_ans_setter_getter();
	Table_oprations to = new Table_oprations(qasg);

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String status = request.getParameter("status");
		System.out.println(status);
		if (status.equals("chart_question_composition")) {
			System.out.println("chart_question_composition");
			String user_id1 = "f6b889b2ac5f";
			JSONObject json = new JSONObject();
			try {
				int question_count = to.count_total_questions(user_id1 + "_question_table", "user_profile", "ques_id");
//				System.out.println(question_count);
				int counter;
				int sum=0;
				String question_id = null;

				for (int i = 1; i <= question_count; i++) {
					counter = 0;
					String chapter_name ="ch_"+ to.get_question_ids(user_id1 + "_question_table", "user_profile", i).split("_")[1]+"\\_";
					chapter_names.add(chapter_name);
				}
				System.out.println(chapter_names);
				for (String item : chapter_names){
					System.out.println(item);
					int count = to.counter(item,user_id1 + "_question_table");
					System.out.println(count);
					sum+=count;
				}
				System.out.println(sum);
			} catch (SQLException | ClassNotFoundException e) {
				throw new RuntimeException(e);
			}
		}
	}
}