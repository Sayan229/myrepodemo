import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionDemo {

	public static void main(String[] args) {
		String sql1 = "insert into citizen values (909, 'Kim', 31, 'Kerala')";
		String sql2 = "update citizen set age=30 where id=101";
		String sql3 = "delete from citizen where id=104";
		
		Connection conn = null;
		
		try {
			conn = JdbcFactory.getConnection();
			
			Statement stmt = conn.createStatement();
			//Adding batch of queries in one go
			stmt.addBatch(sql1);
			stmt.addBatch(sql2);
			stmt.addBatch(sql3);
			
			conn.setAutoCommit(false);//Setting auto-commit state to false
			
			stmt.executeBatch(); //Executing all queries
			
			conn.commit(); //committing transaction successful execution of all queries
		} catch (SQLException e) {
			try {
				conn.rollback(); //rollback transaction as either of the query failed
			}catch(SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();	
		}
	}
}
