package DataBaseTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DBT {

	public static void main(String[] args) throws SQLException {
	
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "root");
		Statement statement = conn.createStatement();
		ResultSet result = statement.executeQuery("SELECT actor_id, first_name, last_name FROM sakila.actor");
		while(result.next()) {
			int actor_id = result.getInt(1);
			String first_name = result.getString(2);
			String last_name = result.getString(3);
			System.out.println(actor_id +" "+ first_name +" " + last_name );	
			
		int result1 =  statement.executeUpdate("INSERT INTO sakila.actor VALUES (204,'Kamila', 'Cornnel','2006-02-15')");
				
		System.out.println(result1);
		if(result1!=0) {
			System.out.println("Insert Operation Successful");
		}
		else {
			System.out.println("Insert Operation failed");
		}
		
 conn.close();
		}
		
		

	}
}
	


