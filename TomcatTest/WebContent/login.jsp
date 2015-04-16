<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
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
<title>PHC-G</title>
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
           <div align="center" style="padding-top: 30px;" id = "add" >
                <form action="login" method="post" >
                    <table class="table1" width="50%" >
                    
                        <tr>
                            <td>ID</td>
                            <td> <input type="text" name="ID" > </td>
                        </tr>
                        <tr>
                            <td>password</td>
                            <td> <input type="password" name="password" > </td>
                        </tr>
                        <tr>
                            <td colspan="2"  > <input type="submit" value="login"  > <input type="reset" value="reset"  ></td>
                        </tr>
                    </table>
                    </form>
                    </div>
       

            
        <!-- /.conL -->
        
    </div><!-- /#contents -->
    </div><!-- /#container -->
    <div id="footer">
        <div class="copyright">Copyright &copy; 2014-2015 PHC-G All Rights Reserved.</div>
    </div><!-- /#footer -->


</body>
</html>