<%@ include file="/WEB-INF/taglib.jsp" %>

<div class="row">
	<div class="col-md-4 col-md-offset-4">
		<div class="login-wrapper">
			<div class="box">
				<div class="content-wrap">
					<h3>Add session</h3>
					<form:form action="/admin/add-session"
					modelAttribute="addSessionModel" method="POST">
						
						<div class="form-group">
  							<label class="control-label">date</label>
							<form:input path="date" cssClass="form-control" title="Movie name" />
							
  							<label class="control-label">time</label>
							<form:input path="time" cssClass="form-control" title="Movie name" />
							<%-- 
							<label class="control-label">seats</label>
							<form:input path="availableSeats" cssClass="form-control" title="Technology" /> --%>
							
							<label class="control-label">price</label>
							<form:input path="price" cssClass="form-control" title="Start Date" />	
							
							<label class="control-label">movie</label>
							<form:select path="movie" cssClass="form-control">
								<form:option value="NONE" label = "Select movie" disabled="true" selected = "true"/>
								<form:options items="${movieSelectOption}"/>
							</form:select>
							
							<label class="control-label">hall</label>					
							<form:select path="hall" cssClass="form-control">
								<form:option  value="NONE" label = "Select hall" disabled="true" selected = "true"/>
								<form:options  items="${hallSelectOptions}"/>
							</form:select>
							

							
							
						</div>
						<div class="form-group">
							<span class="input-group-btn">
								<input type="submit" class="btn btn-primary" value="Add session">
							</span>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>