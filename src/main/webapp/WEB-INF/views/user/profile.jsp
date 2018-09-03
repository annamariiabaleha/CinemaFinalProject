<%@ include file="/WEB-INF/taglib.jsp" %>
<<style>
<!--
img {
max-width: 200px;
}
-->
</style>

<div class="container">
<div class="row">
<figure class="snip1139">
  <blockquote>Enter here your favorite movie blackquote
    <div class="arrow"></div>
  </blockquote>
  <img src="data:image/png; base64, ${userProfile.imagePath}"/>
  <div class="author">
    <h5 > Who said <span>- Movie name</span></h5>
  </div>
</figure>
</div>
  <div class="row">
    <div class="span4">
      <blockquote>
      	
        <p>${userProfile.firstName} ${userProfile.lastName}  </p>
        <small><cite title="Source Title">${userProfile.city}, ${userProfile.country}  <i class="glyphicon glyphicon-map-marker"></i></cite></small>
      </blockquote>
      <p>
      <i class="hidden">${userProfile.id}</i>
        <i class="glyphicon glyphicon-envelope"></i> ${userProfile.email} <br>
        <i class="icon-globe"></i> www.bootsnipp.com <br>
        <i class="glyphicon glyphicon-gift"></i> ${userProfile.dateOfBirth} <br>
        <i class="glyphicon glyphicon-phone"></i> ${userProfile.phoneNumber} 
      </p>
    </div>
 </div>
 
 <p>
     <a href="/user/${userProfile.id}/edit-profile" class="btn btn-warning"> Edit profile</a>
</p>
 </div>  
 
   
   
   
 