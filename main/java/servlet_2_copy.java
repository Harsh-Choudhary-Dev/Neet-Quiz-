

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Objects;

import javax.servlet.ServletException;
//import java.time.format.DateTimeFormatter;
//import java.time.LocalDateTime;   
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import databases_operations.Ques_ans_setter_getter;
import databases_operations.Table_oprations;

@WebServlet("/servlet_2_copy")
public class servlet_2_copy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Ques_ans_setter_getter qasg=new Ques_ans_setter_getter();
	//int ques_id_no=1;
	int correct_ans = 0;
	int total_questions;
	int wrong_ans = 0;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
//		System.out.println("hello from servlet two");
	HttpSession session = request.getSession();
	String user_id = (String)session.getAttribute("user_info");
	String question_id = null;
	 String ques_no = (request.getParameter("ques_no"));
	 String status = (request.getParameter("status"));
		qasg.setQues_id_no(Integer.parseInt(ques_no));
		Table_oprations to = new Table_oprations(qasg);

        try {
            to.create_table(user_id,"wrong_user_answeres");
			question_id = to.get_question_ids(user_id+"_question_table","user_profile");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        if(Objects.equals(status, "check")){
            try {
                to.set_question_ids(user_id+"_question_table", question_id, "wrong_user_answeres");
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

        }
	else if(ques_no != null) {
//	 System.out.println(ques_no);

			try {
				  total_questions = to.count_total_questions(user_id+"_question_table", "user_profile", "ques_id");
//				 System.out.println(question_id);
				qasg = to.get_questions(question_id);	
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

         String[] option =  qasg.getOptions();

//			session.setAttribute("question", qasg.getQues_id_no());
			String message;
	        JSONObject json = new JSONObject();
	        json.put("question", qasg.getQuestion());
	        json.put("options", option);
	        json.put("answere",qasg.getAns() );
	        //json.put("question_number",ques_id_no );
	        message = json.toString();

	       
	        PrintWriter out = response.getWriter();
	        out.print(message);
	        out.flush();
	        //ques_id_no++;
			
		
	}
}

}
