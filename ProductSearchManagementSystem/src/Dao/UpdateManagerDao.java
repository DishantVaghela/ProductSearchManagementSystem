package Dao;

import java.sql.*;

public class UpdateManagerDao {
	public static boolean updateManager(String password, String recoveryQuestion, String recoveryAnswer){  
		boolean status=false;  
		
		try{  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");  
			      
			PreparedStatement ps=con.prepareStatement("update psms_manager set password=?, recovery_question=?, recovery_answer=?, picture=? where id=?");   
			ps.setString(1,password);
			ps.setString(2,recoveryQuestion);
			ps.setString(3,recoveryAnswer);
			ps.setString(4,"manager.png");
			ps.setInt(5,0);
			      
			ps.executeUpdate();
            ps.clearParameters(); 
			status=true;
			
			if (con != null && !con.isClosed())
			{
				con.close();
				Thread.sleep(1000);
			}
		          
		}
		catch(Exception e){
			System.out.println(e);
		}  
		return status;  
	}
}
