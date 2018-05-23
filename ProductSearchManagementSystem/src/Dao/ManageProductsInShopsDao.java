package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ManageProductsInShopsDao {
	public static boolean remove(String id){  
		boolean status=false;  
		
		try{  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");  
			      
			PreparedStatement ps=con.prepareStatement("delete from psms_products_in_shops where id=?");   
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
	public static boolean update(String id, String shopId, String productId){  
		boolean status=false;  
		
		try{  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");  
			      
			PreparedStatement ps=con.prepareStatement("update psms_products_in_shops set shop_id=?,product_id=? where id=?");   
			ps.setString(1,shopId);
			ps.setString(2,productId);
			ps.setString(3,id);
			      
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
	public static boolean add(String shopId, String productId){  
		boolean status=false;  
		
		try{  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");  
			      
			PreparedStatement ps=con.prepareStatement("insert into psms_products_in_shops values (sequence_psms_products_id.nextval,?,?)");   
			ps.setString(1,shopId);
			ps.setString(2,productId);  
			      
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
