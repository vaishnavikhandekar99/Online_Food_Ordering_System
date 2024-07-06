<%@page import="com.qsp.food_app.dto.Items"%>
<%@page import="com.qsp.food_app.dto.FoodOrder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
      <%
	String message = (String) request.getAttribute("message");
	FoodOrder foodOrder = (FoodOrder) request.getAttribute("foodorder");
	long payable_amount = 0;
	%>
	<h1><%=message%></h1>
	<table>
		<tr>
			<td>Name :</td>
			<td><%=foodOrder.getName()%></td>
		</tr>
		<tr>
			<td>Address :</td>
			<td><%=foodOrder.getAddress()%></td>
		</tr>
		<tr>
			<td>Email :</td>
			<td><%=foodOrder.getEmail()%></td>
		</tr>
		<tr>
			<td>Phone :</td>
			<td><%=foodOrder.getPhone()%></td>
		</tr>
	</table>
	<table border="2px solid">
		<tr>
			<th>Name</th>
			<th>Description</th>
			<th>Price</th>
			<th>Offer</th>
			<th>Quantity</th>
			<th>Total Amount</th>
		</tr>
		<%
		for (Items items : foodOrder.getItems()) {
		%>
		<tr>
			<td><%=items.getName()%></td>
			<td><%=items.getDescription()%></td>
			<td><%=items.getPrice()%></td>
			<td><%=items.getOffer()%></td>
			<td><%=items.getQuantity()%></td>
			<td><%=items.getPrice() * items.getQuantity()%></td>
			<%
			payable_amount += items.getPrice() * items.getQuantity();
			%>
		</tr>
		<%
		}
		%>
	</table>
	<h3>
		Amount to be paid :
		<%=payable_amount%></h3>
		<form action="endof">
		<input type="submit" value="ok">
		
		
		
		</form>
</body>
</html>