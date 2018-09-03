<%@ include file="/WEB-INF/taglib.jsp"%>
	<c:forEach items="${sessionList}" var="movie">
		<h1>${movie.key}</h1>
			<table id="mytable" class="table table-bordred table-striped">
							<thead>
								<th>ID</th>
								<th>Date</th>
								<th>Time</th>
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
										<td>${session.price}</td>
										<td>${session.hall.name}</td>
										<td>
											<a href="/admin/${session.id}/edit-session"><button
											class="btn btn-primary btn-xs" data-title="Edit"
											data-toggle="modal" data-target="#edit">
											<span class="glyphicon glyphicon-pencil"></span>
											</button> </a>
										</td>
										<td>
											<a href="/admin/${session.id}/delete-session"><button
											class="btn btn-danger btn-xs" data-title="Delete"
											data-toggle="modal" data-target="#delete">
											<span class="glyphicon glyphicon-trash"></span>
											</button> </a>
										</td>
										</tr>
								</c:forEach>
					</tbody>
			</table>
</c:forEach>