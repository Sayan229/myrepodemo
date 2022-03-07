import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementDemo {

	public static void main(String[] args) {
		String sql = "insert into citizen values(106, 'Paul', 24, 'Delhi')";

		try {
			Connection conn = JdbcFactory.getConnection();

			Statement stmt = conn.createStatement();

			stmt.executeUpdate(sql); // DML Operation

			System.out.println("Record inserted");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
