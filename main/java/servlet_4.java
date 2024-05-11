

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import databases_operations.Ques_ans_setter_getter;
import databases_operations.Table_oprations;
@WebServlet("/servlet_4")
public class servlet_4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Ques_ans_setter_getter qasg=new Ques_ans_setter_getter();
	Table_oprations to = new Table_oprations();
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		System.out.println(email);
		System.out.println(username);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("servlet_3");
		requestDispatcher.forward(request, response);
//		to.check_data();
	}

}
