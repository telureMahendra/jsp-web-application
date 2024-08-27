package daoFolder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javaBean.ExamRegistration;



public class ExamDetailsDao {
	private static final String DB_URL = "jdbc:mysql//localhost:3306/mahi";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "root";

	public void saveRegistration(ExamRegistration registration) throws SQLException {
		String query = "INSERT INTO registrations(student_name, email, exam_id) VALUES (?,?,?)";
		try(Connection connection = DriverManager.getConnection(DB_URL,DB_URL, DB_PASSWORD);
				PreparedStatement preparedStatement = connection.prepareStatement(query)){
			
			preparedStatement.setString(1, registration.getStudentName());
			preparedStatement.setString(2, registration.getEmail());
			preparedStatement.setString(3, registration.getExamId());
			preparedStatement.executeUpdate();
			
		}catch (SQLException e) {
			System.out.println("sSQL Errorwhile saving regisrration: "+e.getMessage());
			throw e;
		}
	}
}
