<%@page import="Dao.ServiceManDao"%>
<%@page import="Model.ServiceMan"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="admin-navside.jsp"%>
<!DOCTYPE html>
<html>
<body>
	<%
	int id = Integer.parseInt(request.getParameter("id"));
	%>
	<%
	ServiceMan ss = ServiceManDao.getServicemanById(id);
	%>
	<!-- INLINE FORM ELELEMNTS -->
	<section id="main-content">
		<section class="wrapper">
			<div class="row mt">
				<div class="col-lg-12">
					<div class="form-panel">
						<form class="form-horizontal style-form" role="form">
							<div class="form-group">
								<label class="sr-only" for="exampleInputEmail2">Id
									</label> <input type="email" class="form-control"
									id="exampleInputEmail2" value="<%=ss.getId()%>">
							</div>
							<div class="form-group">
								<label class="sr-only" for="exampleInputEmail2">Name
									</label> <input type="email" class="form-control"
									id="exampleInputEmail2"  value="<%=ss.getName()%>">
							</div>
							<div class="form-group">
								<label class="sr-only" for="exampleInputEmail2">Contact
									</label> <input type="email" class="form-control"
									id="exampleInputEmail2"  value="<%=ss.getContact()%>">
							</div>
							<div class="form-group">
								<label class="sr-only" for="exampleInputEmail2">
									address</label> <input type="email" class="form-control"
									id="exampleInputEmail2"  value="<%=ss.getAddress()%>">
							</div>
							<div class="form-group">
								<label class="sr-only" for="exampleInputEmail2">Email
									</label> <input type="email" class="form-control"
									id="exampleInputEmail2"  value="<%=ss.getEmail()%>">
							</div>
							<button type="submit" class="btn btn-theme">Update</button>
						</form>
					</div>
					<!-- /form-panel -->
				</div>
				<!-- /col-lg-12 -->
			</div>
			<!-- /row -->
		</section>
	</section>
	<!-- /MAIN CONTENT -->
</body>
</html>
