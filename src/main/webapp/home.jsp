<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/2/8/0008
  Time: 12:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <style>
        #wk{
            width: 360px;
            height: 400px;
            background-color:#FF9900;
            margin: auto;
            border-radius: 20px;
        }
        button{
            width: 100px;
            height:40px;
            color: white;
            border-radius: 10px;
            font-size: 18px;
            background-color: #99CC33;
            margin-left: 50px;
            margin-top: 30px;
        }
        button a{
            font-size: 18px;
            color: white;
            text-decoration: none;
        }
        #bd{
            display: none;
            margin-top: 30px;
            margin-left: 32px;
        }
        #bd select{
            width: 70px;
            height: 30px;
            border-radius: 5px;
        }
        #bd input{
            width: 70px;
            height: 33px;
            border-radius: 10px;
            background-color: #99CC33;
        }

    </style>
</head>
<body>
<div id="wk">
    <button onclick="togame()">开始游戏</button>
    <button><a href="/home/backlogin">退出登录</a></button>
    <form action="/home/games" id="bd">
        <select name="sx">
            <option value="鸡">鸡</option>
            <option value="马">马</option>
            <option value="羊">羊</option>
            <option value="兔">兔</option>
            <option value="龙">龙</option>
            <option value="鼠">鼠</option>
            <option value="猪">猪</option>
            <option value="猴">猴</option>
            <option value="蛇">蛇</option>
            <option value="狗">狗</option>
            <option value="牛">牛</option>
            <option value="虎">虎</option>
        </select>
        <select name="month">
            <option value="1月">1月</option>
            <option value="2月">2月</option>
            <option value="3月">3月</option>
            <option value="4月">4月</option>
            <option value="5月">5月</option>
            <option value="6月">6月</option>
            <option value="7月">7月</option>
            <option value="8月">8月</option>
            <option value="9月">9月</option>
            <option value="10月">10月</option>
            <option value="11月">11月</option>
            <option value="12月">12月</option>
        </select>
        <select name="xz">
            <option value="白羊座">白羊座</option>
            <option value="金牛座">金牛座</option>
            <option value="巨蟹座">巨蟹座</option>
            <option value="天蝎座">天蝎座</option>
            <option value="双子座">双子座</option>
            <option value="射手座">射手座</option>
            <option value="狮子座">狮子座</option>
            <option value="处女座">处女座</option>
            <option value="天平座">天平座</option>
            <option value="双鱼座">双鱼座</option>
            <option value="水瓶座">水瓶座</option>
            <option value="摩羯座">摩羯座</option>
        </select>
        <input type="submit" value="提交" onclick="games()">
    </form>
</div>
</body>
<script>
function togame() {
    document.getElementById("bd").style.display="block";

}
</script>
</html>
