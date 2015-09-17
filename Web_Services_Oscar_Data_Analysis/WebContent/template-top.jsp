<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE HTML>
<html>
	<head>
		<title>Oscars Top Movies</title>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<meta name="description" content="" />
		<meta name="keywords" content="" />
		<!--[if lte IE 8]><script src="css/ie/html5shiv.js"></script><![endif]-->
		<script src="js/jquery.min.js"></script>
		<script src="js/jquery.dropotron.min.js"></script>
		<script src="js/jquery.scrollgress.min.js"></script>
		<script src="js/skel.min.js"></script>
		<script src="js/skel-layers.min.js"></script>
		<script src="js/init.js"></script>

		<noscript>

      <link href="//netdna.bootstrapcdn.com/bootstrap/2.2.2/css/bootstrap.min.css" rel="stylesheet">
      <link href="//netdna.bootstrapcdn.com/bootstrap/2.2.2/css/bootstrap-responsive.min.css" rel="stylesheet">
      <link href="//fonts.googleapis.com/css?family=Finger+Paint" id="link-webfont" rel="stylesheet">

			<link rel="stylesheet" href="css/skel.css" />
			<link rel="stylesheet" href="css/style.css" />
			<link rel="stylesheet" href="css/style-wide.css" />
		</noscript>
	  
	</head>
	<body>

		<!-- Header -->
			<header id="header">
				<h1><a href="showHomePage.do" style="font-weight: bold; font-size: 22px">Oscars Top Hits</a> &nbsp; by Bazinga</h1>
				<nav id="nav">
					<ul>
						<li><strong><a href="showHomePage.do">Home</a></strong></li>
                       
                        <li><strong><a href="AnalyzeTrend.do">Movie Trend</a></strong></li>
				        <li>
							<strong><a href="" class="icon fa-angle-down">Top Movies</a></strong>
							<ul>
							<c:forEach var="movie" items="${movieList}" varStatus="count">
							<!--  	<form method="post">
					               <input type="hidden" name="movie" value="${ movie }">
					               <input type="hidden" name="movieName" value="${ movieNameList[count.index] }"> -->
					               <li><a href="get-tweet.do?movie=${ movie }&movieName=${ movieNameList[count.index] }">${ movie}</a></li>
					        
								
							</c:forEach>
							</ul>
						</li>
						<li><a href="Logout.do" id="logout" class="button" style="width:100px">Log Out</a></li>
					</ul>
				</nav>
			</header>
