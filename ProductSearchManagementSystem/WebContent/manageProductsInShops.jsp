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
<title>Product Search Management System - manage products in shops</title>
<link rel="stylesheet" type="text/css" href="productSearchManagementSystem.css">
</head>
<body>
	<jsp:include page="services.jsp"></jsp:include>
	<form action="ManageProductsInShopsService" method="post">
		<table >
			<tr>
				<td colspan="2" bgcolor="pink">MANAGE PRODUCTS IN SHOPS</td>
			</tr>
			<tr>
				<td  class="title" >Id:</td>
				<td><input type="text" name="textFieldId" ></td>
			</tr>
			<tr>
				<td  class="title" >Shop Id:</td>
				<td><input type="text" name="textFieldShopId"></td>
			</tr>
			<tr>
				<td  class="title" >Product Id:</td>
				<td><input type="text" name="textFieldProductId" ></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="add" name="buttonAdd" style="width:32%;">
					<input type="submit" value="update" name="buttonUpdate" style="width:32%;">
					<input type="submit" value="remove" name="buttonRemove" style="width:32%;">
				</td>
			</tr>
		</table>
	</form>
	<%
		PreparedStatement ps = con.prepareStatement("select * from psms_products_in_shops");  
		
		
		ResultSet rs = ps.executeQuery(); 
		
	    out.print("<table >");
	    out.print("<tr>");
	    out.print("<td  bgcolor=pink>list of products in shops</td></tr>");
	    out.println("</table>"); 
	    out.print("<table border=1>");
	    out.print("<tr><td class=\"title\" >ID</td><td class=\"title\" >SHOP ID</td><td class=\"title\" >PRODUCT ID</td></tr>");
	   	while (rs.next()) {
	   		out.print("<tr><td>" + rs.getString(1) + "</td>");
		    out.print("<td>" + rs.getString(2) + "</td>");
		    out.print("<td>" + rs.getString(3) + "</td></tr>");
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
</body>
</html>