package databases_operations;

import java.util.ArrayList;

public class Ques_ans_setter_getter {
	public ArrayList<String> getChapter_name() {
		return chapter_name;
	}

	public void setChapter_name(ArrayList<String> chapter) {
		this.chapter_name = chapter;
	}

	public ArrayList<String> getChapter_ids() {
		return chapter_ids;
	}

	public void setChapter_ids(ArrayList<String> chapter_ids2) {
		this.chapter_ids = chapter_ids2;
	}

	public String getQuestions_ids() {
		return questions_ids;
	}

	public void setQuestions_ids(String questions_ids) {
		this.questions_ids = questions_ids;
	}

	ArrayList<String> chapter_name;
	ArrayList<String> chapter_ids;
	String questions_ids;
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	String email;
	String userId;
	String question;
	String[] options;
	String fname;
	String lname;

	public String getUser_id() {
		return user_id;
	}



	String user_id;

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public int getTotal_questions() {
		return total_questions;
	}

	public void setTotal_questions(int total_questions) {
		this.total_questions = total_questions;
	}

	public int getCorrect_answere() {
		return correct_answere;
	}

	public void setCorrect_answere(int correct_answere) {
		this.correct_answere = correct_answere;
	}

	public int getWrong_ans() {
		return wrong_ans;
	}

	public void setWrong_ans(int wrong_ans) {
		this.wrong_ans = wrong_ans;
	}

	String datetime;
	int total_questions;
	int correct_answere;
	int wrong_ans;

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	String ans;
	String ques_id;
	int ques_id_no;




	public int getQues_id_no() {
		return ques_id_no;
	}

	public void setQues_id_no(int ques_id_no) {
		this.ques_id_no = ques_id_no;
	}

	public String getQues_id() {
		return ques_id;
	}

	public void setQues_id(String ques_id) {
		this.ques_id = ques_id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}


	public String[] getOptions() {
		return options;
	}

	public void setOptions(String[] options) {
		this.options = options;
	}

	public String getAns() {
		return ans;
	}

	public void setAns(String ans) {
		this.ans = ans;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}




}
