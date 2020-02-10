package logic.model.queries;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SubjectQueries {

	public static ResultSet findSubjectOfLesson(Statement stmt, int idLesson) throws SQLException  {
		
		String sql = "SELECT * " + 
				"FROM lezione join materia on lezione.Materia=materia.Nome " + 
				"WHERE lezione.ID = "+ idLesson +";";
		
		return stmt.executeQuery(sql);
		
	}
	
	public static ResultSet findSubjectOfStudent(Statement stmt,String username) throws SQLException {
		String sql = "SELECT Materia " + 
				"FROM segue " + 
				"WHERE Studente = '"+ username +"';";
		
		return stmt.executeQuery(sql);
	}
	
}
