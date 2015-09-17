<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE HTML>
<!--
	Alpha by HTML5 UP
	html5up.net | @n33co
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
<head>
<title>Oscars Top Movies</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="description" content="" />
<meta name="keywords" content="" />

<script src="js/jquery.min.js"></script>
<script src="js/jquery.dropotron.min.js"></script>
<script src="js/jquery.scrollgress.min.js"></script>
<script src="js/skel.min.js"></script>
<script src="js/skel-layers.min.js"></script>
<script src="js/init.js"></script>
<noscript>
	<link rel="stylesheet" href="css/skel.css" />
	<link rel="stylesheet" href="css/style.css" />
	<link rel="stylesheet" href="css/style-wide.css" />
</noscript>

</head>
<body class="landing">

	<!-- Header -->
	<header id="header" class="alt">
		<h1>
			<a href="index.jsp">Oscars Top Hits</a> &nbsp; by Bazinga
		</h1>
	</header>

	<!-- Banner -->
	<section id="banner">
	    <div class="6u 12u(narrow) 12u(mobilep)">
		<h2>Welcome!</h2>
		<p>Find the top
			movies of Oscars Nominees 2015.</p>
		<ul class="actions">
			<li><a href="login.do" class="button"
				style="font-size: 18px; font-weight: bold">Twitter Login</a></li>
		</ul>
		</div>
	</section>

	<jsp:include page="template-bottom.jsp" />