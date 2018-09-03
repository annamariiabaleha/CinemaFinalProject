<%@ include file="/WEB-INF/taglib.jsp" %>

<style>
<!--

	.btnS {
		width: 150px;
	}
	.buttonSumbit{
		text-align: right;
	}
	
	.container {
		width: 60%;
	}
	
	.row {
	margin-top:20px;
	display: block;
	background-color: beige;
	
	}
-->
</style>

<div class = "container">
	<div class="row">
		<table class="table">
    <thead>
      <tr>
        <th>Movie name:</th>
        <th> ${ticket.session.movie.name}</th>
        <th></th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>Date: </td>
        <td>${ticket.session.date}</td>
        <td>Time: </td>
        <td>${ticket.session.time}</td>
      </tr>
      <tr>
        <td>Hall number: </td>
        <td>${ticket.session.hall.info}</td>
      </tr>
      
      <tr>
        <td>Row: </td>
        <td>${ticket.row}</td>
        <td>Seat: </td>
        <td>${ticket.seat}</td>
      </tr>
      <tr>
        <td>Price</td>
        <td>${ticket.session.price}</td>
        <td></td>
      </tr>
      
      <tr>
      	
      </tr>
    </tbody>
  </table>
	</div>
	
	<div class = "buttonSumbit">
		<form:form action="/${ticketId}/ticket-submit" modelAttribute="ticket"
		method="POST">

		<form:hidden path="id" />
		<br>
		<form:hidden path="session" />
		<form:hidden path="row" />
		<form:hidden path="seat" />
		<input type="submit" value="Submit" class="btn btn-success btnS">

	</form:form>
	</div>	
</div>