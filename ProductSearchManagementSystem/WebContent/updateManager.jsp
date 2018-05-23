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
<title>Product Search Management System - update manager</title>
<link rel="stylesheet" type="text/css" href="productSearchManagementSystem.css">
</head>
<body>
	<jsp:include page="services.jsp"></jsp:include>
	<%
		try{  
			PreparedStatement ps=con.prepareStatement("select * from psms_manager where id=0");  
			ResultSet rs = ps.executeQuery(); 
			if (rs.next()){
	%>
	<form name="formUpdateManager" method="post" action="UpdateManagerService" enctype="multipart/form-data">
		<input type="hidden" name="hiddenFieldButtonClicked">
		<table >
			<tr>
				<td colspan="2" bgcolor="pink">UPDATE MANAGER</td>
			</tr>
			<tr>
				<td class="title" valign="top">Password: </td>
				<td><textarea name="textAreaPassword"><%=rs.getString(3)%></textarea></td>
			</tr>
			<tr>
				<td class="title" valign="top">Recovery Question: </td>
				<td><textarea name="textAreaRecoveryQuestion"><%=rs.getString(4)%></textarea></td>
			</tr>
			<tr>
				<td class="title"  valign="top">Recovery Answer: </td>
				<td><textarea name="textAreaRecoveryAnswer"><%=rs.getString(5)%></textarea></td>
			</tr>
			<tr>
				<td class="information_title">Picture</td>
				<td class="information"><input type="file" name="filePicture"></td>
			</tr>
			<% } } catch(Exception e){System.out.println(e);}%>
			<tr>
				<td colspan="2" >
				<input type="submit" value="update" name="buttonUpdate" style="width:100%;" onclick="{document.formUpdateManager.hiddenFieldButtonClicked.value=this.name;document.formUpdateManager.submit();}">
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