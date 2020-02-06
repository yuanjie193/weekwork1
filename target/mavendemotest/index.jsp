<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>jQuery练习</title>
    <style type="text/css">
        #wk{
            width:400px ;
            margin: auto;
        }
        h2{
            color:#FFB800;
        }
        .div1{
            float: left;
            width: 50px;
            line-height: 30px;
            background-color: lightgray;
            margin-left: 10px;
            text-align: center;
            vertical-align: middle;
            border-radius: 15px;
        }
        .div2{
            width: 300px;
            height: 300px;
            border: solid gray 1px;
            margin-top: 60px;
            color: red;
            position: relative;
        }
    </style>
</head>
<body>
<div id="wk">
<h2>请选择背景颜色</h2>
<div>
    <button id="blue" class="div1" onclick="toblue()">蓝色</button>
    <button id="green" class="div1" onclick="togreen()">绿色</button>
</div>
<div class="div2" id="bg">
</div>
<div>输入颜色首字母： <input type="text" name="color"  id="a"></div>
</div>
<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<script type="text/javascript">
    alert("欢迎来到斑斓界——流光梦境，请选择自己喜欢的模式~")
    function toblue() {
        document.getElementById("bg").style.backgroundColor="blue";
        document.getElementById("bg").innerHTML="<img src='img/b.jpg' style='width:100%;height: 100%;opacity: 0.2'><span style='font-size: 30px;position:absolute;left: 0px'>蓝色背景</span>";
        // document.getElementById("bg").innerHTML="<span style='font-size: 30px'>蓝色背景</span>";
    }
    function togreen() {
        document.getElementById("bg").style.backgroundColor="green";
        document.getElementById("bg").innerHTML="<img src='img/t.jpg' style='width:100%;height: 100%;opacity: 0.2'><span style='font-weight: bolder;font-style: italic;font-size: 30px;position:absolute;left: 0px'>绿色背景</span>";
        // document.getElementById("bg").innerHTML="<span style='font-weight: bolder;font-style: italic;font-size: 30px'>绿色背景</span>";
    }
    $(document).ready(function(){
        $("#a").mouseout(function () {
         var color = $("#a").val()
            if(color ==="B"){
                document.getElementById("bg").style.backgroundColor="blue";
                document.getElementById("bg").innerHTML=null;
            }
            if(color ==="G"){
                document.getElementById("bg").style.backgroundColor="green";
                document.getElementById("bg").innerHTML=null;
            }
        })
    })
   //  $("input").mouseout(function () {
   //      alert($("input").text())
   // })
</script>
</body>
</html>
