package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ManageShopsDao {
	public static boolean removeShops(String shopId){  
		boolean status=false;  
		
		try{  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");  
			      
			PreparedStatement ps=con.prepareStatement("delete from psms_shops where id=?");   
			ps.setString(1,shopId);
			      
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
	public static boolean updateShops(String shopId, String name, String street, String city, String state){  
		boolean status=false;  
		
		try{  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");  
			      
			PreparedStatement ps=con.prepareStatement("update psms_shops set name=?,street=?, city=?, state=? where id=?");   
			ps.setString(1,name);
			ps.setString(2,street);
			ps.setString(3,city);
			ps.setString(4,state);
			ps.setString(5,shopId);
			      
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
	public static boolean addShops(String name, String street, String city, String state){  
		boolean status=false;  
		
		try{  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");  
			      
			PreparedStatement ps=con.prepareStatement("insert into psms_shops values (sequence_psms_shops_id.nextval,?,?,?,?)");   
			ps.setString(1,name);
			ps.setString(2,street);  
			ps.setString(3,city);
			ps.setString(4,state);  
			      
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
