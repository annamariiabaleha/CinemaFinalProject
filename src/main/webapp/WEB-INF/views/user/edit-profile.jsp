<%@ include file="/WEB-INF/taglib.jsp" %>

<div class="row">
	<div class="col-md-4 col-md-offset-4">
		<div class="login-wrapper">
			<div class="box">
				<div class="content-wrap">
					<h3>Add movie page</h3>
					<form:form action="/user/{userId}/edit-profile"
					modelAttribute="userModel" 
					method="POST"
					enctype="multipart/form-data">
						
						<form:hidden path="id"/>
						
						<div class="form-group">
  							<label class="control-label"> name</label>
							<form:input path="email" cssClass="form-control" title="Movie name" />
								
							<label class="control-label">Upload image</label>
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