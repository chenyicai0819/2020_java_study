<%--
  Created by IntelliJ IDEA.
  User: swagg
  Date: 2021/6/16
  Time: 11:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>首页</title>
    <script src="http://cdn.staticfile.org/jquery/3.6.0/jquery.js"></script>
    <link rel="stylesheet" href="./css/main.css">
    <script>
        $(document).ready(function () {
            $(".fa").click(function () {
                var flag = $(this).nextAll("ul").is(":hidden");
                if (flag) {
                    //show() 方法: 使隐藏的变为显示
                    $(this).nextAll("ul").toggle();
                    $(this).nextAll("img").css("transform", "rotate(0deg)");
                } else {
                    $(this).nextAll("ul").hide();
                    $(this).nextAll("img").css("transform", "rotate(270deg)");
                }
            })
            // 点击时模块变色
            $(".son").click(function () {
                $(".son").css("background-color", "#282B33");
                $(this).css("background-color", "#009688");
            })
        })
    </script>
</head>
<body>
<div id="div1">
    <ul id="first">
        <c:forEach items="${user.roleList[0].treeList}" var="tree" varStatus="father">
            <c:if test="${tree.isParent eq true}">
                <li class="father">
                    <a class="fa" href="javascript:void(0)">${tree.title} </a>
                    <img id="fimg" src="jsp/images/jt.png" alt="fatherjt">

                    <c:forEach items="${user.roleList[0].treeList}" var="tree" begin="${father.index+1}"
                               end="${father.index+2}" varStatus="son">
                        <c:if test="${tree.isParent eq false}">
                            <ul id="second">
                                <li class="son">
                                    <a href="javascript:void(0)">${tree.title}</a>
                                </li>
                            </ul>
                        </c:if>
                    </c:forEach>
                </li>
            </c:if>
        </c:forEach>

    </ul>
</div>
</body>
</html>