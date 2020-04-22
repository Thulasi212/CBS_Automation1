package utility;
import java.io.IOException;
import java.sql.*;

public class MobileNoVerify {
	
	public static void main(String args[])throws Exception{
		
	
	
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		
	try{ 
		
		Class.forName("com.mysql.jdbc.Driver");
				
		System.out.println("try one==========="); 
		
		con=DriverManager.getConnection("jdbc:mysql://192.168.64.227:3306/employees","hiveuser","Coty@2017"); 
		System.out.println("Success");
		System.out.println(con);
		
		
		stmt=con.createStatement();  
		
		rs=stmt.executeQuery("select * from views");  
		 
		while(rs.next())  
		{	
		System.out.println(rs.getString(1)+"  "+rs.getInt(2));  
		}
	  
	}		catch(ClassNotFoundException | SQLException  e){   			System.out.println(e);}  
			 
	finally{
		if(rs!=null){
			rs.close();
		}
		if(stmt!=null){
			stmt.close();
		}
		
		if(con!=null){
			con.close();
		}
		
	}
	}
}
	
	




