<%@ include file="/WEB-INF/taglib.jsp" %>

<div class="row">
	<div class="col-md-4 col-md-offset-4">
		<div class="login-wrapper">
			<div class="box">
				<div class="content-wrap">
					<h3>Edit movie</h3>
					<form:form action="/admin/{session.id}/edit-session"
								modelAttribute="editSession" 
								method="POST">
						
						<form:hidden path="id"/>
						
						<form:hidden path="movie"/>
						
						<div class="form-group">
  							<label class="control-label">date</label>
							<form:input path="date" cssClass="form-control" title="Movie name" />\
							
  							<label class="control-label">time</label>
							<form:input path="date" cssClass="form-control" title="Movie name" />
											
					
							<label class="control-label">seats</label>
							<form:input path="availableSeats" cssClass="form-control" title="Technology" />
							
							<label class="control-label">price</label>
							<form:input path="price" cssClass="form-control" title="Start Date" />	
							
							<label class="control-label">hall</label>					
							<form:select path="hall" cssClass="form-control">
								<form:options  items="${hallSelectOptions}"/>
							</form:select>						
							
							
						</div>
						<div class="form-group">
							<span class="input-group-btn">
								<input type="submit" class="btn btn-primary" value="Edit session">
							</span>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>