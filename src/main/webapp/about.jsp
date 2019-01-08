<%@ page import="entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<%
     User user = (User)request.getAttribute("UserInfo");
     pageContext.setAttribute("user",user);

%>
<!DOCTYPE html>
<html lang="en">
<head>

     <meta charset="UTF-8">
     <meta http-equiv="X-UA-Compatible" content="IE=Edge">
     <meta name="description" content="">
     <meta name="keywords" content="">
     <meta name="author" content="">
     <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

     <title>关于我</title>

     <link rel="stylesheet" href="css/bootstrap.min.css">
     <link rel="stylesheet" href="css/font-awesome.min.css">

     <!-- Main css -->
     <link rel="stylesheet" href="css/style.css">
     <link rel="stylesheet" href="css/add.css">
     <link href="https://fonts.googleapis.com/css?family=Lora|Merriweather:300,400" rel="stylesheet">

</head>
<body>

<!-- PRE LOADER -->

<div class="preloader">
     <div class="sk-spinner sk-spinner-wordpress">
          <span class="sk-inner-circle"></span>
     </div>
</div>

<!-- Navigation section  -->

<div class="navbar navbar-default navbar-static-top"  role="navigation">
     <div class="container">
          <div class="navbar-header">
               <button class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="icon icon-bar"></span>
                    <span class="icon icon-bar"></span>
                    <span class="icon icon-bar"></span>
               </button>
               <a href="index.html" class="navbar-brand">Companion</a>
          </div>
          <div class="collapse navbar-collapse collapse-navbar-collapse-width">
               <ul class="nav navbar-nav navbar-right">
                    <li><a href="index.jsp">主页</a></li>
                    <li class="active"><a href="/about">关于我</a></li>
                    <li><a href="/gallery">画廊</a></li>
                    <li><a href="blogEdit.jsp">写博客</a></li>
                    <li><a href="contact.jsp">联系我</a></li>
                    <li>
                         <a href="/person/index.jsp" class="person-pic">
                              <img src="images/author-image1.jpg" height="40px" width="40px" class="img-circle">
                         </a>
                    </li>

               </ul>


          </div>
     </div>



</div>

<!-- Home Section -->

<section id="home" class="main-about parallax-section">
     <div class="overlay"></div>
     <div class="container">
          <div class="row">

               <div class="col-md-12 col-sm-12">
                    <h1>About Me</h1>
               </div>

          </div>
     </div>
</section>

<!-- About Section -->

<section id="about">
     <div class="container">
          <div class="row">

               <div class="col-md-offset-1 col-md-10 col-sm-12">
                    <div class="col-md-4 col-sm-4">
                         <h2>介绍我</h2>
                         <p>
                              ${user.personalIntroduce}
                         </p>

                    </div>

                    <div class="col-md-4 col-sm-4">
                         <h2>职 业</h2>
                         <p>
                              ${user.professionIntroduce}
                         </p>
                    </div>

                    <div class="col-md-4 col-sm-4">
                         <h2>热 爱</h2>
                         <p>
                              ${user.loveIntroduce}
                         </p>
                    </div>

                    <div class="col-md-6 col-sm-6">
                         <h3>目 标</h3>
                         <p>
                              ${user.goalIntroduce}
                         </p>

                    </div>

                    <div class="col-md-6 col-sm-6">
                         <img src="images/TLP.jpg" class="img-responsive" alt="About Image">
                    </div>

                    <h3>其 他</h3>
                    <p>中学时代，作文课上老师推荐的最多的杂志就是《读者》和《青年文摘》，这两本杂志贯穿了我中学时代的这几年。
                         看着它从最初的定价从3块到4块再到如今的一本6块钱。每次走过公交站台的报刊亭
                         ，依然可以看到它们熟悉的身影，但买的次数变少了。</p>
               </div>

          </div>
     </div>
</section>

<!-- Footer Section -->

<footer>
     <div class="container">
          <div class="row">

               <div class="col-md-5 col-md-offset-1 col-sm-6">
                    <h3>Companion Studio</h3>
                    <p>Companion Studio社区致力于为中国软件开发者提供知识传播、在线学习、职业发展等全生命周期服务。
                         截止2018年12月，CSDN拥有超过2600万+技术会员，论坛发帖数1000万+，技术资源700万+，Blog文章1400万+，
                         新媒体矩阵粉丝数量600万+，合作上千家科技公司及技术社区。 CSDN全职员工超过500名，
                         分布在北京、上海、深圳、武汉、成都、江苏沭阳等地区.</p>
                    <div class="footer-copyright">
                         <p>Copyright &copy; 2018 Your Company - Design: Tooplate.</p>
                    </div>
               </div>

               <div class="col-md-4 col-md-offset-1 col-sm-6">
                    <h3>友情链接</h3>
                    <p><i class="fa fa-globe"></i> <a href="https://www.baidu.com/">百度</a></p>
                    <p><i class="fa fa-globe"></i> <a href="https://www.baidu.com/">百度</a></p>
                    <p><i class="fa fa-globe"></i> <a href="https://www.baidu.com/">百度</a></p>
               </div>

               <div class="clearfix col-md-12 col-sm-12">
                    <hr>
               </div>

               <div class="col-md-12 col-sm-12">
                    <ul class="social-icon">
                         <li><a href="#" class="fa fa-facebook"></a></li>
                         <li><a href="#" class="fa fa-twitter"></a></li>
                         <li><a href="#" class="fa fa-google-plus"></a></li>
                         <li><a href="#" class="fa fa-dribbble"></a></li>
                         <li><a href="#" class="fa fa-linkedin"></a></li>
                    </ul>
               </div>
               
          </div>
     </div>
</footer>

<!-- Back top -->
<a href="#back-top" class="go-top"><i class="fa fa-angle-up"></i></a>

<!-- SCRIPTS -->

<script src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.parallax.js"></script>
<script src="js/custom.js"></script>

</body>
</html>