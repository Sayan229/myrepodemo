import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.cj.jdbc.Driver;

public class ConnectorDemo {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/training";

		try {
//			Driver driver = new Driver(); // MYSQL
//			DriverManager.registerDriver(driver);
//			Connection conn = DriverManager.getConnection(url, "root", "Sayan1234#");
			Connection conn = JdbcFactory.getConnection();
			System.out.println("Connection Succesful");

			DatabaseMetaData meta = conn.getMetaData();
			System.out.println("DB Name: " + meta.getDatabaseProductName());
			System.out.println("DB Ver: " + meta.getDatabaseProductVersion());
			System.out.println("Driver Name: " + meta.getDriverName());
			System.out.println("Driver Ver: " + meta.getDriverVersion());

		} catch (SQLException e) {
			System.out.println("Connection failed!");
			e.printStackTrace();
		}
	}
}
