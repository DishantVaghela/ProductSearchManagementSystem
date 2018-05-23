<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Search Management System</title>
<link rel="stylesheet" type="text/css" href="productSearchManagementSystem.css">	
</head>
<body>
	<table>
		<tr>
			<td>
				<form action="ManagerLoginService" method="post">
					<table>
						<tr>
							<td align="center" colspan="2"><img src="productSearchManagementSystemlLogo.png"></td>
						</tr>
						<tr>
							<td colspan="2"><br></td>
						</tr>
						<tr>
							<td colspan="2" bgcolor="pink">MANAGER LOGIN</td>
						</tr>
						<tr>
							<td class="title">Id:</td>
							<td><input type="text" name="textFieldId"></td>
						</tr>
						<tr>
							<td class="title">Password:</td>
							<td><input type="password" name="textFieldPassword"></td>
						</tr>
						
						<tr>
							<td colspan="2">
								<input type="submit" value="recover password" name="buttonRecoverPassword" style="width:49%;">
								<input type="submit" value="login" name="buttonLogin" style="width:49%;">
							</td>
						</tr>
					</table>
				</form>
			</td>
		</tr>
		<tr>
			<td>
				<form action="searchProductSeller.jsp">
					<table>
						<tr>
							<td colspan="2"><br></td>
						</tr>
						<tr>
							<td colspan="2" bgcolor="pink">Search Product Seller</td>
						</tr>
						<tr>
							<td class="title">Category:</td>
							<td>
								<select name="selectCategory">
									<option>food</option>
									<option>clothes</option>
									<option>furniture</option>
								</select>
							</td>
						</tr>
						<tr>
							<td class="title">Brand:</td>
							<td><input type="text" name="textFieldBrand"></td>
						</tr>
						<tr>
							<td class="title">Name:</td>
							<td><input type="text" name="textFieldName"></td>
						</tr>
						<tr>
							<td class="title">Price:</td>
							<td><input type="text" name="textFieldPrice"></td>
						</tr>
						<tr>
							<td colspan="2">
								<input type="submit" value="search"  name="buttonSearch" style="width:100%;">
							</td>
						</tr>
					</table>
				</form>
			</td>
		</tr>
	</table>
</body>
</html>