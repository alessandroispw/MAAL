package logic.model.queries;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CourseQueries {

public static ResultSet findCourse(Statement stmt,String nameOfCourse) throws SQLException  {
		
		String sql = "SELECT * FROM Materia WHERE Corso = '"+ nameOfCourse +"';";
		
		return stmt.executeQuery(sql);
		
	}
	
}
