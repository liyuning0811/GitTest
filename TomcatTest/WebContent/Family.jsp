<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>



<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta http-equiv="Content-Script-Type" content="text/javascript" />
<meta http-equiv="imagetoolbar" content="no" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<link rel="stylesheet" href="css/common.css" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript">
$(function() {
    $('#slide').slideshow({
        autoSlide    : true,
        effect       : 'fade',
        type         : 'repeat',
        interval     : 3000,
        duration     : 500,
        imgHoverStop : true,
        navHoverStop : true
    });
    $(window).load(function() {
        $(".topNaviColumn").uniformHeight();
    });
});
</script>
<title>PHC-G Family Page</title>
</head>
<body>
<div id="container">
    <div id="header">
        <h1><a href="index.html">PHC-Grafical App</a></h1>
    </div><!-- /#header -->
    <div id="slide">
        <ul class="slideInner">
            <li><img src="images/icatch01.jpg" alt="" width="940" height="300" /></li>
            <li><img src="images/icatch02.jpg" alt="" width="940" height="300" /></li>
            <li><img src="images/icatch03.jpg" alt="" width="940" height="300" /></li>
        </ul>
         <div class="slidePrev"><img src="images/nav_prev.png" alt="前へ"></div>
         <div class="slideNext"><img src="images/nav_next.png" alt="次へ"></div>
         <div class="controlNav"></div>
    </div><!-- /#slide -->
    <div id="contents">
    
    <FONT SIZE="30" COLOR="#99999">
               <%String ID = (String)session.getAttribute("ID") ;  %>
Welcome,
Patient ID:<%=ID %> 's Family ！
       
</FONT>
            
        <!-- /.conL -->
        
    </div><!-- /#contents -->
    </div><!-- /#container -->
    <div id="footer">
        <div class="copyright">Copyright &copy; 2014-2015 PHC-G All Rights Reserved.</div>
    </div><!-- /#footer -->


</body>
</html>









