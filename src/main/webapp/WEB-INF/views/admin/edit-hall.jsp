<%@ include file="/WEB-INF/taglib.jsp" %>

<div class="row">
	<div class="col-md-4 col-md-offset-4">
		<div class="login-wrapper">
			<div class="box">
				<div class="content-wrap">
					<h3>Edit hall</h3>
					<form:form action="/admin/{hall.id}/edit-hall"
								modelAttribute="editHall" 
								method="POST">
						
						<form:hidden path="id"/>
						
							<div class="form-group">
  							<label class="control-label">Hall name</label>
							<form:input path="name" cssClass="form-control" title="Hall name" />
											
							<label class="control-label">Capacity</label>
							<form:input path="capacity" cssClass="form-control" title="capacity" />
					
							<label class="control-label">Seats in row</label>
							<form:input path="seatsInRow" cssClass="form-control" title="seatsInRow" />
							
							<label class="control-label">Information</label>
							<form:input path="info" cssClass="form-control" title="informarion" />
							
							<label class="control-label">Is the hall ready for exploitation</label> <br>
							<%-- <form:select path="isAvailable" cssClass="form-control">
								<form:option  value="true" label = "Hall is:" disabled="true" selected = "true"/>
								<form:options  items="${hallSelect}"/>
							</form:select> --%>
							<form:radiobuttons path="isAvailable" items = "${hallSelect}"/> <br>	
							
						</div>
						<div class="form-group">
							<span class="input-group-btn">
								<input type="submit" class="btn btn-primary" value="Edit hall">
							</span>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>