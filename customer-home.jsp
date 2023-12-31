<%@page import="Dao.ServicemanServiceDao"%>
<%@page import="Model.ServicemanServicess"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@include file="customer-navbar.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- Team Start -->
	<div class="container-xxl py-5">
		<div class="container">
			<div class="text-center wow fadeInUp" data-wow-delay="0.1s">
				<h6 class="text-secondary text-uppercase">Our Technicians</h6>
				<h1 class="mb-5">Our Expert Technicians</h1>
			</div>
			<div class="row g-4">

				<%
				List<ServicemanServicess> list = ServicemanServiceDao.getAllServices();
				%>
				<%
				for (ServicemanServicess s1 : list) {
				%>
				<div class="col-lg-3 col-md-6 wow fadeInUp" data-wow-delay="0.1s">
					<div class="team-item">
						<div class="position-relative overflow-hidden">
							<img class="img-fluid" src="img/team-1.jpg" alt="">
						</div>
						<div class="team-text">
							<div class="bg-light">
								<h5 class="fw-bold mb-0"><%=s1.getService_name()%></h5>
								<small><%=s1.getSprice()%></small>
							</div>
							<div class="bg-primary">
								<a class="btn btn-square mx-1" href="customer-single-service.jsp?id=<%=s1.getSid()%>"></i>Book</a>
							</div>
						</div>
					</div>
				</div>
				<%
				}
				%>


			</div>
		</div>
	</div>
	<!-- Team End -->
</body>
</html>