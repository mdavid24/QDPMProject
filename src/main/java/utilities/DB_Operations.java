package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class DB_Operations {
	
	
	public synchronized HashMap<String,String> getSQLResultInMap(String query) throws Exception
	{
		HashMap<String, String> hmap = new HashMap<String,String>();
		
		
		Connection con =	DriverManager.getConnection("jdbc:mysql://localhost:3306/dav_qdpm", "root","david");
		
	Statement stmt =	con.createStatement();
	
	
	ResultSet rs = stmt.executeQuery(query);
	
	ResultSetMetaData md = rs.getMetaData();
	
	while(rs.next())
	{
		for(int i =1;i<=md.getColumnCount();i++)
		{
			hmap.put(md.getColumnName(i),rs.getString(i));
		}
	}
	System.out.println(hmap);
	return hmap;
	
	
	}
	
	

}
