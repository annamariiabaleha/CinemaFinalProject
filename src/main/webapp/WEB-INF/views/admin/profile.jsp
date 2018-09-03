<%@ include file="/WEB-INF/taglib.jsp" %>

<style>
<!--
figure.snip1139 {
  font-family: 'Raleway', Arial, sans-serif;
  position: relative;
  float: left;
  overflow: hidden;
  margin: 10px 1%;
  min-width: 220px;
  max-width: 310px;
  width: 100%;
  color: #333;
  text-align: left;
  box-shadow: 0 0 5px rgba(0, 0, 0, 0.15);
  border-radius: 8px;
}
figure.snip1139 * {
  -webkit-box-sizing: border-box;
  box-sizing: border-box;
  -webkit-transition: all 0.35s cubic-bezier(0.25, 0.5, 0.5, 0.9);
  transition: all 0.35s cubic-bezier(0.25, 0.5, 0.5, 0.9);
}
figure.snip1139 img {
  max-width: 100%;
  vertical-align: middle;
}
figure.snip1139 blockquote {
  position: relative;
  background-color: #ffffff;
  padding: 25px 50px 25px 50px;
  font-size: 0.8em;
  font-weight: 500;
  text-align: left;
  margin: 0;
  line-height: 1.6em;
  font-style: italic;
}
figure.snip1139 blockquote:before,
figure.snip1139 blockquote:after {
  font-family: 'FontAwesome';
  content: "\201C";
  position: absolute;
  font-size: 50px;
  opacity: 0.3;
  font-style: normal;
}
figure.snip1139 blockquote:before {
  top: 25px;
  left: 20px;
}
figure.snip1139 blockquote:after {
  content: "\201D";
  right: 20px;
  bottom: 0;
}
figure.snip1139 .arrow {
  top: 100%;
  width: 0;
  height: 0;
  border-left: 0 solid transparent;
  border-right: 25px solid transparent;
  border-top: 25px solid #ffffff;
  margin: 0;
  position: absolute;
}
figure.snip1139 .author {
  position: absolute;
  bottom: 0;
  width: 100%;
  padding: 5px 25px;
  color: #000000;
  background-color: #ffffff;
  margin: 0;
  text-transform: uppercase;
}
figure.snip1139 .author h5 {
  opacity: 0.8;
  margin: 0;
  font-weight: 800;
}
figure.snip1139 .author h5 span {
  font-weight: 400;
  text-transform: none;
  padding-left: 5px;
}
-->
</style>

<figure class="snip1139">
  <blockquote> May the Force be with you
    <div class="arrow"></div>
  </blockquote>
  <img src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/331810/sample3.jpg" alt="sample3"/>
  <div class="author">
    <h5 > Yoda <span>- Star Wars</span></h5>
  </div>
</figure>

  <div class="row">
    <div class="span4">
      <blockquote>
        <p> Administrators page </p>
        <small><cite title="Source Title"> Lviv, Ukraine  <i class="glyphicon glyphicon-map-marker"></i></cite></small>
      </blockquote>
      <p>
        <i class="glyphicon glyphicon-envelope"></i> ${adminProfile.email} <br>
        <i class="icon-globe"></i> www.cinemacity.com <br>
        <i class="glyphicon glyphicon-phone"></i> 0987130067 
      </p>
      
      <p>
      	<a href="admin/add-movie" class="btn btn-info">Add movie</a>
      	<a href="admin/add-session" class="btn btn-info">Add session</a>
      	<a href="admin/add-hall" class="btn btn-info">Add hall</a>
      	<a href="admin/movies-list" class="btn btn-info">Show movies list</a>
      	<a href="admin/halls-list" class="btn btn-info">Show halls list</a>
      	<a href="admin/session-list" class="btn btn-info">Show session list</a>
      </p>
    </div>
 </div>