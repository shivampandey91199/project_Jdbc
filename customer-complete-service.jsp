<%@page import="Model.BookService"%>
<%@page import="Dao.BookingDao"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="customer-navbar.jsp"%>
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
					<th>Pay Now</th>
				</tr>
			</thead>
			<tbody>
				<%
				List<BookService> list = BookingDao.getConfirmServiceForCustomer(s.getId());
				%>
				<%
				for (BookService s1 : list) {
				%>
				<tr>
					<td><%=s1.getBid()%></td>
					<td><%=s1.getCid()%></td>
					<td><%=s1.getSid()%></td>
					<td><%=s1.getSprice()%></td>
					<td><%=s1.getBooking_status()%></td>
					<td><%=s1.getPayment_status()%></td>
					<td>

						<form method="post"
							action="payment.jsp?amount=<%=s1.getSprice()%>">
							<table border="1">
								<tbody>
									<tr>
										<td><label>Amount</label></td>
										<td><input title="TXN_AMOUNT" tabindex="10" type="text"
											name="TXN_AMOUNT" value="<%=s1.getSprice()%>"></td>
									</tr>
									<tr>
										<td></td>
										<td></td>
										<td><input value="Pay" type="submit" onclick=""></td>
									</tr>
								</tbody>
							</table>
							
						</form>
					</td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</div>
</body>
</html>