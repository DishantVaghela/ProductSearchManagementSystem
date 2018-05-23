<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*" %>
<%	
	Class.forName("oracle.jdbc.driver.OracleDriver");  
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system"); 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Search Management System - display password</title>
<link rel="stylesheet" type="text/css" href="productSearchManagementSystem.css">	
</head>
<body>
	<form action="services.jsp">
		<%
			try{  
				PreparedStatement ps=con.prepareStatement("select * from psms_manager where id=?");  
				ps.setInt(1,0);  
				ResultSet rs = ps.executeQuery(); 
				if (rs.next()){
		%>
		<table >
			<tr>
				<td ><img src="productSearchManagementSystemlLogo.png"></td>
			</tr>
			<tr>
				<td ><br></td>
			</tr>
			<tr>
				<td bgcolor="pink">DISPLAY PASSWORD</td>
			</tr>
			<tr>
				<td>your password is <%out.print(rs.getString(3));%></td>
			</tr>
			<% } } catch(Exception e){System.out.println(e);}%>
			<tr>
				<td>
				<input type="submit" value="go ahead" style="width:100%;">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
<%
	try {
		if (con != null && !con.isClosed())
		{
			con.close();
			Thread.sleep(1000);
		}
	}
	catch (SQLException e) {
		e.printStackTrace();
	}
%>