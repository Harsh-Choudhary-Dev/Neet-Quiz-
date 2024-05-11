
package databases_operations;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database_connections {
	
	
	static Connection con = null;

	public static  Connection connectDB(String databases_name) throws ClassNotFoundException

	{
//		System.out.println("connection started");
//		System.out.println("started connectDB ");

		try {
			// Importing and registering drivers
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String database_connect=String.format("jdbc:mysql://localhost:3306/%s", databases_name);
//			System.out.println(database_connect);

			Connection con = DriverManager.getConnection(database_connect,"root", "harsh");
//			System.out.println("database connected");
			return con;
		}
		catch (SQLException e) {

			System.out.println(e);
		}
		try {
			return con;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return null;
	}
	

}


