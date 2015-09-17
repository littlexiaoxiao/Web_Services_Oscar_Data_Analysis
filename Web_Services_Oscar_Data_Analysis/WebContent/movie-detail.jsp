<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<jsp:include page="template-top.jsp" />

<!-- Main -->
<section id="main" class="container">
	<header>
		<h2>${ movie }</h2>
	</header>
	<div class="row">
		<div class="12u">
			<section class="box">
				<h3>Top Flickrs</h3>
				<div class="box alt">
					<div class="row no-collapse 50% uniform">
					<c:forEach var="picture" items="${imgUrls}" varStatus="loopStatus">
						<c:if test="${loopStatus.index < 9}">
						<div class="4u 6u(narrow) 12u(mobile)">
							<span class="image fit"><img src="${ picture }" alt="" /></span>
						</div>
						</c:if>
					</c:forEach>
					</div>
				</div>
			</section>
		</div>
	</div>
	
	<jsp:include page="simple.jsp" />

	<div class="row">
		<div class="12u">
			<!-- Lists -->
			<section class="box">
				<form method="post" action="PostTweet.do">
					<section>
						<h3>What do you like to tweet?</h3>
						<div class="12u">
							<textarea name="post" id="post" placeholder="#${ movieName } Enter your tweet here"
								rows="2"></textarea>
						</div>
						<input type="hidden" name="movieName" value="${ movieName }">
						<input type="hidden" name="movie" value="${ movie }"> 
						<div class="row uniform">
							<div class="12u">
								<input type="submit" value="Submit on Twitter" class="button special small"
									style="float: right; margin-top: 5px" />
							</div>
						</div>
					</section>
				</form>
			</section>
		</div>
	</div>
	
	<div class="row">
		<div class="12u">
			<section class="box" style="margin-bottom:7px">
			    <h3>
			        <strong>Top Tweets of ${ movie } </strong>
			    </h3>
			</section>
		</div>
	</div>
	
	<c:forEach var="status" items="${statuses}">
	<div class="row">
		<div class="12u">
			<section class="box" id="tweet">
					<section>
						<h4> ${ status.user.name } </h4>
						<h5> ${ status.text } </h5>
						<p> <b>Retweeted:</b> ${ status.retweetCount } times &nbsp;&nbsp; 
							<b>Favorited:</b> ${ status.favoriteCount } times
						</p>
						<div class="row uniform">
							<div class="12u">					
								<form method="post" action="replyTweet.do">
									<textarea name="comment" id="comment" placeholder="Enter your comment" rows="1"></textarea>
									<input type="hidden" id="hid" name="hiddenID" value=${status.id }>
									<input type="hidden" name="movieName" value="${ movieName }">
									<input type="hidden" name="movie" value="${ movie }"> 
									<input type="hidden" id="hid" name="hiddenName" value=${status.user.screenName }>
								<div class="2u 3u(narrower) 4u(mobile)" style="float:right;margin-top:0.7em;" >
									<input type="submit" value="Comment" class="button special small" style="float:right"/>
								</div>
								    
								</form>
								<form method="post" action="favoriteTweet.do">	
									<input type="hidden" id="hid" name="hiddenID" value=${status.id }>
									<input type="hidden" name="movieName" value="${ movieName }">
									<input type="hidden" name="movie" value="${ movie }"> 
								<div class="2u 3u(narrower) 4u(mobile) 5u(mobilep)" style="float:right;margin-top:-1.3em;margin-right:1em">
							    	<input type="submit" value="Like it!" class="button small" style="float:right"/>
								</div>
							    </form>
							</div>
						</div>
					</section>
			</section>
		</div>
	</div>
	</c:forEach>

</section>



<jsp:include page="template-bottom.jsp" />