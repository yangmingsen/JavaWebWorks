<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style type="text/css" >


        .l {
            float: left;
        }
        .main {
            padding: 0!important;
            min-height: 650px;
        }

        .main-setting {
            width: 1200px;
            margin: 0 auto;
            padding: 30px 0;
        }
        .main-setting-left {
            width: 216px;
            background-color: #f8fafc;
        }
        .main-setting-left-avator-wapper {
            padding: 32px 0 24px;
        }
        .main-setting-left-avator-wapper-mode {
            position: relative;
            width: 100px;
            height: 100px;
            box-sizing: border-box;
            border: 4px solid #d9dde1;
            border-radius: 50px;
            margin: 0 auto;
            text-align: center;
            overflow: hidden;
        }
        .main-setting-left-avator-wapper-mode-updateAvator{
            font-size: 12px;
            position: absolute;
            width: 100%;
            left: 0;
        }
        .main-setting-left-avator-wapper-desMode {
            font-size: 16px;
            text-align: center;
        }

        .main-setting-left-listWapper {
            text-align: center;
            overflow: hidden;
        }
        .line {
            height: 1px;
            background-color: #d9dde1;
            margin: 0 24px;
        }

        .main-setting-left-listWapper-menu {
            padding: 10px 0 25px;
        }

        /*##############################################################*/
        .main-setting-right {
            float: left;
            margin-left: 48px;
            width: 936px;
            box-sizing: border-box;
            background-color: #fff;
        }

        .main-setting-right-Wrap{
            min-height: 550px;
            padding: 0!important;
        }

        .setting-profile {

        }

        .main-setting-right-Wrap-formBox-profile-commonTitle {
            line-height: 40px;
            font-size: 16px;
            font-weight: 700;
        }

        .main-setting-right-Wrap-formBox-profile-commonTitle a {
            color: #93999f;
            font-weight: 400;
            font-size: 14px;
        }

         .info-wapper {
            margin: 24px auto 24px 40px;
        }

        .info-box {
            margin-bottom: 12px;
        }

        .setting-profile .info-box label {
            width: 120px;
            line-height: 20px;
            padding: 20px 0;
            text-align: center;
            background-color: #f3f5f7;
            color: #07111b;
            font-weight: 700;
        }
        .pull-left {
            float: left;
        }

        user agent stylesheet
        label {
            cursor: default;
        }

        .setting-profile .info-box div {
            width: 708px;
            margin-left: 8px;
            line-height: 20px;
            padding: 20px 0 20px 22px;
            border-bottom: 1px solid #d9dde1;
        }

        .pull-left {
            float: left;
        }

    </style>
</head>
<body>
    <div class="main">
        <div class="main-setting">
            <div class="main-setting-left l">
                <div class="main-setting-left-avator-wapper">
                    <div class="main-setting-left-avator-wapper-mode">
                        <img class="avator-img" src="https://img.mukewang.com/5458676e0001af7702200220-200-200.jpg" data-portrait="5458676e0001af7702200220" width="92" height="92">
                        <div class="main-setting-left-avator-wapper-mode-updateAvator" style="bottom: -30px;">
                            <p><a href="javascript:void(0);" class="js-avator-link">更换头像</a></p>
                        </div>
                    </div>
                    <div class="main-setting-left-avator-wapper-desMode">
                        <p>weixin_你的问题充钱就能解_0</p>
                    </div>
                </div>
                <div class="main-setting-left-listWapper">
                    <h2>个人管理</h2>
                    <div class="line"></div>
                    <ul class="main-setting-left-listWapper-menu">
                        <li><a href="######">账号绑定</a></li>
                        <li><a href="######">账号绑定</a></li>
                        <li><a href="######">账号绑定</a></li>
                        <li><a href="######">账号绑定</a></li>
                    </ul>
                </div>
            </div>


            <!-- 个人信息模态框（Modal） -->
            <div class="modal fade" id="MyInfo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                &times;
                            </button>
                            <h4 class="modal-title" id="myModalLabel">
                                个人信息编辑
                            </h4>
                        </div>
                        <div class="modal-body">
                            昵&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称：<input type="text" name="nickname" id="nickname"><br>
                            性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：<input type="text" name="sex" id="sex"><br>
                            电&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;话：<input type="text" name="phone" id="phone"><br>
                            E-mail：&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="email" id="email"><br>
                            个性签名：<input type="text" name="personalized-signature" id="personalized-signature"><br>
                            个人介绍：<input type="text" name="personal-introduce" id="personal-introduce"><br>
                            职业介绍：<input type="text" name="profession-introduce" id="profession-introduce"><br>
                            热爱介绍：<input type="text" name="love-introduce" id="love-introduce"><br>
                            目标介绍：<input type="text" name="goal-introduce" id="goal-introduce"><br>

                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                            </button>
                            <button type="button" id="submitInfo" class="btn btn-primary">
                                提交更改
                            </button>
                        </div>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal -->
            </div>


            <!-- 相册信息模态框（Modal） -->
            <div class="modal fade" id="MyGallery" tabindex="-1" role="dialog" aria-labelledby="MyGalleryLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                &times;
                            </button>
                            <h4 class="modal-title" id="MyGalleryLabel">
                                个人信息编辑
                            </h4>
                        </div>
                        <div class="modal-body">
                            标&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;题：<input type="text" name="title" id="title"><br>
                            描&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;述：<input type="text" name="describe" id="describe"><br>

                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                            </button>
                            <button type="button" id="submitGalleryInfo" class="btn btn-primary">
                                提交更改
                            </button>
                        </div>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal -->
            </div>

            <!-- 个人信息模态框（Modal） -->
            <div class="modal fade" id="UploadGallery" tabindex="-1" role="dialog" aria-labelledby="UploadGalleryLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                &times;
                            </button>
                            <h4 class="modal-title" id="UploadGalleryLabel">
                                个人信息编辑
                            </h4>
                        </div>
                        <div class="modal-body">
                            上传相册
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                            </button>
                            <button type="button" class="btn btn-primary">
                                提交更改
                            </button>
                        </div>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal -->
            </div>



            <div class="main-setting-right">
                <div class="main-setting-right-Wrap">
                    <div class="main-setting-right-Wrap-formBox">
                        <div class="setting-profile">
                            <div class="main-setting-right-Wrap-formBox-profile-commonTitle">
                                "
                                个人信息
                                "
                                <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#MyInfo">编辑</button>
                            </div>
                            <div class="main-setting-right-Wrap-formBox-profile-commonTitle">
                                "
                                相册信息
                                "
                                <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#MyGallery">编辑</button>
                                <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#UploadGallery">上传相册</button>
                            </div>


                            <div class="line"></div>


                            <div class="info-wapper">
                                <div class="info-box clearfix">
                                    <label class="pull-left">昵称</label><div class="pull-left">weixin_你的问题充钱就能解_0</div>
                                </div>
                                <div class="info-box clearfix">
                                    <label class="pull-left">性别</label><div class="pull-left">未设置</div>
                                </div>
                                <div class="info-box clearfix">
                                    <label class="pull-left">城市</label>
                                    <div class="pull-left">
                                        未设置
                                    </div>
                                </div>
                                <div class="info-box clearfix">
                                    <label class="pull-left">性别</label><div class="pull-left">
                                    男</div>
                                </div>
                                <div class="info-box clearfix">
                                    <label class="pull-left">个性签名</label><div class="pull-left">未设置</div>
                                </div>
                            </div>

                            <div class="line"></div>


                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
<script src="/js/jquery.js"></script>
<script type="application/javascript">
    $(document).ready(function () {
        $("#submitInfo").click(function () {
            $.ajax({
               type: "POST",
                url: "/user/?",
                async: false,
                data: {
                    "nickname": $("#nickname").val(),
                    "sex": $("#sex").val(),
                    "phone": $("#phone").val(),
                    "email": $("#email").val(),
                    "personalizedSignature": $("#personalized-signature").val(),
                    "personalIntroduce": $("#personal-introduce").val(),
                    "professionIntroduce": $("#profession-introduce").val(),
                    "loveIntroduce": $("#love-introduce").val(),
                    "goalIntroduce": $("#goal-introduce").val()
                },
                dataType: "json",
                success(data) {
                   var status = data.status;
                   if (status == 1) {
                       alert("更新成功!!!");
                   } else {
                       alert("更新失败!!!");
                   }
                }
            });
        });

        $("#submitGalleryInfo").click(function () {
            $.ajax({
                type: "POST",
                url: "/user/?",
                async: false,
                data: {
                    "title": $("#title").val(),
                    "describe": $("#describe").val()
                },
                dataType: "json",
                success(data) {
                    var status = data.status;
                    if (status == 1) {
                        alert("更新成功!!!");
                    } else {
                        alert("更新失败!!!");
                    }
                }
            });
        });

    });

</script>
</html>