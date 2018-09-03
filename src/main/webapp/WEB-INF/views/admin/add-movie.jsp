<%@ include file="/WEB-INF/taglib.jsp" %>

<div class="row">
	<div class="col-md-4 col-md-offset-4">
		<div class="login-wrapper">
			<div class="box">
				<div class="content-wrap">
					<h3>Add movie page</h3>
					<form:form action="/admin/add-movie"
					modelAttribute="uploadModel" 
					method="POST"
					enctype="multipart/form-data">
						
						<div class="form-group">
  							<label class="control-label">Movie name</label>
  							<form:errors path="movie.name" ></form:errors>	
							<form:input path="movie.name" cssClass="form-control" title="Movie name" />
							
							<label class="control-label">Min age</label>
  							<form:errors path="movie.age" ></form:errors>	
							<form:input path="movie.age" cssClass="form-control" title="Movie name" />
							
							<label class="control-label">Language</label>
  							<form:errors path="movie.language" ></form:errors>	
							<form:input path="movie.language" cssClass="form-control" title="Movie name" />
							
							<label class="control-label">Movie genre</label>
  							<form:errors path="movie.genre" ></form:errors>	
							<form:input path="movie.genre" cssClass="form-control" title="Movie name" />
							
							<label class="control-label">Duration</label>
  							<form:errors path="movie.duration" ></form:errors>	
							<form:input path="movie.duration" cssClass="form-control" title="Movie name" />
											
							<label class="control-label">Production</label>
  							<form:errors path="movie.production" ></form:errors>	
							<form:input path="movie.production" cssClass="form-control" title="Movie name" />
							
							<label class="control-label">Staring</label>
  							<form:errors path="movie.staring" ></form:errors>	
							<form:input path="movie.staring" cssClass="form-control" title="Movie name" />
											
							<label class="control-label">Information</label>
							<form:errors path="movie.info" ></form:errors>	
							<form:input path="movie.info" cssClass="form-control" title="Information" />
					
							<label class="control-label">Technology</label>
							<form:errors path="movie.technology" ></form:errors>	
							<form:input path="movie.technology" cssClass="form-control" title="Technology" />
							
							<label class="control-label">Start date</label>
							<form:errors path="movie.startDate" ></form:errors>	
							<form:input path="movie.startDate" cssClass="form-control" title="Start Date" />
							
							
							<label class="control-label">Finish Date</label>
							<form:errors path="movie.finishDate" ></form:errors>	
							<form:input path="movie.finishDate" cssClass="form-control" title="Finish Date" />
							
							<label class="control-label">Upload image</label>
							<form:errors path="file" ></form:errors>	
							<form:input path="file" type = "file" cssClass="form-control"/>
							
						</div>
						<div class="form-group">
							<span class="input-group-btn">
								<input type="submit" class="btn btn-primary" value="Add movie">
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