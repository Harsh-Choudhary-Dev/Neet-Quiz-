

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import databases_operations.Ques_ans_setter_getter;
import databases_operations.Set_questions;
import databases_operations.Table_oprations;

import javax.servlet.annotation.WebServlet;

@WebServlet("/servlet_1")
public class servlet_1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Ques_ans_setter_getter qasg=new Ques_ans_setter_getter();
	ArrayList<String> chapter = new ArrayList<String>();
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("hello from servlet one");
		String[] options = request.getParameterValues("chapter");
		for (String opt : options) {
			System.out.println(opt);
			chapter.add(opt);
		}
		
		qasg.setChapter_name(chapter);
		
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("user_info");
		System.out.println(user_id);
		qasg.setUserId(user_id);
		try {
			Table_oprations to = new Table_oprations(qasg);
			qasg = to.chapter_ids();	
			to.create_table(user_id,"user_profile");
			Set_questions sq = new Set_questions(qasg);
			sq.create_custom_test_paper();
			session.setAttribute("user_info", user_id);
			System.out.println("custom question paper created successfully");
			request.getRequestDispatcher("quiz_html.html").forward(request,response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		
	}


