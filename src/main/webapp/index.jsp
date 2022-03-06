<%@ page import="java.util.List" %>
<%@ page import="entity.group.IndexGroup" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="entity.AeArticle" %>
<%@ page import="dao.AeArticleDao" %>
<%@ page import="entity.User" %>
<%@ page import="dao.UserDao" %>
<%@ page import="dao.AeCommentDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //1.定义一个IndexGroup数据List,作为数据填充List
    List<IndexGroup> lists = new ArrayList<IndexGroup>();
    //2.使用AeArticleDao去数据库查询前5个最新的博客,然后根据每个博客的username通过UserDao查询相关该用户信息，查到后和AeArticle填充到IndexGroup.
    List<AeArticle> lists2 = AeArticleDao.getInstance().getAearticlePart();
    for (AeArticle article: lists2) {
        User user = UserDao.getInstance().search(article.getUsername());
        int size = AeCommentDao.getInstance().search(article.getId().toString()).size();//获取文章评论数
        lists.add(new IndexGroup(article,user,size));
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

    <title>我的主页</title>

    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/font-awesome.min.css">

    <!-- Main css -->
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/add.css">
    <link href="https://fonts.googleapis.com/css?family=Lora|Merriweather:300,400" rel="stylesheet">

    <style type="text/css">
        .blog-post-des img{
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
                <li class="active"><a href="index.jsp">主页</a></li>
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

<section id="home" class="main-home parallax-section">
    <div class="overlay"></div>
    <div id="particles-js"></div>
    <div class="container">
        <div class="row">

            <div class="col-md-12 col-sm-12">
                <h1>Hello! Welcome!!!.</h1>
                <h4>欢迎来到,你会是这里的主人</h4>
                <a href="#blog" class="smoothScroll btn btn-default">Discover More</a>
            </div>

        </div>
    </div>
</section>

<!-- Blog Section -->

<section id="blog">
    <div class="container">
        <div class="row">

            <div class="col-md-offset-1 col-md-10 col-sm-12">

                <%
                    for (IndexGroup data: lists) {

                    %>

                        <div class="blog-post-thumb">
                            <div class="blog-post-title">
                                <h3><a href="/blogDetail.jsp?id=<%=data.getArticle().getId()%>"><%=data.getArticle().getTitle()%></a></h3>
                            </div>
                            <div class="blog-post-format">
                                <span><a href="#"><img src="images/author-image1.jpg" class="img-responsive img-circle"> <%=data.getUser().getNickname()%></a></span>
                                <span><i class="fa fa-date"></i> <%=data.getArticle().getUpdateDate()%></span>
                                <span><a href="#"><i class="fa fa-comment-o"></i> <%=data.getCommentNum()%></a></span>
                            </div>
                            <div class="blog-post-des">
<%--                                <%=data.getArticle().getContent()%>--%>

                                <a href="/blogDetail.jsp?id=<%=data.getArticle().getId()%>" class="btn btn-default">Continue Reading</a>
                            </div>
                        </div>


                     <%
                         }
                %>



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
<script src="js/particles.min.js"></script>
<script src="js/app.js"></script>
<script src="js/jquery.parallax.js"></script>
<script src="js/smoothscroll.js"></script>
<script src="js/custom.js"></script>

</body>
</html>