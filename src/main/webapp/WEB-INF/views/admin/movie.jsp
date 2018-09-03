<%@ include file="/WEB-INF/taglib.jsp" %>


<!------ Include the above in your HEAD tag ---------->

<div class="container">
      <div class="row">
      <div>
       <!--  <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad" > -->
   
   
          <div class="panel panel-info">
            
            <div class="panel-body">
              <div class="row">
                <div class="col-md-3 col-lg-3 " align="center"> 
                <img alt="User Pic" src="http://www.stanleydee.co.uk/wp-content/uploads/2015/12/movie-film-roll-clip-art-10-1024x896.jpg" class="img-circle img-responsive"> </div>
                
     
                <div class=" col-md-9 col-lg-9 "> 
                  <table class="table table-user-information">
                    <tbody>
                      <tr>
                        <td>Movie name:</td>
                        <td>${movie.name}</td>
                      </tr>
                      <tr>
                        <td>Information:</td>
                        <td>${movie.info}</td>
                      </tr>
                      <tr>
                        <td>Technology:</td>
                        <td>${movie.technology}</td>
                      </tr>
                   
                         <tr>
                             <tr>
                        <td>Start date:</td>
                        <td>${movie.startDate}</td>
                      </tr>
                        <tr>
                        <td>Finish date:</td>
                        <td>${movie.finishDate}</td>
                      </tr>
                                           
                    </tbody>
                  </table>
                  
                  <a href="/admin/movies-list" class="btn btn-primary">Back to movies list</a>
                  <a href="/admin/${movie.id}/edit-movie" class="btn btn-primary">Edit movie</a>
                  <a href="/${movie.id}/movie-details" class="btn btn-primary">How user see it</a>                  
                  <a href="/home" class="btn btn-primary">Home</a>
                </div>
              </div>
            </div>
                             
          </div>
        </div>
      </div>
    </div>