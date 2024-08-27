package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoFolder.ExamDetailsDao;
import javaBean.ExamRegistration;

@WebServlet("/RegisterExam")
public class ExamRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1l;
	private ExamDetailsDao examDetailsDao;

	@Override
	public void init() throws ServletException {
		super.init();
		examDetailsDao = new ExamDetailsDao();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String studentName = request.getParameter("studentName");
		String email = request.getParameter("email");
		String examId = request.getParameter("examId");
		
		ExamRegistration registration = new ExamRegistration(studentName, email, examId);
		
		try {
			examDetailsDao.saveRegistration(registration);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/registrationSuccess.jsp");
			dispatcher.forward(request, response);
			
		} catch (SQLException e) {
			log("SQLEroor saving registration: "+ e);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/erro.jsp");
		}
	}

}
