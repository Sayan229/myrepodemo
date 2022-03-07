import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSetMetaData;

public class ResultDemo {

	public static void main(String[] args) {

		// String sql = "select * from citizen";

		try {
			Connection conn = JdbcFactory.getConnection();
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

			ResultSet rs = stmt.executeQuery("select * from citizen");
//			rs.absolute(5);
//			rs.updateRow();
//			rs.updateString("name", "Chris");
//			rs.absolute(0);
//
//			rs.moveToInsertRow();
//			rs.updateInt(1, 106);
//			rs.updateString(2, "Vijay");
//			rs.updateInt(3, 28);
//			rs.updateString(4, "Shimla");
//			rs.insertRow();
//			rs.moveToCurrentRow();
			
//			rs.absolute(2);
//			rs.deleteRow();
//			rs.moveToCurrentRow();
//			rs.absolute(0);

			ResultSetMetaData meta = rs.getMetaData();

			for (int c = 1; c <= meta.getColumnCount(); c++)
				System.out.println(meta.getColumnName(c) + "\t");
			System.out.println();

			while (rs.next())
				System.out.println(rs.getString("id") + "\t" + rs.getString(2) + "\t" + rs.getString("age") + "\t" + rs.getString(4));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
