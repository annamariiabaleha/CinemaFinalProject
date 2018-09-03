<%@ include file="/WEB-INF/taglib.jsp" %>
    <style>
    
    	.btnOrder {
    		margin-top: 10px;
    		width: 100%;
    	}
    
   		.container-fluid {
   			margin: 20px;
   		}
   
    	.padding-around {
    		padding: 10px;
    		display: inline-grid;
    	}
    	.seat {    	
    		background-color: blue;
    		width: 35px;
    		height: 35px;
    		border-radius: 12px;
		    cursor:pointer;
		    overflow:hidden;
	  	}
		.seat > input{
		    display:none;
		}
	  	.seatChosen, .seatNumber {			
    		background-color: orange;
    		color: white;
    		font-size: 18pt;
    		text-align: center;
    		width: 35px;
    		height: 35px;
    		border-radius: 12px;
		    cursor:pointer;
		    overflow:hidden;
	  	}
	  	.seat > .seatChosen,.seat > .seatNumber{
		    position:absolute;
		    opacity:0;
		    transition:.3s;
		}	  
		.seat:hover > .seatNumber,.seat > input:checked + .seatNumber + .seatChosen{
		    opacity:1;
		}  
	  	.seat > input:checked + .seatNumber {
	    	opacity:0;
	  	}
    </style>

<div class="container-fluid">
	<div class="row">
				
		<div class="col-md-8">
			<c:forEach var="seatRow" begin="0" end="${ticket.session.hall.capacity / ticket.session.hall.seatsInRow - 1}">
				<div "row">
					Row ${seatRow + 1} :
					<c:forEach var="seat" begin="0" end="${ticket.session.hall.seatsInRow - 1}">
						<div class="padding-around">
							<label class="seat">
								<input 	type="checkbox" name="test" 
									disabled = "true"
									<c:choose>
										<c:when test="${fn:substring(ticket.session.seats, 
														seatRow * ticket.session.hall.capacity / ticket.session.hall.seatsInRow + seat, 
														seatRow * ticket.session.hall.capacity / ticket.session.hall.seatsInRow + seat + 1)
														!= 'f' }">
											checked
										</c:when>
									</c:choose>
								/>
								<div class="seatNumber">
									${seat + 1}
								</div>
								<img class="seatChosen" alt="C" src="https://openclipart.org/image/2400px/svg_to_png/190113/1389952697.png">
							</label>
						</div>
					</c:forEach>
				</div>
			</c:forEach>
		</div>
		
		<div class="col-md-4">
			
			<form:form action="/${sessionId}/seats-selection"
				method="POST"
				modelAttribute="ticket"
			>
				<form:hidden path="id"/>
				<form:hidden path="session" />
				<label class="control-label">Choose seat</label>					
				<form:select path="row" cssClass="form-control">
					<form:options  items="${seatsMap}"/>
				</form:select>
				
					
			 	<input type="submit" value="Order" class="btn btn-success btnOrder">
			 </form:form>
		</div>
	</div>
</div>