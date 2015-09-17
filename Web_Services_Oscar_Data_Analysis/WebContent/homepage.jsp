<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<jsp:include page="template-top.jsp" />

<!-- Main -->
<section id="main" class="container">
	<header>
		<h2>Welcome to Oscars Top Hits 2015!</h2>
	</header>
<!--  <div class="row">
		<div class="12u"> -->	
			<section class="box special">
				<header class="major">
					<h3>
						The Academy Award 2015 is around the corner! <br /> Which movie
						is your favorite?
					</h3>
					<p>Find out what are people discussing about the top movies
						on Twitter and Flickr!</p>
					<form method="post" action="movieList.do">
						<input type="submit" class="button special" name="movieList" value="Oscars Top Movies">
					</form>
				</header>
				
			 	<span class="image featured">
					<ul class="slides">
					    <input type="radio" name="radio-btn" id="img-1" checked />
					    <li class="slide-container">
							<div class="slide">
								<img src="images/0.jpg" />
							</div>
							<div class="nav">
								<label for="img-9" class="prev">&#x2039;</label>
								<label for="img-2" class="next">&#x203a;</label>
							</div>
						</li>
					<c:forEach var="movie" items="${movieList}" varStatus="loopStatus">
					<c:if test="${loopStatus.index < 7}">
					    <input type="radio" name="radio-btn" id="img-${loopStatus.index+2}" />
					    <li class="slide-container">
							<div class="slide">
								<img src="images/${loopStatus.index+1}.jpg"/>
							</div>
							<div class="nav">
								<label for="img-${loopStatus.index+1}" class="prev">&#x2039;</label>
								<label for="img-${loopStatus.index+3}" class="next">&#x203a;</label>
							</div>
						</li>
					</c:if>
					</c:forEach>
					    <input type="radio" name="radio-btn" id="img-9" />
					    <li class="slide-container">
							<div class="slide">
								<img src="images/8.jpg" />
							</div>
							<div class="nav">
								<label for="img-8" class="prev">&#x2039;</label>
								<label for="img-1" class="next">&#x203a;</label>
							</div>
						</li>
						<li class="nav-dots">
					<c:forEach var="movie" items="${movieList}" varStatus="loopStatus">
					<c:if test="${loopStatus.index < 9}">
					<!--    <a href="" class="nav-pic" id="pic-${loopStatus.index+1}">
					      <img src="images/${loopStatus.index}.jpg" class="nav-pic" id="pic-${loopStatus.index+1}"/>
					    </a>  -->
						  <label for="img-${loopStatus.index+1}" class="nav-dot" 
						     id="img-dot-${loopStatus.index+1}"></label>
					</c:if>
					</c:forEach>
					    </li>
					</ul>
				</span> 
			</section>
<!--		</div>
 	</div>  -->

	
	<section class="box special features">
		<div class="features-row">
				<!-- 	<section>
				<span class="icon major fa-bolt accent2"></span>
				<h3>Weekly Top Four Movies</h3>
				<p>We rank the top four favorite movies every week based on our users comments.</p>
				<ul class="actions">
					<li>
						<form method="post" action="AnalyzeTrend.do">
							<input type="submit" class="button alt" value="Learn More">
						</form>
					</li>
				</ul>
			</section>  -->
			<section>
				<span class="icon major fa-bolt accent2"></span>
				<h3>How popular are the movies?</h3>
				<p>We draw diagrams to show how many times each movie is mentioned on Twitter and Flickr.</p>
				<ul class="actions">
					<li>
						<form method="post" action="AnalyzeTrend.do">
							<input type="submit" class="button alt" value="Learn More">
						</form>
					</li>
				</ul>
			</section>
			<section>
				<span class="icon major fa-area-chart accent3"></span>
				<h3>When do most people discuss?</h3>
				<p>We draw a chart to show how many tweets each movie has every day in the past week.</p>
				<ul class="actions">
					<li>
						<form method="post" action="AnalyzeTrend.do">
							<input type="submit" class="button alt" value="Learn More">
						</form>
					</li>
				</ul>
			</section>
		</div>
		<div class="features-row">
			<section>
				<span class="icon major fa-cloud accent4"></span>
				<h3>Participate in discussion on Twitter!</h3>
				<p>We enable you to post tweets and make comment on others' tweets of each movie.</p>
				<ul class="actions">
					<li>
						<form method="post" action="movieList.do">
							<input type="submit" class="button alt" value="Learn More">
						</form>
					</li>
				</ul>
			</section>
			<section>
				<span class="icon major fa-lock accent5"></span>
				<h3>What words are frequently used?</h3>
				<p>We create a word cloud to show what words are most frequently used to describe each movie.</p>
				<ul class="actions">
					<li>
						<form method="post" action="movieList.do">
							<input type="submit" class="button alt" value="Learn More">
						</form>
					</li>
				</ul>
			</section>
		</div>
	</section>

</section>

<jsp:include page="template-bottom.jsp" />