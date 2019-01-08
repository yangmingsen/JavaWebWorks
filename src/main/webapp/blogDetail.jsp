<%@ page import="entity.AeArticle" %>
<%@ page import="dao.AeArticleDao" %>
<%@ page import="utils.UserStats" %>
<%@ page import="java.util.List" %>
<%@ page import="entity.AeComment" %>
<%@ page import="dao.AeCommentDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
     String blogId = request.getParameter("id");//博客id
     Long searchid = Long.parseLong(blogId);
     AeArticle article = AeArticleDao.getInstance().search(searchid);

     List<AeComment> comments = AeCommentDao.getInstance().search(blogId);

     System.out.println("seesionid = "+request.getSession().getId());

     //评论必须登录
     String commenterUseranme = UserStats.getUsernameBySessionid(request.getSession().getId());
     System.out.println("commentUser = "+commenterUseranme);
     if (commenterUseranme == null) {
          commenterUseranme = "";
     }

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

     <title><%=article.getTitle()%></title>

     <link rel="stylesheet" href="css/bootstrap.min.css">
     <link rel="stylesheet" href="css/font-awesome.min.css">

     <!-- Main css -->
     <link rel="stylesheet" href="css/style.css">
     <link rel="stylesheet" href="css/add.css">
     <link href="https://fonts.googleapis.com/css?family=Lora|Merriweather:300,400" rel="stylesheet">

     <style>
          .blog-post-des img {
               width: 100%;
          }
     </style>


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
                    <li><a href="/about">关于我</a></li>
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


<section id="home" class="main-single-post parallax-section">
     <div class="overlay">
     </div>
     <div class="container">
          <div class="row">

               <div class="col-md-12 col-sm-12">
                    <h1>Blog Details</h1>
               </div>

          </div>
     </div>
</section>

<script type="application/javascript">
     function load() {
          var obj = document.getElementById("home");
          obj.style.background = "url('images/blog-image1.jpg')";
     }
     load();
</script>

<!-- Blog Single Post Section -->

<section id="blog-single-post">
     <div class="container">
          <div class="row">

               <div class="col-md-offset-1 col-md-10 col-sm-12">
                    <div class="blog-single-post-thumb">
                         

                         <div class="blog-post-title">
                              <h2><a><%= article.getTitle() %></a></h2>
                         </div>

                         <div class="blog-post-format">
                              <span><a href="#"><img src="images/author-image1.jpg" class="img-responsive img-circle"> Jen Lopez</a></span>
                              <span><i class="fa fa-date"></i> <%=article.getWriteDate()%></span>
                              <span><a href="#"><i class="fa fa-comment-o"></i> 124 Comments</a></span>
                         </div>

                         <div class="blog-post-des">
                              <%=article.getContent()%>
                         </div>

                         <div class="blog-comment">
                              <h3 id="comment">评论</h3>
                              <%
                                   for (AeComment comment : comments) {
                              %>
                              <div class="media">
                                        <div class="media-object pull-left">
                                             <img src="images/comment-image1.jpg" class="img-responsive img-circle" alt="Blog Image 11">
                                        </div>
                                        <div class="media-body">
                                             <h3 class="media-heading"><%=comment.getUsername()%></h3>
                                             <span><%=comment.getDate().substring(0,19)%></span>
                                             <p>
                                                  <%=comment.getContent()%>
                                             </p>
                                        </div>
                              </div>
                              <%
                                   }
                              %>

                         </div>

                         <div class="blog-comment-form">
                              <h3>提交</h3>
                              <form action="#" method="post">
                                   <textarea name="message" rows="5" class="form-control" id="CommentMessage" placeholder="Message" message="message" required="required"></textarea>
                                   <div class="col-md-3 col-sm-4">
                                        <input name="submit" type="button" class="form-control" id="submit" value="提交">
                                   </div>
                              </form>
                         </div>
                    </div>
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
<script type="application/javascript">
     var blogId = <%=blogId%>;
     var commenterUseranme = "<%=commenterUseranme%>";
     $(function () {
          $("#submit").click(function () {
               var comment = $("#CommentMessage").val();
               $.ajax({
                    type: "POST",
                    url: "/blog/comment",
                    async: false,
                    dataTpye: "json",
                    data: {"blogId":blogId,"comment":comment},
                    success(data) {

                         var status = data.status;
                         if (status == 1) {
                              addComment();
                         } else if(status == 0 ) {
                              alert("评论失败!!!");
                         }
                    },
                    error:function (exception) {
                         var status = exception.status;
                         console.log("exception.status = "+status);
                         if(status == 404) {
                              alert("你需要登录后评论!!!");
                              window.location.href="login.jsp";
                         }
                    }

               });
          });
     })

     function getDate() {
          var date = new Date();
          var res = date.toLocaleString();
          return res;
     }


     function addComment() {
          var content = $("#CommentMessage").val();

          var date = getDate();
          $("#comment").after(" <div class=\"media\">\n" +
                  "                                        <div class=\"media-object pull-left\">\n" +
                  "                                             <img src=\"images/comment-image2.jpg\" class=\"img-responsive img-circle\" alt=\"Blog Image 22\">\n" +
                  "                                        </div>\n" +
                  "                                        <div class=\"media-body\">\n" +
                  "                                             <h3 class=\"media-heading\">" +commenterUseranme+ "</h3>\n" +
                  "                                             <span>"+date+"</span>\n" +
                  "                                             <p>\n" + content +
                  "                                             </p>\n" +
                  "                                        </div>\n" +
                  "                                   </div>");

     }



</script>

</body>
</html>