

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import databases_operations.Ques_ans_setter_getter;
import databases_operations.Table_oprations;
import org.json.JSONArray;
import org.json.JSONObject;

@WebServlet("/servlet_5")
public class servlet_5 extends HttpServlet {

    Set<String> chapter_names = new HashSet<String>();
    ArrayList<String> ques_data = new ArrayList<String>();
//	String user_id = "3a0ee90c4f71";
     Ques_ans_setter_getter qasg = new Ques_ans_setter_getter();
    Table_oprations to1 = new Table_oprations();

    protected void set_history(){


    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("hello from servlet from 5");
        HttpSession session = request.getSession();
        String user_id = (String) session.getAttribute("user_info");
        System.out.println(user_id);;
		int question_count;
        try {
            question_count = to1.count_total_questions(user_id + "_question_table", "wrong_user_answeres", "ques_id");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

        String status = request.getParameter("status");
        System.out.println(status);
        Table_oprations to = new Table_oprations(qasg);
      
        if (Objects.equals(status, "ques")) {
            System.out.println("fuck yeah");

            JSONObject parentJson = new JSONObject();
            JSONArray myArray = new JSONArray();
            for(int i=1;i<=question_count;i++) {
//                int ques_no = Integer.parseInt(request.getParameter("ques_no"))
                System.out.println(i);
                String[] option;
                
                try {
                    String ques_id = to.get_question_ids(user_id + "_question_table", "wrong_user_answeres", i);
//                    System.out.println(ques_id);
                     qasg = to.get_questions(ques_id);
                    option = qasg.getOptions();
                    JSONObject json = new JSONObject();
                    json.put("question", qasg.getQuestion());
                    json.put("options", option);
                    json.put("answere", qasg.getAns());
//
                    myArray.put(json);



                } catch (ClassNotFoundException | SQLException e) {
                    throw new RuntimeException(e);
                }
                
            }
            parentJson.put("data",myArray);
            PrintWriter out = response.getWriter();
            out.print(parentJson);
            out.flush();
//            System.out.println(parentJson);
        } else if (status.equals("user_info")) {
			try {

				String fname=to.get_user_name(user_id);
//				System.out.println(fname);
				JSONObject json = new JSONObject();
				json.put("name",fname);
				json.put("user_id",user_id);
				json.put("question_count",question_count);
				PrintWriter out = response.getWriter();
				out.print(json);
				out.flush();

			} catch (ClassNotFoundException | SQLException e) {
                System.out.println(e);
				throw new RuntimeException(e);
			}
		} else if (status.equals("chart_question_composition")){
            JSONObject json = new JSONObject();

            System.out.println("chart_question_composition");

            int ques_count = 0;
            try {
                question_count = to.count_total_questions(user_id + "_question_table", "user_profile", "ques_id");
            } catch (ClassNotFoundException | SQLException e) {
                throw new RuntimeException(e);
            }
            for (int i = 1; i <= question_count; i++) {

                String chapter_name = null;
                try {
                    chapter_name = "ch_"+ to.get_question_ids(user_id + "_question_table", "user_profile", i).split("_")[1]+"\\_";
                } catch (ClassNotFoundException | SQLException e) {
                    throw new RuntimeException(e);
                }
                chapter_names.add(chapter_name);
            }
            System.out.println(chapter_names);
            int sum=0;
            for (String item : chapter_names) {
//                System.out.println(item);

                int count;
                try {
                    count = to.counter(item, user_id + "_question_table");
                    json.put(item,count);
                } catch (SQLException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
//                System.out.println(count);
//                sum += count;
            }
//            System.out.println(sum);
            PrintWriter out = response.getWriter();
            out.print(json);
            out.flush();
        } else if (status.equals("history")) {
//        	System.out.println(user_id+"user_id *******************************");
            int total_questions;
            int question;
            try {
                question = to1.count_total_questions(user_id + "_question_table", "wrong_user_answeres", "ques_id");
                total_questions = to1.count_total_questions(user_id + "_question_table", "user_profile", "ques_id");
            } catch (ClassNotFoundException | SQLException e) {
                throw new RuntimeException(e);
            }

            int correct_ans_count = total_questions - question;
            qasg.setWrong_ans(question);
            qasg.setUserId(user_id);
            qasg.setCorrect_answere(correct_ans_count);
            qasg.setDatetime(to1.get_time());
            qasg.setTotal_questions(total_questions);
            try {
                to.store_history();
            } catch (ClassNotFoundException | SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }
}


