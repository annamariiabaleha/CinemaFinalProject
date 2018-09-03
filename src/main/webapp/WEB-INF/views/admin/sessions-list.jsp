 <%@ include file="/WEB-INF/taglib.jsp"%>
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<style>
<!--
h3 {
	color: #fff;
	font-size: 24px;
	text-align: center;
	margin-top: 30px;
	padding-bottom: 30px;
	border-bottom: 1px solid #eee;
	margin-bottom: 30px;
	font-weight: 300;
}

.container {
	max-width: 970px;
}

div[class*='col-'] {
	padding: 0 30px;
}

.wrap {
	box-shadow: 0px 2px 2px 0px rgba(0, 0, 0, 0.14), 0px 3px 1px -2px
		rgba(0, 0, 0, 0.2), 0px 1px 5px 0px rgba(0, 0, 0, 0.12);
	border-radius: 4px;
}

a:focus, a:hover, a:active {
	outline: 0;
	text-decoration: none;
}

.panel {
	border-width: 0 0 1px 0;
	border-style: solid;
	border-color: #fff;
	background: none;
	box-shadow: none;
}

.panel:last-child {
	border-bottom: none;
}

.panel-group>.panel:first-child .panel-heading {
	border-radius: 4px 4px 0 0;
}

.panel-group .panel {
	border-radius: 0;
}

.panel-group .panel+.panel {
	margin-top: 0;
}

.panel-heading {
	background-color: #0072AE;
	border-radius: 0;
	border: none;
	color: #fff;
	padding: 0;
}

.panel-title a {
	display: block;
	color: #fff;
	padding: 15px;
	position: relative;
	font-size: 22px;
	font-weight: 400;
}

.panel-body {
	background: #fff;
}

.panel:last-child .panel-body {
	border-radius: 0 0 4px 4px;
}

.panel:last-child .panel-heading {
	border-radius: 0 0 4px 4px;
	transition: border-radius 0.3s linear 0.2s;
}

.panel:last-child .panel-heading.active {
	border-radius: 0;
	transition: border-radius linear 0s;
}
/* #bs-collapse icon scale option */
.panel-heading a:before {
	content: '\e146';
	position: absolute;
	font-family: 'Material Icons';
	right: 5px;
	top: 10px;
	font-size: 24px;
	transition: all 0.5s;
	transform: scale(1);
}

.panel-heading.active a:before {
	content: ' ';
	transition: all 0.5s;
	transform: scale(0);
}

#bs-collapse .panel-heading a:after {
	content: ' ';
	font-size: 24px;
	position: absolute;
	font-family: 'Material Icons';
	right: 5px;
	top: 10px;
	transform: scale(0);
	transition: all 0.5s;
}

#bs-collapse .panel-heading.active a:after {
	content: '\e909';
	transform: scale(1);
	transition: all 0.5s;
}
/* #accordion rotate icon option */
#accordion .panel-heading a:before {
	content: '\e316';
	font-size: 24px;
	position: absolute;
	font-family: 'Material Icons';
	right: 5px;
	top: 10px;
	transform: rotate(180deg);
	transition: all 0.5s;
}

#accordion .panel-heading.active a:before {
	transform: rotate(0deg);
	transition: all 0.5s;
}
-->
</style>

<div class="container">
	<c:forEach items="${sessionList}" var="movie">
		<div class="col-md-12 col-sm-12 col-xs-12">
			<div class="panel-group wrap" id="bs-collapse">
			
			<div class="panel">
				<div class="panel-heading">
					<h4 class="panel-title">
						<a data-toggle="collapse" data-parent="#bs-collapse" href="#one">
							<%-- <c:forEach items="{allMoviesList}" var="movie">
								{movie.name} 
							</c:forEach> --%>
							${movie.key} 
						</a>
					</h4>
				</div>
				<div id="one" class="panel-collapse collapse">
					<div class="panel-body">
						<table id="mytable" class="table table-bordred table-striped">

							<thead>
								<th>ID</th>
								<th>Date</th>
								<th>Time</th>
								<th>Available seats</th>
								<th>Price</th>
								<th>Hall</th>
								<th>Edit</th>
								<th>Delete</th>
							</thead>
							<tbody>
								<c:forEach items="${movie.value}" var="session">
									<tr>
										<!--  <td><input type="checkbox" class="checkthis" /></td> -->
										<td>${session.id}</td>
										<td>${session.date}</td>
										<td>${session.time}</td>
										<td>${session.availableSeats}</td>
										<td>${session.price}</td>
										<td>${session.hall.name}</td>
										<td><p data-placement="top" data-toggle="tooltip"
												title="Edit">
												<a href="/admin/${session.id}/edit-session"><button
														class="btn btn-primary btn-xs" data-title="Edit"
														data-toggle="modal" data-target="#edit">
														<span class="glyphicon glyphicon-pencil"></span>
													</button> </a>
											</p></td>
										<td><p data-placement="top" data-toggle="tooltip"
												title="Delete">
												<a href="/admin/${session.id}/delete-session"><button
														class="btn btn-danger btn-xs" data-title="Delete"
														data-toggle="modal" data-target="#delete">
														<span class="glyphicon glyphicon-trash"></span>
													</button> </a>
											</p></td>
									</tr>
								</c:forEach>


							</tbody>

						</table>
					</div>
				</div>

			</div>
			<!-- end of panel -->
			
			</div>
			<!-- end of #bs-collapse  -->

		</div>


	</c:forEach>
	</div>
	<!-- end of container --> 
	
