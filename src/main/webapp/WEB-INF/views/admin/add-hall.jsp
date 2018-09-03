<%@ include file="/WEB-INF/taglib.jsp" %>
<style>
<!--
.error {
		color: red;
	}
-->
</style>
<div class="row">
	<div class="col-md-4 col-md-offset-4">
		<div class="login-wrapper">
			<div class="box">
				<div class="content-wrap">
					<h3>Add hall page</h3>
					<form:form action="/admin/add-hall"
					modelAttribute="addHallModel" method="POST">
												
						<div class="form-group">
  							<label class="control-label">Hall name</label>
							<form:input path="name" cssClass="form-control" title="Hall name"/>
							<form:errors path="name" ></form:errors>
							
											
							<label class="control-label">Capacity</label>
							<form:input path="capacity" cssClass="form-control" title="capacity" />
							<form:errors path="capacity" ></form:errors>
					
							<label class="control-label">Seats in row</label>
							<form:input path="seatsInRow" cssClass="form-control" title="seatsInRow" /> <br>
							<form:errors path="seatsInRow" ></form:errors>
							
							<label class="control-label">Information</label>
							<form:errors path="info" cssClass="error"></form:errors> <br>
							<form:input path="info" cssClass="form-control" title="informarion" /> 
							
							
							<label class="control-label">Is the hall ready for exploitation</label> <br>
							<form:errors path="isAvailable" ></form:errors>	
							<form:radiobuttons path="isAvailable" items = "${hallSelect}"/> <br>
								
							
							<%-- <form:select path="isAvailable" cssClass="form-control">
								<form:option  value="true" label = "Hall is:" disabled="true" selected = "true"/>
								<form:options  items="${hallSelect}"/>
							</form:select> --%>	
							
						</div>
						<div class="form-group">
							<span class="input-group-btn">
								<input type="submit" class="btn btn-primary" value="Add hall">
							</span>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>