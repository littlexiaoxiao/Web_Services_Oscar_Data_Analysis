<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<jsp:include page="template-top.jsp" />

<!-- Main -->
<section id="main" class="container">
	<header>
		<h2>Top Movies of 2015 Oscars Nomonees</h2>
	</header>

	<div class="row">
		<c:forEach var="movie" items="${movieList}" varStatus="loopStatus">
			<c:if test="${loopStatus.index < 10}">
				<div class="6u 12u(narrower)">
					<section class="box special">
						<span class="image featured" id="movie"> <img id="movie"
							src="images/${ loopStatus.index+1 }.jpg" alt="" />
						</span>
						<h3>${ movie }</h3>
						<ul class="actions">
							<li>
								<form method="post" action="get-tweet.do">
									<input type="hidden" name="movie" value="${ movie }"> <input
										type="hidden" name="movieName"
										value="${ movieNameList[loopStatus.index] }"> <input
										type="submit" class="button alt" value="Learn More">
								</form>
							</li>
						</ul>
					</section>
				</div>
			</c:if>
		</c:forEach>
	</div>

</section>

<jsp:include page="template-bottom.jsp" />