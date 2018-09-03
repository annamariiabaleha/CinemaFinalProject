<%@ include file="/WEB-INF/taglib.jsp" %>


<!------ Include the above in your HEAD tag ---------->

<div class="container">
      <div class="row">
      <div>
       <!--  <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad" > -->
   
   
          <div class="panel panel-info">
            
            <div class="panel-body">
              <div class="row">
                <div class="col-md-3 col-lg-3 " align="center"> <img alt="User Pic" src="http://www.stanleydee.co.uk/wp-content/uploads/2015/12/movie-film-roll-clip-art-10-1024x896.jpg" class="img-circle img-responsive"> </div>
                
     
                <div class=" col-md-9 col-lg-9 "> 
                  <table class="table table-user-information">
                    <tbody>
                      <tr>
                        <td>Hall name:</td>
                        <td>${hall.name}</td>
                      </tr>
                      <tr>
                        <td>Information:</td>
                        <td>${hall.info}</td>
                      </tr>
                      <tr>
                        <td>Capacity:</td>
                        <td>${hall.capacity}</td>
                      </tr>
                     <tr>
                        <td>Seats in row:</td>
                        <td>${hall.seatsInRow}</td>
                      </tr>
                                                                 
                    </tbody>
                  </table>
                  
                  <a href="/admin/halls-list" class="btn btn-primary">Back to halls list</a>
                  <a href="/home" class="btn btn-primary">Home</a>
                </div>
              </div>
            </div>
                             
          </div>
        </div>
      </div>
    </div>