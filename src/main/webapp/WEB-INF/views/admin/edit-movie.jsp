<%@ include file="/WEB-INF/taglib.jsp" %>

<div class="row">
	<div class="col-md-4 col-md-offset-4">
		<div class="login-wrapper">
			<div class="box">
				<div class="content-wrap">
					<h3>Edit movie</h3>
					<form:form action="/admin/{movie.id}/edit-movie"
								modelAttribute="editMovie" 
								method="POST">
						
						<form:hidden path="id"/>
						
						
						<div class="form-group">
  							<label class="control-label">Movie name</label>
							<form:input path="name" cssClass="form-control" title="Movie name" />
							
							<label class="control-label">Min age</label>
  							<form:errors path="age" ></form:errors>	
							<form:input path="age" cssClass="form-control" title="Movie name" />
							
							<label class="control-label">Language</label>
  							<form:errors path="language" ></form:errors>	
							<form:input path="language" cssClass="form-control" title="Movie name" />
							
							<label class="control-label">Movie genre</label>
  							<form:errors path="genre" ></form:errors>	
							<form:input path="genre" cssClass="form-control" title="Movie name" />
							
							<label class="control-label">Duration</label>
  							<form:errors path="duration" ></form:errors>	
							<form:input path="duration" cssClass="form-control" title="Movie name" />
											
							<label class="control-label">Production</label>
  							<form:errors path="production" ></form:errors>	
							<form:input path="production" cssClass="form-control" title="Movie name" />
							
							<label class="control-label">Staring</label>
  							<form:errors path="staring" ></form:errors>	
							<form:input path="staring" cssClass="form-control" title="Movie name" />
											
							<label class="control-label">Information</label>
							<form:input path="info" cssClass="form-control" title="Information" />
					
							<label class="control-label">Technology</label>
							<form:input path="technology" cssClass="form-control" title="Technology" />
							
							<label class="control-label">Start date</label>
							<form:input path="startDate" cssClass="form-control" title="Start Date" />
							
							<label class="control-label">Finish Date</label>
							<form:input path="finishDate" cssClass="form-control" title="Finish Date" />
							
							
						</div>
						<div class="form-group">
							<span class="input-group-btn">
								<input type="submit" class="btn btn-primary" value="Edit movie">
							</span>
					
							<span class="input-group-btn">
								<input type="submit" class="btn btn-primary" value="Cancel" onclick="history.back()">
							</span>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>