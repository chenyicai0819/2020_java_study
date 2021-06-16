<%@ page import="java.util.List" %>
<%@ page import="bean.User" %>
<%--
  Created by IntelliJ IDEA.
  bean.User: swagg
  Date: 2021/6/6
  Time: 17:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>书籍信息</title>
    <style>
        table, th, tr, td {
            border: 1px solid red;
            border-collapse: collapse;
        }
    </style>
    <script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>

    <script>
        //上一页
        $(document).ready(function () {
            var cou = $("#bill").text();
            var count = parseInt(cou);

            $("#SYY").click(function () {
                if (count == 1) {
                    alert("已经是第一页了");
                    count = 1;
                } else {
                    count = count - 1;
                }
                $("#bill").text(count);
                window.location.href = "user.do?curPage=" + count;
            })

        })
        //下一页
        $(document).ready(function () {
            var cou = $("#bill").text();
            var count = parseInt(cou);
            var lcou = $("#p1").text();
            var lcount = parseInt(lcou);
            $("#XYY").click(function () {
                if (count == lcount) {
                    alert("已经是最后一页了");
                    count = lcount;
                } else {
                    count = count + 1;
                }
                $("#bill").text(count);
                window.location.href = "user.do?curPage=" + count;
            })

        })
        // 首页
        $(document).ready(function () {
            var cou = $("#bill").text();
            var count = parseInt(cou);

            $("#SY").click(function () {
                count = 1;
                $("#bill").text(count);
                window.location.href = "user.do?curPage=" + count;
            })
        })
        //尾页
        $(document).ready(function () {
            var cou = $("#bill").text();
            var count = parseInt(cou);
            var lcou = $("#p1").text();
            var lcount = parseInt(lcou);

            $("#WY").click(function () {
                count = lcount;
                $("#bill").text(count);
                window.location.href = "user.do?curPage=" + count;
            })
        })
        //点击
        $(document).ready(function () {
            var cou = $("#bill").text();
            var count = parseInt(cou);
            $("#a1").click(function () {
                var acou = $("#a1").text();
                var acount = parseInt(acou);
                count = acount;
                $("#bill").text(count);
                window.location.href = "user.do?curPage=" + count;
            })
            $("#a2").click(function () {
                var acou = $("#a2").text();
                var acount = parseInt(acou);
                count = acount;
                $("#bill").text(count);
                window.location.href = "user.do?curPage=" + count;
            })
            $("#a3").click(function () {
                var acou = $("#a3").text();
                var acount = parseInt(acou);
                count = acount;
                $("#bill").text(count);
                window.location.href = "user.do?curPage=" + count;
            })
            $("#a4").click(function () {
                var acou = $("#a4").text();
                var acount = parseInt(acou);
                count = acount;
                $("#bill").text(count);
                window.location.href = "user.do?curPage=" + count;
            })
            $("#a5").click(function () {
                var acou = $("#a5").text();
                var acount = parseInt(acou);
                count = acount;
                $("#bill").text(count);
                window.location.href = "user.do?curPage=" + count;
            })
            $("#al").click(function () {
                var acou = $("#al").text();
                var acount = parseInt(acou);
                count = acount;
                $("#bill").text(count);
                window.location.href = "user.do?curPage=" + count;
            })

        })


    </script>
</head>
<body>
<table id="test">
    <thead>
    <tr>
        <th>ID</th>
        <th>状态</th>
        <th>书名</th>
        <th>作者</th>
        <th>地址</th>
    </tr>
    </thead>
    <tbody>
    <%
        List<User> userList = (List<User>) request.getAttribute("userList");
        for (int i = 0; i < userList.size(); i++) {
    %>
    <tr id="tr1">
        <td><%=userList.get(i).getBid()%>
        </td>
        <td><%=userList.get(i).getSname()%>
        </td>
        <td><%=userList.get(i).getBname()%>
        </td>
        <td><%=userList.get(i).getBauthor()%>
        </td>
        <td><%=userList.get(i).getBhome()%>
        </td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
<p id="bill" style="display: none"><%=request.getAttribute("nowPage")%>
</p>
<p id="p1" style="display: none"><%=request.getAttribute("totalPage")%>
</p>

<input id="SY" type="button" value="首页">
<input id="SYY" type="button" value="上一页">

<%int LastPage = (int) request.getAttribute("totalPage");
%>
<%
    int Page5 = (int) request.getAttribute("nowPage") - 2;
    if (Page5 < 1) {
        Page5 = 1;
    }
%>
<%
    int Page4 = (int) request.getAttribute("nowPage") - 1;
    if (Page4 < 1) {
        Page4 = 1;
    }
%>
<%
    int Page2 = (int) request.getAttribute("nowPage") + 1;
    if (Page2 > LastPage) {
        Page2 = LastPage;
    }
%>
<%
    int Page3 = (int) request.getAttribute("nowPage") + 2;
    if (Page3 > LastPage) {
        Page3 = LastPage;
    }
%>

<a class="aa" id="a5" href="javascript:void(0)"><%=Page5%>
</a>
<a class="aa" id="a4" href="javascript:void(0)"><%=Page4%>
</a>
<a class="aa" id="a1" href="javascript:void(0)"><%=request.getAttribute("nowPage")%>
</a>
<a class="aa" id="a2" href="javascript:void(0)"><%=Page2%>
</a>
<a class="aa" id="a3" href="javascript:void(0)"><%=Page3%>
</a>

<a class="aa" id="al" href="javascript:void(0)">尾页：<%=LastPage%>
</a>
<input id="XYY" type="button" value="下一页">
<input id="WY" type="button" value="尾页">


</body>
</html>
