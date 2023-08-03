<%@page import="Model.Customer"%>
<%@page import="Dao.BookingDao"%>
<%@page import="Model.BookService"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@include file="serviceman-navbar.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h2>Your Services</h2>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>Bid</th>
					<th>CID</th>
					<th>Sid</th>
					<th>booking_price</th>
					<th>Booking_status</th>
					<th>Payment_status</th>
					<th>Confirm</th>
					<th>Reject</th>
				</tr>
			</thead>
			<tbody>
			<% Customer c=new Customer(); 
			  
			%>
			<input type="hidden" name="email" value="<%=c.getEmail()%>">
				<%
				List<BookService> list = BookingDao.getPendingServiceForServicemanById(s.getId());
				%>
				<%
				for (BookService s1 : list) {
				%>
				<tr>
					<td><%=s1.getBid()%></td>
					<td><%=s1.getCid()%></td>
					<td><%=s1.getSid()%></td>
					<td><%=s1.getSprice()%></td>
					<td><%=s1.getBooking_status() %></td>
					<td><%=s1.getPayment_status() %></td>
					<td><a href="BookingController?action=confirm&bid=<%=s1.getBid()%>&cid=<%s1.getCid();%>">Confirm</a></td>
					<td><a href="BookingController?action=confirm&bid=<%=s1.getBid()%>&cid=<%s1.getCid();%>">Reject</a></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</div>
</body>
</html>