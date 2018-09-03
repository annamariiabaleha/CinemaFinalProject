<%@ include file="/WEB-INF/taglib.jsp" %>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<script type="text/javascript">

var $item = $('.carousel .item'); 
var $wHeight = $(window).height();
$item.eq(0).addClass('active');
$item.height($wHeight); 
$item.addClass('full-screen');

$('.carousel img').each(function() {
  var $src = $(this).attr('src');
  var $color = $(this).attr('data-color');
  $(this).parent().css({
    'background-image' : 'url(' + $src + ')',
    'background-color' : $color
  });
  $(this).remove();
});

$(window).on('resize', function (){
  $wHeight = $(window).height();
  $item.height($wHeight);
});

$('.carousel').carousel({
  interval: 6000,
  pause: "false"
});
</script>

<style>
<!-- 
.containsAll {
	background-color: black;
}
h3 {
  display: inline-block;
  padding: 10px;
  background: white;
  border-top-left-radius: 10px;
  border-top-right-radius: 10px;
}

.full-screen {
  background-size: cover;
  background-position: center;
  background-repeat: no-repeat;
}

.col-md-3 {
	padding: 25px;
}
img {
    display: block;
    margin-left: auto;
    margin-right: auto;
}

figcaption {
	text-align: center;
}
-->
</style>
<div class = "contaonAll">
	<div class = "row row1">

	<div id="mycarousel" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#mycarousel" data-slide-to="0" class="active"></li>
    <li data-target="#mycarousel" data-slide-to="1"></li>
    <li data-target="#mycarousel" data-slide-to="2"></li>
    <li data-target="#mycarousel" data-slide-to="3"></li>
    <li data-target="#mycarousel" data-slide-to="4"></li>
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner" role="listbox">
    <div class="item">
        <img src="https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/hbz-peter-rabbit-index-1516221574.jpg" 
        data-color="lightblue" alt="Peter-Rabbit">
        <div class="carousel-caption">
            <a href="1/movie-details">
            <h3>Peter-Rabbit</h3>
            </a>
        </div>
    </div>
    
    <div class="item">
        <img src="https://getbg.net/upload/full/www.GetBg.net_2017Movies_Logo_of_the_new_film_Tomb_Raider._Lara_Croft__2018_119653_.jpg" 
        data-color="firebrick" alt="Second Image">
        <div class="carousel-caption">
            <a href="2/movie-details">
            <h3>Tomb Rider</h3>
            </a>
        </div>
    </div>
    <div class="item">
        <img src="https://i2.wp.com/www.seenit.co.uk/wp-content/uploads/I_KILL_GIANTS_QUAD.jpg?resize=2000%2C1500" 
        data-color="violet" alt="Third Image">
        <div class="carousel-caption">
            <a href="3/movie-details">
            <h3>I kill giants</h3>
            </a>
        </div>
    </div>
    <div class="item">
        <img src="https://itc.ua/wp-content/uploads/2018/02/Deadpool-2.jpg" 
        data-color="lightgreen" alt="Fourth Image">
        <div class="carousel-caption">
        	<a href="3/movie-details">
            	<h3>Deadpool - 2</h3>
            </a>
        </div>
    </div>
    <div class="item">
        <img src="https://i.ytimg.com/vi/3WPiTIMNlDk/maxresdefault.jpg" 
        data-color="tomato" alt="Fifth Image">
        <div class="carousel-caption">
            <a href="5/movie-details">
            	<h3>The Incredibles 2</h3>
            </a>
        </div>
    </div>
  </div>

  <!-- Controls -->
  <a class="left carousel-control" href="#mycarousel" role="button" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#mycarousel" role="button" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>
<script>
    var $item = $('.carousel .item'); 
var $wHeight = $(window).height();
$item.eq(0).addClass('active');
$item.height($wHeight); 
$item.addClass('full-screen');

$('.carousel img').each(function() {
  var $src = $(this).attr('src');
  var $color = $(this).attr('data-color');
  $(this).parent().css({
    'background-image' : 'url(' + $src + ')',
    'background-color' : $color
  });
  $(this).remove();
});

$(window).on('resize', function (){
  $wHeight = $(window).height();
  $item.height($wHeight);
});

$('.carousel').carousel({
  interval: 6000,
  pause: "false"
});
</script>
</div>	




<!-- <div class="container-fluid">
    <div class="row">
   		<div class="col-md-10 col-md-offset-0">
    		
    	</div>
    </div> -->

  <div class="panel-body">
    <div class="row">
    	<h2 class="text-center">Movies list</h2>
    	<c:forEach items="${moviesList}" var="movie">
    		
    		<div class="col-md-3 col-sm-6">
    		<a href="${movie.id}/movie-details">	
    				<figure>	
    				<img width="160" height="236" src="data:image/png; base64, ${movie.imagePath}" />
    				<figcaption> ${movie.name} </figcaption>
    				</figure>
    		</a>
    		</div>
    		
    		
    		
    	</c:forEach>
    </div>
  </div>
</div>