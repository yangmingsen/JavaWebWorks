<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Blog Edit</title>
    <link rel="stylesheet" href="markdown/css/editormd.css">
    <style type="text/css">
        .write {

        }
        .div-title {
            margin-left: 93px;
            margin-right: 93px;
        }
        .write-title input {
            display: block;
            width: 100%;
            height: 40px;
            line-height: 40px;
            box-sizing: border-box;
            padding: 0 16px;
            border: none;
            background-color: #efefef;
            color: #4f4f4f;
            overflow: visible;
            margin: 0;
            font-family: inherit;
            font-size: inherit;
            margin-bottom: 15px;
        }

    </style>
</head>
<body>

 <div class="write">
     <form action="/blog/write" method="post">
         <div class="div-title write-title">
             <input type="text" name="blog-title" placeholder="输入文字标题">
         </div>
         <div class="editormd" id="test-editormd">
             <textarea class="editormd-markdown-textarea" name="test-editormd-markdown-doc"></textarea>
             <!-- 第二个隐藏文本域，用来构造生成的HTML代码，方便表单POST提交，这里的name可以任意取，后台接受时以这个name键为准 -->
             <textarea class="editormd-html-textarea" name="blog-content"></textarea>
         </div>
         <div class="div-title write-title">
             <input type="submit" value="提交">
         </div>

     </form>

 </div>
</body>
<script src="markdown/jquery.min.js"></script>
<script src="markdown/editormd.min.js"></script>
<script type="text/javascript">
    $(function() {
        editormd("test-editormd", {
            width   : "90%",
            height  : 640,
            syncScrolling : "single",
            //你的lib目录的路径，我这边用JSP做测试的
            path    : "markdown/lib/",
            //这个配置在simple.html中并没有，但是为了能够提交表单，使用这个配置可以让构造出来的HTML代码直接在第二个隐藏的textarea域中，方便post提交表单。
            imageUpload : true,
            imageFormats : ["jpg", "jpeg", "gif", "png", "bmp", "webp"],
            imageUploadURL : "/blog/photo/upload",
            saveHTMLToTextarea : true
        });
    });
</script>

</html>