

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import databases_operations.Ques_ans_setter_getter;
import databases_operations.Table_oprations;

@WebServlet("/servlet_3")
public class servlet_3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Ques_ans_setter_getter qasg=new Ques_ans_setter_getter();

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		System.out.println(email);
		System.out.println(fname);
		System.out.println(lname);
		qasg.setEmail(email);
		qasg.setLname(lname);
		qasg.setFname(fname);
		Table_oprations to1=new Table_oprations();
		String user_id=to1.generate_userIds();
		qasg.setUserId(user_id);
		Table_oprations to=new Table_oprations(qasg);
		
		try {
			to.set_users_details();
			HttpSession session = request.getSession();
			session.setAttribute("user_info", user_id);
			response.sendRedirect("weak_ch_input.html");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
