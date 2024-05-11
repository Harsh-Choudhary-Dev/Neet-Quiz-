

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import java.time.format.DateTimeFormatter;
//import java.time.LocalDateTime;   
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import databases_operations.Ques_ans_setter_getter;
import databases_operations.Table_oprations;

@WebServlet("/servlet_2")
public class servlet_2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Ques_ans_setter_getter qasg=new Ques_ans_setter_getter();
	int ques_id_no=1;
	int correct_ans = 0;
	int total_questions;
	int wrong_ans = 0;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		
		System.out.println("hello from servlet two");
//		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("M_dd_YYYY");  
//		   LocalDateTime now = LocalDateTime.now();
	HttpSession session = request.getSession();
	String user_id = (String)session.getAttribute("user_info");
	System.out.println(user_id);
//		String email = "harshchoudhary@gmail.com";
//	Ques_ans_setter_getter qasg = (Ques_ans_setter_getter)session.getAttribute("user_data");
//		qasg.setEmail(email);
	String question_id = null;
		qasg.setQues_id_no(ques_id_no);
		Table_oprations to = new Table_oprations(qasg);
//			 String table_name_wrongDB = user_id;
			 System.out.println(user_id);
			
			try {
				 question_id = to.get_question_ids(user_id+"_question_table","user_profile");
				  total_questions = to.count_total_questions(user_id+"_question_table", "user_profile", "ques_id");
				 System.out.println(question_id);
				qasg = to.get_questions(question_id);
				to.create_table(user_id, "wrong_user_answeres");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String[] option =  qasg.getOptions();
			request.setAttribute("question", qasg.getQuestion());
			request.setAttribute("opt1",option[0]);
			request.setAttribute("opt2",option[1]);
			request.setAttribute("opt3",option[2]);
			request.setAttribute("opt4",option[3]);
//			session.setAttribute("question", qasg.getQues_id_no());
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("quiz.jsp");
		
	        requestDispatcher.forward(request, response);
	        
	        String selected_option = request.getParameter("flexRadioDefault");
			System.out.println("selected_option "+selected_option);
			if(selected_option != null) {
				if (ques_id_no != 2) {
					ques_id_no++;
				}else {
					session.setAttribute("wrong",wrong_ans);
					session.setAttribute("correct",correct_ans);
//					session.setAttribute("question", qasg.getQues_id_no());
					response.sendRedirect("result.jsp");
			        
				}
				
				if(!selected_option.equals(qasg.getAns())) {
					try {
						to.set_question_ids(user_id, question_id, "wrong_user_answeres");
						wrong_ans++;
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}else {
				correct_ans++;
			}
		}
	}
}


