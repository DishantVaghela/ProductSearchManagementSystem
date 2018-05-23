<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*" %>
<%	 
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");  
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system"); 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Search Management System - search product seller</title>
<link rel="stylesheet" type="text/css" href="productSearchManagementSystem.css">
</head>
<body>
	<table>
		<tr>
			<td ><img src="productSearchManagementSystemlLogo.png"></td>
		</tr>
		<tr>
			<td><br></td>
		</tr>
		<tr>
			<td>
				<%
					 
						String category=request.getParameter("selectCategory");
						String brand=request.getParameter("textFieldBrand");
						String name=request.getParameter("textFieldName");
						String price=request.getParameter("textFieldPrice");
				
						PreparedStatement ps = con.prepareStatement("select distinct s.*,p.* from psms_shops s,psms_products p,psms_products_in_shops ps where p.category=? and p.brand=? and p.name=? and p.price=? and p.id=ps.product_id and ps.shop_id=s.id");  
						ps.setString(1,category);
						ps.setString(2,brand);
						ps.setString(3,name);
						ps.setString(4,price);
						
						ResultSet rs = ps.executeQuery(); 
						
					    out.print("<table >");
					    out.print("<tr>");
					    out.print("<td  bgcolor=pink>Sellers selling your desired product</td></tr>");
					    out.println("</table>"); 
					    out.print("<table border=1>");
					    out.print("<tr><td class=\"title\" >ID</td><td class=\"title\" >NAME</td><td class=\"title\" >STREET</td><td class=\"title\" >CITY</td><td class=\"title\" 	>STATE</td></tr>");
					   	while (rs.next()) {
					   		out.print("<tr><td>" + rs.getString(1) + "</td>");
						    out.print("<td>" + rs.getString(2) + "</td>");
						    out.print("<td>" + rs.getString(3) + "</td>");
						    out.print("<td>" + rs.getString(4) + "</td>");
						    out.print("<td>" + rs.getString(5) + "</td></tr>");
					    }
					    out.println("</table>"); 
					    if (con != null && !con.isClosed())
						{
							con.close();
							Thread.sleep(1000);
						}
					}
					catch (Exception e) {
				        System.out.println(e);
				    }
				%>
			</td>
		</tr>
	</table>
</body>
</html>