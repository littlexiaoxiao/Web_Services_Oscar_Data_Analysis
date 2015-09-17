<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<jsp:include page="template-top.jsp" />

<!-- Main -->
<section id="main" class="container">
	<header>
		<h2>What did we find?</h2>
	</header>

<!--	<section class="box special features">
		<h3>Weekly Top Six Movies</h3>
		<div class="features-row">
		<c:forEach var="movie" items="${topMovies}" varStatus="count">
			<section>
				<h3>Top ${count.index+1} : ${ movie.name }</h3>
				<ul class="actions">
				    <li>
					    <form method="post" action="ShowMovieInfo.do">
					        <input type="hidden" name="movieName" value="${ movie.name }">
					        <input type="submit" class="button alt" value="Learn More">
					    </form>
					</li>
				</ul>
			</section>
		</c:forEach>
		</div>
	</section> -->

	<div class="row">
		<div class="12u">
			<section class="box">
				<section>
					<h3>How popular are the movies on Twitter and Flickr?</h3>
					<div id="flickrPieChartMoives"></div><br>
					<div id="twitterPieChartMoives"></div><br>
				</section>
 			</section>
		</div>
	</div>

	<div class="row">
		<div class="12u">
			<section class="box">
				<section>
					<h3>When do people discuss in our website on each movie?</h3>
					<div id="historyTrendOfOurWebsite"></div><br>
				</section>
			</section>
		</div>
	</div>

</section>

<jsp:include page="template-bottom.jsp"/>

	<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/docs.min.js"></script>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="js/ie10-viewport-bug-workaround.js"></script>

	<!-- Flickr Movies Trend PIE Chart javascript // added on FEB 8TH by Joven-------------------------------------------------->
	<script type="text/javascript" src="https://www.google.com/jsapi"></script>
  	 <script type="text/javascript">
      google.setOnLoadCallback(drawChart);
  function drawChart() {
 	var searchTotalFlicr = new Array();
 	var movieList = new Array();
 	<%
 	String[] searchTotalFlicrA = (String[])request.getAttribute("searchTotalFlicr");
 	String[] movieListA = (String[])request.getAttribute("movieList");
 	for(int count=0;count<10;count++){
 	%>
 		searchTotalFlicr[<%=count%>]=<%= searchTotalFlicrA[count]%>;
 		movieList[<%=count%>]= '<%= movieListA[count]%>';
 	<% } %>
 
 	var dataFlickr = google.visualization.arrayToDataTable([
       ['Flickr', 'Search Results of Top Oscar Movies'],
   	<%	for(int count=0;count<10;count++){ %>
 		[movieList[<%=count%>], searchTotalFlicr[<%=count%>]],
 	<% } %>
    ]);
 	
 	var optionsFlickr = {
    		  'legend':'left',
    		  'width':750,
              'height':340,
        title: 'Popular Movies on Flickr',
        is3D: true,
      };

      var chart = new google.visualization.PieChart(document.getElementById('flickrPieChartMoives'));     
      chart.draw(dataFlickr, optionsFlickr);
      }
  </script> 	
 
 	<!-- twitter Movies Trend PIE Chart javascript // added on FEB 14TH by Joven---------------------------------------------->
  <script type="text/javascript">
  google.setOnLoadCallback(drawChart);
      function drawChart() {
    	  var searchTotalTwitter = new Array();
    	  var movieList = new Array();   	  
    		<%
    	 	int[] searchTotalTwitterA = (int[])request.getAttribute("searchTotalTwitter");
    		String[] movieListB = (String[])request.getAttribute("movieList");
    	 	for(int count=0;count<10;count++){
    	 	%>
    	 	
    	 	searchTotalTwitter[<%=count%>]=<%=searchTotalTwitterA[count]%>;
    	 	movieList[<%=count%>]= '<%= movieListB[count]%>';
      	 	
      	 	<% }%>
       
      var dataTwitter = google.visualization.arrayToDataTable([
       ['Twitter', 'Search Results of Top Oscar Movies'],
    	<%	for(int count=0;count<10;count++){ %>
    	
 		[movieList[<%=count%>], searchTotalTwitter[<%=count%>]],
 		
 		<% } %>
   	 ]);

      var optionsTwitter = {
    		  'legend':'left',
    		  'width':750,
              'height':340,
        title: 'Popular Movies on Twitter',
        is3D: true,
      };

      var chart = new google.visualization.PieChart(document.getElementById('twitterPieChartMoives'));
      chart.draw(dataTwitter, optionsTwitter);
    }
  </script>
  
  <!-- Our webiste's Movies Trend PIE Chart javascript // added on FEB 14TH by Joven------------------------------------------------>
  <script type="text/javascript">
     google.load('visualization', '1.1', {packages: ['corechart','line']});
     google.setOnLoadCallback(drawChart);

    function drawChart() {
     var movieList = new Array(); 
      var historyTrendCount1 = new Array(); 
      var historyTrendCount2 = new Array(); 
      var historyTrendCount3 = new Array(); 
      var historyTrendCount4 = new Array(); 
      var historyTrendCount5 = new Array(); 
      var historyTrendCount6 = new Array(); 
      var historyTrendCount7 = new Array(); 
      var historyTrendCount8 = new Array(); 
      var historyTrendCount9 = new Array(); 
      var historyTrendCount10 = new Array();     
      <%
		String[] movieListC = (String[])request.getAttribute("movieList");
        int[] historyTrendMovie1 = (int[])request.getAttribute("historyTrendCount1");
        int[] historyTrendMovie2 = (int[])request.getAttribute("historyTrendCount2");
        int[] historyTrendMovie3 = (int[])request.getAttribute("historyTrendCount3");
        int[] historyTrendMovie4 = (int[])request.getAttribute("historyTrendCount4");
        int[] historyTrendMovie5 = (int[])request.getAttribute("historyTrendCount1");
        int[] historyTrendMovie6 = (int[])request.getAttribute("historyTrendCount6");
        int[] historyTrendMovie7 = (int[])request.getAttribute("historyTrendCount7");
        int[] historyTrendMovie8 = (int[])request.getAttribute("historyTrendCount8");
        int[] historyTrendMovie9 = (int[])request.getAttribute("historyTrendCount9");
        int[] historyTrendMovie10 = (int[])request.getAttribute("historyTrendCount10");
        
	 	for(int count=0;count<10;count++){
	    %>	  
	    movieList[<%=count%>]= '<%= movieListC[count]%>';	    
	    <% }%>
	  
	    <% for(int count=0;count < 7;count++){ %>
	 	historyTrendCount1[<%=count%>]= <%= historyTrendMovie1[count]%>;
	 	historyTrendCount2[<%=count%>]= <%= historyTrendMovie2[count]%>;
	 	historyTrendCount3[<%=count%>]= <%= historyTrendMovie3[count]%>;
	 	historyTrendCount4[<%=count%>]= <%= historyTrendMovie4[count]%>;
	 	historyTrendCount5[<%=count%>]= <%= historyTrendMovie5[count]%>;
	 	historyTrendCount6[<%=count%>]= <%= historyTrendMovie6[count]%>;
	 	historyTrendCount7[<%=count%>]= <%= historyTrendMovie7[count]%>;
	 	historyTrendCount8[<%=count%>]= <%= historyTrendMovie8[count]%>;
	 	historyTrendCount9[<%=count%>]= <%= historyTrendMovie9[count]%>;
	 	historyTrendCount10[<%=count%>]= <%= historyTrendMovie10[count]%>	 	
	  <% }%>
 	  
      var data = new google.visualization.DataTable();
      data.addColumn('number', 'The Last 7 Days');
      
     <% for(int count=0;count<10;count++){ %>
     
      data.addColumn('number', movieList[<%=count%>]);	
      
	<% } %>
	
	 data.addRows([
	               [1,  historyTrendCount1[6], historyTrendCount2[6], historyTrendCount3[6],historyTrendCount4[6],historyTrendCount5[6],historyTrendCount6[6],historyTrendCount7[6],historyTrendCount8[6],historyTrendCount9[6],historyTrendCount10[6]],                
	               [2,  historyTrendCount1[5], historyTrendCount2[5], historyTrendCount3[5],historyTrendCount4[5],historyTrendCount5[5],historyTrendCount6[5],historyTrendCount7[5],historyTrendCount8[5],historyTrendCount9[5],historyTrendCount10[5]],
	               [3,  historyTrendCount1[4], historyTrendCount2[4], historyTrendCount3[4],historyTrendCount4[4],historyTrendCount5[4],historyTrendCount6[4],historyTrendCount7[4],historyTrendCount8[4],historyTrendCount9[4],historyTrendCount10[4]],
	               [4,  historyTrendCount1[3], historyTrendCount2[3], historyTrendCount3[3],historyTrendCount4[3],historyTrendCount5[3],historyTrendCount6[3],historyTrendCount7[3],historyTrendCount8[3],historyTrendCount9[3],historyTrendCount10[3]],                 
	               [5,  historyTrendCount1[2], historyTrendCount2[2], historyTrendCount3[2],historyTrendCount4[2],historyTrendCount5[2],historyTrendCount6[2],historyTrendCount7[2],historyTrendCount8[2],historyTrendCount9[2],historyTrendCount10[2]],
	               [6,  historyTrendCount1[1], historyTrendCount2[1], historyTrendCount3[1],historyTrendCount4[1],historyTrendCount5[1],historyTrendCount6[1],historyTrendCount7[1],historyTrendCount8[1],historyTrendCount9[1],historyTrendCount10[1]],
	               [7,  historyTrendCount1[0], historyTrendCount2[0], historyTrendCount3[0],historyTrendCount4[0],historyTrendCount5[0],historyTrendCount6[0],historyTrendCount7[0],historyTrendCount8[0],historyTrendCount9[0],historyTrendCount10[0]],	                 	    	       	  	         	  	         	  	         	              
	               ]);
	
      var options = {
        chart: {
         subtitle: 'Tweets posted through our website'
        },
        width: 830,
        height: 450
      };

      var chart = new google.charts.Line(document.getElementById('historyTrendOfOurWebsite'));

      chart.draw(data, options);
    }
  </script>
 	
</body>
</html>
<!-- /footer -->