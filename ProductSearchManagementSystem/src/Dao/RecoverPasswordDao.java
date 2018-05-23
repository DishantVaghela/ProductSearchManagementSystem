package Dao;

import java.sql.*;

public class RecoverPasswordDao {
	public static boolean recover(String loginId,String loginRecoveryanswer){  
		boolean status=false;  
		try{  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");  
			      
			PreparedStatement ps=con.prepareStatement("select * from psms_manager where manager_id=? and recovery_answer=?");  
			ps.setString(1,loginId);  
			ps.setString(2,loginRecoveryanswer);  
			      
			ResultSet rs=ps.executeQuery();  
			status=rs.next();  
			
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
