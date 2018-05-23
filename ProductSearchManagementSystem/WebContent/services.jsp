<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Search Management System - services</title>
<link rel="stylesheet" type="text/css" href="productSearchManagementSystem.css">
</head>
<body>
<div class="header">
	<form action="ServicesService" method="post">
		<table>
			<tr>
				<td ><img src="productSearchManagementSystemlLogo.png"></td>
			</tr>
			<tr>
				<td ><br></td>
			</tr>
			<tr>
				<td class="manager"><img src="manager/manager.png"></td>
			</tr>
			<tr>
				<td ><input type="submit" value="logout <%=session.getAttribute("sessionLoginId")%>" name="buttonLogout" style="width:100%;"></td>
			</tr>
			<tr>
				<td >
					<input type="submit" value="update manager" name="buttonUpdateManager" style="width:32%;">
					<input type="submit" value="manage products or shops" name="buttonManageProductsOrShops" style="width:32%;">
					<input type="submit" value="manage products in shops" name="buttonManageProductsInShops" style="width:32%;">
				</td>
			</tr>
			<tr>
				<td><br></td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>