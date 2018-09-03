<%@ include file="/WEB-INF/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<style>
		.price {
			display: none;
		}
		.asession:hover + .price {
			display: inline-block !important;
		}
		.asession {
			background-color: skyblue;
			margin: 5px;
			padding: 5px;
		}
		body {
			background-size: cover;
  			background-position: center;
  			background-repeat: no-repeat;
		    font-family: "Lato", sans-serif;
			background-image: url("https://www.hunterandbligh.com.au/wp-content/uploads/2017/09/Cinema_blue.jpg"); 
			/* background-image: url("https://www.newstatesman.com/sites/default/files/styles/nodeimage/public/blogs_2014/09/2014_34drivein.jpg?itok=7O9F7TxQ"); */ 
		   }
		.sidenav {
		    width: 15%;
		    position: fixed;
		    z-index: 1;
		    top: 80px;
		    left: 10px;
		    overflow-x: hidden;
		    padding: 8px 10px;
		}
		.sidenav1 {
		    width: 30%;
		    position: fixed;
		    z-index: 1;
		    top: 80px;
		    right: 10px;
		    background: #eee;
		    overflow-x: hidden;
		    padding: 15px;
		}
		.sidenav a {
		    padding: 6px 8px 6px 16px;
		    text-decoration: none;
		    font-size: 25px;
		    color: #2196F3;
		    display: block;
		}
		.sidenav a:hover {
		    color: #064579;
		}
		.main {
			width: 55%;
			margin-top:20px;
		    margin-left: 12%; /* Same width as the sidebar + left position in px */
		    font-size: 28px; /* Increased text to enable scrolling */
		    padding: 0px 10px;
		    /* background-color:rgb(0,0,0);opacity:0.6; */
		    color: white;
		}
		@media screen and (max-height: 450px) {
		    .sidenav {padding-top: 15px;}
		    .sidenav a {font-size: 18px;}
		}
	</style>
</head>
<body>
	<div class="sidenav">
		<img width="95%" height="auto" src="data:image/png; base64, ${movie.imagePath}" />
	  	<a href="#about">Trailer</a>
	  	<a href="#contact">Contact</a>
	</div>
	
	<div class="main">
	 	<h1>${movie.name}</h1> 
	 	<br>
	  	<p> <table class="table table-user-information">			
			<tbody>
			
				<tr>
	                <td>Min age:</td>
	            	<td>${movie.age}</td>
	            </tr>
	            
	            <tr>
	                <td>Language:</td>
	            	<td>${movie.language}</td>
	            </tr>
	            
	            <tr>
	                <td>Movie duration:</td>
	            	<td>${movie.duration}</td>
	            </tr>
	            
	            <tr>
	                <td>Genres</td>
	            	<td>${movie.genre}</td>
	            </tr>
	            
	            <tr>
	                <td>Production:</td>
	            	<td>${movie.production}</td>
	            </tr>			
				
	            <tr>
	                <td>Technology:</td>
	            	<td>${movie.technology}</td>
				</tr>
				<tr>
	                <td>Start date:</td>
	            	<td>${movie.startDate}</td>
	            </tr>
	            <tr>
	                <td>Finish date:</td>
	            	<td>${movie.finishDate}</td>
	        	</tr>            
	        	
	        	<tr>
	                <td>Staring:</td>
	            	<td>${movie.staring}</td>
	            </tr>
	            	
	            <tr>
	                <td>Information:</td>
	            	<td>${movie.info}</td>
	            </tr>
	    	</tbody>
		</table> 	                 
	</div>  
	
	<div class="sidenav1">
		<h1 align="center">Show times: </h1>
		<h5 style="font-style: italic;">To choose seats click on the show time</h5>
		<c:forEach items="${sessionsByDate}" var="entry">
			<p>${entry.key}</p>
			<c:forEach items="${entry.value}" var="session">
				<a href="/${session.id}/seats-selection" class="asession"> ${session.time} </a>
				<div class="price">${session.price}</div>
			</c:forEach>
		</c:forEach>
	</div>  	
</body>
</html> 
