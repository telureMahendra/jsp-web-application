package javaBean;

public class ExamRegistration {
	private String studentName;
	private String email;
	private String examId;
	
	public ExamRegistration() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ExamRegistration(String studentName, String email, String examId) {
		super();
		this.studentName = studentName;
		this.email = email;
		this.examId = examId;
	}
	
	public String getStudentName() {
		return studentName;
	}
	
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getExamId() {
		return examId;
	}
	public void setExamId(String examId) {
		this.examId = examId;
	}
	
	
}
