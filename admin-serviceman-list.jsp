<%@page import="Dao.ServiceManDao"%>
<%@page import="Model.ServiceMan"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="admin-navside.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!--main content start-->
	<section id="main-content">
		<section class="wrapper">
			<h3>
				<i class="fa fa-angle-right"></i> Basic Table Examples
			</h3>
			<div class="row">

				<div class="col-md-12">
					<div class="content-panel">
						<h4>
							<i class="fa fa-angle-right"></i> Basic Table
						</h4>
						<hr>
						<table class="table">
							<thead>
								<tr>
									<th>Id</th>
									<th>Name</th>
									<th>Contact</th>
									<th>Address</th>
									<th>Email</th>
									<th>Edit</th>
									<th>Delete</th>
								</tr>
							</thead>
							<tbody>
								<%
								List<ServiceMan> list = ServiceManDao.getAllServiceman();
								%>
								<%
								for (ServiceMan s : list) {
								%>
								<tr>
									<td><%=s.getId()%></td>
									<td><%=s.getName()%></td>
									<td><%=s.getContact()%></td>
									<td><%=s.getAddress()%></td>
									<td><%=s.getEmail()%></td>
									<td><a href="single-serviceman.jsp?id=<%=s.getId()%>">Edit</a></td>
									<td><a href="#">Delete</a></td>
								</tr>
								<%
								}
								%>
							</tbody>
						</table>
					</div>
					<! --/content-panel -->
				</div>
				<!-- /col-md-12 -->
			</div>
			<!-- row -->


		</section>
		<! --/wrapper -->
	</section>
	<!-- /MAIN CONTENT -->
</body>
</html>
