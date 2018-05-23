package Dao;

import java.sql.*;

public class ManageProductsDao {
	public static boolean removeProducts(String id){  
		boolean status=false;  
		
		try{  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");  
			      
			PreparedStatement ps=con.prepareStatement("delete from psms_products where id=?");   
			ps.setString(1,id);
			      
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
	public static boolean updateProducts(String id, String category, String brand, String name, String price){  
		boolean status=false;  
		
		try{  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");  
			      
			PreparedStatement ps=con.prepareStatement("update psms_products set category=?,brand=?, name=?, price=? where id=?");   
			ps.setString(1,category);
			ps.setString(2,brand);
			ps.setString(3,name);
			ps.setString(4,price);
			ps.setString(5,id);
			      
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
	public static boolean addProducts(String category, String brand, String name, String price){  
		boolean status=false;  
		
		try{  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");  
			      
			PreparedStatement ps=con.prepareStatement("insert into psms_products values (sequence_psms_products_id.nextval,?,?,?,?)");   
			ps.setString(1,category);
			ps.setString(2,brand);  
			ps.setString(3,name);
			ps.setString(4,price);  
			      
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
